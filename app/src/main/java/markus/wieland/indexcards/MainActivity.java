package markus.wieland.indexcards;

import android.content.Intent;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import markus.wieland.defaultappelements.uielements.activities.DefaultActivity;
import markus.wieland.indexcards.database.index_card_stack.IndexCardStackViewModel;

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
        startActivity(new Intent(this, IndexCardActivity.class));
    }

    @Override
    public void onDelete(IndexCardStackWithIndexCards indexCardStackWithIndexCards) {
        indexCardStackViewModel.delete(indexCardStackWithIndexCards.getIndexCardStack());
    }

    @Override
    public void onEdit(IndexCardStackWithIndexCards indexCardStackWithIndexCards) {

    }

    @Override
    public void onTest(IndexCardStackWithIndexCards indexCardStackWithIndexCards) {

    }

    @Override
    public void onPractice(IndexCardStackWithIndexCards indexCardStackWithIndexCards) {

    }

    @Override
    public void onChanged(List<IndexCardStackWithIndexCards> indexCardStackWithIndexCards) {
        indexCardStackAdapter.submitList(indexCardStackWithIndexCards);
    }
}