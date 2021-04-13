package markus.wieland.indexcards.practice;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import markus.wieland.indexcards.IndexCard;
import markus.wieland.indexcards.R;

public class PracticeIndexCardView extends FrameLayout implements View.OnClickListener, View.OnTouchListener {

    private boolean isBackVisible;

    private AnimatorSet mSetRightOut;
    private AnimatorSet mSetLeftIn;

    private TextView textViewForeground;
    private ImageView imageViewForeground;

    private TextView textViewBackground;
    private ImageView imageViewBackground;

    private ConstraintLayout constraintLayoutBackground;
    private ConstraintLayout constraintLayoutForeground;

    public PracticeIndexCardView(@NonNull Context context) {
        this(context, null);
    }

    public PracticeIndexCardView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PracticeIndexCardView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    private void init() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.view_index_card, this, true);

        constraintLayoutBackground = findViewById(R.id.item_card_background);
        constraintLayoutForeground = findViewById(R.id.item_card_foreground);

        textViewForeground = constraintLayoutForeground.findViewById(R.id.item_index_card_text);
        imageViewForeground = constraintLayoutForeground.findViewById(R.id.item_index_card_image);

        textViewBackground = constraintLayoutBackground.findViewById(R.id.item_index_card_text);
        imageViewBackground = constraintLayoutBackground.findViewById(R.id.item_index_card_image);

        mSetRightOut = (AnimatorSet) AnimatorInflater.loadAnimator(getContext(), R.animator.card_flip_out_animation);
        mSetLeftIn = (AnimatorSet) AnimatorInflater.loadAnimator(getContext(), R.animator.card_flip_in_animation);

        int distance = 8000;
        float scale = getResources().getDisplayMetrics().density * distance;
        constraintLayoutBackground.setCameraDistance(scale);
        constraintLayoutForeground.setCameraDistance(scale);

        constraintLayoutForeground.findViewById(R.id.scrollView).setOnTouchListener(this);
        constraintLayoutBackground.findViewById(R.id.scrollView).setOnTouchListener(this);

        isBackVisible = false;

        view.setOnClickListener(this);
    }

    public void load(IndexCard indexCard, boolean switchSides) {
        textViewBackground.setText(switchSides ? indexCard.getTerm() : indexCard.getDefinition());
        textViewForeground.setText(switchSides ? indexCard.getDefinition() : indexCard.getTerm());
    }

    @Override
    public void onClick(View view) {
        flip();
    }

    private void flip() {
        if (!isBackVisible) {
            mSetRightOut.setTarget(constraintLayoutForeground);
            mSetLeftIn.setTarget(constraintLayoutBackground);
        } else {
            mSetRightOut.setTarget(constraintLayoutBackground);
            mSetLeftIn.setTarget(constraintLayoutForeground);
        }
        mSetRightOut.start();
        mSetLeftIn.start();
        isBackVisible = !isBackVisible;
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == MotionEvent.ACTION_UP)
            flip();
        return false;
    }
}
