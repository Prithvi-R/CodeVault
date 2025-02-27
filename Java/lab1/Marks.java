import java.util.*;

public class Marks{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter marks: ");
        int marks = sc.nextInt();
        if(marks >= 90){
            System.out.println("Grade AA");
        }else if(marks >= 80 && marks < 90){
            System.out.println("Grade AB");
        }else if(marks >= 70 && marks < 90){
            System.out.println("Grade BB");
        }else {
            System.out.println("Grade F");
        }
        sc.close();
    }
}