package markus.wieland.indexcards.database;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import markus.wieland.indexcards.IndexCard;
import markus.wieland.indexcards.IndexCardStack;
import markus.wieland.indexcards.cards.index_cards.IndexCardDataAccessObject;
import markus.wieland.indexcards.stacks.index_card_stack.IndexCardStackDataAccessObject;


@androidx.room.Database(entities = {IndexCard.class, IndexCardStack.class}, version = 1)
public abstract class Database extends RoomDatabase {

    private static Database instance;

    public abstract IndexCardDataAccessObject getIndexCardDataAccessObject();

    public abstract IndexCardStackDataAccessObject getIndexCardStackDataAccessObject();

    public static synchronized Database getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), Database.class, "school_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }


}
