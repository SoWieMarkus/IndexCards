package markus.wieland.indexcards.stacks.index_card_stack;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import java.util.List;

import markus.wieland.databases.BaseRepository;
import markus.wieland.indexcards.IndexCardStack;
import markus.wieland.indexcards.IndexCardStackWithIndexCards;
import markus.wieland.indexcards.database.Database;

public class IndexCardStackRepository extends BaseRepository<IndexCardStack, IndexCardStackDataAccessObject> {

    public IndexCardStackRepository(@NonNull Application application) {
        super(application);
    }

    @Override
    public IndexCardStackDataAccessObject initDataAccessObject(@NonNull Application application) {
        return Database.getInstance(application).getIndexCardStackDataAccessObject();
    }

    public LiveData<List<IndexCardStackWithIndexCards>> getAllIndexCardStacks() {
        return dataAccessObject.getAllIndexCardStacks();
    }
}
