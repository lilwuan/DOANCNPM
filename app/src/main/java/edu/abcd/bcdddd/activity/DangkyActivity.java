package edu.abcd.bcdddd.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import edu.abcd.bcdddd.R;
import edu.abcd.bcdddd.model.TaiKhoan;

public class DangkyActivity extends AppCompatActivity {

    private EditText edt_email, edt_pass, edt_diachi, edt_name, edt_phone;
    FirebaseAuth auth;
    FirebaseDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangky);

        edt_email = findViewById(R.id.dangki_email);
        edt_pass = findViewById(R.id.dangki_password);
        edt_diachi = findViewById(R.id.dangki_address);
        edt_name = findViewById(R.id.dangki_name);
        edt_phone = findViewById(R.id.dangki_phone);

        database = FirebaseDatabase.getInstance();
        auth = FirebaseAuth.getInstance();

        Button btn_dangky = findViewById(R.id.btn_dangky);
        btn_dangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dangkytaikhoan();
            }
        });
    }

    private void dangkytaikhoan() {
        String email = edt_email.getText().toString();
        String pass = edt_pass.getText().toString();
        String diachi = edt_diachi.getText().toString();
        String name = edt_name.getText().toString();
        String phone = edt_phone.getText().toString();

        if(TextUtils.isEmpty(email)){
            Toast.makeText(this, "Email không được bỏ trống", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(pass)){
            Toast.makeText(this, "Mật khẩu không được bỏ trống", Toast.LENGTH_SHORT).show();
            return;
        }
        if (pass.length() < 6){
            Toast.makeText(this, "Mật khẩu phải từ 6 ký tự trở lên", Toast.LENGTH_SHORT).show();
            return;
        }
        auth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    TaiKhoan taiKhoan1 = new TaiKhoan(email,pass,diachi,name,phone);
                    String id = task.getResult().getUser().getUid();
                    database.getReference().child("TaiKhoan").child(id).setValue(taiKhoan1);
                    Toast.makeText(DangkyActivity.this, "Đăng ký thành công", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(DangkyActivity.this, "Đăng ký thất bại", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}