package markus.wieland.indexcards.test;

import markus.wieland.games.GameActivity;
import markus.wieland.games.game.GameConfiguration;
import markus.wieland.games.game.Highscore;
import markus.wieland.games.persistence.GameGenerator;
import markus.wieland.games.persistence.GameSaver;
import markus.wieland.games.screen.view.EndScreenView;
import markus.wieland.games.screen.view.StartScreenView;
import markus.wieland.indexcards.R;

public class TestActivity extends GameActivity<TestConfiguration, Highscore,TestGameState, TestGameResult, Test> {

    public TestActivity() {
        super(R.layout.activity_test);
    }

    @Override
    protected StartScreenView initializeStartScreen() {
        return null;
    }

    @Override
    protected EndScreenView initializeEndScreen() {
        return null;
    }

    @Override
    protected GameGenerator<TestGameState> initializeGenerator(GameConfiguration configuration) {
        return null;
    }

    @Override
    protected GameSaver<TestGameState, Highscore> initializeGameSaver() {
        return null;
    }

    @Override
    protected void initializeGame(TestGameState testGameState) {

    }
}
