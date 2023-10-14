package edu.abcd.bcdddd.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import java.util.ArrayList;
import java.util.List;
import edu.abcd.bcdddd.R;
import edu.abcd.bcdddd.adapter.SanphamAdapter;
import edu.abcd.bcdddd.model.SanPham;

public class TrangchinhFragment extends Fragment {

    ImageView imageView;

    RecyclerView rcv_hotsale;
    FirebaseDatabase database;
    FirebaseAuth auth;
    DatabaseReference reference;
    SanphamAdapter adapter;
    List<SanPham> list;

    public TrangchinhFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_trangchinh, container, false);


        rcv_hotsale = v.findViewById(R.id.rcv_hotsale);
        rcv_hotsale.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
        list = new ArrayList<>();
        database = FirebaseDatabase.getInstance();
        reference = database.getReference("SanPham");
        adapter = new SanphamAdapter(getActivity(),list);
        rcv_hotsale.setAdapter(adapter);

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    SanPham sanPham = dataSnapshot.getValue(SanPham.class);
                    list.add(sanPham);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        return v;
    }
}