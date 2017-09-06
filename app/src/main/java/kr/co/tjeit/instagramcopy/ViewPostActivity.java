package kr.co.tjeit.instagramcopy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import kr.co.tjeit.instagramcopy.data.PostingData;
import kr.co.tjeit.instagramcopy.data.ReplyData;

public class ViewPostActivity extends BaseActivity {

    private android.widget.ImageView backBtn;
    private android.widget.ImageView refreshBtn;
    private android.widget.ImageView replyBtnImg;
    private android.widget.TextView showReplyBtnTxt;
    private PostingData mPostingDataData = null;
    private TextView writerNickNameTxt;
    private TextView postingContentTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_post);

        mPostingDataData = (PostingData) getIntent().getSerializableExtra("포스팅데이터");
        bindViews();
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {
        View.OnClickListener replyListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, ReplyListActivity.class);
                intent.putExtra("댓글데이터", (ArrayList<ReplyData>)mPostingDataData.getReplies());
                startActivity(intent);
            }
        };

        replyBtnImg.setOnClickListener(replyListener);

        showReplyBtnTxt.setOnClickListener(replyListener);


        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        refreshBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "댓글들을 새로 읽어옵니다.", Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public void setValues() {
        writerNickNameTxt.setText(mPostingDataData.getWriterData().getNickName());
        postingContentTxt.setText(mPostingDataData.getContent());
    }

    @Override
    public void bindViews() {
        this.showReplyBtnTxt = (TextView) findViewById(R.id.showReplyBtnTxt);
        this.postingContentTxt = (TextView) findViewById(R.id.postingContentTxt);
        this.replyBtnImg = (ImageView) findViewById(R.id.replyBtnImg);
        this.writerNickNameTxt = (TextView) findViewById(R.id.writerNickNameTxt);
        this.refreshBtn = (ImageView) findViewById(R.id.refreshBtn);
        this.backBtn = (ImageView) findViewById(R.id.backBtn);
    }
}
