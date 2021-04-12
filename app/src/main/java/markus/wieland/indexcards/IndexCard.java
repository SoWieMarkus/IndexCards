package markus.wieland.indexcards;

import android.content.Context;
import android.graphics.Color;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;

import markus.wieland.databases.DatabaseEntity;
import markus.wieland.indexcards.annotation.IndexCardScore;

@Entity(tableName = "index_cards")
public class IndexCard implements DatabaseEntity, Serializable {

    @PrimaryKey(autoGenerate = true)
    private long indexCardId;
    private long indexCardStackId;

    private String term;
    private String definition;

    @IndexCardScore
    private int score;

    public static final int MAX_SCORE = 3;
    public static final int MIN_SCORE = -3;

    public long getIndexCardId() {
        return indexCardId;
    }

    public void setIndexCardId(long indexCardId) {
        this.indexCardId = indexCardId;
    }

    public long getIndexCardStackId() {
        return indexCardStackId;
    }

    public void setIndexCardStackId(long indexCardStackId) {
        this.indexCardStackId = indexCardStackId;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Ignore
    public int getColor(){
        return Color.CYAN;
    }

    @Ignore
    public void rate(boolean answeredCorrectly) {
        if (answeredCorrectly) {
            answeredCorrectly();
            return;
        }
        answeredWrong();
    }

    @Ignore
    private void answeredCorrectly() {
        if (score < MAX_SCORE)
            score++;
    }

    @Ignore
    private void answeredWrong() {
        if (score > MIN_SCORE)
            score--;
    }

    @Ignore
    @Override
    public long getUniqueId() {
        return getIndexCardId();
    }
}
