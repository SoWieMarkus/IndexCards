package markus.wieland.indexcards.test;

import markus.wieland.defaultappelements.uielements.adapter.iteractlistener.OnItemInteractListener;
import markus.wieland.indexcards.IndexCard;

public interface TestAnswerInteractListener extends OnItemInteractListener<IndexCard> {

    void onClick(IndexCard answerOfUser, IndexCard correctAnswer);

}
