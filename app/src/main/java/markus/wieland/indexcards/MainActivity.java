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

import markus.wieland.defaultappelements.uielements.activities.CreateItemActivity;
import markus.wieland.defaultappelements.uielements.activities.DefaultActivity;
import markus.wieland.games.GameActivity;
import markus.wieland.indexcards.practice.PracticeConfiguration;
import markus.wieland.indexcards.stacks.CreateIndexCardStackActivity;
import markus.wieland.indexcards.stacks.index_card_stack.IndexCardStackViewModel;
import markus.wieland.indexcards.practice.PracticeActivity;


public class MainActivity extends DefaultActivity implements IndexCardStackInteractListener, Observer<List<IndexCardStackWithIndexCards>> {

    private IndexCardStackViewModel indexCardStackViewModel;
    private RecyclerView recyclerView;
    private IndexCardStackAdapter indexCardStackAdapter;

    public MainActivity() {
        super(R.layout.activity_main);
    }

    @Override
    public void bindViews() {
        recyclerView = findViewById(R.id.activity_main_recycler_view);
    }

    @Override
    public void initializeViews() {
        indexCardStackAdapter = new IndexCardStackAdapter(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(indexCardStackAdapter);

        indexCardStackViewModel = ViewModelProviders.of(this).get(IndexCardStackViewModel.class);
        
    }

    @Override
    public void execute() {
        indexCardStackViewModel.getAllIndexCardStacks().observe(this, this);
    }

    @Override
    public void onClick(IndexCardStackWithIndexCards indexCardStackWithIndexCards) {
        startActivity(new Intent(this, IndexCardActivity.class)
                .putExtra(IndexCardActivity.KEY_INDEX_CARD_STACK, indexCardStackWithIndexCards.getIndexCardStack()));
    }

    @Override
    public void onDelete(IndexCardStackWithIndexCards indexCardStackWithIndexCards) {
        indexCardStackViewModel.delete(indexCardStackWithIndexCards.getIndexCardStack());
    }

    @Override
    public void onEdit(IndexCardStackWithIndexCards indexCardStackWithIndexCards) {
        startActivityForResult(new Intent(this, CreateIndexCardStackActivity.class)
                        .putExtra(CreateItemActivity.OBJECT_TO_EDIT, indexCardStackWithIndexCards.getIndexCardStack()),
                CreateItemActivity.REQUEST_EDIT);
    }

    @Override
    public void onTest(IndexCardStackWithIndexCards indexCardStackWithIndexCards) {
        if (indexCardStackWithIndexCards.getIndexCards().size() < 5) {
            //TODO error toast
            return;
        }
        startActivity(new Intent(this, IndexCardTestActivity.class));

    }

    @Override
    public void onPractice(IndexCardStackWithIndexCards indexCardStackWithIndexCards) {
        startActivity(new Intent(this, PracticeActivity.class).putExtra("markus.wieland.games.CONFIGURATION", new PracticeConfiguration(indexCardStackWithIndexCards.getIndexCards())));
    }

    @Override
    public void onChanged(List<IndexCardStackWithIndexCards> indexCardStackWithIndexCards) {
        indexCardStackAdapter.submitList(indexCardStackWithIndexCards);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (resultCode == RESULT_OK) {
            if (data == null) return;
            IndexCardStack indexCardStack = (IndexCardStack) data.getSerializableExtra(CreateItemActivity.RESULT);
            if (indexCardStack == null) return;
            if (requestCode == CreateItemActivity.REQUEST_EDIT)
                indexCardStackViewModel.update(indexCardStack);
            if (requestCode == CreateItemActivity.REQUEST_CREATE)
                indexCardStackViewModel.insert(indexCardStack);
        }

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
            startActivityForResult(new Intent(this, CreateIndexCardStackActivity.class), CreateItemActivity.REQUEST_CREATE);
        return super.onOptionsItemSelected(item);
    }
}