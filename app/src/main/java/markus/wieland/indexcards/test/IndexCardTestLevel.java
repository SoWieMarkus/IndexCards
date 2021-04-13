package markus.wieland.indexcards.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import markus.wieland.games.game.level.Level;
import markus.wieland.games.game.level.LevelResult;
import markus.wieland.indexcards.IndexCard;

public class IndexCardTestLevel extends Level {

    private final IndexCard question;
    private final List<IndexCard> answers;
    private final boolean switchFrontAndBack;

    public IndexCardTestLevel(IndexCard question, List<IndexCard> answers) {
        this.question = question;
        this.answers = answers;

        this.switchFrontAndBack = new Random().nextBoolean();
    }

    public IndexCard getQuestion() {
        return question;
    }

   public boolean isCorrect(IndexCard indexCard) {
        return question.getIndexCardId() == indexCard.getIndexCardId();
   }

    public List<IndexCard> getPossibleAnswers(){
        List<IndexCard> indexCards = new ArrayList<>(answers);
        indexCards.add(question);
        Collections.shuffle(indexCards);
        return indexCards;
    }

    public boolean isSwitchFrontAndBack() {
        return switchFrontAndBack;
    }

    @Override
    protected void finishLevel(LevelResult levelResult) {

    }
}
