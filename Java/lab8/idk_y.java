package Java.lab8;

/*
   idk why they need the same code twice..........Better Go and see other one
*/

import java.util.*;

class Faculty{
    String name;
    int empID;
    Faculty(){
        this.name = "NAME01";
        this.empID = 1001;
    }
    Faculty(String name, int empID) {
        this.name = name;
        this.empID = empID;
    }

    String tooString(){
        return("FacultyName: " + this.name 
                +"\nEmployee ID: " + this.empID);
    }
}


class Students{
    String name;
    int rollNumber;
    double CGPA;
    Faculty facultyAdvisor;
    String branch;
    String collegeID;    

    Students(){
    }
    Students(String name, int rollNumber, double CGPA, Faculty fac, String branch, String collegeID) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.CGPA = CGPA;
        this.facultyAdvisor = fac;
        this.branch = branch;
        this.collegeID = collegeID;
    }
    Students(Students std) {
        this.name = std.name;
        this.rollNumber = std.rollNumber;
        this.CGPA = std.CGPA;
        this.facultyAdvisor = std.facultyAdvisor;
        this.branch = std.branch;
        this.collegeID = std.collegeID;
    }
    Students(Faculty fac){
        this.facultyAdvisor = fac;
    }
    String getStudentDetails(){
        if(this.rollNumber == -1){
            return "Student don't exist";
        }
        if(this.facultyAdvisor.empID != -1){
            return("Student Name: " + name
                    + "\n Student RollNo: "+ rollNumber
                    + "\n Student CGPA: "+ CGPA

                    + "\n Facult Advisor: "+ facultyAdvisor.name
                    + "\n Branch Details: "+ branch

                    + "\n College ID: "+ collegeID);
        }
        else{
            return("Student Name: " + name
                    + "\n Student RollNo: "+ rollNumber
                    + "\n Student CGPA: "+ CGPA

                    + "\n Faculty Advisor: Advisor isn't available"
                    + "\n Branch Details: "+ branch

                    + "\n College ID: "+ collegeID);
        }
    }

    void updateStudentRecord(){
            System.out.println(" 1. Student Name\r\n" + 
                                "2. Student RollNo\r\n" + 
                                "3. Student CGPA\r\n" + 
                                "4. Branch Details\r\n" + 
                                "5. College ID\r\n"  
                                //+ "6. faculty"
                                );
		    Scanner sc = new Scanner(System.in);
            int option = sc.nextInt();
            sc.nextLine();
            switch(option){
                case 1:{
                    this.name = sc.nextLine();
                    break;
                }
                case 2:{
                    System.out.println("TeHee U cant change it... Heheheehehehehehehehehdehehehehrhen");
                    break;
                }
                case 3:{
                    this.CGPA = sc.nextDouble();
                    sc.nextLine();
                    break;
                }
                case 4:{
                    this.branch = sc.nextLine();
                    // sc.nextLine();
                    break;
                }
                case 5:{
                    this.collegeID = sc.nextLine();
                    // sc.nextLine();
                    break;
                }
                case 6:{
                    
                    // this.facultyAdvisor = sc.nextLine();
                    break;
                }            
            // sc.close();
        }
    }

    Faculty getAdvisor(){
        return this.facultyAdvisor;
    }

    
}

public class idk_y {
    static int n = 0;
    static int m = 0;
    static Students[] students = new Students[5];
    static Faculty[] faculties = new Faculty[2];

    static int match(int roll){
        int id=-1;
        for(int i = 0; i < n; ++i){
            if(students[i].rollNumber == roll){
                id=i;break;}
        }
        return id;
    }

    static void addFaculty(){
        if(m>=2){
            System.out.println("Max Limit Reached.");
            return;
        }
        Faculty newfac = new Faculty();
        Scanner sc = new Scanner(System.in);

        System.out.println("");
        System.out.print("Enter the Faculty Name: ");
        newfac.name = sc.nextLine();

        System.out.print("Enter the Faculty Emp ID: ");
        newfac.empID = sc.nextInt();

        faculties[m] = newfac;
        m++;
        
    }
    static void addStudent(){
        boolean condition=true;
        if(n>=5){
            System.out.println("Max Limit Reached.");
            return;
        }
        Students newstudent = new Students();
        Scanner sc = new Scanner(System.in);

        System.out.println("");
        System.out.print("Enter the Student Name: ");
        newstudent.name = sc.nextLine();

        System.out.print("Enter the Studnent RollNumber: ");
        newstudent.rollNumber = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter the obtained CGPA: ");
        newstudent.CGPA = sc.nextDouble();
        sc.nextLine();
        while(condition){
            System.out.print("Enter the Faculty Advisor: ");
            int id = sc.nextInt();
            sc.nextLine();
            for(int i = 0; i<m; ++i){
                if(id == faculties[i].empID){
                    newstudent.facultyAdvisor = faculties[i];
                    id=-1;
                }
            }
            condition=false;
            if(id!=-1){System.out.println("There isn't such Faculty Advisor available.");condition=true;}
        }
        System.out.print("Enter the Branch: ");
        newstudent.branch = sc.nextLine();

        System.out.print("Enter the College ID: ");
        newstudent.collegeID = sc.nextLine();
        students[n] = newstudent;
        n++;
        
        // sc.close();
    }
    static void delStudents(int rollNumber){
        for(int i=0;i<n;++i){
            if(rollNumber == students[i].rollNumber){
                students[i].rollNumber = -1; 
                rollNumber = -1;
            }
        }
        if(rollNumber!=-1){System.out.println("There isn't such Student available.");return;}
        
        n--;
    }
    static void delFaculty(int ID){
        for(int i=0;i<m;++i){
            if(ID == faculties[i].empID){
                faculties[i].empID = -1;
                ID=-1;
            }
        }
        if(ID!=-1){System.out.println("There isn't such Faculty Advisor available.");return;}
        
        m--;
    }

    static Students shallowCopy(Students std){
        return new Students(std);
    }
    static Students deepCopy(Students std){
        Faculty newFaculty = new Faculty(std.facultyAdvisor.name, std.facultyAdvisor.empID);
        return new Students(std.name, std.rollNumber, std.CGPA, newFaculty, std.branch, std.collegeID);
    }


	public static void main(String args[]) {
        addFaculty();
        // addStudent();
        // Students std = students[0];

        Students std = new Students("Kumar", 101, 1.1, faculties[0], "CS", "IIITG");
        Students shallowCopy = shallowCopy(std);
        Students deepCopy = deepCopy(std);

        System.out.println("\nBefore changing Faculty details:");
        System.out.println("Original Student's Faculty: \n" + std.facultyAdvisor.tooString());
        // System.out.println("\nShallow Copied Student's Faculty: \n" + shallowCopy.getStudentDetails());
        System.out.println("\nDeep Copied Student's Faculty: \n" + deepCopy.getStudentDetails());

        std.facultyAdvisor.name = "Sharma Ji";
        std.facultyAdvisor.empID = 202;

        System.out.println("\n\nAfter changing Faculty details:");
        System.out.println("Original Student's Faculty: \n" + std.facultyAdvisor.tooString());
        // System.out.println("\nShallow Copied Student's Faculty: \n" + shallowCopy.getStudentDetails());
        System.out.println("\nDeep Copied Student's Faculty: \n" + deepCopy.getStudentDetails());
    }
}