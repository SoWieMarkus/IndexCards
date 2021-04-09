package markus.wieland.indexcards;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

import markus.wieland.databases.DatabaseEntity;
import markus.wieland.defaultappelements.uielements.adapter.QueryableEntity;

public class IndexCardStackWithIndexCards implements DatabaseEntity, QueryableEntity<Long> {

    @Embedded
    private IndexCardStack indexCardStack;

    @Relation(parentColumn = "indexCardStackId", entityColumn = "indexCardStackId")
    private List<IndexCard> indexCards;

    public IndexCardStack getIndexCardStack() {
        return indexCardStack;
    }

    public void setIndexCardStack(IndexCardStack indexCardStack) {
        this.indexCardStack = indexCardStack;
    }

    public List<IndexCard> getIndexCards() {
        return indexCards;
    }

    public void setIndexCards(List<IndexCard> indexCards) {
        this.indexCards = indexCards;
    }

    @Override
    public long getUniqueId() {
        return indexCardStack.getUniqueId();
    }

    @Override
    public Long getId() {
        return getUniqueId();
    }

    @Override
    public String getStringToApplyQuery() {
        return indexCardStack.getTitle() + " " + indexCardStack.getDescription();
    }
}
