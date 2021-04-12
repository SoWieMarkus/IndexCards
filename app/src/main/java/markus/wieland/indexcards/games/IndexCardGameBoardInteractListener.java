package markus.wieland.indexcards.games;

import markus.wieland.games.game.view.GameBoardInteractionListener;

public interface IndexCardGameBoardInteractListener extends GameBoardInteractionListener {

    void onLevelFinished(IndexCardLevel indexCardLevel);

}
