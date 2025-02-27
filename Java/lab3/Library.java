package Java.lab3;
import java.util.*;

class Books{
    int bookID;
    String bookTitle;
    int yearOfPublication;
    String authorName;
    String publisherName;
    int numberOfAvailableCopies;
    int totalCopies;

    void setDetails(int id,String title,int year,String author,String publisher,int count){
        this.bookID = id;
        this.bookTitle = title;
        this.yearOfPublication = year;
        this.authorName = author;
        this.publisherName = publisher;
        this.numberOfAvailableCopies = count;
        // totalCopies = sc.nextInt();
        // sc.close();
    }
    void getDetails(){
        System.out.println("Book ID: " + bookID);
        System.out.println("Book Title: "+ bookTitle);
        System.out.println("Book yearOfPublication: "+ yearOfPublication);
        
        System.out.println("Book authorName: "+ authorName);
        System.out.println("Book publisherName: "+publisherName);

        System.out.println("numberOfAvailableCopies: "+numberOfAvailableCopies);
    }

    void issue(){
        if(this.numberOfAvailableCopies > 0){
            this.numberOfAvailableCopies = this.numberOfAvailableCopies - 1;
            System.out.println("Your Book "+this.bookTitle +" is being issued.");
        }
        else System.out.println("Book isn't available to issue.");
    }

    void returnBooks(){
        this.numberOfAvailableCopies = this.numberOfAvailableCopies + 1;
        System.out.println("Thankyou for returning the Book.");
    }
}

public class Library {
    static int n = 3;
    static int match(int id,Books[] books){
        int i;
        for(i = 0; i <n; ++i){
            if(books[i].bookID == id)
                break;
        }
        return i;
    }

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
        Books[] books = new Books[n];

        while(true){
            System.out.println("");
            System.out.print("Enter Option: ");
            int option = sc.nextInt();
            switch(option){
                case 0:{
                    return;
                }
                case 1:{
                    for(int i=0;i<n;++i){
                        Books obj = new Books();
                        books[i] = obj;
                        // System.out.print("set: "+i);
                        // books[i].setDetails(i, null, i, null, null, i);
            
                        // Scanner sc = new Scanner(System.in);
                        System.out.println("");
                        System.out.print("Enter the Book ID: ");
                        int bookID = sc.nextInt();
                        String bookTitle = sc.nextLine();//remove Enter
                        System.out.print("Enter the Book Title: ");
                        bookTitle = sc.nextLine();
                        System.out.print("Enter the Book yearOfPublication: ");
                        int yearOfPublication = sc.nextInt();
                        String authorName = sc.nextLine();//remove Enter
                        System.out.print("Enter the Book authorName: ");
                        authorName = sc.nextLine();
                        // publisherName = sc.nextLine();//remove Enter
                        System.out.print("Enter the Book publisherName: ");
                        String publisherName = sc.nextLine();
                        System.out.print("Enter the numberOfAvailableCopies: ");
                        int numberOfAvailableCopies = sc.nextInt();
                        // totalCopies = sc.nextInt();
                        // sc.close();
                        books[i].setDetails(bookID, bookTitle, yearOfPublication, authorName, publisherName, numberOfAvailableCopies);
                    }
                    break;
                }
                case 2:{
                    System.out.print("Enter Book ID: ");
                    int id = match(sc.nextInt(), books);
                    books[id].getDetails();
                    break;
                }
                case 3:{
                    System.out.print("Enter Book ID: ");
                    int id = match(sc.nextInt(), books);
                    books[id].issue();
                    break;
                }
                case 4:{
                    System.out.print("Enter Book ID: ");
                    int id = match(sc.nextInt(), books);
                    books[id].returnBooks();
                    break;
                }
                default:{
                    System.out.println("0: Exit");
                    System.out.println("1: SetDetails");
                    System.out.println("2: GetDetails");
                    System.out.println("3: Issue a Book");
                    System.out.println("4: Return a Book");
                }
            }
        sc.close();
        }
	}
}