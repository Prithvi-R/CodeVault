package Java.lab11;

import java.util.*;

class InvalidPINsize extends Exception {
    public InvalidPINsize(String message) {
        super(message);
    }
}

class InvalidRollNumber extends Exception {
    public InvalidRollNumber(String message) {
        super(message);
    }
}
class InvalidEmailException extends Exception {
    public InvalidEmailException(String message) {
        super(message);
    }
}

class InvalidEmployeeID extends Exception {
    public InvalidEmployeeID(String message) {
        super(message);
    }
}

class Person {
    String firstName;
    String lastName;
    String PAN;
    String PIN;

    Person(String firstName, String lastName, String PAN, String PIN) throws InvalidPINsize {
        this.firstName = firstName;
        this.lastName = lastName;
        this.PAN = PAN;
        setPin(PIN);
    }

    private void setPin(String PIN) throws InvalidPINsize {
        if (PIN.length() != 6) {
            throw new InvalidPINsize("\nInvalid PIN Size!(It must be of 6 digits) \n");
        } 

        for (char c : PIN.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new InvalidPINsize("\nInvalid PIN! (Only numberrs allowed) \n");
            }
        }

        this.PIN = PIN;
    }

    public void getPersonDetails() {
        System.out.println("Name: " + this.firstName+" "+this.lastName);
        System.out.println("PAN: " + this.PAN);
        System.out.println("PIN: " + this.PIN);
    }
}

class Student extends Person {
    String emailId;
    String roll;

    Student(String firstName, String lastName, String PAN, String PIN, String emailId, String roll)
            throws InvalidPINsize, InvalidRollNumber, InvalidEmailException {
        super(firstName, lastName, PAN, PIN);
        // this.emailId = emailId;
        setEmailId(emailId);
        setRoll(roll);
    }

    private void setEmailId(String emailId) throws InvalidEmailException {
        if (!emailId.contains("@") || checksubstring(emailId)) {
            throw new InvalidEmailException("\nInvalid Email Format(It must contain @ followed by a domain name.) \n");
        }else{
            this.emailId = emailId;
        }
    }

    private boolean checksubstring(String emailId) throws InvalidEmailException {
        String local = emailId.substring(0, emailId.indexOf("@"));
        String domain = emailId.substring(emailId.indexOf("@") + 1);

        if (!(local.contains("!") ||
            local.contains("#") || local.contains("$") ||
            local.contains("&") || local.contains("*") || 
            (local.contains("@") || domain.contains("@") )) 
            || 
                (domain.isEmpty() || !domain.contains("."))
            ) {
            throw new InvalidEmailException("\nInvalid Email Format(Also must contain a special character (anyone from the set {@, !, #, $, &,*}) in the first part before @.) \n" );
            // return true;
        } else{
            return false;
        }
    }


    private void setRoll(String roll) throws InvalidRollNumber {
        if (!roll.startsWith("stud") || roll.length() != 9) {
            throw new InvalidRollNumber("\nWrong Roll Number format! (It must start with 'stud' and be 9 characters long)\n");
        } else {
            this.roll = roll;
        }
    }

    public void getStudentDetails() {
        super.getPersonDetails();
        System.out.println("Email ID: " + this.emailId);
        System.out.println("Roll: " + this.roll);
    }
}

class Employee extends Person {
    String emailId;
    String employeeId;

    Employee(String firstName, String lastName, String PAN, String PIN, String emailId, String employeeId)
            throws InvalidPINsize, InvalidEmployeeID, InvalidEmailException {
        super(firstName, lastName, PAN, PIN);
        // this.emailId = emailId;
        setEmailId(emailId);
        setEmpId(employeeId);
    }

    private void setEmpId(String employeeId) throws InvalidEmployeeID {
        if (!employeeId.startsWith("emp") || employeeId.length() != 6) {
            throw new InvalidEmployeeID("\nWrong Employee ID format! (It must start with 'emp' and be 6 characters long)\n");
        } else {
            this.employeeId = employeeId;
        }
    }
    private void setEmailId(String emailId) throws InvalidEmailException {
        if (!emailId.contains("@") || checksubstring(emailId)) {
            throw new InvalidEmailException("\nInvalid Email Format(It must contain @ followed by a domain name.Also must contain a special character (anyone from the set {@, !, #, $, &,*}) in the first part before @.) \n" );
        }else{
            this.emailId = emailId;
        }
    }

    private boolean checksubstring(String emailId) throws InvalidEmailException {
        String local = emailId.substring(0, emailId.indexOf("@") - 1);
        String domain = emailId.substring(emailId.indexOf("@") + 1);

        if (!(local.contains("!") ||
            local.contains("#") || local.contains("$") ||
            local.contains("&") || local.contains("*") || 
            (local.contains("@") || domain.contains("@") )) 
            || 
                (domain.isEmpty() || !domain.contains("."))
            ) {
            throw new InvalidEmailException("\nInvalid Email Format(Also must contain a special character (anyone from the set {@, !, #, $, &,*}) in the first part before @.) \n" );
            // return true;
        } else{
            return false;
        }
    }


    public void getEmployeeDetails() {
        super.getPersonDetails();
        System.out.println("Email ID: " + this.emailId);
        System.out.println("Employee ID: " + this.employeeId);
    }
}

public class day11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Employee> employees = new ArrayList<>();

        System.out.println("Enter Student Details:");
        String sFirstName = promptForInput(scanner, "First Name: ");
        String sLastName = promptForInput(scanner, "Last Name: ");
        String sPAN = promptForInput(scanner, "PAN: ");
        String sPIN = promptForInput(scanner, "PIN (6 digits): ");
        String sEmailId = promptForInput(scanner, "Student Email ID: ");
        String sRoll = promptForInput(scanner, "Roll Number: ");

        try {
            Student student = new Student(sFirstName, sLastName, sPAN, sPIN, sEmailId, sRoll);
            students.add(student);
            System.out.println("Student added successfully!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nEnter Employee Details:");
        String eFirstName = promptForInput(scanner, "First Name: ");
        String eLastName = promptForInput(scanner, "Last Name: ");
        String ePAN = promptForInput(scanner, "PAN: ");
        String ePIN = promptForInput(scanner, "PIN (6 digits): ");
        String eEmailId = promptForInput(scanner, "Employee Email ID: ");
        String eEmployeeId = promptForInput(scanner, "Employee ID: ");

        try {
            Employee employee = new Employee(eFirstName, eLastName, ePAN, ePIN, eEmailId, eEmployeeId);
            employees.add(employee);
            System.out.println("Employee added successfully!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Display Student Details
        System.out.println("\n-------------------Student Details-------------------");
        for (Student stud : students) {
            stud.getStudentDetails();
        }

        // Display Employee Details
        System.out.println("\n-------------------Employee Details-------------------");
        for (Employee emp : employees) {
            emp.getEmployeeDetails();
        }

        scanner.close();
    }

    private static String promptForInput(Scanner scanner, String prompt) {
        String input;
        while (true) {
            try {
                System.out.print(prompt);
                input = scanner.nextLine();
                if (prompt.contains("PIN")) {
                    new Person("temp", "temp", "temp", input);
                } else if (prompt.contains("Student Email ID")) {
                    new Student("temp", "temp", "temp", "123456", input, "stud12345");
                } else if (prompt.contains("Employee Email ID")) {
                    new Employee("temp", "temp", "temp", "123456", input, "emp123");
                } else if (prompt.contains("Roll Number")) {
                    new Student("temp", "temp", "temp", "123456", "as$d@gmail.com", input);
                } else if (prompt.contains("Employee ID")) {
                    new Employee("temp", "temp", "temp", "123456", "as$d@gmail.com", input);
                }
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return input;
    }
}
