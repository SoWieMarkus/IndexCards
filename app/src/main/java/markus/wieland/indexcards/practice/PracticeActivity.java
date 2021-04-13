package markus.wieland.indexcards.practice;

import androidx.lifecycle.ViewModelProviders;

import java.util.List;

import markus.wieland.games.ConfirmDialog;
import markus.wieland.games.GameActivity;
import markus.wieland.games.game.GameConfiguration;
import markus.wieland.games.game.Highscore;
import markus.wieland.games.persistence.GameGenerator;
import markus.wieland.games.persistence.GameSaver;
import markus.wieland.games.screen.view.EndScreenView;
import markus.wieland.games.screen.view.StartScreenView;
import markus.wieland.indexcards.IndexCard;
import markus.wieland.indexcards.R;
import markus.wieland.indexcards.cards.index_cards.IndexCardViewModel;

public class PracticeActivity extends GameActivity<PracticeConfiguration, Highscore, PracticeGameState, PracticeGameResult, PracticeGame> {

    private IndexCardViewModel indexCardViewModel;

    public PracticeActivity() {
        super(R.layout.activity_practice);
    }

    @Override
    protected StartScreenView initializeStartScreen() {
        return null;
    }

    @Override
    protected EndScreenView initializeEndScreen() {
        return findViewById(R.id.activity_practice_end_screen);
    }

    @Override
    protected GameGenerator<PracticeGameState> initializeGenerator(GameConfiguration configuration) {
        return new PracticeGenerator(configuration);
    }

    @Override
    protected GameSaver<PracticeGameState, Highscore> initializeGameSaver() {
        return null;
    }

    @Override
    protected void initializeGame(PracticeGameState practiceGameState) {
        /*endScreen.setScreenInteractListener(withConfiguration -> {
            if (withConfiguration) restartActivity(true);
            else finish();
        });*/

        game = new PracticeGame(this, practiceGameState, findViewById(R.id.activity_practice_game_board));

        indexCardViewModel = ViewModelProviders.of(this).get(IndexCardViewModel.class);
    }

    @Override
    public void onAbort(ConfirmDialog confirmDialog) {
        update(game.getResult().getIndexCards());
    }

    @Override
    public void onGameFinish(PracticeGameResult gameResult) {
        super.onGameFinish(gameResult);
        update(gameResult.getIndexCards());
    }

    private void update(List<IndexCard> indexCards) {
        for (IndexCard indexCard : indexCards) {
            indexCardViewModel.update(indexCard);
        }
    }

}