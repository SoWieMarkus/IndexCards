package markus.wieland.indexcards.stacks.index_card_stack;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Transaction;

import java.util.List;

import markus.wieland.databases.BaseDataAccessObject;
import markus.wieland.indexcards.IndexCardStack;
import markus.wieland.indexcards.IndexCardStackWithIndexCards;

@Dao
public interface IndexCardStackDataAccessObject extends BaseDataAccessObject<IndexCardStack> {

    @Transaction
    @Query("SELECT * FROM index_card_stacks ORDER BY indexCardStackId ASC")
    LiveData<List<IndexCardStackWithIndexCards>> getAllIndexCardStacks();


}
