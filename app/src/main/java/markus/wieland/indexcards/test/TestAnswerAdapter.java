package markus.wieland.indexcards.test;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import markus.wieland.defaultappelements.uielements.adapter.DefaultAdapter;
import markus.wieland.defaultappelements.uielements.adapter.DefaultViewHolder;
import markus.wieland.indexcards.IndexCard;
import markus.wieland.indexcards.R;

public class TestAnswerAdapter extends DefaultAdapter<IndexCard, TestAnswerAdapter.TestAnswerViewHolder> {

    private final IndexCardTestLevel testLevel;

    public TestAnswerAdapter(IndexCardTestLevel testLevel, TestAnswerInteractListener testAnswerInteractListener) {
        super(testAnswerInteractListener);
        this.testLevel = testLevel;
        submitList(testLevel);
    }

    public void submitList(IndexCardTestLevel testLevel) {
        super.submitList(testLevel.getPossibleAnswers());
    }

    @NonNull
    @Override
    public TestAnswerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //TODO hier das richtige layout einstellen
        return new TestAnswerViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_index_card, parent, false));
    }

    public TestAnswerInteractListener getOnItemInteractListener() {
        return (TestAnswerInteractListener) super.getOnItemInteractListener();
    }

    public class TestAnswerViewHolder extends DefaultViewHolder<IndexCard> {

        public TestAnswerViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        @Override
        public void bindViews() {

        }

        @Override
        public void bindItemToViewHolder(IndexCard indexCard) {
            itemView.setOnClickListener(view -> onClick(indexCard));
            // TODO im Level kann man herausfinden ob der Rück under Vorderseite getauscht werden sollen

            //TODO danach ein paar sekunden warten und dann weiter oder weiter erst per Knopfdruck
        }

        private void onClick(IndexCard answerOfUser) {
            if (testLevel.isCorrect(answerOfUser))
                //TODO hier die hintergrund farbe ändern
                getOnItemInteractListener().onClick(answerOfUser, testLevel.getQuestion());
        }


    }

}
