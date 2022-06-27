package com.example.sijuko.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sijuko.Article.ArticleResponse;
import com.example.sijuko.R;
import com.example.sijuko.databinding.ArticleViewBinding;

import java.util.ArrayList;
import java.util.List;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ViewHolder> {

    private final List<ArticleResponse> list;

    public ArticleAdapter(List<ArticleResponse> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.article_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.date.setText(list.get(position).getDate());
        holder.title.setText(list.get(position).getTitle().getRendered());
        holder.tvId.setText(Integer.toString(list.get(position).getId()));


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvId, date, title;
        public ViewHolder(View view) {
            super(view);
            tvId = view.findViewById(R.id.id_article);
            date = view.findViewById(R.id.date_article);
            title = view.findViewById(R.id.judul_article);
        }
    }
}
