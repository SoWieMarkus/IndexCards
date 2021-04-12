package markus.wieland.indexcards.cards.index_cards;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Transaction;

import java.util.List;

import markus.wieland.databases.BaseDataAccessObject;
import markus.wieland.indexcards.IndexCard;

@Dao
public interface IndexCardDataAccessObject extends BaseDataAccessObject<IndexCard> {

    @Transaction
    @Query("SELECT * FROM index_cards WHERE indexCardStackId = :indexCardStackId")
    LiveData<List<IndexCard>> getAllIndexCardsByIndexCardStackId(long indexCardStackId);


}
