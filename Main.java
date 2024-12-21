import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Book> books = new ArrayList<>();

        public static void addBook() {
            Book newBook = new Book();

            System.out.print("Entrer le titre : ");
            newBook.title = scanner.nextLine();
            scanner.nextLine();
            System.out.print("Entrer l'auteur : ");
            newBook.author = scanner.nextLine();

            System.out.print("Entrer l'ISBN : ");
            newBook.ISBN = scanner.nextLine();

            System.out.print("Entrer la disponibilité (oui/non) : ");
            newBook.available = scanner.nextBoolean();
            scanner.nextLine();  // To consume the newline character

            books.add(newBook);
            System.out.println("Livre ajouté avec succès.");
        }

public static void afficherbook(){
        if (books.size()<0){
            System.out.println("Aucun book a afficher");
        }else{
            for (int i = 0; i < books.size(); i++){
                System.out.println(books.get(i).title);
                System.out.println(books.get(i).author);
                System.out.println(books.get(i).ISBN);
                System.out.println(books.get(i).available);


            }

        }
    }
    public static void rechercherBooks() {
        System.out.print("Entrer le titre du livre à rechercher : ");
        String livre = scanner.nextLine();
        scanner.nextLine();

        boolean found = false;
        for (Book book : books) {
            if (livre.equals(book.title)) {  // Use .equals() to compare strings
                System.out.println("Livre trouvé :");
                System.out.println("Titre: " + book.title);
                System.out.println("Auteur: " + book.author);
                System.out.println("ISBN: " + book.ISBN);
                System.out.println("Disponible: " + (book.available ? "Oui" : "Non"));
                found = true;
                break;  // Exit the loop after finding the book
            }
        }

        if (!found) {
            System.out.println("Livre non trouvé.");
        }
    }



    public static void supprimerBooks() {
        System.out.print("Entrer le titre du livre à supprimer : ");
        String title = scanner.nextLine();
scanner.nextLine();
        boolean found = false;
        for (int i = 0; i < books.size(); i++) {
            if (title.equals(books.get(i).title)) {  // Use .equals() for string comparison
                books.remove(i);  // Remove the book directly by index
                found = true;
                System.out.println("Livre supprimé avec succès.");
                break;  // Exit the loop after removing the book
            }
        }

        if (!found) {
            System.out.println("Livre non trouvé.");
        }
    }

    public static void modifierBooks() {
        String isbn;
        boolean found = false;
        System.out.println("entrer L'ISBN du livre a modifier");
        isbn=scanner.nextLine();
        for(Book book: books){
            if(book.ISBN.equals(isbn)){
                found = true;
                System.out.println("1: modifier le titre\n 2: modifierl'autheur\n 3: modifier la disponibilité ");
                System.out.println("entrer votre choix");
                int find=scanner.nextInt();      //hadi declaration diyal variable ghathez liya ra9 d choix dyl user
                // dakchi li dkhel user
                switch(find){
                    case 1:
                        System.out.println("entrer le nouveau titre:");
                        book.setTitle(scanner.nextLine());
                        break;
                        case 2:
                            System.out.println("entrer le nouveau autheur:");
                            book.setAuthor(scanner.nextLine());
                            break;
                            case 3:
                                System.out.print("est ce que ce livre est disponible? (oui/non): ");
                                book.setAvailable(scanner.nextBoolean());
                                scanner.nextLine();
                                break;
                                default:
                                    System.out.println("choix invalide");
                                    return;

                }
                System.out.println("le livre est bien modifier!");
                break;

            }
        }
        if(!found){
            System.out.println("ISBN invalide");
        }
    }


    public static void main(String[] args) {


        int choix;
        do {
            System.out.println("===========MENU===========");
            System.out.println("1 Ajouter un livre ");
            System.out.println("2 recherger un livre ");
            System.out.println("3 supprimer un livre ");
            System.out.println("4 modifier un livre ");
            System.out.println("5 afficher un livre ");
            System.out.println(" 6 quitter");
            System.out.println("entrer un choix :");
            choix = scanner.nextInt();

            switch (choix) {
                case 1:
                   addBook();
                   break;
                case 2 :
                    rechercherBooks();
                    break;
                case 3 :
                    supprimerBooks();
                        break;
                case 4 :
                    modifierBooks();
                         break;
                         case 5 :
                             afficherbook();
                             break;
                             case 6 :
                                 System.out.println("merci!");
break;
            }
        }while(choix != 6);
    }


