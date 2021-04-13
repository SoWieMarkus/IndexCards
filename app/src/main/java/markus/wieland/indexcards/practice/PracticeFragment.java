package markus.wieland.indexcards.practice;

import markus.wieland.games.game.level.LevelFragment;
import markus.wieland.games.game.level.LevelResult;
import markus.wieland.indexcards.R;
import markus.wieland.indexcards.games.IndexCardLevel;

public class PracticeFragment extends LevelFragment<IndexCardLevel> {

    private PracticeIndexCardView practiceIndexCardView;

    public PracticeFragment(IndexCardLevel level) {
        super(R.layout.fragment_practice, level, null);
    }

    @Override
    protected void initializeViews() {
        practiceIndexCardView = findViewById(R.id.fragment_practice_index_card);
    }

    @Override
    protected void loadLevel() {
        practiceIndexCardView.load(level.getIndexCard());
    }

    @Override
    protected LevelResult getResult() {
        return null;
    }
}
