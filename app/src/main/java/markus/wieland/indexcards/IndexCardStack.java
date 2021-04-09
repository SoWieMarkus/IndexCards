package markus.wieland.indexcards;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import markus.wieland.databases.DatabaseEntity;

@Entity(tableName = "index_card_stacks")
public class IndexCardStack implements DatabaseEntity, Serializable {

    @PrimaryKey(autoGenerate = true)
    private long indexCardStackId;

    private String title;
    private String lastUse;

    private String languageTerm;
    private String languageDescription;

    public String getLanguageTerm() {
        return languageTerm;
    }

    public void setLanguageTerm(String languageTerm) {
        this.languageTerm = languageTerm;
    }

    public String getLanguageDescription() {
        return languageDescription;
    }

    public void setLanguageDescription(String languageDescription) {
        this.languageDescription = languageDescription;
    }

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

    public String getLastUse() {
        return lastUse;
    }

    public void setLastUse(String lastUse) {
        this.lastUse = lastUse;
    }

    public void updateLastUse(){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy : HH:mm");
        this.lastUse = now.format(dateTimeFormatter);
    }

    @Override
    public long getUniqueId() {
        return getIndexCardStackId();
    }
}
