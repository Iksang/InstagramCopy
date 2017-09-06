package kr.co.tjeit.instagramcopy;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import kr.co.tjeit.instagramcopy.Util.ContextUtil;
import kr.co.tjeit.instagramcopy.Util.GlobalData;
import kr.co.tjeit.instagramcopy.data.UserData;

public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        bindViews();
        setupEvents();
        setValues();

//        UserData loginUserData = ContextUtil.getUserData(mContext);
//        Log.d("로그인한사람의 ID", loginUserData.getUserId()+"");
//        Log.d("로그인 유저의 이름", loginUserData.getName()+"");
    }

    @Override
    public void setupEvents() {
//        1. 스플래시 액티비티가 나타난지 2초가 지나면 메인액티비티로 넘어가게.
//        2. 만약 로그인을 안한상태라면 로그인 액티비티로, 한 상태라면 메인 액티비티로

//        ※ 스플래시 액티비티는 다른 화면으로 넘어가면 종료.


//        코드를 찾아서 붙여넣고, 어떤 역할을 하는 코드 들인지 주석 달기.


        // 시간이 지나면 실행되게 하는 코드 : Handler, Runnable
            // Handler : 안드로이드의 쓰레드(Thread) 개념.
            // Thread : 기본 앱과 별개로 돌아가는 프로세스. -> CPU 하나 더 쓰는것과 같다.
            // Handler는 시간에 관련된 특수한 동작을 실행.
            // => 백그라운드에서 돌아가야 하는 일들 : 메인쓰레드 이외의 작업

//            1. 핸들러 변수 생성 및 객체화.
//            Handler myHandler = new Handler();

//            2. 만들어진 핸들러에게 업무 지시
//            업무를 ~~초 이후에 하도록 지시. postDelayed
//            postDelayed의 파라미터는 2개 필요.
//            1) 해야할 일 -> new Runnable
//            2) 실행 할 시간은 1/1000초 단위로. (밀리세컨드)
//            Runnable 객체의 내부에 있는 run 메쏘드에 실제로 해야할 일을 구현.
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
//                    화면을 전환하고 자신을 종료하는 코드를 작성
                    // 화면을 전환하는 코드

                    // Intent 변수를 빈 공간으로 설정.
                    // 왜? 상황에 따라 목적지가 달라질 수 있으므로.

                    // 로그인 여부를 GlobalData 클래스에게 물어봄.
                    // => 이미 사전작업이 되어잇다.
                    Intent intent;

                    UserData tempData = ContextUtil.getUserData(mContext);
                    if(tempData == null){
                        // 로그인이 안되어있는 상환
                        intent = new Intent (mContext, LoginActivity.class);
                    }
                    else{
                        intent = new Intent (mContext, MainActivity.class);
                    }

                    // 상황에 따라 만들어진 intent를 실제로 실행
                    startActivity(intent);
                    // 스플래쉬 화면을 종료
                    finish();
                }
            }, 2000);



    }

    @Override
    public void setValues() {
        GlobalData.initGlobalData();

    }

    @Override
    public void bindViews() {

    }
}
