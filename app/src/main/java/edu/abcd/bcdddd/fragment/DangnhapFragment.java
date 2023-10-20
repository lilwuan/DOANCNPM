package edu.abcd.bcdddd.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import edu.abcd.bcdddd.R;
import edu.abcd.bcdddd.admin.AdminActivity;
import edu.abcd.bcdddd.activity.DangkyActivity;
import edu.abcd.bcdddd.activity.MainActivity;
import edu.abcd.bcdddd.model.TaiKhoan;

public class DangnhapFragment extends Fragment {
    public static TaiKhoan taiKhoan = new TaiKhoan();
    TextView tv_dangky;
    EditText edt_email, edt_pass;
    Button btn_dangnhap;
    DatabaseReference reference;
    FirebaseDatabase database;
    FirebaseAuth auth;

    public DangnhapFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_dangnhap, container, false);
        tv_dangky = v.findViewById(R.id.tv_dangky);
        tv_dangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), DangkyActivity.class));
            }
        });

        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();

        edt_email = v.findViewById(R.id.dangnhap_email);
        edt_pass = v.findViewById(R.id.dangnhap_password);
        btn_dangnhap = v.findViewById(R.id.btn_dangnhap);

        reference = database.getReference("TaiKhoan");

        btn_dangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dangnhaptaikhoan();
            }
        });

        return v;
    }

    private void dangnhaptaikhoan() {
        String email = edt_email.getText().toString();
        String pass = edt_pass.getText().toString();

        if (TextUtils.isEmpty(email)){
            Toast.makeText(getActivity(), "Vui lòng nhập email", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(pass)){
            Toast.makeText(getActivity(), "Vui lòng nhập mật khẩu", Toast.LENGTH_SHORT).show();
            return;
        }
        auth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                reference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.exists()){
                            for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                                TaiKhoan taiKhoan1 = dataSnapshot.getValue(TaiKhoan.class);
                                if (taiKhoan1.getEmail().equals(email) && taiKhoan1.getPass().equals(pass)){
                                    taiKhoan = taiKhoan1;
                                    if (taiKhoan1.getRole() == 0){
                                        startActivity(new Intent(getActivity(), MainActivity.class));
                                        Toast.makeText(getActivity(), "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                                    }else {
                                        startActivity(new Intent(getActivity(), AdminActivity.class));
                                        Toast.makeText(getActivity(), "Xin chào Admin", Toast.LENGTH_SHORT).show();
                                    }
                                    getActivity().finish();
                                    return;
                                }
                            }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });

    }
}