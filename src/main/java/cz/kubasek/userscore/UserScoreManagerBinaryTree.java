package cz.kubasek.userscore;

import cz.kubasek.userscore.model.BinaryTree;
import cz.kubasek.userscore.serialise.BinaryTreeSerialiser;

import java.util.List;

public class UserScoreManagerBinaryTree implements UserScoreManager<BinaryTree> {

    @Override
    public BinaryTree processUserScores(List<Integer> scores) {
        return BinaryTree.buildFrom(scores);
    }

    @Override
    public String serialiseUserScores(BinaryTree userScores) {
        return new BinaryTreeSerialiser().serialise(userScores);
    }
}
