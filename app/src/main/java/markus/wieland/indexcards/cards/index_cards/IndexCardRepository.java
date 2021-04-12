package markus.wieland.indexcards.cards.index_cards;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import java.util.List;

import markus.wieland.databases.BaseRepository;
import markus.wieland.indexcards.IndexCard;
import markus.wieland.indexcards.database.Database;

public class IndexCardRepository extends BaseRepository<IndexCard, IndexCardDataAccessObject> {

    public IndexCardRepository(@NonNull Application application) {
        super(application);
    }

    @Override
    public IndexCardDataAccessObject initDataAccessObject(@NonNull Application application) {
        return Database.getInstance(application).getIndexCardDataAccessObject();
    }

    public LiveData<List<IndexCard>> getAllIndexCardsByIndexCardStackId(long indexCardStackId) {
        return dataAccessObject.getAllIndexCardsByIndexCardStackId(indexCardStackId);
    }
}
