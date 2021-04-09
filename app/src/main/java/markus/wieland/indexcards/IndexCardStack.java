package markus.wieland.indexcards;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import markus.wieland.databases.DatabaseEntity;

@Entity(tableName = "index_card_stacks")
public class IndexCardStack implements DatabaseEntity {

    @PrimaryKey(autoGenerate = true)
    private long indexCardStackId;

    private String title;
    private String description;

    public long getIndexCardStackId() {
        return indexCardStackId;
    }

    public void setIndexCardStackId(long indexCardStackId) {
        this.indexCardStackId = indexCardStackId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public long getUniqueId() {
        return getIndexCardStackId();
    }
}
