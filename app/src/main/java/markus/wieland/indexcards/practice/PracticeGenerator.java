package markus.wieland.indexcards.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import markus.wieland.games.game.GameConfiguration;
import markus.wieland.games.game.level.LevelManager;
import markus.wieland.games.persistence.GameGenerator;
import markus.wieland.indexcards.IndexCard;
import markus.wieland.indexcards.games.IndexCardLevel;

public class PracticeGenerator extends GameGenerator<PracticeGameState> {

    private final LevelManager<IndexCardLevel> indexCardLevelLevelManager;

    public PracticeGenerator(GameConfiguration configuration) {
        super(configuration);

        List<IndexCardLevel> indexCardLevels = new ArrayList<>();
        for (IndexCard indexCard : getConfiguration().getIndexCardsToPractice()) {
            if (indexCard.getScore() >= getConfiguration().getLowestRating()
                    && indexCard.getScore() <= getConfiguration().getHighestRating())
                indexCardLevels.add(new IndexCardLevel(indexCard));
        }

        Collections.shuffle(indexCardLevels);
        indexCardLevelLevelManager = new LevelManager<>(indexCardLevels);
    }

    @Override
    public PracticeConfiguration getConfiguration(){
        return (PracticeConfiguration) super.getConfiguration();
    }

    @Override
    public PracticeGameState generate() {
        return new PracticeGameState(indexCardLevelLevelManager);
    }
}
