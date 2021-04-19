package markus.wieland.indexcards.test;

import markus.wieland.games.game.level.LevelResult;
import markus.wieland.indexcards.IndexCard;

public class IndexCardTestLevelResult extends LevelResult {

    private final IndexCard correctAnswer;
    private final IndexCard answer;

    public IndexCardTestLevelResult(IndexCard correctAnswer, IndexCard answer) {
        this.correctAnswer = correctAnswer;
        this.answer = answer;
    }

    public IndexCard getCorrectAnswer() {
        return correctAnswer;
    }

    public IndexCard getAnswer() {
        return answer;
    }

    public boolean isAnsweredCorrectly() {
        return answer.getIndexCardId() == correctAnswer.getIndexCardId();
    }
}
