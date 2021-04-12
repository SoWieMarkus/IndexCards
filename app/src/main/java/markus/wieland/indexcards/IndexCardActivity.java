package markus.wieland.indexcards;

import android.content.Intent;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import markus.wieland.defaultappelements.uielements.activities.DefaultActivity;
import markus.wieland.indexcards.cards.index_cards.IndexCardViewModel;

public class IndexCardActivity extends DefaultActivity implements Observer<List<IndexCard>>, IndexCardInteractListener {

    public static final String KEY_INDEX_CARD_STACK = "markus.wieland.indexcards.KEY_INDEX_CARD_STACK";

    private RecyclerView recyclerViewIndexCards;
    private IndexCardViewModel indexCardViewModel;
    private IndexCardAdapter indexCardAdapter;

    public IndexCardActivity(int layout) {
        super(layout);
    }

    @Override
    public void bindViews() {
        recyclerViewIndexCards = findViewById(R.id.activity_index_card_recycler_view);
    }

    @Override
    public void initializeViews() {
        recyclerViewIndexCards.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewIndexCards.setHasFixedSize(true);

        indexCardViewModel = ViewModelProviders.of(this).get(IndexCardViewModel.class);
    }

    @Override
    public void execute() {
        IndexCardStack indexCardStack = (IndexCardStack)getIntent()
                .getSerializableExtra(KEY_INDEX_CARD_STACK);
        if (indexCardStack == null) {
            finish();
            return;
        }

        indexCardAdapter = new IndexCardAdapter(this);
        indexCardViewModel.getAllIndexCardsByIndexCardStackId(indexCardStack.getIndexCardStackId())
                .observe(this, this);
    }

    @Override
    public void onChanged(List<IndexCard> indexCards) {
        indexCardAdapter.submitList(indexCards);
    }

    @Override
    public void onClick(IndexCard indexCard) {
        // TODO read
    }

    @Override
    public void onDelete(IndexCard indexCard) {
        indexCardViewModel.delete(indexCard);
    }

    @Override
    public void onEdit(IndexCard indexCard) {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}