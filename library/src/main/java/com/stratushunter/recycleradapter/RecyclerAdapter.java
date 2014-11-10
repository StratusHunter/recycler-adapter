package com.stratushunter.recycleradapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by Terence Baker on 07/11/14.
 */
public class RecyclerAdapter<Model, Holder extends RecyclerAdapter.RecyclerViewHolder<Model>> extends RecyclerView.Adapter<Holder> {

    private OnRecyclerViewItemClickListener<Model> mItemClickListener;
    private ArrayList<Model> mList = new ArrayList<Model>();
    private ViewHolderFactory<Holder> mHolderFactory;

    public RecyclerAdapter(ViewHolderFactory<Holder> holderFactory, OnRecyclerViewItemClickListener<Model> itemClickListener) {

        mHolderFactory = holderFactory;
        mItemClickListener = itemClickListener;
    }

    public void setModelList(final ArrayList<Model> modelList) {

        mList.clear();
        mList.addAll(modelList);
        notifyDataSetChanged();
    }

    public ArrayList<Model> getModelList() {

        return mList;
    }

    @Override
    public int getItemCount() {

        return mList.size();
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        v.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (mItemClickListener != null) {

                    Model model = (Model) v.getTag();
                    mItemClickListener.onItemClick(v, model);
                }
            }
        });

        return mHolderFactory.create(v);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {

        Model model = mList.get(position);
        holder.setupWithModel(model);
        holder.itemView.setTag(model);
    }

    @Override
    public int getItemViewType(int position) {

        return mHolderFactory.getLayoutRes();
    }

    public static interface OnRecyclerViewItemClickListener<Model> {

        public void onItemClick(View view, Model model);
    }

    public static abstract class RecyclerViewHolder<Model> extends RecyclerView.ViewHolder {

        public RecyclerViewHolder(View itemView) {

            super(itemView);
        }

        public abstract void setupWithModel(Model model);
    }

    public static interface ViewHolderFactory<Holder extends RecyclerView.ViewHolder> {

        public Holder create(View itemView);

        public int getLayoutRes();
    }
}
