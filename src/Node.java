public class Node {

    public String nameOfBook;
    public String nameOfAuthor;
    public Node next;

    public Node(String nameOfBook, String nameOfAuthor) {
        this.nameOfBook = nameOfBook;
        this.nameOfAuthor = nameOfAuthor;
        this.next = null;
    }

}
