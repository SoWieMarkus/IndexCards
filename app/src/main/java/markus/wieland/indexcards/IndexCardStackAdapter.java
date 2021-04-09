package markus.wieland.indexcards;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;

import markus.wieland.defaultappelements.uielements.adapter.DefaultViewHolder;
import markus.wieland.defaultappelements.uielements.adapter.QueryableAdapter;
import markus.wieland.defaultappelements.uielements.adapter.iteractlistener.OnItemInteractListener;

public class IndexCardStackAdapter extends QueryableAdapter<Long, IndexCardStackWithIndexCards, IndexCardStackAdapter.IndexCardStackViewHolder> {

    public IndexCardStackAdapter(OnItemInteractListener<IndexCardStackWithIndexCards> onItemInteractListener) {
        super(onItemInteractListener);
    }

    @NonNull
    @Override
    public IndexCardStackViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_index_card_stack, parent, false);
        return new IndexCardStackViewHolder(view);
    }

    @Override
    public IndexCardStackInteractListener getOnItemInteractListener() {
        return (IndexCardStackInteractListener) onItemInteractListener;
    }

    public class IndexCardStackViewHolder extends DefaultViewHolder<IndexCardStackWithIndexCards>  {

        private ProgressBar itemIndexCardStackProgress;
        private TextView itemIndexCardStackTitle;
        private TextView itemIndexCardStackLastUse;
        private TextView itemIndexCardStackProgressTextView;
        private TextView itemIndexCardStackAmount;
        private Button itemIndexCardTest;
        private Button itemIndexCardPractice;

        public IndexCardStackViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        @Override
        public void bindViews() {
            itemIndexCardStackTitle = findViewById(R.id.item_index_card_stack_title);
            itemIndexCardStackProgress = findViewById(R.id.item_index_card_stack_progress_bar);
            itemIndexCardStackLastUse = findViewById(R.id.item_index_card_stack_last_use);
            itemIndexCardStackProgressTextView = findViewById(R.id.item_index_card_stack_progress);
            itemIndexCardTest = findViewById(R.id.item_index_card_stack_test);
            itemIndexCardPractice = findViewById(R.id.item_index_card_stack_pratice);
            itemIndexCardStackAmount = findViewById(R.id.item_index_card_stack_amount);
        }

        @Override
        public void bindItemToViewHolder(IndexCardStackWithIndexCards indexCardStackWithIndexCards) {
            itemView.setOnClickListener(view -> getOnItemInteractListener().onClick(indexCardStackWithIndexCards));
            itemView.setOnCreateContextMenuListener(new OnCreateContextMenuListener(indexCardStackWithIndexCards));

            itemIndexCardStackProgress.setMin(0);
            itemIndexCardStackProgress.setMax(indexCardStackWithIndexCards.getMaxProgress());
            itemIndexCardStackProgress.setProgress(indexCardStackWithIndexCards.getProgress());
            itemIndexCardStackProgressTextView.setText(indexCardStackWithIndexCards.getProgressAsPercentage());
            itemIndexCardStackTitle.setText(indexCardStackWithIndexCards.getIndexCardStack().getTitle());
            itemIndexCardStackLastUse.setText(indexCardStackWithIndexCards.getIndexCardStack().getLastUse());

            itemIndexCardStackAmount.setText(indexCardStackWithIndexCards.getIndexCards().size() + "");

            itemIndexCardTest.setOnClickListener(view -> getOnItemInteractListener().onTest(indexCardStackWithIndexCards));
            itemIndexCardPractice.setOnClickListener(view -> getOnItemInteractListener().onPractice(indexCardStackWithIndexCards));

        }

    }

    private class OnCreateContextMenuListener implements View.OnCreateContextMenuListener {

        private final IndexCardStackWithIndexCards indexCardStackWithIndexCards;

        public OnCreateContextMenuListener(IndexCardStackWithIndexCards indexCardStackWithIndexCards){
            this.indexCardStackWithIndexCards = indexCardStackWithIndexCards;
        }

        @Override
        public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
            contextMenu.add(0,1,0, R.string.default_edit).setOnMenuItemClickListener(menuItem -> {
                getOnItemInteractListener().onEdit(indexCardStackWithIndexCards);
                return true;
            });
            contextMenu.add(0,1,0, R.string.default_delete).setOnMenuItemClickListener(menuItem -> {
                getOnItemInteractListener().onDelete(indexCardStackWithIndexCards);
                return true;
            });
        }
    }
}
