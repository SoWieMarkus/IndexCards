package markus.wieland.indexcards.practice.level;

import markus.wieland.games.game.level.Level;
import markus.wieland.games.game.level.LevelResult;
import markus.wieland.indexcards.IndexCard;

public class IndexCardLevel extends Level {

    private final IndexCard indexCard;
    private IndexCardLevelResult indexCardLevelResult;

    public IndexCardLevel(IndexCard indexCard) {
        this.indexCard = indexCard;
    }

    public IndexCard getIndexCard() {
        return indexCard;
    }

    @Override
    public void finishLevel(LevelResult levelResult) {
        indexCardLevelResult = (IndexCardLevelResult) levelResult;
        indexCard.rate(indexCardLevelResult.isAnsweredCorrectly());
    }

    public IndexCardLevelResult getIndexCardLevelResult() {
        return indexCardLevelResult;
    }
}
