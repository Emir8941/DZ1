package com.example.dz1.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dz1.R;
import com.example.dz1.utils.interfaces.OnItemClickListener;
import com.example.dz1.model.Model;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {


    public List<Model> list = new ArrayList<>();
    private OnItemClickListener onClick;

    public void addList(List<Model> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public void setOnClick(OnItemClickListener onClick) {
        this.onClick = onClick;
    }

    @NonNull
    @NotNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull Adapter.MyViewHolder holder, int position) {
        holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView itemText;
        ImageView itemImg;


        public MyViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            itemImg = itemView.findViewById(R.id.item_img);
            itemText = itemView.findViewById(R.id.item_text);
            itemView.setOnClickListener(v -> {
                onClick.onClick(getAdapterPosition());
            });
        }

        private void onBind(Model s) {
            itemImg.setImageResource(s.getImg());
            itemText.setText(s.getTitle());

        }
    }
}
