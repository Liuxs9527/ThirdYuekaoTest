package com.example.administrator.thirdyuekaotest.ui.activity;

import android.Manifest;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.administrator.thirdyuekaotest.R;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SecondActivity extends AppCompatActivity {

    @BindView(R.id.btn_dl)
    Button btnDl;
    @BindView(R.id.btn_qq)
    ImageView btnQq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ButterKnife.bind(this);

        if (Build.VERSION.SDK_INT >= 23) {
            String[] mPermissionList = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.CALL_PHONE, Manifest.permission.READ_LOGS, Manifest.permission.READ_PHONE_STATE, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.SET_DEBUG_APP, Manifest.permission.SYSTEM_ALERT_WINDOW, Manifest.permission.GET_ACCOUNTS, Manifest.permission.WRITE_APN_SETTINGS};
            ActivityCompat.requestPermissions(this, mPermissionList, 123);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }

    UMAuthListener authListener = new UMAuthListener() {

        @Override
        public void onStart(SHARE_MEDIA platform) {

        }

        @Override
        public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {

            String uid = data.get("uid");
            String name = data.get("name");
            String gender = data.get("gender");
            String iconurl = data.get("iconurl");
            Toast.makeText(SecondActivity.this, "uid:" + uid + "……name:" + name + "……gender:" + gender + "……iconurl:" + iconurl, Toast.LENGTH_SHORT).show();
            Log.e("MainActivity", "uid:" + uid + "……name:" + name + "……gender:" + gender + "……iconurl:" + iconurl);



        }

        @Override
        public void onError(SHARE_MEDIA platform, int action, Throwable t) {
            Toast.makeText(SecondActivity.this, "失败：" + t.getMessage(), Toast.LENGTH_LONG).show();
        }

        @Override
        public void onCancel(SHARE_MEDIA platform, int action) {
            Toast.makeText(SecondActivity.this, "取消了", Toast.LENGTH_LONG).show();
        }
    };


    @OnClick({R.id.btn_qq, R.id.btn_dl})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_qq:
                UMShareAPI umShareAPI = UMShareAPI.get(this);
                //切记平台切换
                umShareAPI.getPlatformInfo(SecondActivity.this, SHARE_MEDIA.QQ, authListener);
                break;
            case R.id.btn_dl:
                Intent intent = new Intent(SecondActivity.this, CategoryActivity.class);
                startActivity(intent);
                break;
        }
    }
}
