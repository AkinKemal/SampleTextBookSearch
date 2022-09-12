import java.util.Scanner;

public class Application {

    //tasarım için
    public static final String ANSI_BG_YELLOW = "\u001B[43m";
    public static final String ANSI_BOLD = "\u001B[1m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        LinkedList linkedList = new LinkedList();
        //dosya okuma
        ReaderFile readerFile;
        //dosya yazma
        FileWriter fileWriter;
        LinkedList containsList;
        LinkedList temporary;
        int data;
        String keyword;
        String nameOfBook;
        String nameOfAuthor;
        int choice;
        readerFile = new ReaderFile(linkedList);
        do {
            System.out.println(ANSI_RED + "1. " + ANSI_RESET + "Search book with a keyword\n"
                    + ANSI_RED + "2. " + ANSI_RESET + "Add new book to list\n"
                    + ANSI_RED + "3. " + ANSI_RESET + "Delete book to list\n"
                    + ANSI_RED + "4. " + ANSI_RESET + "Print all available books\n"
                    + ANSI_RED + "5. " + ANSI_RESET + "Save current linked list\n"
                    + ANSI_RED + ANSI_BOLD + "6. Exit" + ANSI_RESET);
            System.out.print(ANSI_RED + " -> " + ANSI_RESET + ANSI_BG_YELLOW + " Choice: " + ANSI_RESET + " ");
            choice = scanner.nextInt();
            design();
            if (choice > 6) {
                System.out.print(ANSI_RED + " Please try again..." + ANSI_RESET);
            }
            switch (choice) {
                case 1:
                    System.out.print("Please enter keyword: ");
                    scanner.nextLine();
                    keyword = scanner.nextLine();
                    temporary = linkedList.contains(keyword);
                    containsList = temporary.printListContains(keyword);
                    containsList.printList();
                    design();
                    break;
                case 2:
                    System.out.print("Please enter the name of the book: ");
                    scanner.nextLine();
                    nameOfBook = scanner.nextLine();
                    System.out.print("Please enter the name of the author: ");
                    nameOfAuthor = scanner.nextLine();
                    linkedList.add(nameOfBook, nameOfAuthor);
                    design();
                    break;
                case 3:
                    linkedList.printList();
                    System.out.print("Please enter the number of the book you want to delete: ");
                    data = scanner.nextInt();
                    scanner.nextLine();
                    linkedList.remove(data);
                    design();
                    break;
                case 4:
                    linkedList.printList();
                    design();
                    break;
                case 5:
                    fileWriter = new FileWriter(linkedList);
                    design();
                    break;
                case 6:
                    System.out.println(ANSI_BG_YELLOW + "GOOD BYE" + ANSI_RESET);
                    break;
                default:
                    System.out.println(ANSI_RED + "Warning!" + ANSI_RESET);
                    design();
                    break;
            }
        } while (choice != 6);
    }

    public static void design() {
        System.out.println(ANSI_BOLD + "-----------------------------------------------------------------------------------------" + ANSI_RESET);
    }

}
