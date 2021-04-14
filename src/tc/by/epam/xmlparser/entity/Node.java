package tc.by.epam.xmlparser.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Node implements Serializable {

    private List<Node> nodes = new ArrayList<>();
    private List<Attribute> attributes = new ArrayList<>();

    private String name;
    private String value;

    public Node() {}

    public Node(List<Node> nodes, List<Attribute> attributes, String name, String content) {
        this.nodes = nodes;
        this.attributes = attributes;
        this.name = name;
        this.value = content;
    }

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }

    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }


    public void addNode(Node node) {
        nodes.add(node);
    }

    public void removeNode(Node node) {
        nodes.remove(node);
    }

    public void addAttribute(Attribute attribute) {
        attributes.add(attribute);
    }

    public void removeAttribute(Attribute attribute) {
        attributes.remove(attribute);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return Objects.equals(nodes, node.nodes) &&
                Objects.equals(attributes, node.attributes) &&
                Objects.equals(name, node.name) &&
                Objects.equals(value, node.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nodes, attributes, name, value);
    }

    @Override
    public String toString() {
        return "Node{" +
                "name='" + name + '\'' +
                ", attributes=" + attributes +
                ", nodes=" + nodes +
                ", content='" + value + '\'' +
                '}';
    }
}
