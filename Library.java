import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Library {
    //Initializes assorted objects
    List<Object> Library = new ArrayList<>();
    ArrayList<Object> Book = new ArrayList<>();
    List<Object> Hold;
    Scanner myObj = new Scanner(System.in);

    //Function to print entire main list
    public void printLibrary() {
        //Iterates through main list and then prints the entire sub-list
        for(int i = 0; i < Library.size(); i++){
            //Takes item from main list for temporary use
            Hold = (List<Object>) Library.get(i);
            System.out.println(Hold);
        }
    }

    //Adds books to list from file
    public void addBooks(){
        try{
            //User prompt
            System.out.println("Enter the name of the file you are entering");
            //Initializes FileReader to take file
            FileReader fileReader = new FileReader(myObj.nextLine());
            //Initializes scanner to take from file
            Scanner scanner = new Scanner(fileReader);
            //Separates items by breaking them at the commas
            scanner.useDelimiter(",");
            //Ensures Book is empty
            Book.clear();

            while (scanner.hasNextLine()) {
                //Initializes variable to check
                int n = 0;
                //Takes data from file and adds it to Book
                Object data = scanner.next();
                Book.add(data);
                data = scanner.next();
                Book.add(data);
                //Takes data from file that doesn't end in a comma
                data = scanner.nextLine();
                String cut = data.toString();
                //Cuts off extra from data before entering it into book
                data = cut.replace(", ", "");
                Book.add(data);

                //Compares the ID of the new book with all the books inside the list
                for(int i = 0; i < Library.size(); i++){
                    //Temporarily takes item from main list
                    Hold = (List<Object>) Library.get(i);
                    if(Integer.parseInt((Hold.get(0)).toString()) == Integer.parseInt((Book.get(0)).toString())){
                        //If the ID matches n is set to 1
                        n = 1;
                        //Alerts user of any books that did not get added to list
                        System.out.println(Book.get(1) + " did not print because a book with that ID already exists.");
                    }
                }

                //If n hasn't been set to 1 because the ID matches a copy of the book will be added to the list
                if(n == 0){
                    Library.add(Book.clone());
                }
                //Empties book when done
                Book.clear();
            }
            scanner.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }
        //Prints everything in the newly updated list out
        printLibrary();
    }

    public void removeBooks(){
        int g = 0;
        //User prompt
        System.out.println("Enter Book ID to remove");
        //Takes user int
        int r = myObj.nextInt();
        //Goes through list checking IDs
        for(int i = 0; i < Library.size(); i++){
            //Temporarily takes item from main list
            Hold = (List<Object>) Library.get(i);
            //If the ID entered and the ID of any book in the list are the same, the book is removed
            if(Integer.parseInt((Hold.get(0)).toString()) == r){
                Library.remove(i);
                //Used to check if a book matched
                g = 1;
            }
        }
        //Alerts user what book was removed
        if(g == 1){
            System.out.println(Book.get(1) + " removed.");
            //Prints updated list
            printLibrary();
        }
        //Notifies user if that ID does not exist
        else{
            System.out.println("A book by this ID dos not exist");
        }
    }
}
