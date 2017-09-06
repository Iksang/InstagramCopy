package kr.co.tjeit.instagramcopy;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by tjoeun on 2017-08-17.
 */

// 베이스액티비티의 생성 이유
//    1. 자주쓰는 메쏘드들을 자동완성하기 편하려고. -> 빼먹지 않으려고.
//    =>자주쓰는메쏘드가 더 생긴다면, 베이스 액티비티에 추가해주자.
//    2. --Activity.this 타이핑 스트레스. => mContext 대체.
public abstract class BaseActivity extends AppCompatActivity {
    // 클래스 선언의 유의사항
    // 1. 반드시 AppCompatActivity 상속. -> 액티비티로서 기능할 수 있도록.
    // 2. abstract 달아주자. 추상화하자. -> BaseActivity 객체화 할 일이 없다.
    // =>메쏘드들을 추상화 (abstract) 해서, 반드시 구현하게 만들려고.
    // cf. 추상화 : 상속을 받아야만 의미가 생기는 객체 / 메쏘드.
    // 메쏘드에 추상화를 하면, 부모는 내용을 갖고있지 않으므로
    // 반드시 물려받은 자식이 실제 내용을 구현해야할 의무가 생김.

    // 안드로이드의 대부분의 동적 생성 객체는
    // 파라미터로 어느화면에서 사용할건지 명시하는 경향이 있다.
    // ---Activity.this를 넣어줘야하는데, 이를 대체하는 변수가 mContext
    // 이 mContext 자료형은 Context. => ~~Activity.this == Context 역할을 한다.

    Context mContext = this;

    // 추상화 메쏘드.
    // 일반메쏘드와 다르게 중괄호 대신 세미콜론
    // 메쏘드를 선언만 하고, 구현은 하지 않은 상태.
    // 가능한 이유? BaseActivity는 추상화되된 클래스.
    // 그 내부에 있는 메쏘드도 abstract로 정의했기 때문에 가능.
    public abstract void setupEvents();
    public abstract void setValues();
    public abstract void bindViews();

}
