import java.io.*;

public class FileWriter {

    public FileWriter(LinkedList ll) {
        Node walk = ll.head;
        String fileName = "TextBooks";

        try {
            File f = new File(fileName + ".txt");
            f.delete();

            if (f.createNewFile()) {
                System.out.println("The file has been created.");
            } else {
                System.out.println("The file already exists.");
            }
        } catch (IOException e) {
            System.err.println(e);
        }

        while (walk != null) {
            try {
                BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(fileName + ".txt", true));
                writer.write(walk.nameOfBook + " by " + walk.nameOfAuthor);
                writer.newLine();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            walk = walk.next;
        }
    }

}
