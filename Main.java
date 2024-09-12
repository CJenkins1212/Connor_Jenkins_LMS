import java.util.*;

public class Main {
    public static void main(String[] args) {
        //Initializes scanner
        Scanner myObj = new Scanner(System.in);
        //Initializes variables for loop
        int inf = 0;
        int cho = 0;

        //Initializes library object
        Library L1 = new Library();

        //Infinite loop
        while (inf == 0) {
            //User prompt
            System.out.println("Enter 1 to display the library\nEnter 2 to add books to library\nEnter 3 to remove a book from the library\nEnter 0 to exit");
            //Takes user input
            cho = myObj.nextInt();
            if (cho == 1) {
                L1.printLibrary();
            } else if (cho == 2) {
                L1.addBooks();
            } else if (cho == 3) {
                L1.removeBooks();
            } else if (cho == 0) {
                //Shuts down program
                System.exit(0);
            }

        }
    }
}