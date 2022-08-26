package com.example.grabit;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.grabit.databinding.ActivitySettingAccountBinding;
import com.example.grabit.databinding.ActivitySettingBinding;
import com.google.android.material.navigation.NavigationView;

import java.io.IOException;

public class SettingAccountActivity extends AppCompatActivity {
    private ActivitySettingAccountBinding binding;
    private ImageView imageView;
    private Uri uri;
    private Bitmap bitmap;
    private ActivityResultLauncher<Intent> resultLauncher;
    private Button changeBtn;
    private Button completeBtn;
    private EditText nicknameEtxt;
    private EditText emailEtxt;
    private EditText passwordEtxt;
    private Button leaveBtn;
    private Button joinBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySettingAccountBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        imageView = binding.imgProfile;
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                resultLauncher.launch(intent);
            }
        });

        resultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == RESULT_OK) {
                                uri = result.getData().getData();
                                try {
                                    bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(),uri);
                                    imageView.setImageBitmap(bitmap);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                        }
                    }
                });

        nicknameEtxt = binding.etxtNickname;
        emailEtxt = binding.etxtEmail;
        passwordEtxt = binding.etxtPassword;
        changeBtn = binding.btnChange;
        completeBtn = binding.btnComplete;
        leaveBtn = binding.btnLeave;
        joinBtn = binding.btnJoin;

        nicknameEtxt.setClickable(false);
        nicknameEtxt.setFocusable(false);
        emailEtxt.setClickable(false);
        emailEtxt.setFocusable(false);
        passwordEtxt.setClickable(false);
        passwordEtxt.setFocusable(false);

        changeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nicknameEtxt.setFocusableInTouchMode (true);
                nicknameEtxt.setFocusable(true);
                emailEtxt.setFocusableInTouchMode (true);
                emailEtxt.setFocusable(true);
                passwordEtxt.setFocusableInTouchMode (true);
                passwordEtxt.setFocusable(true);
            }
        });

        completeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nicknameEtxt.setFocusableInTouchMode (false);
                nicknameEtxt.setFocusable(false);
                emailEtxt.setFocusableInTouchMode (false);
                emailEtxt.setFocusable(false);
                passwordEtxt.setFocusableInTouchMode (false);
                passwordEtxt.setFocusable(false);
            }
        });

        leaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder oDialog = new AlertDialog.Builder(SettingAccountActivity.this);
                oDialog.setMessage("탈퇴하시겠습니까?")
                        .setTitle("계정 탈퇴")
                        .setPositiveButton("아니오", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Log.i("Dialog", "취소");
                                Toast.makeText(getApplicationContext(), "취소", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNeutralButton("예", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(getApplicationContext(), "탈퇴", Toast.LENGTH_SHORT).show();
                            }
                        })

                        .show();

            }
        });

        joinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder oDialog = new AlertDialog.Builder(SettingAccountActivity.this);
                oDialog.setMessage("회원가입하시겠습니까?")
                        .setTitle("회원가입")
                        .setPositiveButton("아니오", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Log.i("Dialog", "취소");
                                Toast.makeText(getApplicationContext(), "취소", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNeutralButton("예", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(getApplicationContext(), "회원가입", Toast.LENGTH_SHORT).show();
                            }
                        })

                        .show();

            }
        });
    }
}