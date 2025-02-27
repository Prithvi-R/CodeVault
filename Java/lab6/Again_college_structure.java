package Java.lab6;

import java.util.*;

class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void getDetails() {
        System.out.println("NAME OF PERSON : " + this.name);
        System.out.println("AGE OF PERSON : " + this.age);
    }
}

class Faculty extends Person {
    int empID;

    public Faculty(String name, int ID, int age) {
        super(name, age);
        this.empID = ID;
    }

    public String toString() {
        System.out.println("Name of teacher : " + this.name);
        System.out.println("ID : " + this.empID);
        return null;
    }
}

class Student extends Person {
    int roll;
    double cgp;
    String branch;
    static String ID ;
    Faculty advisor;

    public Student(String name, int roll, double cgp, String branch, Faculty advisor, int age) {
        super(name, age);
        this.roll = roll;
        this.cgp = cgp;
        this.branch = branch;
        this.advisor = advisor;
    }
}

public class Again_college_structure {
    static Scanner sc = new Scanner(System.in);

    public static void ADDStudent(Student[] students, int count, Faculty advisor) {
        System.out.print("Enter name: ");
        sc.nextLine();
        String name = sc.nextLine();
        System.out.print("Enter AGE: ");
        int age = sc.nextInt();
        System.out.print("Enter roll number: ");
        int roll = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter CGP: ");
        double cgp = sc.nextDouble();
        sc.nextLine();
        System.out.print("Enter branch: ");
        String branch = sc.nextLine();

        Student newStudent = new Student(name, roll, cgp, branch, advisor, age);
        students[count] = newStudent;

        Arrays.sort(students, 0, count + 1, Comparator.comparingInt(s -> s.roll));
    }

    public static void DeleteStudent(Student[] students, int count, int roll) {
        int index = -1;
        for (int i = 0; i < count; i++) {
            if (students[i] != null && students[i].roll == roll) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println("Student not found.");
            return;
        }
        for (int i = index; i < count - 1; i++) {
            students[i] = students[i + 1];
        }
        students[count - 1] = null;
    }

    public static void ADDFaculty(Faculty[] faculty, int index) {
        System.out.print("Enter faculty name: ");
        String name = sc.next();
        System.out.print("Enter AGE: ");
        int age = sc.nextInt();
        System.out.print("Enter faculty ID: ");
        int empID = sc.nextInt();
        sc.nextLine();
        faculty[index] = new Faculty(name, empID, age);
    }

    public static void DeleteFaculty(Faculty[] faculty, Student[] students, int index) {
        if (index < 0 || index >= faculty.length || faculty[index] == null) {
            System.out.println("Faculty not Found");
            return;
        }

        for (int i = 0; i < students.length; i++) {
            if (students[i] != null && students[i].advisor == faculty[index]) {
                students[i].advisor = null;
            }
        }

        faculty[index] = null;
    }

    public static void updateStudent(Student student) {
        System.out.print("Update name: ");
        student.name = sc.nextLine();
        System.out.print("Update age: ");
        student.age = sc.nextInt();
        System.out.print("Update CGP: ");
        student.cgp = sc.nextDouble();
        sc.nextLine();
        System.out.print("Update branch: ");
        student.branch = sc.nextLine();
    }

    public static void getStudentDetails(Student student) {
        if (student != null) {
            System.out.println("Name: " + student.name);
            System.out.println("AGE: " + student.age);
            System.out.println("Roll: " + student.roll);
            System.out.println("CGP: " + student.cgp);
            System.out.println("Branch: " + student.branch);
            System.out.println("Advisor: " + student.advisor);
        } else {
            System.out.println("Student not found.");
        }
    }

    public static void getFacultyAdvisor(Student student) {
        if (student != null && student.advisor != null) {
            System.out.println("Advisor Name: " + student.advisor.name);
            System.out.println("Advisor AGE: " + student.advisor.age);
            System.out.println("Advisor ID: " + student.advisor.empID);
        } else {
            System.out.println("Advisor not found.");
        }
    }

    public static Student searchStudent(Student[] students, int count, int roll) {
        for (int i = 0; i < count; i++) {
            if (students[i] != null && students[i].roll == roll) {
                return students[i];
            }
        }
        System.out.println("NO STUDENT FOUND");
        return null;
    }

    public static Person searchPerson(Person[] persons, String name, int count) {
        for (int i = 0; i < count; i++) {
            if (persons[i] != null && persons[i].name.equals(name)) {
                return persons[i];
            }
        }
        System.out.println("NO PERSON OF SUCH NAME");
        return null;
    }

    public static int deletePerson(Person[] persons, String name, int count) {
        for (int i = 0; i < count; i++) {
            if (persons[i] != null && persons[i].name.equals(name)) {
                for (int j = i; j < count - 1; j++) {
                    persons[j] = persons[j + 1];
                }
                persons[count - 1] = null;
                return 1;
            }
        }
        System.out.println("Person not Found");
        return 0;
    }
    
    public static void addPerson(Person[] p , int count) {
        System.out.print("Enter the name of person: ");
        sc.nextLine();
        String name = sc.nextLine();
        System.out.print("Enter AGE : ");
        int age = sc.nextInt();
        p[count]=new Person(name,age);
    }
     
    public static void main(String[] args) {
        Faculty[] faculty = new Faculty[3];
        Student[] students = new Student[6];
        Person[] persons = new Person[5];
        int p = 2;
        int m = 2;
        int n = 1;

        persons[0] = new Person("person1", 1);
        persons[1] = new Person("person2", 2);
        faculty[0] = new Faculty("faculty1", 1, 1);
        students[0] = new Student("student1", 1, 1, "branch1", faculty[0], 1);
        students[1] = new Student("student2", 2, 2, "branch2", faculty[0], 2);

        System.out.println(
                "1.) ADD student \n2.) Delete student \n3.) ADD faculty \n4.) Delete faculty \n5.) Update student records \n6.) Get student details \n7.) Get advisor details \n8.) ADD PERSON \n9.) DELETE PERSON \n10.) GET PERSON DETAILS\n");

        while (true) {
            System.out.print("\nEnter your choice: ");
            int i = sc.nextInt();
            
            switch (i) {
                case 1:
                    System.out.print("Enter the faculty advisor (1 or 2): ");
                    int k = sc.nextInt();
                    ADDStudent(students, m, faculty[k - 1]);
                    m++;
                    break;
                case 2:
                    System.out.print("Enter the roll number of student: ");
                    int r = sc.nextInt();
                    DeleteStudent(students, m, r);
                    m--;
                    break;
                case 3:
                    if (n > 2) {
                        System.out.println("NO PLACE AVAILABLE");
                        break;
                    }
                    ADDFaculty(faculty, n);
                    n++;
                    break;
                case 4:
                    if (n <= 0) {
                        System.out.println("NO FACULTY REMAINS");
                        break;
                    }
                    System.out.print("Enter the employee ID (1 or 2): ");
                    int id = sc.nextInt();
                    DeleteFaculty(faculty, students, id - 1);
                    n--;
                    break;
                case 5:
                    System.out.print("Enter the roll number of student: ");
                    r = sc.nextInt();
                    sc.nextLine();
                    updateStudent(searchStudent(students, m, r));
                    break;
                case 6:
                    System.out.print("Enter the roll number of student: ");
                    r = sc.nextInt();
                    getStudentDetails(searchStudent(students, m, r));
                    break;
                case 7:
                    System.out.print("Enter the roll number: ");
                    r = sc.nextInt();
                    getFacultyAdvisor(searchStudent(students, m, r));
                    break;
                case 8:
                    addPerson(persons,p);
                    p++;
                    break;
                case 9:
                    System.out.print("Enter the name to be deleted: ");
                    sc.nextLine();
                    String name = sc.nextLine();
                    int t=0;
                    t=deletePerson(persons, name, p);
                    if(t==1) p--;
                    break;
                case 10:
                    System.out.print("Enter the name to get details: ");
                    sc.nextLine();
                    name = sc.nextLine();
                    Person personCount = searchPerson(persons, name, p);
                    if (personCount != null) personCount.getDetails();
                    break;
                default:
                System.out.println(
                    "1.) ADD student \n2.) Delete student \n3.) ADD faculty \n4.) Delete faculty \n5.) Update student records \n6.) Get student details \n7.) Get advisor details \n8.) ADD PERSON \n9.) DELETE PERSON \n10.) GET PERSON DETAILS\n");
    
            }
        }
    }
}