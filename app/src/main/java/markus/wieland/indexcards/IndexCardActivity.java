package markus.wieland.indexcards;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import markus.wieland.defaultappelements.uielements.activities.DefaultActivity;
import markus.wieland.indexcards.cards.CreateIndexCardActivity;
import markus.wieland.indexcards.cards.index_cards.IndexCardViewModel;

public class IndexCardActivity extends DefaultActivity implements Observer<List<IndexCard>>, IndexCardInteractListener {

    public static final String KEY_INDEX_CARD_STACK = "markus.wieland.indexcards.KEY_INDEX_CARD_STACK";

    private RecyclerView recyclerViewIndexCards;
    private IndexCardViewModel indexCardViewModel;
    private IndexCardAdapter indexCardAdapter;
    private IndexCardStack indexCardStack;

    public IndexCardActivity() {
        super(R.layout.activity_index_card);
    }

    @Override
    public void bindViews() {
        recyclerViewIndexCards = findViewById(R.id.activity_index_card_recycler_view);
    }

    @Override
    public void initializeViews() {
        indexCardAdapter = new IndexCardAdapter(this);

        recyclerViewIndexCards.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewIndexCards.setHasFixedSize(true);
        recyclerViewIndexCards.setAdapter(indexCardAdapter);

        indexCardViewModel = ViewModelProviders.of(this).get(IndexCardViewModel.class);
    }

    @Override
    public void execute() {
         indexCardStack = (IndexCardStack)getIntent()
                .getSerializableExtra(KEY_INDEX_CARD_STACK);
        if (indexCardStack == null) {
            finish();
            return;
        }


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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_activity_index_card_stack, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.activity_index_card_stack_add)
            startActivity(new Intent(this, CreateIndexCardActivity.class)
                    .putExtra(CreateIndexCardActivity.KEY_INDEX_CARD_STACK_ID, indexCardStack));
        return super.onOptionsItemSelected(item);
    }
}