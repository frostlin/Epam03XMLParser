package tc.by.epam.xmlparser.reader;

import java.io.*;
import java.util.stream.Stream;

public class XMLReader {
    public static Stream<String> readFile(File file) {
        String resultData = "";
        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            StringBuilder stringBuilder = new StringBuilder();
            String nextLine = bufferedReader.readLine();
            if (nextLine.contains("<?")) {
                bufferedReader.readLine();
            }
            while(nextLine != null){
                stringBuilder.append(nextLine);
                nextLine = bufferedReader.readLine();
            }
            resultData = stringBuilder.toString()
                    .replace("\n", "")
                    .replace("\r", "")
                    .replace("<", "\n<")
                    .replace(">", ">\n");
        } catch (IOException e) {
            System.out.println("Error reading XML file: " + e.getMessage());
        }

        return resultData.lines().filter(line -> !line.isBlank());
    }
}
