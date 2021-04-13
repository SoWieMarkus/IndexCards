package markus.wieland.indexcards.test;

import java.util.List;

import markus.wieland.games.game.GameConfiguration;
import markus.wieland.indexcards.IndexCard;

public class TestConfiguration implements GameConfiguration {

    private final List<IndexCard> indexCards;

    public TestConfiguration(List<IndexCard> indexCards) {
        this.indexCards = indexCards;
    }

    public List<IndexCard> getIndexCards() {
        return indexCards;
    }
}
