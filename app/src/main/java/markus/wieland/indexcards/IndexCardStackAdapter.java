package markus.wieland.indexcards;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

    public static class IndexCardStackViewHolder extends DefaultViewHolder<IndexCardStackWithIndexCards> {
        public IndexCardStackViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        @Override
        public void bindViews() {

        }

        @Override
        public void bindItemToViewHolder(IndexCardStackWithIndexCards indexCardStackWithIndexCards) {

        }
    }
}
