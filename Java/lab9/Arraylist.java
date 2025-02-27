package Java.lab9;

import java.util.*;

class Student{
    String name;
    int roll;
    String birthyear;
    Student(String name,int roll,String birthyear){
        this.name=name;
        this.roll=roll;
        this.birthyear=birthyear;
    }
    public String getFirstName() {
        return this.name.split(" ")[0];
    }

    public String getTitle() {
        String[] parts = this.name.split(" ");
        if (parts.length > 1) {
            return parts[1];
        } else {
            return "";
        }
    }
    

    public void getStudentDetails() {
        System.out.println("Name: " + this.name);
        System.out.println("Roll: " + this.roll);
        System.out.println("Birthyear: " + this.birthyear);
        // System.out.println("");
    }
}

public class Arraylist {
    static int n=5;

    static void showStudents(ArrayList<Student> students){
            for (Student student : students) {
                student.getStudentDetails();
            }
    }
    static void displayStudents(Student[] students) {
        for (Student student : students) {
            student.getStudentDetails();
        }
    }

    public static void main(String[] args) {
        
        ArrayList<Student> student = new ArrayList<>();
        student.add(new Student("name1",10,"101"));
        student.add(new Student("name2 title2",2,"202"));
        student.add(new Student("name83 title63",3,"303"));
        student.add(new Student("name64 title84",4,"404"));
        student.add(new Student("name5 title5",5,"505"));

        Student[] students=new Student[5];
        students[0]=new Student("name1",10,"101");
        students[1]=new Student("name2 title2",2,"202");
        students[2]=new Student("name83 title63",3,"303");
        students[3]=new Student("name64 title84",4,"404");
        students[4]=new Student("name5 title5",5,"505");
    
        System.out.println("\n----------------Original----------------");
        displayStudents(students);

        Arrays.sort(students, (a,b) -> a.getFirstName().compareTo(b.getFirstName()));
        System.out.println("\n----------------Sorted by First Name----------------");
        displayStudents(students);

        Arrays.sort(students, (a,b) -> a.getTitle().compareTo(b.getTitle()));
        System.out.println("\n----------------Sorted by Title----------------");
        displayStudents(students);

        Arrays.sort(students, (a, b) -> a.birthyear.compareTo(b.birthyear));
        System.out.println("\n----------------Sorted by Birth Year----------------");
        displayStudents(students);

        System.out.println("\n----------------Reverse RollNo----------------");
        Arrays.sort(students, (a, b) -> b.roll-a.roll);
        displayStudents(students);


    }
}

