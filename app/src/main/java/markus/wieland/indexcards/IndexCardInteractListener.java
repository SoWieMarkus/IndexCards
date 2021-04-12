package markus.wieland.indexcards;

import markus.wieland.defaultappelements.uielements.adapter.iteractlistener.OnItemInteractListener;

public interface IndexCardInteractListener extends OnItemInteractListener<IndexCard> {
    void onClick(IndexCard indexCard);

    void onDelete(IndexCard indexCard);

    void onEdit(IndexCard indexCard);
}
