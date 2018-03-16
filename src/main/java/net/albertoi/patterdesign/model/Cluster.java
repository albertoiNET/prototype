package net.albertoi.patterdesign.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import net.albertoi.patterdesign.factory.Prototype;

import java.util.ArrayList;
import java.util.List;

@ToString
public class Cluster implements Prototype<Cluster> {
    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private List<Node> nodes = new ArrayList<>();

    public Cluster(String listName) {
        this.name = listName;
    }

    public void addNode(Node node){
        this.nodes.add(node);
    }



    @Override
    public Cluster clone() {
        Cluster clone = new Cluster(name);
        clone.setNodes(nodes);
        return clone;
    }

    @Override
    public Cluster deepClone() {
        List<Node> clonedNodes = new ArrayList<>();
        for (Node node : nodes) {
            Node cloneItem = node.clone();
            clonedNodes.add(cloneItem);
        }

        Cluster clone = new Cluster(name);
        clone.setNodes(clonedNodes);
        return clone;
    }


}
