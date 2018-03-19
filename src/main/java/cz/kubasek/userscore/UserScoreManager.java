package cz.kubasek.userscore;

import java.util.List;

public interface UserScoreManager<T> {

    T processUserScores(List<Integer> scores);

    String serialiseUserScores(T userScores);
}
