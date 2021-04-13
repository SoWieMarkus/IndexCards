package markus.wieland.indexcards.cards;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;

import androidx.lifecycle.ViewModelProviders;

import com.google.android.material.textfield.TextInputLayout;

import java.io.File;

import markus.wieland.defaultappelements.textinputvalidator.TextInputValidator;
import markus.wieland.defaultappelements.textinputvalidator.ValidatorResult;
import markus.wieland.defaultappelements.textinputvalidator.arguments.MaxLengthValidatorArgument;
import markus.wieland.defaultappelements.textinputvalidator.arguments.MinLengthValidatorArgument;
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

    private TextInputValidator textInputValidatorTerm;
    private TextInputValidator textInputValidatorDefinition;

    public CreateIndexCardActivity() {
        super(R.layout.activity_create_index_card);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        indexCardStack = (IndexCardStack) getIntent().getSerializableExtra(KEY_INDEX_CARD_STACK_ID);
        if (indexCardStack == null) {
            setResult(RESULT_CANCELED);
            finish();
            return;
        }
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void initializeViewsEditMode() {

    }

    @Override
    public void initializeViewsAddMode() {

    }

    @Override
    protected boolean validateItem() {

        //TODO if image there is no need for text
        //TODO at the same time there is no need for an image

        ValidatorResult termResult = textInputValidatorTerm.validate(getTerm());
        ValidatorResult definitionResult = textInputValidatorDefinition.validate(getDefinition());

        if (!termResult.isValid()){
            textInputLayoutTerm.setError(termResult.getErrorMessage());
            return false;
        }

        if (!definitionResult.isValid()) {
            textInputLayoutDefinition.setError(definitionResult.getErrorMessage());
            return false;
        }

        return true;
    }

    private String getTerm() {
        return textInputLayoutTerm.getEditText().getText().toString().trim();
    }

    private String getDefinition() {
        return textInputLayoutDefinition.getEditText().getText().toString().trim();
    }

    @Override
    protected void onCommitItem() {
        if (item != null) {
            commitItem();
            return;
        }

        if (!validateItem()) return;

        String term = getTerm();
        String definition = getDefinition();

        //TODO validate

        IndexCard indexCard = new IndexCard();
        indexCard.setDefinition(definition);
        indexCard.setTerm(term);
        indexCard.setIndexCardStackId(indexCardStack.getIndexCardStackId());

        indexCardViewModel.insert(indexCard);

        //TODO clear views
        //TODO Vllt eine Liste mit allen Wörtern in der Activity für bessere übersichtlichkeit
        //TODO wenn man Bilder etc hinzugefügt hat, dann benötigt man keinen Text!


    }

    @Override
    public void bindViews() {
        textInputLayoutTerm = findViewById(R.id.textInputLayout_index_card_2);
        textInputLayoutDefinition = findViewById(R.id.textInputLayout_index_card_3);
    }

    @Override
    public void initializeViews() {
        indexCardViewModel = ViewModelProviders.of(this).get(IndexCardViewModel.class);

        findViewById(R.id.imageButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.INTERNET}, 1001);

                Uri uriSavedImage= Uri.fromFile(new File("/sdcard/flashCropped.png"));
                startActivityForResult(new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE).putExtra(MediaStore.EXTRA_OUTPUT,uriSavedImage),100);
            }
        });

        //TODO Real error messages
        textInputValidatorTerm = new TextInputValidator()
                .add(new MaxLengthValidatorArgument(1000,""))
                .add(new MinLengthValidatorArgument(1,""));
        textInputValidatorDefinition = new TextInputValidator()
                .add(new MaxLengthValidatorArgument(1000,""))
                .add(new MinLengthValidatorArgument(1,""));
    }


}