package markus.wieland.indexcards.stacks.index_card_stack;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import java.util.List;

import markus.wieland.databases.BaseViewModel;
import markus.wieland.indexcards.IndexCardStack;
import markus.wieland.indexcards.IndexCardStackWithIndexCards;

public class IndexCardStackViewModel extends BaseViewModel<IndexCardStack, IndexCardStackDataAccessObject, IndexCardStackRepository> {

    public IndexCardStackViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<IndexCardStackWithIndexCards>> getAllIndexCardStacks() {
        return repository.getAllIndexCardStacks();
    }

    @Override
    protected IndexCardStackRepository initRepository() {
        return new IndexCardStackRepository(getApplication());
    }
}
