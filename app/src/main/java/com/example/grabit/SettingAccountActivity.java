package com.example.grabit;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
    }
}