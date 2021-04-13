package markus.wieland.indexcards.practice;

import java.util.List;

import markus.wieland.games.game.GameConfiguration;
import markus.wieland.indexcards.IndexCard;
import markus.wieland.indexcards.annotation.IndexCardScore;

public class PracticeConfiguration implements GameConfiguration {

    private final List<IndexCard> indexCardsToPractice;
    private final int lowestRating;
    private final int highestRating;

    //TODO possible options
    // - repeat until every question is answered
    // - shuffle
    // - borders
    // - switch front and back

    public PracticeConfiguration(List<IndexCard> indexCardsToPractice, @IndexCardScore int lowestRating, @IndexCardScore int highestRating) {
        this.indexCardsToPractice = indexCardsToPractice;
        this.lowestRating = lowestRating;
        this.highestRating = highestRating;
    }

    public PracticeConfiguration(List<IndexCard> indexCardsToPractice) {
        this(indexCardsToPractice, IndexCard.MIN_SCORE, IndexCard.MAX_SCORE);
    }

    public List<IndexCard> getIndexCardsToPractice() {
        return indexCardsToPractice;
    }

    public int getHighestRating() {
        return highestRating;
    }

    public int getLowestRating() {
        return lowestRating;
    }
}
