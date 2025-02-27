package Java.lab10;

import java.util.*;

class Person{
    int age;
    Person(int age){
        this.age = age;
    }
    void eat(){
        System.out.println("Eat Function");
    }
    void sleep(){
        System.out.println("Sleep Function");
    }
}

interface Driver {
    int driveCar();
    int driveBike();
}

interface Singer {
    int riyaz();
    int sing();
}

class Employee extends Person implements Driver,Singer{
    Employee(int age){
        super(age);
    }

    public int officeWork(){
        return (age < 40) ? 20 : 10;
    }

    @Override
    public int driveCar(){
        return (age < 40) ? 10 : 0;
    }

    @Override
    public int driveBike(){
        return (age < 40) ? 5 : 0;
    }

    @Override
    public int sing(){
        return (age < 20) ? 15 : 0;
    }   

    @Override
    public int riyaz() {
        return 0; 
    }
}

public class Polymorphism{
    static void sort(Employee[] employees,int[] eif){
        for(int i = 0; i < 5; i++){
            for (int j = 0; j < 5; j++) {
                if(eif[i] < eif[j]){
                    int temp=eif[j];
                    Employee tempo = employees[j];
                    eif[j] = eif[i];    employees[j] = employees[i];
                    eif[i] = temp;      employees[i] = tempo;
                }
            }
        }
    }
    public static void main(String[] args) {
    
        Employee[] employees = new Employee[5];
    
        employees[0] = new Employee(5);
        employees[1] = new Employee(55);
        employees[2] = new Employee(25);
        employees[3] = new Employee(78);
        employees[4] = new Employee(50);
     
        Driver driver = employees[0];
        Singer singer = employees[0];
        System.out.println("\nDriver Car: " + driver.driveCar());      
        System.out.println("Driver Bike: " + driver.driveBike());
        
        System.out.println("Sing: " + singer.sing());
        
        int[] e = new int[employees.length];
        for (int i = 0; i < employees.length; i++) {
            e[i] = employees[i].driveCar() + employees[i].driveBike() + employees[i].sing() + employees[i].officeWork();
        }
        System.out.println("\n-----------------Before Sorting-------------------------------------");
        for(int i = 0; i < 5; i++){
            System.out.println("Age: "+employees[i].age+"\t EIF: "+e[i]);
        }
        System.out.println("\n-----------------After Sorting-------------------------------------");
        sort(employees, e);
        for(int i = 0; i < 5; i++){
            System.out.println("Age: "+employees[i].age+"\t EIF: "+e[i]);
        }

    }
}