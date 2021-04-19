package markus.wieland.indexcards.test;

import markus.wieland.games.game.GameEventListener;
import markus.wieland.games.game.level.LevelGame;

public class Test extends LevelGame<IndexCardTestLevel, TestGameState, TestGameResult> {

    public Test(GameEventListener<TestGameResult> gameEventListener) {
        super(gameEventListener);
    }

    @Override
    public TestGameState getGameState() {
        return null;
    }

    @Override
    public TestGameResult getResult() {
        return null;
    }
}
