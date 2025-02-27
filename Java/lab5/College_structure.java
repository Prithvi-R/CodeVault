package Java.lab5;
import java.util.*;

class Faculty{
    String name;
    int empID;
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
        Scanner sc = new Scanner(System.in);
            System.out.println(" 1. Student Name\r\n" + 
                                "2. Student RollNo\r\n" + 
                                "3. Student CGPA\r\n" + 
                                "4. Branch Details\r\n" + 
                                "5. College ID\r\n"  
                                //+ "6. faculty"
                                );
            int option = sc.nextInt();
            sc.nextLine();
            switch(option){
                case 1:{
                    this.name = sc.nextLine();
                    break;
                }
                case 2:{
                    // // this.rollNumber = sc.nextInt();
                    // sc.nextLine();
                    //
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
            }
            sc.close();
    }

    Faculty getAdvisor(){
        return this.facultyAdvisor;
    }

    
}

public class College_structure{
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

    static void sortStudent(){
        Students tempStudent = new Students();
        for(int i=0;i<n;++i){
            for(int j=i;j<n;++j){
                if(students[i].rollNumber < students[j].rollNumber){
                    tempStudent = students[i];
                    students[i] = students[j];
                    students[j] = tempStudent;
                }
            }

        }
    }
    static void sortFaculty(){
        Faculty tempFaculty = new Faculty();
        for(int i=0;i<m;++i){
            for(int j=i;j<m;++j){
                if(faculties[i].empID < faculties[j].empID){
                    tempFaculty = faculties[i];
                    faculties[i] = faculties[j];
                    faculties[j] = tempFaculty;
                }
            }

        }
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
        sortFaculty();
        sc.close();
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
        sortStudent();
        sc.close();
    }
    static void delStudents(int rollNumber){
        for(int i=0;i<n;++i){
            if(rollNumber == students[i].rollNumber){
                students[i].rollNumber = -1; 
                rollNumber = -1;
            }
        }
        if(rollNumber!=-1){System.out.println("There isn't such Student available.");return;}
        sortStudent();
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
        sortFaculty();
        m--;
    }


	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("");
            System.out.print("Enter Option:(Hint: Menu after 10+) ");
            int option = sc.nextInt();
            sc.nextLine();
            switch(option){
                case 0:{
                    return;
                }
                case 1:{
                    addStudent();
                    
                    break;
                }
                case 2:{
                    System.out.print("Enter Roll Number: ");
                    int number = sc.nextInt();
                    sc.nextLine();
                    delStudents(number);
                    break;
                }
                case 3:{
                    addFaculty();
                    
                    break;
                }
                case 4:{
                    System.out.print("Enter Employee ID: ");
                    int number = sc.nextInt();
                    sc.nextLine();
                    delFaculty(number);
                    break;
                }
                case 5:{
                    System.out.print("Enter Roll Number: ");
                    int number = sc.nextInt();
                    sc.nextLine();
                    int id = match(number);
                    System.out.println("Details:\n"+ students[id].getStudentDetails());
                    break;
                }
                case 6:{
                    System.out.print("Enter Roll Number: ");
                    int number = sc.nextInt();
                    sc.nextLine();
                    int id = match(number);
                    if(id==-1||id>n){
                        System.out.println("Student not available");
                        break;
                    }
                    System.out.println("Details:\n"+ students[id].facultyAdvisor.tooString());
                    break;
                }
                case 7:{
                    System.out.print("Enter Roll Number: ");
                    int number = sc.nextInt();
                    sc.nextLine();
                    int id = match(number);
                    students[id].updateStudentRecord();
                    break;
                }
                case 8:{
                    System.out.println("MaaHudao: "+ n);
                    break;
                }
                default:{
                    System.out.println("0: Exit");
                    System.out.println("1: AddStudent");
                    System.out.println("2: DelStudent");
                    System.out.println("3: AddFaculty");
                    System.out.println("4: DelFaculty");
                    System.out.println("5: GetStudentDetails");
                    System.out.println("6: GetFaculty");
                    System.out.println("7: UpdateStudent");
                    // System.out.println("8: Total Account");
                }
            }
            sc.close();
        }
        
	}
}