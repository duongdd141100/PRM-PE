package com.example.prm392m2_he140609.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.prm392m2_he140609.R;
import com.example.prm392m2_he140609.entity.Room;

import java.util.List;

public class RoomAdapter extends RecyclerView.Adapter<RoomAdapter.RoomViewHolder> {
    public RoomAdapter(List<Room> rooms, Context context) {
        this.rooms = rooms;
        this.context = context;
    }

    private List<Room> rooms;

    private Context context;
    @NonNull
    @Override
    public RoomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.room_item, parent, false);
        return new RoomViewHolder(view, this);
    }

    @Override
    public void onBindViewHolder(@NonNull RoomViewHolder holder, int position) {
        holder.tvId.setText(rooms.get(position).getId().toString());
        holder.tvRoomNo.setText(rooms.get(position).getRoomNo());
        holder.tvGuestName.setText(rooms.get(position).getGuestName());
        holder.tvType.setText(rooms.get(position).getType());
        holder.tvPrice.setText(rooms.get(position).getPrice().toString());
    }

    @Override
    public int getItemCount() {
        return rooms.size();
    }

    protected class RoomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView tvId;
        private TextView tvRoomNo;
        private TextView tvGuestName;
        private TextView tvType;
        private TextView tvPrice;
        private RoomAdapter adapter;
        public RoomViewHolder(@NonNull View itemView, RoomAdapter adapter) {
            super(itemView);
            this.adapter = adapter;
            this.tvId = itemView.findViewById(R.id.tv_id);
            this.tvRoomNo = itemView.findViewById(R.id.tv_room_no);
            this.tvGuestName = itemView.findViewById(R.id.tv_guest_name);
            this.tvType = itemView.findViewById(R.id.tv_type);
            this.tvPrice = itemView.findViewById(R.id.tv_price);
        }

        @Override
        public void onClick(View v) {
        }
    }
}
