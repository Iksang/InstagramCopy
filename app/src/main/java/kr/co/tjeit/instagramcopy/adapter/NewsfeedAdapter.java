package kr.co.tjeit.instagramcopy.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import kr.co.tjeit.instagramcopy.R;
import kr.co.tjeit.instagramcopy.ReplyListActivity;
import kr.co.tjeit.instagramcopy.data.PostingData;
import kr.co.tjeit.instagramcopy.data.ReplyData;

/**
 * Created by tjoeun on 2017-08-17.
 */

public class NewsfeedAdapter extends ArrayAdapter<PostingData> {
    private Context mContext;
    private List<PostingData> mList;
    private LayoutInflater inf;

    public NewsfeedAdapter(Context context, List<PostingData> list){

        super(context, R.layout.newsfeed_item_list, list);
        mContext = context;
        mList = list;
        inf = LayoutInflater.from(mContext);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;
        if(row==null){
            row = inf.inflate(R.layout.newsfeed_item_list, null);
        }

//        (1) 데이터를 찍어주려면, 일단 데이터를 가져오기 부터.
//        가져온다 : mList => get으로 빼내자. 몇번째를? position이 알려줌
//        빼낼때 변수로 저장. 변수 형태 : 어댑터에서 다루는 자료형.

        final PostingData data = mList.get(position);

//        (2) 자료를 빼낸 후에 반영할 뷰 들을 바인딩.
//        바인딩 : findViewById로 묶어주는 행동.

        TextView writerNickNameTxt = (TextView)row.findViewById(R.id.writerNickNameTxt);
        TextView postingContentTxt = (TextView)row.findViewById(R.id.postingContentTxt);
        ImageView replyBtnImg = (ImageView)row.findViewById(R.id.replyBtnImg);

//        (3) 표시할 데이터 세팅.
//        1. TextView에게 setText
//        2. ImageView Glide활용해서 이미지 세팅 (이번 예제에서는 이미지 X)

//        게시글의 내용을 작성
        postingContentTxt.setText(data.getContent());

//        게시글의 작성자의 닉네임을 작성.
        writerNickNameTxt.setText(data.getWriterData().getNickName());

//        (4) 버튼들이 눌리면 처리할 이벤트.
        replyBtnImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, ReplyListActivity.class);
                intent.putExtra("댓글데이터", (ArrayList<ReplyData>)data.getReplies());
                mContext.startActivity(intent);
            }
        });




        return row;
    }
}
