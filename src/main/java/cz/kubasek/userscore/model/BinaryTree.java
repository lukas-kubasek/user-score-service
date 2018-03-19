package cz.kubasek.userscore.model;

import java.util.*;

import static cz.kubasek.userscore.model.Node.EMPTY_NODE;
import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;

public class BinaryTree {

    private Node rootNode;
    private int treeDepth;

    public static BinaryTree buildFrom(List<Integer> values) {
        BinaryTree binaryTree = new BinaryTree();
        values.forEach(binaryTree::addOrIncreaseCountForValue);
        return binaryTree;
    }

    public Node getRootNode() {
        return rootNode;
    }

    public int getTreeDepth() {
        return treeDepth;
    }

    public List<Node> getAllNodesBreadthFirst() {
        return rootNode != null ? findAllNodesUsingBreadthFirstSearchIteratively() : emptyList();
    }

    public void addOrIncreaseCountForValue(int value) {
        rootNode = addOrIncreaseCountResursively(value, rootNode, 1);
    }

    private Node addOrIncreaseCountResursively(int value, Node node, int level) {
        if (level > treeDepth) {
            treeDepth = level;
        }
        if (node == null) {
            return new Node(level, value);
        }
        if (value < node.getValue()) {
            node.setLeft(addOrIncreaseCountResursively(value, node.getLeft(), ++level));
        } else if (value > node.getValue()) {
            node.setRight(addOrIncreaseCountResursively(value, node.getRight(), ++level));
        } else {
            node.incrementCount();
        }
        return node;
    }

    private List<Node> findAllNodesUsingBreadthFirstSearchIteratively() {
        List<Node> nodesFound = new ArrayList<>(singletonList(rootNode));
        Queue<Node> nodesToVisit = new LinkedList<>(singletonList(rootNode));

        while (!nodesToVisit.isEmpty()) {
            Node node = nodesToVisit.remove();
            if (node.getLeft() != null) {
                nodesFound.add(node.getLeft());
                nodesToVisit.add(node.getLeft());
            } else if (node.getLevel() < treeDepth) {
                nodesFound.add(EMPTY_NODE);
            }
            if (node.getRight() != null) {
                nodesFound.add(node.getRight());
                nodesToVisit.add(node.getRight());
            } else if (node.getLevel() < treeDepth) {
                nodesFound.add(EMPTY_NODE);
            }
        }
        return nodesFound;
    }

}
