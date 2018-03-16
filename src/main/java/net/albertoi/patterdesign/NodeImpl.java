package net.albertoi.patterdesign;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class NodeImpl implements Prototype<NodeImpl> {
    @Getter
    @Setter
    private String nodeName;

    @Getter
    @Setter
    private double size;

    public NodeImpl(String nodeName, double size) {
        this.nodeName = nodeName;
        this.size = size;
    }


    @Override
    public NodeImpl clone() {
        return new NodeImpl(this.nodeName, this.size);
    }

    @Override
    public NodeImpl deepClone() {
        return clone();
    }
}
