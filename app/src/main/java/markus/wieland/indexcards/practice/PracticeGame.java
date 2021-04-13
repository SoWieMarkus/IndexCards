package markus.wieland.indexcards.practice;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import markus.wieland.games.game.Game;
import markus.wieland.games.game.GameEventListener;
import markus.wieland.games.game.level.LevelManager;
import markus.wieland.indexcards.games.IndexCardLevel;

public class PracticeGame extends Game<PracticeGameState, PracticeGameResult> {

    private final LevelManager<IndexCardLevel> levelLevelManager;

    private final LocalDateTime startTime;
    private LocalDateTime endTime;

    public PracticeGame(GameEventListener<PracticeGameResult> gameEventListener, PracticeGameState practiceGameState) {
        super(gameEventListener);
        levelLevelManager = practiceGameState.getIndexCardLevelLevelManager();
        startTime = LocalDateTime.now();
    }

    @Override
    public PracticeGameState getGameState() {
        return null;
    }

    @Override
    public PracticeGameResult getResult() {
        endTime = LocalDateTime.now();
        long seconds =  startTime.until(endTime, ChronoUnit.SECONDS);
        return null;
    }
}
