package markus.wieland.indexcards.games;

import markus.wieland.games.game.level.LevelResult;

public class IndexCardLevelResult extends LevelResult {

    private final boolean answeredCorrectly;

    public IndexCardLevelResult(boolean answeredCorrectly) {
        this.answeredCorrectly = answeredCorrectly;
    }

    public boolean isAnsweredCorrectly() {
        return answeredCorrectly;
    }
}
