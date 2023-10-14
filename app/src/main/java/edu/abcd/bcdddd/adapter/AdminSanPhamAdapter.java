package edu.abcd.bcdddd.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

import edu.abcd.bcdddd.R;
import edu.abcd.bcdddd.model.Admin_Sanpham;

public class AdminSanPhamAdapter extends RecyclerView.Adapter<AdminSanPhamAdapter.ViewHolder> {
    private Context context;
    private List<Admin_Sanpham> list;
    DatabaseReference reference;
    FirebaseDatabase database;

    public AdminSanPhamAdapter(Context context, List<Admin_Sanpham> list) {
        this.context = context;
        this.list = list;
        database = FirebaseDatabase.getInstance();
        reference = database.getReference("SanPham");
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sanpham, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.ten_sanpham.setText(list.get(position).getTensanpham());
        holder.delete_sanpham.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reference.getRef().removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(context, "Đã xóa sản phẩm", Toast.LENGTH_SHORT).show();
                        notifyDataSetChanged();
                    }
                });
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image_sanpham;
        TextView ten_sanpham, gia_sanpham;
        ImageView edit_sanpham, delete_sanpham;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image_sanpham = itemView.findViewById(R.id.image_sanpham);
            ten_sanpham = itemView.findViewById(R.id.ten_sanpham);
            gia_sanpham = itemView.findViewById(R.id.gia_sanpham);
            edit_sanpham = itemView.findViewById(R.id.sanpham_edit);
            delete_sanpham = itemView.findViewById(R.id.sanpham_delete);
        }
    }
}
