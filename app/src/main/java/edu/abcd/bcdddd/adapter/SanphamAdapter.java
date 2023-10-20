package edu.abcd.bcdddd.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import edu.abcd.bcdddd.R;
import edu.abcd.bcdddd.activity.ChitietSanpham;
import edu.abcd.bcdddd.model.SanPham;

public class SanphamAdapter extends RecyclerView.Adapter<SanphamAdapter.ViewHolder> {
    private Context context;
    private List<SanPham> list;

    public SanphamAdapter(Context context, List<SanPham> list) {
        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_hotsale, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        SanPham sanPham = list.get(position);
        Glide.with(context).load(list.get(position).getImagePro()).into(holder.image_hotsale);
        holder.ten_hotsale.setText(sanPham.getTensanpham());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ChitietSanpham.class);
                intent.putExtra("chitietsanpham",list.get(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image_hotsale;
        TextView ten_hotsale, gia_hotsale;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image_hotsale = itemView.findViewById(R.id.image_hotsale);
            ten_hotsale = itemView.findViewById(R.id.ten_hotsale);
            gia_hotsale = itemView.findViewById(R.id.gia_hotsale);
        }
    }
}
