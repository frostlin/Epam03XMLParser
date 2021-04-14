package tc.by.epam.xmlparser;

import tc.by.epam.xmlparser.parser.XMLParser;
import tc.by.epam.xmlparser.entity.Node;

public class Main {
    public static void main(String[] args) {
        String pathToXMLFile = "resources/students2.xml";
        //String pathToXMLFile = "resources/notes.xml";

        Node root = XMLParser.parse(pathToXMLFile);
        System.out.println(root);
    }
}
