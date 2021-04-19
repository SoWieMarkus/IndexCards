package markus.wieland.indexcards.test;

import android.os.Handler;
import android.os.Looper;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import markus.wieland.games.game.level.LevelEventListener;
import markus.wieland.games.game.level.LevelFragment;
import markus.wieland.games.game.level.LevelResult;
import markus.wieland.indexcards.IndexCard;
import markus.wieland.indexcards.R;

public class TestFragment extends LevelFragment<IndexCardTestLevel> implements TestAnswerInteractListener {

    private RecyclerView recyclerView;

    public TestFragment(IndexCardTestLevel level, LevelEventListener<IndexCardTestLevel> levelEventListener) {
        super(R.layout.fragment_test, level, levelEventListener);
    }

    @Override
    protected void initializeViews() {
        recyclerView = findViewById(R.id.test_fragment_recycler_view);
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setNestedScrollingEnabled(true);
    }

    @Override
    protected void loadLevel() {
        TestAnswerAdapter testAnswerAdapter = new TestAnswerAdapter(level, this);
        recyclerView.setAdapter(testAnswerAdapter);
    }

    @Override
    protected LevelResult getResult() {
        return null;
    }

    @Override
    public void onClick(IndexCard answerOfUser, IndexCard correctAnswer) {
        Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(() -> levelEventListener.onLevelCompleted(level, new IndexCardTestLevelResult(correctAnswer, answerOfUser)), 1000);
    }
}
