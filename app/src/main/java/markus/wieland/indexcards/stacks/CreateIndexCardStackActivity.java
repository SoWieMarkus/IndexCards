package markus.wieland.indexcards.stacks;

import android.widget.Spinner;

import com.google.android.material.textfield.TextInputLayout;

import markus.wieland.defaultappelements.textinputvalidator.TextInputValidator;
import markus.wieland.defaultappelements.textinputvalidator.ValidatorResult;
import markus.wieland.defaultappelements.textinputvalidator.arguments.MaxLengthValidatorArgument;
import markus.wieland.defaultappelements.textinputvalidator.arguments.MinLengthValidatorArgument;
import markus.wieland.defaultappelements.uielements.activities.CreateItemActivity;
import markus.wieland.indexcards.IndexCardStack;
import markus.wieland.indexcards.R;

public class CreateIndexCardStackActivity extends CreateItemActivity<IndexCardStack> {

    private TextInputLayout textInputLayoutIndexCardStackTitle;
    private TextInputValidator textInputValidatorTitle;

    private Spinner spinnerLanguageTerm;
    private Spinner spinnerLanguageDescription;

    public CreateIndexCardStackActivity() {
        super(R.layout.activity_create_index_card_stack);
    }

    @Override
    public void initializeViewsEditMode() {
        textInputLayoutIndexCardStackTitle.getEditText().setText(item.getTitle());
    }

    @Override
    public void initializeViewsAddMode() {

    }

    private String getIndexCardStackTitle() {
        return textInputLayoutIndexCardStackTitle.getEditText()
                .getText()
                .toString()
                .trim();
    }

    @Override
    protected boolean validateItem() {
        textInputLayoutIndexCardStackTitle.setError(null);


        String indexCardStackTitle = getIndexCardStackTitle();
        ValidatorResult titleResult = textInputValidatorTitle.validate(indexCardStackTitle);
        if (!titleResult.isValid()) {
            textInputLayoutIndexCardStackTitle.setError(titleResult.getErrorMessage());
            return false;
        }

        if (item == null) {
            item = new IndexCardStack();
            item.updateLastUse();
        }

        item.setTitle(indexCardStackTitle);
        item.setLanguageTerm("de_DE");
        item.setLanguageDescription("de_DE");
        return true;
    }

    @Override
    protected void onCommitItem() {
        commitItem();
    }

    @Override
    public void execute() {
        textInputValidatorTitle = new TextInputValidator()
                .add(new MinLengthValidatorArgument(1, "Test1"))
                .add(new MaxLengthValidatorArgument(1000, ""));
        super.execute();
    }

    @Override
    public void bindViews() {
        textInputLayoutIndexCardStackTitle = findViewById(R.id.textInputLayout);
        spinnerLanguageTerm = findViewById(R.id.spinner);
        spinnerLanguageDescription = findViewById(R.id.spinner2);
    }

    @Override
    public void initializeViews() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //spinnerLanguageTerm.setAdapter(new IndexCardStackLanguageAdapter());
        //spinnerLanguageDescription.setAdapter(new IndexCardStackLanguageAdapter());
    }
}