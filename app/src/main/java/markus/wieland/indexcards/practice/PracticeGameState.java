package markus.wieland.indexcards.practice;

import markus.wieland.games.game.level.LevelManager;
import markus.wieland.games.persistence.GameState;
import markus.wieland.indexcards.games.IndexCardLevel;

public class PracticeGameState implements GameState {

    private final LevelManager<IndexCardLevel> indexCardLevelLevelManager;

    public PracticeGameState(LevelManager<IndexCardLevel> indexCardLevelLevelManager) {
        this.indexCardLevelLevelManager = indexCardLevelLevelManager;
    }

    public LevelManager<IndexCardLevel> getIndexCardLevelLevelManager() {
        return indexCardLevelLevelManager;
    }
}
