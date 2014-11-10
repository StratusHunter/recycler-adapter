package com.stratushunter.sample;

import android.view.View;
import android.widget.TextView;

import com.stratushunter.recycleradapter.RecyclerAdapter;

/**
 * Created by Terence Baker on 10/11/14.
 */
public class ModelHolder extends RecyclerAdapter.RecyclerViewHolder<Model> {

    public TextView textView;

    public ModelHolder(View itemView) {

        super(itemView);
        textView = (TextView) itemView.findViewById(R.id.text_view);
    }

    @Override
    public void setupWithModel(Model model) {

        textView.setText(model.text);
    }

    public static class ModelHolderFactory implements RecyclerAdapter.ViewHolderFactory<ModelHolder> {

        @Override
        public ModelHolder create(View itemView) {

            return new ModelHolder(itemView);
        }

        @Override
        public int getLayoutRes() {

            return R.layout.cell_model;
        }
    }
}
