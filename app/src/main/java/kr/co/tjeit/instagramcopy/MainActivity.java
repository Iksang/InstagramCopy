package kr.co.tjeit.instagramcopy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import kr.co.tjeit.instagramcopy.Util.ContextUtil;
import kr.co.tjeit.instagramcopy.Util.GlobalData;
import kr.co.tjeit.instagramcopy.adapter.NewsfeedAdapter;
import kr.co.tjeit.instagramcopy.adapter.NotificationAdapter;

public class MainActivity extends BaseActivity {

    private android.widget.Button logoutBtn;
    private android.widget.ImageView tabBtn1;
    private ImageView tabBtn2;
    private ImageView tabBtn3;
    private ImageView tabBtn4;
    private ImageView tabBtn5;
    private android.widget.ListView newsfeedListView;
    private android.widget.LinearLayout newsfeedLayout;
    private NewsfeedAdapter mNewsfeedAdapter;
    private ImageView titleImg;
    private android.widget.TextView profileNickNameTxt;
    private ImageView settingBtnImg;
    private ListView myPostListView;
    private LinearLayout myProfileLayout;
    private ListView notificationListView;
    private LinearLayout notificationLayout;
    private NotificationAdapter mNotificationAdapter;
    private TextView notificationTitleTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        bindViews();
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {

        View.OnClickListener setImageSetListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.tabBtn1) {
                    titleImg.setVisibility(View.VISIBLE);
                    profileNickNameTxt.setVisibility(View.INVISIBLE);
                    settingBtnImg.setVisibility(View.INVISIBLE);
                    notificationTitleTxt.setVisibility(View.INVISIBLE);

                    newsfeedLayout.setVisibility(View.VISIBLE);
                    myProfileLayout.setVisibility(View.INVISIBLE);
                    notificationLayout.setVisibility(View.INVISIBLE);


                    tabBtn1.setImageResource(R.drawable.home_fill);
                    tabBtn2.setImageResource(R.drawable.home_empty);
                    tabBtn3.setImageResource(R.drawable.home_empty);
                    tabBtn4.setImageResource(R.drawable.home_empty);
                    tabBtn5.setImageResource(R.drawable.home_empty);

                } else if (v.getId() == R.id.tabBtn2) {
                    titleImg.setVisibility(View.VISIBLE);
                    profileNickNameTxt.setVisibility(View.INVISIBLE);
                    settingBtnImg.setVisibility(View.INVISIBLE);
                    notificationTitleTxt.setVisibility(View.INVISIBLE);

                    newsfeedLayout.setVisibility(View.GONE);
                    myProfileLayout.setVisibility(View.INVISIBLE);
                    notificationLayout.setVisibility(View.INVISIBLE);

                    tabBtn1.setImageResource(R.drawable.home_empty);
                    tabBtn2.setImageResource(R.drawable.home_fill);
                    tabBtn3.setImageResource(R.drawable.home_empty);
                    tabBtn4.setImageResource(R.drawable.home_empty);
                    tabBtn5.setImageResource(R.drawable.home_empty);
                } else if (v.getId() == R.id.tabBtn3) {

                    titleImg.setVisibility(View.VISIBLE);
                    profileNickNameTxt.setVisibility(View.INVISIBLE);
                    settingBtnImg.setVisibility(View.INVISIBLE);
                    notificationTitleTxt.setVisibility(View.INVISIBLE);

                    newsfeedLayout.setVisibility(View.GONE);
                    myProfileLayout.setVisibility(View.INVISIBLE);
                    notificationLayout.setVisibility(View.INVISIBLE);

                    tabBtn1.setImageResource(R.drawable.home_empty);
                    tabBtn2.setImageResource(R.drawable.home_empty);
                    tabBtn3.setImageResource(R.drawable.home_fill);
                    tabBtn4.setImageResource(R.drawable.home_empty);
                    tabBtn5.setImageResource(R.drawable.home_empty);
                } else if (v.getId() == R.id.tabBtn4) {
                    titleImg.setVisibility(View.INVISIBLE);
                    profileNickNameTxt.setVisibility(View.INVISIBLE);
                    settingBtnImg.setVisibility(View.INVISIBLE);
                    notificationTitleTxt.setVisibility(View.VISIBLE);

                    newsfeedLayout.setVisibility(View.GONE);
                    myProfileLayout.setVisibility(View.INVISIBLE);
                    notificationLayout.setVisibility(View.VISIBLE);

                    tabBtn1.setImageResource(R.drawable.home_empty);
                    tabBtn2.setImageResource(R.drawable.home_empty);
                    tabBtn3.setImageResource(R.drawable.home_empty);
                    tabBtn4.setImageResource(R.drawable.home_fill);
                    tabBtn5.setImageResource(R.drawable.home_empty);
                } else if (v.getId() == R.id.tabBtn5) {
                    titleImg.setVisibility(View.INVISIBLE);
                    profileNickNameTxt.setVisibility(View.VISIBLE);
                    settingBtnImg.setVisibility(View.VISIBLE);
                    notificationTitleTxt.setVisibility(View.INVISIBLE);

                    newsfeedLayout.setVisibility(View.GONE);
                    myProfileLayout.setVisibility(View.VISIBLE);
                    notificationLayout.setVisibility(View.INVISIBLE);

                    tabBtn1.setImageResource(R.drawable.home_empty);
                    tabBtn2.setImageResource(R.drawable.home_empty);
                    tabBtn3.setImageResource(R.drawable.home_empty);
                    tabBtn4.setImageResource(R.drawable.home_empty);
                    tabBtn5.setImageResource(R.drawable.home_fill);
                }
            }
        };

        tabBtn1.setOnClickListener(setImageSetListener);
        tabBtn2.setOnClickListener(setImageSetListener);
        tabBtn3.setOnClickListener(setImageSetListener);
        tabBtn4.setOnClickListener(setImageSetListener);
        tabBtn5.setOnClickListener(setImageSetListener);

        newsfeedListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(mContext, ViewPostActivity.class);
                intent.putExtra("포스팅데이터",GlobalData.postingDataList.get(position));
                startActivity(intent);
            }
        });



        notificationListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(mContext, ViewPostActivity.class);
                intent.putExtra("포스팅데이터",GlobalData.myNotiDataList.get(position).getPost());
                startActivity(intent);
            }
        });




        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 로그아웃 기능을 구현
                // 로그인 처리를 ContextUtil => pref.edit => 데이터 세팅.
                // 로그아웃도 ContextUtil => pref.edit => 데이터 세팅.

                ContextUtil.loggoutProcess(mContext);
                Intent intent = new Intent(mContext, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    @Override
    public void setValues() {
        mNewsfeedAdapter = new NewsfeedAdapter(mContext, GlobalData.postingDataList);
        newsfeedListView.setAdapter(mNewsfeedAdapter);

        mNotificationAdapter = new NotificationAdapter(mContext, GlobalData.myNotiDataList);
        notificationListView.setAdapter(mNotificationAdapter);

    }

    @Override
    public void bindViews() {
        this.tabBtn5 = (ImageView) findViewById(R.id.tabBtn5);
        this.tabBtn4 = (ImageView) findViewById(R.id.tabBtn4);
        this.tabBtn3 = (ImageView) findViewById(R.id.tabBtn3);
        this.tabBtn2 = (ImageView) findViewById(R.id.tabBtn2);
        this.tabBtn1 = (ImageView) findViewById(R.id.tabBtn1);
        this.myProfileLayout = (LinearLayout) findViewById(R.id.myProfileLayout);
        this.myPostListView = (ListView) findViewById(R.id.myPostListView);
        this.notificationLayout = (LinearLayout) findViewById(R.id.notificationLayout);
        this.notificationListView = (ListView) findViewById(R.id.notificationListView);
        this.newsfeedLayout = (LinearLayout) findViewById(R.id.newsfeedLayout);
        this.newsfeedListView = (ListView) findViewById(R.id.newsfeedListView);
        this.notificationTitleTxt = (TextView) findViewById(R.id.notificationTitleTxt);
        this.settingBtnImg = (ImageView) findViewById(R.id.settingBtnImg);
        this.profileNickNameTxt = (TextView) findViewById(R.id.profileNickNameTxt);
        this.titleImg = (ImageView) findViewById(R.id.titleImg);
        this.logoutBtn = (Button) findViewById(R.id.logoutBtn);

    }
}
