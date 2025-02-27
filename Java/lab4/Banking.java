package Java.lab4;
import java.util.*;

class Accounts{
    int accountNumber;
    String accountType;
    String serviceBranchIFSC;
    float minimumBalance;
    float availableBalance;
    int customerID;
    String customerName;
    int totalAccountCreated;
    int yearCreated;

    void setDetails(){
		Scanner sc = new Scanner(System.in);

        System.out.println("");
        System.out.print("Enter the Account Number: ");
        this.accountNumber = sc.nextInt();
        sc.nextLine();//remove Enter
        System.out.print("Enter the Account Type: ");
        this.accountType = sc.nextLine();
        System.out.print("Enter the Service Branch IFSC: ");
        this.serviceBranchIFSC = sc.nextLine();

        System.out.print("Enter the minimum Balance: ");
        this.minimumBalance = sc.nextFloat();
        System.out.print("Enter the available Balance: ");
        this.availableBalance = sc.nextFloat();

        System.out.print("Enter the customer ID: ");
        this.customerID = sc.nextInt();
        sc.nextLine();//remove Enter
        System.out.print("Enter the Customer Name: ");
        customerName = sc.nextLine();
        // sc.close();
    }
    String getDetails(int accountNumber){
        if(this.accountNumber == accountNumber){
            // System.out.println("Account Number: " + accountNumber);
            // System.out.println("Account Type: "+ accountType);
            // System.out.println("Service Branch IFSC: "+ serviceBranchIFSC);
            
            // System.out.println("Minimum Balance: "+ minimumBalance);
            // System.out.println("Available Balance: "+ availableBalance);

            // System.out.println("Customer ID: "+ customerID);
            // System.out.println("Customer Name: "+ customerName);

            return("Account Number: " + accountNumber
                    + "\n Account Type: "+ accountType
                    + "\n Service Branch IFSC: "+ serviceBranchIFSC

                    + "\n Minimum Balance: "+ minimumBalance
                    + "\n Available Balance: "+ availableBalance

                    + "\n Customer ID: "+ customerID
                    + "\n Customer Name: "+ customerName);
        }
        return "";
    }

    void updateDetails(int accountNumber){
        if(this.accountNumber == accountNumber){
            System.out.println(" 1. accountType\r\n" + 
                                "2. serviceBranchIFSC\r\n" + 
                                "3. minimumBalance\r\n" + 
                                "4. availableBalance\r\n" + 
                                "5. customerID\r\n" + 
                                "6. customerName");
		    Scanner sc = new Scanner(System.in);
            int option = sc.nextInt();
            switch(option){
                case 1:{
                    this.accountType = sc.nextLine();
                    break;
                }
                case 2:{
                    this.serviceBranchIFSC = sc.nextLine();
                    break;
                }
                case 3:{
                    this.minimumBalance = sc.nextFloat();
                    sc.nextLine();
                    break;
                }
                case 4:{
                    this.availableBalance = sc.nextFloat();
                    sc.nextLine();
                    break;
                }
                case 5:{
                    this.customerID = sc.nextInt();
                    sc.nextLine();
                    break;
                }
                case 6:{
                    this.customerName = sc.nextLine();
                    break;
                }
                default:{
                    System.out.println(" 1. accountType\r\n" + 
                                        "2. serviceBranchIFSC\r\n" + 
                                        "3. minimumBalance\r\n" + 
                                        "4. availableBalance\r\n" + 
                                        "5. customerID\r\n" + 
                                        "6. customerName"
                                        );
                }
            }
            // sc.close();
        }
    }

    float getBalance(int accountNumber){
        if(this.accountNumber == accountNumber){
            return this.availableBalance;
        }
        return 0;
    }

    void deposit(int accountNumber, float amount){
        if(this.accountNumber == accountNumber){
            this.availableBalance = this.availableBalance + amount;
        }
    }

    void withdraw(int accountNumber, float amount){
        if(this.accountNumber == accountNumber){
            this.availableBalance = this.availableBalance - amount;
        }
    }
    int totalAccount(){
        return totalAccountCreated;
    }

    void compare (int accountNumber1,int accountNumber2){
        int accountNumber;
        if(accountNumber1 >= accountNumber2){
            accountNumber = accountNumber1;
        }else{
            accountNumber = accountNumber2;
        }
        System.out.println(getDetails(accountNumber));
    }
}

public class Banking {
    static int n = 3;

    static int match(int id,Accounts[] accounts){
        int i;
        for(i = 0; i <n; ++i){
            if(accounts[i].accountNumber == id)
                break;
        }
        return i;
    }
    static int compare (int accountNumber1,int accountNumber2){
        int accountNumber;
        if(accountNumber1 >= accountNumber2){
            accountNumber = accountNumber1;
        }else{
            accountNumber = accountNumber2;
        }
        return accountNumber;
        // System.out.println(getDetails(accountNumber));
        // System.out.println("Details:\n"+ accounts[id].getDetails(accountNumber));
    }
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
        Accounts[] accounts = new Accounts[n];

        while(true){
            System.out.println("");
            System.out.print("Enter Option:(for menu enter 10+) ");
            int option = sc.nextInt();
            switch(option){
                case 0:{
                    return;
                }
                case 1:{
                    for(int i=0;i<n;++i){
                        Accounts obj = new Accounts();
                        accounts[i] = obj;
                        accounts[i].setDetails();
                    }
                    break;
                }
                case 2:{
                    System.out.print("Enter Account Number: ");
                    int accountNumber = sc.nextInt();
                    int id = match(accountNumber, accounts);
                    System.out.println("Details:\n"+ accounts[id].getDetails(accountNumber));
                    break;
                }
                case 3:{
                    System.out.print("Enter Account Number: ");
                    int accountNumber = sc.nextInt();
                    int id = match(accountNumber, accounts);
                    accounts[id].updateDetails(accountNumber);
                    break;
                }
                case 4:{
                    System.out.print("Enter Account Number: ");
                    int accountNumber = sc.nextInt();
                    int id = match(accountNumber, accounts);
                    System.out.println("Your Balance is: " +accounts[id].getBalance(accountNumber));
                    break;
                }
                case 5:{
                    System.out.print("Enter Account Number: ");
                    int accountNumber = sc.nextInt();
                    int id = match(accountNumber, accounts);
                    System.out.print("Enter Amount to deposit: ");
                    float amount = sc.nextFloat();
                    accounts[id].deposit(accountNumber, amount);
                    break;
                }
                case 6:{
                    System.out.print("Enter Account Number: ");
                    int accountNumber = sc.nextInt();
                    int id = match(accountNumber, accounts);
                    System.out.print("Enter Amount to withdraw: ");
                    float amount = sc.nextFloat();
                    accounts[id].withdraw(accountNumber, amount);
                    break;
                }
                case 7:{
                    System.out.print("Enter First Account Number: ");
                    int accountNumber1 = sc.nextInt();
                    System.out.print("Enter Secound Account Number: ");
                    int accountNumber2 = sc.nextInt();
                    int accountNumber = compare(accountNumber1,accountNumber2);
                    int id = match(accountNumber, accounts);
                    System.out.println("Details:\n"+ accounts[id].getDetails(accountNumber));
                    break;
                }
                case 8:{
                    System.out.println("Total Number of Account created: "+ n);
                    break;
                }
                default:{
                    System.out.println("0: Exit");
                    System.out.println("1: SetDetails");
                    System.out.println("2: GetDetails");
                    System.out.println("3: UpdateDetails");
                    System.out.println("4: GetBalance");
                    System.out.println("5: Deposit");
                    System.out.println("6: Withdraw");
                    System.out.println("7: Compare");
                    System.out.println("8: Total Account");
                }
            }
            sc.close();
        }
        
	}
}