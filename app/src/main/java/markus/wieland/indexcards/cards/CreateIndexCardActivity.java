package markus.wieland.indexcards.cards;

import android.os.Bundle;

import markus.wieland.defaultappelements.uielements.activities.CreateItemActivity;
import markus.wieland.indexcards.IndexCard;
import markus.wieland.indexcards.IndexCardStack;
import markus.wieland.indexcards.R;

public class CreateIndexCardActivity extends CreateItemActivity<IndexCard> {

    public static final String KEY_INDEX_CARD_STACK_ID = "markus.wieland.indexcards.create.KEY_INDEX_CARD_STACK_ID";

    private long indexCardStackId;

    public CreateIndexCardActivity() {
        super(R.layout.activity_create_index_card);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        indexCardStackId = getIntent().getLongExtra(KEY_INDEX_CARD_STACK_ID, IndexCardStack.NO_INDEX_CARD_STACK);
        if (indexCardStackId == IndexCardStack.NO_INDEX_CARD_STACK) {
            setResult(RESULT_CANCELED);
            finish();
            return;
        }
        super.onCreate(savedInstanceState);
    }

    @Override
    public void initializeViewsEditMode() {

    }

    @Override
    public void initializeViewsAddMode() {

    }

    @Override
    protected boolean validateItem() {
        return false;
    }

    @Override
    protected void onCommitItem() {
        if (item != null) {
            commitItem();
            return;
        }
        

    }

    @Override
    public void bindViews() {

    }

    @Override
    public void initializeViews() {

    }

}