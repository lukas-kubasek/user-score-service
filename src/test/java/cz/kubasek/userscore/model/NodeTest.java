package cz.kubasek.userscore.model;

import org.junit.Test;

import static cz.kubasek.userscore.model.Node.EMPTY_NODE;
import static org.assertj.core.api.Assertions.assertThat;

public class NodeTest {

    @Test
    public void nodeSerialisesAsValueAndCount() {
        Node node = new Node(1, 10);
        assertThat(node.toString()).isEqualTo("10:1");
    }

    @Test
    public void increasedCountNodeSerialisedWithCorrectCount() {
        Node node = new Node(1, 20);
        node.incrementCount();
        assertThat(node.toString()).isEqualTo("20:2");
    }

    @Test
    public void emptyNodeSerialisesAsEmptyString() {
        assertThat(EMPTY_NODE.toString()).isEqualTo("");
    }
}