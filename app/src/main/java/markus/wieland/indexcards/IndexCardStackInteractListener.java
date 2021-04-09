package markus.wieland.indexcards;

import markus.wieland.defaultappelements.uielements.adapter.iteractlistener.OnItemInteractListener;

public interface IndexCardStackInteractListener extends OnItemInteractListener<IndexCardStackWithIndexCards> {
    void onClick(IndexCardStackWithIndexCards indexCardStackWithIndexCards);
    void onDelete(IndexCardStackWithIndexCards indexCardStackWithIndexCards);
    void onEdit(IndexCardStackWithIndexCards indexCardStackWithIndexCards);
    void onTest(IndexCardStackWithIndexCards indexCardStackWithIndexCards);
    void onPractice(IndexCardStackWithIndexCards indexCardStackWithIndexCards);
}
