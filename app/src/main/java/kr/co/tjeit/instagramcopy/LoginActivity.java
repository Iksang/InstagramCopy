package kr.co.tjeit.instagramcopy;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import kr.co.tjeit.instagramcopy.Util.ContextUtil;
import kr.co.tjeit.instagramcopy.data.UserData;

public class LoginActivity extends BaseActivity {

    private android.widget.Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        bindViews();
        setupEvents();
        setValues();

    }

    @Override
    public void setupEvents() {
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserData myData = new UserData(542, "아이유","iu","아이유사진경로");

                // ContextUtil을 이용해서 저장.
                ContextUtil.setLoginUser(mContext, myData);

            }
        });

    }

    @Override
    public void setValues() {

    }

    @Override
    public void bindViews() {
        this.loginBtn = (Button) findViewById(R.id.loginBtn);

    }
}
