package Client;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class fileWrite {

    public static void appendUsingFileWriter(String filePath, String text) {
        File file = new File(filePath);
        FileWriter fr = null;
        try {
            // Below constructor argument decides whether to append or override
            fr = new FileWriter(file, true);
            fr.write(text);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static ArrayList<String> readUsingScanner(String fileName) throws IOException {
        ArrayList<String> alllines = new ArrayList<>();
        Path path = Paths.get(fileName);
        Scanner scanner = new Scanner(path);
        //read line by line
        while (scanner.hasNextLine()) {
            //process each line
            String line = scanner.nextLine();
            alllines.add(line);

        }
        scanner.close();
        return alllines;
    }

}
