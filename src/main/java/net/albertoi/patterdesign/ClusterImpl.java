package net.albertoi.patterdesign;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
public class ClusterImpl implements Prototype<ClusterImpl> {
    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private List<NodeImpl> nodes = new ArrayList<>();

    public ClusterImpl(String listName) {
        this.name = listName;
    }

    public void addNode(NodeImpl node){
        this.nodes.add(node);
    }



    @Override
    public ClusterImpl clone() {
        ClusterImpl clone = new ClusterImpl(name);
        clone.setNodes(nodes);
        return clone;
    }

    @Override
    public ClusterImpl deepClone() {
        List<NodeImpl> clonedNodes = new ArrayList<>();
        for (NodeImpl node : nodes) {
            NodeImpl cloneItem = node.clone();
            clonedNodes.add(cloneItem);
        }

        ClusterImpl clone = new ClusterImpl(name);
        clone.setNodes(clonedNodes);
        return clone;
    }


}
