package markus.wieland.indexcards;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;

import markus.wieland.defaultappelements.uielements.adapter.DefaultAdapter;
import markus.wieland.defaultappelements.uielements.adapter.DefaultViewHolder;
import markus.wieland.defaultappelements.uielements.adapter.iteractlistener.OnItemInteractListener;

public class IndexCardAdapter extends DefaultAdapter<IndexCard, IndexCardAdapter.IndexCardViewHolder> {

    public IndexCardAdapter(OnItemInteractListener<IndexCard> onItemInteractListener) {
        super(onItemInteractListener);
    }

    @NonNull
    @Override
    public IndexCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_index_card, parent, false);
        return new IndexCardAdapter.IndexCardViewHolder(view);
    }

    @Override
    public IndexCardInteractListener getOnItemInteractListener() {
        return (IndexCardInteractListener) super.getOnItemInteractListener();
    }

    public class IndexCardViewHolder extends DefaultViewHolder<IndexCard> {

        private LinearLayout itemIndexCardRating;
        private TextView itemIndexCardTerm;
        private TextView itemIndexCardDescription;
        private ImageButton itemIndexCardManage;

        public IndexCardViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        @Override
        public void bindViews() {
            itemIndexCardTerm = findViewById(R.id.item_index_card_term);
            itemIndexCardDescription = findViewById(R.id.item_index_card_description);
            itemIndexCardRating = findViewById(R.id.item_index_card_rating);
            itemIndexCardManage = findViewById(R.id.item_index_card_manage);
        }

        @Override
        public void bindItemToViewHolder(IndexCard indexCard) {
            itemView.setOnClickListener(view -> getOnItemInteractListener().onClick(indexCard));
            itemView.setOnCreateContextMenuListener(new OnCreateContextMenuListener(indexCard));
            itemIndexCardTerm.setText(indexCard.getTerm());
            itemIndexCardDescription.setText(indexCard.getDefinition());
            itemIndexCardRating.setBackgroundColor(indexCard.getColor());
            itemIndexCardManage.setOnClickListener(v -> itemView.showContextMenu());
        }
    }

    private class OnCreateContextMenuListener implements View.OnCreateContextMenuListener {

        private final IndexCard indexCard;

        public OnCreateContextMenuListener(IndexCard indexCard) {
            this.indexCard = indexCard;
        }

        @Override
        public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
            contextMenu.add(0, 1, 0, R.string.default_edit).setOnMenuItemClickListener(menuItem -> {
                getOnItemInteractListener().onEdit(indexCard);
                return true;
            });
            contextMenu.add(0, 1, 0, R.string.default_delete).setOnMenuItemClickListener(menuItem -> {
                getOnItemInteractListener().onDelete(indexCard);
                return true;
            });
        }
    }
}
