package markus.wieland.indexcards.cards;

import android.os.Bundle;

import androidx.lifecycle.ViewModelProviders;
import androidx.room.Index;

import com.google.android.material.textfield.TextInputLayout;

import markus.wieland.defaultappelements.uielements.activities.CreateItemActivity;
import markus.wieland.indexcards.IndexCard;
import markus.wieland.indexcards.IndexCardStack;
import markus.wieland.indexcards.R;
import markus.wieland.indexcards.cards.index_cards.IndexCardViewModel;

public class CreateIndexCardActivity extends CreateItemActivity<IndexCard> {

    public static final String KEY_INDEX_CARD_STACK_ID = "markus.wieland.indexcards.create.KEY_INDEX_CARD_STACK_ID";

    private IndexCardStack indexCardStack;

    private TextInputLayout textInputLayoutTerm;
    private TextInputLayout textInputLayoutDefinition;

    private IndexCardViewModel indexCardViewModel;

    public CreateIndexCardActivity() {
        super(R.layout.activity_create_index_card);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        indexCardStack = (IndexCardStack)getIntent().getSerializableExtra(KEY_INDEX_CARD_STACK_ID);
        if (indexCardStack == null) {
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


        return true;
    }

    @Override
    protected void onCommitItem() {
        if (item != null) {
            commitItem();
            return;
        }

        String term = textInputLayoutTerm.getEditText().getText().toString().trim();
        String definition = textInputLayoutDefinition.getEditText().getText().toString().trim();

        //TODO validate

        IndexCard indexCard = new IndexCard();
        indexCard.setDefinition(definition);
        indexCard.setTerm(term);
        indexCard.setIndexCardStackId(indexCardStack.getIndexCardStackId());

        indexCardViewModel.insert(indexCard);

        //TODO clear views
        

    }

    @Override
    public void bindViews() {
        textInputLayoutTerm = findViewById(R.id.textInputLayout_index_card_2);
        textInputLayoutDefinition = findViewById(R.id.textInputLayout_index_card_3);
    }

    @Override
    public void initializeViews() {
        indexCardViewModel = ViewModelProviders.of(this).get(IndexCardViewModel.class);
    }

}