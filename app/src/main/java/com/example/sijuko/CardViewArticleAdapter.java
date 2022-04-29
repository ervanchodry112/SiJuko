package com.example.sijuko;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sijuko.databinding.ArticleViewBinding;

import java.util.ArrayList;
import java.util.List;

public class CardViewArticleAdapter extends RecyclerView.Adapter<CardViewArticleAdapter.CardViewViewHolder> {
    private ArrayList<Article> articleList;
    private Context context;
    private ArticleViewBinding binding;

    public ArrayList<Article> getArticleList() {
        return articleList;
    }

    public void setArticleList(ArrayList<Article> articleList) {
        this.articleList = articleList;
    }

    public CardViewArticleAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.article_view, parent, false);
        CardViewViewHolder viewHolder = new CardViewViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewViewHolder holder, int position) {
        Article article = getArticleList().get(position);
        holder.date.setText(article.getDate());
        holder.judul.setText(article.getJudul());
        holder.author.setText(article.getAuthor());
    }

    @Override
    public int getItemCount() {
        return getArticleList().size();
    }

    public class CardViewViewHolder extends RecyclerView.ViewHolder{
        TextView date, judul, author;

        public CardViewViewHolder(@NonNull View itemView) {
            super(itemView);
            date = (TextView) itemView.findViewById(R.id.date_article);
            judul = (TextView) itemView.findViewById(R.id.judul_article);
            author = (TextView) itemView.findViewById(R.id.author);
        }
    }
}
