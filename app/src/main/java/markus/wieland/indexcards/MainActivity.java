package markus.wieland.indexcards;

import android.content.Intent;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import markus.wieland.defaultappelements.uielements.activities.CreateItemActivity;
import markus.wieland.defaultappelements.uielements.activities.DefaultActivity;
import markus.wieland.indexcards.create.CreateIndexCardStackActivity;
import markus.wieland.indexcards.database.index_card_stack.IndexCardStackViewModel;
import markus.wieland.indexcards.practice.PracticeActivity;
import markus.wieland.indexcards.test.TestActivity;

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
        startActivity(new Intent(this, TestActivity.class));

    }

    @Override
    public void onPractice(IndexCardStackWithIndexCards indexCardStackWithIndexCards) {
        startActivity(new Intent(this, PracticeActivity.class));
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


}