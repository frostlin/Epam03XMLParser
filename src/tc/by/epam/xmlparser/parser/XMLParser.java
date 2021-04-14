package tc.by.epam.xmlparser.parser;

import tc.by.epam.xmlparser.entity.Attribute;
import tc.by.epam.xmlparser.entity.Node;
import tc.by.epam.xmlparser.reader.XMLReader;

import java.io.File;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class XMLParser {
    public static Node parse(String pathToXMLFile) {
        File xmlFile = new File(pathToXMLFile);
        ArrayList<String> list = XMLReader.readFile(xmlFile).collect(Collectors.toCollection(ArrayList::new));
        ArrayList<Node> nodes = new ArrayList<>();

        for (String line : list) {
            if (line.charAt(1) == '/') {
                if (nodes.size() > 1) {
                    Node lastNode = nodes.get(nodes.size() - 1);
                    nodes.remove(lastNode);
                    nodes.get(nodes.size()-1).addNode(lastNode);
                }
            } else if (line.charAt(0) == '<') {
                Node node = new Node();

                line = line.substring(1, line.length() - 1).trim();
                String[] nameAndAttrs = line.split(" ", 1);
                node.setName(nameAndAttrs[0]);

                if (nameAndAttrs.length > 1){
                    ArrayList<String> attributes = new ArrayList<>();
                    Pattern pattern = Pattern.compile("(?<name>\\S+)=\"(?<value>[^\"]+)\"");
                    Matcher matcher = pattern.matcher(line);
                    while (matcher.find()) {
                        Attribute attr = new Attribute();
                        attr.setName(matcher.group("name"));
                        attr.setValue(matcher.group("value"));

                        node.addAttribute(attr);
                    }
                }
                nodes.add(node);
            } else {
                nodes.get(nodes.size() - 1).setValue(line);
            }
        }
        return nodes.get(nodes.size() - 1);
    }
}
