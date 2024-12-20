import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Book> books = new ArrayList<>();

    public static void addBook() {
        Book newBook = new Book();

        System.out.print("entrer le titre :");
        newBook.title = scanner.nextLine();
        scanner.nextLine();
        System.out.print("entrer l'autheur :");
        newBook.author = scanner.nextLine();
        System.out.print("entrer L'ISBN :");
        newBook.ISBN = scanner.nextLine();
        System.out.print("enter la disponibilité ( oui / non): ");
        newBook.available = scanner.nextBoolean();

        books.add(newBook);
        System.out.println("livre ajouter avec succés");
    }

    public static void recherBooks() {

        String livre = scanner.nextLine();
        Book book = new Book();
        for (int i = 0; i < books.toArray().length; i++) {
            if (livre == books.get(i).title) {
                book = books.get(i);
            }
        }
    }


    public static void suprimerBooks() {


        System.out.println("entrer le titre du livre a suprimer");

        //b1
        String title = scanner.nextLine();
        Book book = new Book();
        for (int i = 0; i < books.size(); i++) {
            if (title == books.get(i).title) {
                book = books.get(i);

            }

        }
        books.remove(book);
    }


    public static void main(String[] args) {


        int choix;
        do {
            System.out.println("===========MENU===========");
            System.out.println("1 Ajouter un livre ");
            System.out.println("2 recherger un livre ");
            System.out.println("3 supprimer un livre ");
            System.out.println("entrer un choix :");
            choix = scanner.nextInt();

            switch (choix) {
                case 1:
                   addBook();
                   break;
                case 2 :
                    recherBooks();
                    break;
                case 3 :
                        suprimerBooks();
                        break;
                case 0 :
                         break;
            }
        }while(choix != 3);
    }


}