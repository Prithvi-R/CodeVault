import java.util.*;


class Students {
    int roll_no;
    String name;
    String branch;
    float cgpa;

    void set() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Value for Student: ");
        System.out.print("Enter Name: ");
        name = sc.nextLine();

        System.out.print("Enter Roll No: ");
        roll_no = sc.nextInt();
		
        branch = sc.nextLine(); //kaam ni kr rha tha (Clears Enter one)
        System.out.print("Enter Branch: ");
        branch = sc.nextLine();

        System.out.print("Enter CGPA: ");
        cgpa = sc.nextFloat();
    }

    boolean branch_change() {
        if (cgpa > 9.0) {
            branch = "CSE";
            return true;
        }
        return false;
    }

    void print_student_details() {
		System.out.println("--------------------");
        System.out.println("Name: " + name);
        System.out.println("Roll No: " + roll_no);
        System.out.println("Branch: " + branch);
        System.out.println("CGPA: " + cgpa);
		System.out.println("--------------------");
		System.out.println("");
    }
}

public class Branch_change {
	public static void main(String args[]) {
		// Scanner sc = new Scanner(System.in);
		Students s1 = new Students();
		Students s2 = new Students();

		s1.set();
		s2.set();

		s1.print_student_details();
		s2.print_student_details();

		System.out.println("=====================");
		System.out.println("After Branch Change: ");

		s1.branch_change();
		s2.branch_change();

		s1.print_student_details();
		s2.print_student_details();

	}
}