package com.kopmaul.sijuko.Adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.kopmaul.sijuko.Article.ArticleResponse;
import com.kopmaul.sijuko.R;
import com.kopmaul.sijuko.databinding.ArticleViewBinding;

import java.util.List;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ViewHolder> {

    private final List<ArticleResponse> list;
    private Context context;

    public ArticleAdapter(Context context, List<ArticleResponse> list) {
        this.context = context;
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
        holder.date.setText(list.get(position).getDate().toString().substring(0, 10));
        holder.title.setText(list.get(position).getTitle().getRendered());
        holder.tvId.setText(Integer.toString(list.get(position).getId()));

        holder.parentLayout.setOnClickListener(view -> {
            String url = list.get(position).getLink().toString();
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            context.startActivity(i);
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvId, date, title;
        private final CardView parentLayout;
        public ViewHolder(View view) {
            super(view);
            tvId = view.findViewById(R.id.id_article);
            date = view.findViewById(R.id.date_article);
            title = view.findViewById(R.id.judul_article);
            parentLayout = view.findViewById(R.id.parentLayout);
        }
    }
}
