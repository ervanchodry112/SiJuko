package com.kopmaul.sijuko;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kopmaul.sijuko.databinding.ArticleViewBinding;
import com.kopmaul.sijuko.databinding.HistoryViewBinding;

import java.util.ArrayList;

public class CardViewTransactionsAdapter extends
        RecyclerView.Adapter<CardViewTransactionsAdapter.CardViewViewHolder> {

    private ArrayList<Transaction> transactionsList;
    private Context context;
    private HistoryViewBinding binding;

    public ArrayList<Transaction> getTransactionsList() {
        return transactionsList;
    }

    public void setTransactionsList(ArrayList<Transaction> transactionsList) {
        this.transactionsList = transactionsList;
    }

    public CardViewTransactionsAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.history_view, parent, false);
        CardViewTransactionsAdapter.CardViewViewHolder viewHolder = new CardViewTransactionsAdapter.CardViewViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewViewHolder holder, int position) {
        Transaction transaction = getTransactionsList().get(position);
        holder.date.setText(transaction.getDate());
        holder.name.setText(transaction.getName());
        holder.nominal.setText(transaction.getNominal());
    }

    @Override
    public int getItemCount() {
        return getTransactionsList().size();
    }

    public class CardViewViewHolder extends RecyclerView.ViewHolder{
        TextView date, name, nominal;

        public CardViewViewHolder(@NonNull View itemView) {
            super(itemView);
            date = (TextView) itemView.findViewById(R.id.date_history);
            name = (TextView) itemView.findViewById(R.id.nama_transaksi);
            nominal = (TextView) itemView.findViewById(R.id.nominal_transaksi);
        }
    }
}
