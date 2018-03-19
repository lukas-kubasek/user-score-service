package cz.kubasek.userscore.serialise;

import cz.kubasek.userscore.model.BinaryTree;
import cz.kubasek.userscore.model.Node;

import java.util.List;

public class BinaryTreeSerialiser {

    public String serialise(BinaryTree userScores) {
        List<Node> nodes = userScores.getAllNodesBreadthFirst();
        return printDelimiterSeparated(nodes, ", ");
    }

    private String printDelimiterSeparated(List<Node> nodes, String delimiter) {
        StringBuilder stringBuilder = new StringBuilder();
        nodes.forEach(node -> stringBuilder
                .append(node.toString())
                .append(delimiter));
        return stringBuilder.substring(0, stringBuilder.length() - delimiter.length());
    }
}
