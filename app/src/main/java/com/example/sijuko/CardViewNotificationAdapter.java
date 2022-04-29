package com.example.sijuko;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sijuko.databinding.HistoryViewBinding;
import com.example.sijuko.databinding.NotificationViewBinding;

import java.util.ArrayList;

public class CardViewNotificationAdapter extends RecyclerView.Adapter<CardViewNotificationAdapter.CardViewViewHolder> {

    private ArrayList<Notification> notificationList;
    private Context context;
    private NotificationViewBinding binding;

    public ArrayList<Notification> getNotificationList() {
        return notificationList;
    }

    public void setNotificationList(ArrayList<Notification> notificationList) {
        this.notificationList = notificationList;
    }

    public CardViewNotificationAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.notification_view, parent, false);
        CardViewNotificationAdapter.CardViewViewHolder viewHolder = new CardViewNotificationAdapter.CardViewViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewViewHolder holder, int position) {
        Notification notification = getNotificationList().get(position);
        holder.title.setText(notification.getTitle());
        holder.description.setText(notification.getDescription());
        holder.date.setText(notification.getDate());
    }

    @Override
    public int getItemCount() {
        return getNotificationList().size();
    }

    public class CardViewViewHolder extends RecyclerView.ViewHolder{
        TextView title, description, date;

        public CardViewViewHolder(@NonNull View itemView) {
            super(itemView);
            this.title = (TextView) itemView.findViewById(R.id.judul_notif);
            this.description = (TextView) itemView.findViewById(R.id.description);
            this.date = (TextView) itemView.findViewById(R.id.date_notif);
        }
    }
}
