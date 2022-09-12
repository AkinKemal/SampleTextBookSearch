import java.io.*;

public class ReaderFile {
    private final static String fileName = "TextBooks.txt";

    public ReaderFile(LinkedList ll) throws Exception {
        String line;
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        while ((line = br.readLine()) != null) {
            String nameBook = null;
            String nameAuthor = null;
            boolean booleanControl = true;
            String[] arrStr = line.split(" by ");
            for (String temporary : arrStr) {
                if (booleanControl) {
                    nameBook = temporary;
                    booleanControl = false;
                } else {
                    nameAuthor = temporary;
                }
            }
            ll.add(nameBook, nameAuthor);
        }
        br.close();
    }

}
