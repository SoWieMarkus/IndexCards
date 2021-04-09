package markus.wieland.indexcards.database.index_cards;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import java.util.List;

import markus.wieland.databases.BaseViewModel;
import markus.wieland.indexcards.IndexCard;

public class IndexCardViewModel extends BaseViewModel<IndexCard, IndexCardDataAccessObject, IndexCardRepository> {

    public IndexCardViewModel(@NonNull Application application) {
        super(application);
    }

    @Override
    protected IndexCardRepository initRepository() {
        return new IndexCardRepository(getApplication());
    }

    public LiveData<List<IndexCard>> getAllIndexCardsByIndexCardStackId(long indexCardStackId) {
        return repository.getAllIndexCardsByIndexCardStackId(indexCardStackId);
    }

}
