package com.example.lab2.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lab2.R;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.prViewHolder> {
    private final List<String> items;

    public static class prViewHolder extends RecyclerView.ViewHolder {
        private final TextView item;

        private final Button btnDelete;

        public prViewHolder(View view) {
            super(view);
            item = (TextView) view.findViewById(R.id.tvItems);
            btnDelete = (Button) view.findViewById(R.id.DeleteButton);
        }

        public TextView getItem() {
            return item;
        }

        public Button getDeleteButton() {
            return btnDelete;
        }
    }

    public Adapter(List<String> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public prViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row, viewGroup, false);
        return new prViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull prViewHolder holder, int position) {
        holder.getItem().setText(items.get(position));
        holder.getDeleteButton().setOnClickListener(v -> clear(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void clear(int position) {
        items.remove(position);
        notifyDataSetChanged();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void save(String itemName, String itemNum) {
        items.add(itemName + " " + itemNum + " шт.");
        notifyDataSetChanged();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void clearAll() {
        items.clear();
        notifyDataSetChanged();
    }


}
