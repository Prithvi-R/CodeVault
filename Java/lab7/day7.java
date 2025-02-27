package Java.lab7;

import java.util.*;
/*
   Q1. Write a Java program to implement the addition operation as listed in below. (Use method overloading) 
   int add() : It takes no arguement. Arguments are taken from user and the final result is returned as int.
   int add(int a, int b) : It takes two argument and adds them and returns the sum as int.
   int add(int a, int b, int c) : It takes three arguments, adds them and returns the sum as int.
  
   Q2. Write a Java program to create a class called Shape with a method called
   getArea(). Create a subclass called Rectangle that overrides getArea() method to
   calculate the area of the rectangle.
*/

class Shape {
    int getArea(){
        return 0;
    }
}

class Rectangle extends Shape {
    int width;
    int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    int getArea() {
        return width * height;
    }
}

public class day7 {
    static int add(){
        Scanner sc = new Scanner(System.in);
        int sum=0,a,n;
        System.out.print("Enter total no. of numbers to add: ");
        n=sc.nextInt();
        for(int i=0;i<n;i++){
            System.out.print("Enter no.: ");
            a=sc.nextInt();
            sum = sum + a;;
        }
        sc.close();
        return sum;
    }
    static int add(int a,int b){
        return a+b;
    }
    static int add(int a,int b,int c){
        return a+b+c;
    }

    static void q1(){
        System.out.println("First: ");
        System.out.println("Result: "+ add());
        System.out.println("Second: ");
        Scanner sc = new Scanner(System.in);
        int c,a,b;
        System.out.print("Enter a: ");
        a=sc.nextInt();
        System.out.print("Enter b: ");
        b=sc.nextInt();
        System.out.println("Result: "+ add(a,b));
        System.out.println("Third: ");
        System.out.print("Enter a: ");
        a=sc.nextInt();
        System.out.print("Enter b: ");
        b=sc.nextInt();
        System.out.print("Enter c: ");
        c=sc.nextInt();
        System.out.println("Result: "+ add(a,b,c));
        sc.close();
    }

    static void q2(){
        Scanner sc = new Scanner(System.in);
        int w,h;
        System.out.print("Width: ");
        w=sc.nextInt();
        System.out.print("Height: ");
        h=sc.nextInt();
        Rectangle rect = new Rectangle(w,h);
        int area=rect.getArea();
        if(area!=0){System.out.println("Area of the rectangle: " + area);}
        else{System.out.println("Area isn't defined.");}
        sc.close();
    }
    public static void main(String[] args) {
        System.out.println("Ques: 1");
        q1();
        System.out.println("Ques: 2");
        q2();
    }
}