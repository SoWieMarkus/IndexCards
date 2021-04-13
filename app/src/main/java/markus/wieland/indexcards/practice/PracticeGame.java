package markus.wieland.indexcards.practice;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import markus.wieland.games.game.Game;
import markus.wieland.games.game.GameEventListener;
import markus.wieland.games.game.level.LevelManager;
import markus.wieland.indexcards.games.IndexCardLevel;
import markus.wieland.indexcards.games.IndexCardLevelResult;

public class PracticeGame extends Game<PracticeGameState, PracticeGameResult> implements PracticeGameBoardInteractListener {

    private final LevelManager<IndexCardLevel> levelLevelManager;
    private final PracticeGameBoardView practiceGameBoardView;

    private final LocalDateTime startTime;

    public PracticeGame(GameEventListener<PracticeGameResult> gameEventListener, PracticeGameState practiceGameState, PracticeGameBoardView practiceGameBoardView) {
        super(gameEventListener);
        levelLevelManager = practiceGameState.getIndexCardLevelLevelManager();
        startTime = LocalDateTime.now();
        this.practiceGameBoardView = practiceGameBoardView;
        this.practiceGameBoardView.setGameBoardInteractionListener(this);
        this.practiceGameBoardView.loadGameState(practiceGameState);

    }

    @Override
    public PracticeGameState getGameState() {
        return null;
    }

    @Override
    public PracticeGameResult getResult() {
        LocalDateTime endTime = LocalDateTime.now();
        long seconds = startTime.until(endTime, ChronoUnit.SECONDS);
        return new PracticeGameResult(levelLevelManager.getLevels(), seconds);
    }

    @Override
    public void onLevelFinish(boolean answeredCorrectly) {
        levelLevelManager.getCurrentLevel().finishLevel(new IndexCardLevelResult(answeredCorrectly));
        IndexCardLevel indexCardLevel = levelLevelManager.getNextLevel();
        if (indexCardLevel == null) {
            finish(getResult());
            return;
        }
        practiceGameBoardView.load(levelLevelManager);

        //levelManager.getNextLevel is called in praticegameboardview.load

    }
}
