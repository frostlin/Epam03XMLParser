package tc.by.epam.xmlparser;

import tc.by.epam.xmlparser.parser.XMLParser;
import tc.by.epam.xmlparser.entity.Node;

public class Main {
    public static void main(String[] args) {
        Node root = XMLParser.parse("resources/students2.xml");
        System.out.println(root);
    }
}
