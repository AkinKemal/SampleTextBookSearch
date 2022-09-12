public class LinkedList implements LinkedListInterface {

    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    public Node head = null;

    @Override
    public void add(String nameOfBook, String nameOfAuthor) {
        Node element = new Node(nameOfBook, nameOfAuthor);
        if (head == null) {
            head = element;
            printNewLinkedList();
        } else {
            Node walk = head;
            while (walk.next != null) {
                walk = walk.next;
            }
            walk.next = element;
            element.next = null;
        }
        //printAddData(nameOfBook, nameOfAuthor);
    }

    @Override
    public void remove(int data) {
        if ((data - 1) <= size() && !isEmpty() && data >= 0) {
            int counter = 0;
            Node walk = null;
            Node prev = null;
            if (head != null) {
                walk = head;
            }
            while (walk.next != null) {
                if ((data - 1) == counter) {
                    break;
                }
                counter++;
                prev = walk;
                walk = walk.next;
            }
            if (walk == head) {
                head = head.next;
            } else {
                assert prev != null;
                prev.next = walk.next;
            }
            printRemoveData(walk.nameOfBook, walk.nameOfAuthor);
        } else {
            System.out.println(ANSI_RED + "WARNING!" + ANSI_RESET + " Index not found, please try again.");
        }
    }

    @Override
    public LinkedList contains(String keyword) {
        LinkedList containsList = new LinkedList();
        boolean control = true;
        keyword = keyword.toLowerCase();
        String InstantName;
        int InstantSize = 0;
        Node walk = null;
        if (head != null) {
            walk = head;
        }
        while (walk != null) {
            InstantSize = (walk.nameOfBook.length() + walk.nameOfAuthor.length());
            InstantName = (walk.nameOfBook + " " + walk.nameOfAuthor).toLowerCase();
            for (int i = 0; i < InstantSize; i++) {
                for (int j = i; j <= InstantSize; j++) {
                    if (InstantName.substring(i, j + 1).equals(keyword) && control) {
                        containsList.add(walk.nameOfBook, walk.nameOfAuthor);
                        control = false;
                        break;
                    }
                }
            }
            control = true;
            walk = walk.next;
        }
        return containsList;
    }

    @Override
    public int size() {
        int size = 0;
        Node walk = null;
        if (head != null) {
            walk = head;
        }
        while (walk.next != null) {
            size++;
            walk = walk.next;
        }
        return size;
    }

    @Override
    public void clear() {
        head = null;
    }

    @Override
    public boolean isEmpty() {
        if (head == null) {
            System.out.println("Linked List is empty");
            return true;
        } else {
            System.out.println("Linked list is not empty");
        }
        return false;
    }

    @Override
    public void printList() {
        if (head != null) {
            int counter = 1;
            Node walk = null;
            walk = head;
            System.out.println(ANSI_GREEN + "BOOK LIST" + ANSI_RESET);
            while (walk != null) {
                System.out.println(ANSI_GREEN + counter + ". " + ANSI_RESET + walk.nameOfBook + " by " + walk.nameOfAuthor);
                counter++;
                walk = walk.next;
            }
        } else {
            System.out.println(ANSI_RED + "Book list is empty" + ANSI_RESET);
        }
    }

    public LinkedList printListContains(String keyword) {
        LinkedList temporary = new LinkedList();
        Node walk = null;
        if (head != null) {
            walk = head;
        }
        boolean controlNameOfBook = true;
        boolean controlNameOfAuthor = true;
        String temporaryNameOfBook = null;
        String temporaryNameOfAuthor = null;
        while (walk != null) {
            int sizeNameOfBook = walk.nameOfBook.length();
            for (int i = 0; i < sizeNameOfBook; i++) {
                for (int j = i; j < sizeNameOfBook; j++) {
                    if (walk.nameOfBook.substring(i, j + 1).equalsIgnoreCase(keyword)) {
                        temporaryNameOfBook = walk.nameOfBook.substring(0, i) + ANSI_RED + walk.nameOfBook.substring(i, j + 1) + ANSI_RESET + walk.nameOfBook.substring(j + 1, sizeNameOfBook);
                        controlNameOfBook = false;
                    }
                }
            }
            int sizeNameOfAuthor = walk.nameOfAuthor.length();
            for (int i = 0; i < sizeNameOfAuthor; i++) {
                for (int j = i; j < sizeNameOfAuthor; j++) {
                    if (walk.nameOfAuthor.substring(i, j + 1).equalsIgnoreCase(keyword)) {
                        temporaryNameOfAuthor = walk.nameOfAuthor.substring(0, i) + ANSI_RED + walk.nameOfAuthor.substring(i, j + 1) + ANSI_RESET + walk.nameOfAuthor.substring(j + 1, sizeNameOfAuthor);
                        controlNameOfAuthor = false;
                    }
                }
            }
            if (!controlNameOfBook && controlNameOfAuthor) {
                temporary.add(temporaryNameOfBook, walk.nameOfAuthor);
            } else if (!controlNameOfBook) {
                temporary.add(temporaryNameOfBook, temporaryNameOfAuthor);
            } else if (!controlNameOfAuthor) {
                temporary.add(walk.nameOfBook, temporaryNameOfAuthor);
            } else {
                temporary.add(walk.nameOfBook, walk.nameOfAuthor);
            }
            walk = walk.next;
            controlNameOfBook = true;
            controlNameOfAuthor = true;
        }
        return temporary;
    }

    @Override
    public void printAddData(String nameOfBook, String nameOfAuthor) {
        System.out.println(ANSI_GREEN + "✅" + ANSI_RESET + " " + nameOfBook + " by " + nameOfAuthor + ", " + ANSI_GREEN + "successfully" + ANSI_RESET + " prepended.");
    }

    @Override
    public void printNewLinkedList() {
        System.out.println(ANSI_GREEN + "✅" + ANSI_RESET);
    }

    @Override
    public void printRemoveData(String nameOfBook, String nameOfAuthor) {
        System.out.println(ANSI_GREEN + "✅" + ANSI_RESET + " " + nameOfBook + " by " + nameOfAuthor + ", deleted " + ANSI_GREEN + "successfully." + ANSI_RESET);
    }
}
