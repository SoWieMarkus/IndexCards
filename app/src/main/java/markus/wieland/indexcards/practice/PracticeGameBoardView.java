package markus.wieland.indexcards.practice;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import markus.wieland.games.game.GameResult;
import markus.wieland.games.game.level.LevelManager;
import markus.wieland.games.game.view.GameBoardView;
import markus.wieland.games.persistence.GameState;
import markus.wieland.indexcards.R;
import markus.wieland.indexcards.practice.level.IndexCardLevel;

public class PracticeGameBoardView extends GameBoardView {

    private ProgressBar progressBarOfLevels;
    private TextView textViewProgressOfLevels;

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
        progressBarOfLevels = findViewById(R.id.layout_game_practice_progress_bar);
        textViewProgressOfLevels = findViewById(R.id.layout_game_practice_progress_text_view);

        findViewById(R.id.layout_game_practice_wrong).setOnClickListener(view -> ((PracticeGameBoardInteractListener) gameBoardInteractionListener).onLevelFinish(false));
        findViewById(R.id.layout_game_practice_correct).setOnClickListener(view -> ((PracticeGameBoardInteractListener) gameBoardInteractionListener).onLevelFinish(true));
    }

    @Override
    protected GameResult checkGameForFinish() {
        return null;
    }

    @Override
    protected void loadGameState(GameState gameState) {
        PracticeGameState practiceGameState = (PracticeGameState) gameState;
        progressBarOfLevels.setMax(practiceGameState.getIndexCardLevelLevelManager().getAmountOfLevel());
        load(practiceGameState.getIndexCardLevelLevelManager());
    }

    public void load(LevelManager<IndexCardLevel> levelManager) {
        progressBarOfLevels.setProgress(levelManager.getCurrentLevelIndex());
        textViewProgressOfLevels.setText(levelManager.getCurrentLevelIndex() + " / " + levelManager.getAmountOfLevel());

        PracticeFragment practiceFragment = new PracticeFragment(levelManager.getCurrentLevel());
        ((AppCompatActivity) getContext()).getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(R.anim.slide_in_right_animation, R.anim.slide_out_left_animation)
                .replace(R.id.frame_layout, practiceFragment).commit();
    }
}
