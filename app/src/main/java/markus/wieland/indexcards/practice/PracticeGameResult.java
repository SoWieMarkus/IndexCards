package markus.wieland.indexcards.practice;

import java.util.ArrayList;
import java.util.List;

import markus.wieland.games.game.GameResult;
import markus.wieland.indexcards.IndexCard;
import markus.wieland.indexcards.practice.level.IndexCardLevel;
import markus.wieland.indexcards.practice.level.IndexCardLevelResult;

public class PracticeGameResult implements GameResult {

    private final List<IndexCardLevel> indexCardLevelList;
    private final long time;

    public PracticeGameResult(List<IndexCardLevel> indexCardLevelList, long time) {
        this.indexCardLevelList = indexCardLevelList;
        this.time = time;
    }

    public List<IndexCardLevel> getIndexCardLevelList() {
        return indexCardLevelList;
    }

    public int getSize() {
        return indexCardLevelList.size();
    }

    public long getTime() {
        return time;
    }

    public String getPercentage() {
        if (getSize() == 0) return "0%";
        return (int) (((float) getCorrectAnswered() / getSize()) * 100) + "%";
    }

    public int getCorrectAnswered() {
        int amountCorrect = 0;
        for (IndexCardLevel indexCardLevel : indexCardLevelList) {
            IndexCardLevelResult indexCardLevelResult = indexCardLevel.getIndexCardLevelResult();
            if (indexCardLevelResult != null
                    && indexCardLevel.getIndexCardLevelResult().isAnsweredCorrectly())
                amountCorrect++;
        }
        return amountCorrect;
    }

    public List<IndexCard> getIndexCards() {
        List<IndexCard> indexCards = new ArrayList<>();
        for (IndexCardLevel level : indexCardLevelList) {
            indexCards.add(level.getIndexCard());
        }
        return indexCards;
    }
}
