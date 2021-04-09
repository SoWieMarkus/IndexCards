package markus.wieland.indexcards;

import markus.wieland.defaultappelements.uielements.activities.CreateItemActivity;

public class CreateIndexCardStackActivity extends CreateItemActivity<IndexCardStack> {


    public CreateIndexCardStackActivity() {
        super(R.layout.activity_create_index_card_stack);
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

    }

    @Override
    public void bindViews() {

    }

    @Override
    public void initializeViews() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}