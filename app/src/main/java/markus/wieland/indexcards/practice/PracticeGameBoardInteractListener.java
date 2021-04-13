package markus.wieland.indexcards.practice;

import markus.wieland.games.game.view.GameBoardInteractionListener;

public interface PracticeGameBoardInteractListener extends GameBoardInteractionListener {

    void onLevelFinish(boolean answeredCorrectly);

}
