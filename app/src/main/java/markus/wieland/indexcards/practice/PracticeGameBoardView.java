package markus.wieland.indexcards.practice;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import markus.wieland.games.game.GameResult;
import markus.wieland.games.game.view.GameBoardView;
import markus.wieland.games.persistence.GameState;

public class PracticeGameBoardView extends GameBoardView {

    private ProgressBar progressBarOfLevels;
    private FrameLayout frameLayout;

    public PracticeGameBoardView(@NonNull Context context) {
        super(context);
    }

    public PracticeGameBoardView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public PracticeGameBoardView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void initializeFields() {

    }

    @Override
    protected GameResult checkGameForFinish() {
        return null;
    }

    @Override
    protected void loadGameState(GameState gameState) {

    }
}
