package cz.kubasek.userscore.model;

import org.junit.Before;
import org.junit.Test;

import static cz.kubasek.userscore.model.Node.EMPTY_NODE;
import static org.assertj.core.api.Assertions.assertThat;

public class BinaryTreeTest {

    private BinaryTree binaryTree;

    @Before
    public void setUp() {
        this.binaryTree = new BinaryTree();
    }

    @Test
    public void addNewNodeWithUniqueValue() {
        assertThat(binaryTree.getRootNode()).isNull();

        binaryTree.addOrIncreaseCountForValue(4);
        Node rootNode = binaryTree.getRootNode();
        assertThat(rootNode).isEqualTo(new Node(1, 4));
        assertThat(rootNode.getLeft()).isNull();
        assertThat(rootNode.getRight()).isNull();

        binaryTree.addOrIncreaseCountForValue(2);
        assertThat(rootNode.getLeft()).isEqualTo(new Node(2, 2));
        assertThat(rootNode.getRight()).isNull();

        binaryTree.addOrIncreaseCountForValue(5);
        assertThat(rootNode.getRight()).isEqualTo(new Node(2, 5));
    }

    @Test
    public void increaseCountWhenSameValueAddedRepeteadly() {
        binaryTree.addOrIncreaseCountForValue(4);
        binaryTree.addOrIncreaseCountForValue(4);

        Node rootNode = binaryTree.getRootNode();
        assertThat(rootNode.getCount()).isEqualTo(2);

        binaryTree.addOrIncreaseCountForValue(10);
        binaryTree.addOrIncreaseCountForValue(10);
        binaryTree.addOrIncreaseCountForValue(10);

        assertThat(rootNode.getRight().getCount()).isEqualTo(3);
    }

    @Test
    public void treeDepthPopulatedCorrectly() {
        assertThat(binaryTree.getAllNodesBreadthFirst()).isEmpty();
        assertThat(binaryTree.getTreeDepth()).isEqualTo(0);

        binaryTree.addOrIncreaseCountForValue(4);
        assertThat(binaryTree.getAllNodesBreadthFirst()).containsExactly(new Node(1, 4));
        assertThat(binaryTree.getTreeDepth()).isEqualTo(1);

        binaryTree.addOrIncreaseCountForValue(2);
        binaryTree.addOrIncreaseCountForValue(1);
        assertThat(binaryTree.getAllNodesBreadthFirst()).containsExactly(new Node(1, 4), new Node(2, 2), EMPTY_NODE, new Node(3, 1), EMPTY_NODE);
        assertThat(binaryTree.getTreeDepth()).isEqualTo(3);
    }

}