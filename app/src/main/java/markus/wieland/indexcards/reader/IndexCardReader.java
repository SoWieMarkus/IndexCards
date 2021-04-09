package markus.wieland.indexcards.reader;

import android.content.Context;
import android.speech.tts.TextToSpeech;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public class IndexCardReader implements TextToSpeech.OnInitListener {

    private final TextToSpeech textToSpeech;
    private boolean isInitialised;
    private final HashMap<String, Locale> availableLanguages;
    private final IndexCardReaderLocaleEventListener indexCardReaderLocaleEventListener;

    public IndexCardReader(Context context, IndexCardReaderLocaleEventListener indexCardReaderLocaleEventListener) {
        this.textToSpeech = new TextToSpeech(context, this);
        this.isInitialised = false;
        this.availableLanguages = new HashMap<>();
        this.indexCardReaderLocaleEventListener = indexCardReaderLocaleEventListener;
    }

    @Override
    public void onInit(int i) {
        this.isInitialised = true;
        Set<Locale> locales = textToSpeech.getAvailableLanguages();
        for (Locale locale : locales) {
            availableLanguages.put(locale.toString(), locale);
        }
        if (indexCardReaderLocaleEventListener != null)
            indexCardReaderLocaleEventListener.newLocalesAvailable();
    }

    public List<Locale> getAvailableLanguages() {
        return new ArrayList<>(availableLanguages.values());
    }

    @Nullable
    public Locale getLocale(String displayName) {
        return availableLanguages.get(displayName);
    }

    public Locale getDefaultLocale(Locale locale) {
        for (Locale language : availableLanguages.values()) {
            if (language.toString().equals(locale.toString())) {
                return language;
            }
        }
        return getLocale("eng_USA");
    }

    public void speak(Locale locale, String text) {
        try {
            if (isInitialised) {
                textToSpeech.setLanguage(locale);
                textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null, null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
