package markus.wieland.indexcards.test;

import java.util.Collections;
import java.util.List;

import markus.wieland.games.game.GameConfiguration;
import markus.wieland.games.persistence.GameGenerator;
import markus.wieland.indexcards.IndexCard;

public class TestGenerator extends GameGenerator<TestGameState> {

    public TestGenerator(GameConfiguration configuration) {
        super(configuration);
    }

    @Override
    public TestConfiguration getConfiguration() {
        return (TestConfiguration) super.getConfiguration();
    }

    @Override
    public TestGameState generate() {
        List<IndexCard> indexCards = getConfiguration().getIndexCards();
        Collections.shuffle(indexCards);





        return null;
    }
}
