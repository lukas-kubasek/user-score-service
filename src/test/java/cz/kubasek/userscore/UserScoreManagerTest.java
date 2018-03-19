package cz.kubasek.userscore;

import cz.kubasek.userscore.model.BinaryTree;
import org.junit.Before;
import org.junit.Test;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class UserScoreManagerTest {

    private UserScoreManager<BinaryTree> userScoreManager;

    @Before
    public void setUp() {
        userScoreManager = new UserScoreManagerBinaryTree();
    }

    @Test
    public void serialiseScores_emptyChildrenWithSibling() {
        BinaryTree userScoreTree = userScoreManager.processUserScores(asList(4, 2, 5, 5, 6, 1, 4));
        String serialisedScores = userScoreManager.serialiseUserScores(userScoreTree);
        assertThat(serialisedScores).isEqualTo("4:2, 2:1, 5:2, 1:1, , , 6:1");
    }

    @Test
    public void serialiseScores_emptyChildrenWithOneSingleNodeInBottomLevel() {
        BinaryTree userScoreTree = userScoreManager.processUserScores(asList(4, 2, 5, 5, 6, 4));
        String serialisedScores = userScoreManager.serialiseUserScores(userScoreTree);
        assertThat(serialisedScores).isEqualTo("4:2, 2:1, 5:2, , , , 6:1");
    }

    @Test
    public void serialiseScores_fullTreeWithNoEmptyChildren() {
        BinaryTree userScoreTree = userScoreManager.processUserScores(asList(4, 2, 6, 5, 7, 4, 3, 1, 6));
        String serialisedScores = userScoreManager.serialiseUserScores(userScoreTree);
        assertThat(serialisedScores).isEqualTo("4:2, 2:1, 6:2, 1:1, 3:1, 5:1, 7:1");
    }

    @Test
    public void serialiseScores_leftSideDisbalancedTreeWithThreeEmptyLevelsAndSignificantTrailingComma() {
        BinaryTree userScoreTree = userScoreManager.processUserScores(asList(4, 2, 1, 0, 1));
        String serialisedScores = userScoreManager.serialiseUserScores(userScoreTree);
        assertThat(serialisedScores).isEqualTo("4:1, 2:1, , 1:2, , 0:1, ");
    }

}