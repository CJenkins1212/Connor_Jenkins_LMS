import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        int inf = 0;
        int cho = 0;

        Library L1 = new Library();

        L1.printLibrary();

        while (inf == 0) {
            System.out.println("Enter 1 to display the library\nEnter 2 to add books to library\nEnter 3 to remove a book from the library\nEnter 0 to exit");
            cho = myObj.nextInt();
            if (cho == 1) {
                L1.printLibrary();
            } else if (cho == 2) {
                L1.addBooks();
            } else if (cho == 3) {
                L1.removeBooks();
            } else if (cho == 0) {
                System.exit(0);
            }

        }
    }
}