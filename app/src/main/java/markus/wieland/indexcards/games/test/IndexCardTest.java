package markus.wieland.indexcards.games.test;

import markus.wieland.games.game.GameEventListener;
import markus.wieland.games.game.level.LevelGame;
import markus.wieland.games.game.level.LevelGameBoardView;
import markus.wieland.games.game.level.LevelManager;
import markus.wieland.indexcards.games.IndexCardLevel;

public class IndexCardTest extends LevelGame<IndexCardLevel, IndexCardTestGameState, IndexCardTestGameResult> {

    private final LevelGameBoardView<IndexCardLevel> indexCardLevelLevelGameBoardView;
    private final LevelManager<IndexCardLevel> indexCardLevelLevelManager;

    public IndexCardTest(GameEventListener<IndexCardTestGameResult> gameEventListener, LevelGameBoardView<IndexCardLevel> indexCardLevelLevelGameBoardView, LevelManager<IndexCardLevel> indexCardLevelLevelManager) {
        super(gameEventListener);
        this.indexCardLevelLevelGameBoardView = indexCardLevelLevelGameBoardView;
        this.indexCardLevelLevelManager = indexCardLevelLevelManager;
    }

    @Override
    public IndexCardTestGameState getGameState() {
        return null;
    }

    @Override
    public IndexCardTestGameResult getResult() {
        return null;
    }
}
