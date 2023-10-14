package edu.abcd.bcdddd.admin;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import edu.abcd.bcdddd.R;
import edu.abcd.bcdddd.adapter.AdminSanPhamAdapter;
import edu.abcd.bcdddd.model.Admin_Sanpham;

public class DanhSachSanPham extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference reference;
    List<Admin_Sanpham> list;
    AdminSanPhamAdapter adapter;
    RecyclerView rcv_adminsanpham;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_sach_san_pham);

        rcv_adminsanpham = findViewById(R.id.rcv_danhsachsanpham);
        rcv_adminsanpham.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        list = new ArrayList<>();
        database = FirebaseDatabase.getInstance();
        reference = database.getReference("SanPham");
        adapter = new AdminSanPhamAdapter(this, list);
        rcv_adminsanpham.setAdapter(adapter);
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    Admin_Sanpham sanPham = dataSnapshot.getValue(Admin_Sanpham.class);
                    list.add(sanPham);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}