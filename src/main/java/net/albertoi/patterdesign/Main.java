package net.albertoi.patterdesign;

public class Main {
    public static void main(String[] args) {
        final String miniClusterLabel =   "Min cluster List";
        final String mediumClusterLabel = "Med cluster List";
        final String bigClusterLabel =    "Big cluster List";


        ClusterImpl sizeSCluster = new ClusterImpl(miniClusterLabel);
        for (int c = 1; c <= 5; c++) {
            NodeImpl nodeSizeS = new NodeImpl("Node " + c, c * 1024);
            sizeSCluster.addNode(nodeSizeS);
        }
        PrototypeFactory.addPrototype(sizeSCluster.getName(), sizeSCluster);

        ClusterImpl sizeMCluster = (ClusterImpl) PrototypeFactory.getPrototype(sizeSCluster.getName());
        sizeMCluster.setName(mediumClusterLabel);
        for (NodeImpl nodeSizeM : sizeMCluster.getNodes()) {
            nodeSizeM.setSize(nodeSizeM.getSize() * 2);
        }
        PrototypeFactory.addPrototype(sizeMCluster.getName(), sizeMCluster);


        ClusterImpl sizeLCluster = (ClusterImpl) PrototypeFactory.getPrototype(sizeMCluster.getName());
        sizeLCluster.setName(bigClusterLabel);
        for (NodeImpl nodeSizeL : sizeLCluster.getNodes()) {
            nodeSizeL.setSize(nodeSizeL.getSize() * 2);
        }
        PrototypeFactory.addPrototype(sizeLCluster.getName(), sizeLCluster);

        System.out.println(PrototypeFactory.getPrototype(miniClusterLabel));
        System.out.println(PrototypeFactory.getPrototype(mediumClusterLabel));
        System.out.println(PrototypeFactory.getPrototype(bigClusterLabel));

    }

}
