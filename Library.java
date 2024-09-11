import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Library extends Main {
    List<Object> Library = new ArrayList<>();
    ArrayList<Object> Book = new ArrayList<>();
    List<Object> Hold;
    Scanner myObj = new Scanner(System.in);

    Library() {
        Book.add(4);
        Book.add("ABC");
        Book.add("EDF");

        Library.add(Book.clone());

        Book.clear();

        Book.add(5);
        Book.add("LLL");
        Book.add( "ZZZ");

        Library.add(Book.clone());

        Book.clear();

        Book.add(6);
        Book.add("JJJ");
        Book.add( "PPP");

        Library.add(Book.clone());

        Book.clear();
    }

    public void printLibrary() {
        System.out.println(Library);
    }

    public void addBooks(){
        try{
            System.out.println("Enter the name of the file you are entering");
            FileReader fileReader = new FileReader(myObj.nextLine());
            Scanner scanner = new Scanner(fileReader);
            scanner.useDelimiter(",");
            Book.clear();

            while (scanner.hasNextLine()) {
                int n = 0;
                Object data = scanner.next();
                Book.add(data);
                data = scanner.next();
                Book.add(data);
                data = scanner.nextLine();
                String cut = data.toString();
                data = cut.replace(", ", "");
                Book.add(data);

                for(int i = 0; i < Library.size(); i++){
                    Hold = (List<Object>) Library.get(i);
                    if(Integer.parseInt((Hold.get(0)).toString()) == Integer.parseInt((Book.get(0)).toString())){
                        n = 1;
                    }
                }

                if(n == 0){
                    Library.add(Book.clone());
                }
                Book.clear();
            }
            scanner.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }
        printLibrary();
    }

    public void removeBooks(){
        System.out.println("Enter Book ID to remove");
        int r = myObj.nextInt();
        for(int i = 0; i < Library.size(); i++){
            Hold = (List<Object>) Library.get(i);
            if(Integer.parseInt((Hold.get(0)).toString()) == r){
                Library.remove(i);
            }
        }
        printLibrary();
    }
}
