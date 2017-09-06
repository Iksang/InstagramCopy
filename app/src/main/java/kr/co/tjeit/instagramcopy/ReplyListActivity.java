package kr.co.tjeit.instagramcopy;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import kr.co.tjeit.instagramcopy.adapter.ReplyListAdapter;
import kr.co.tjeit.instagramcopy.data.ReplyData;

public class ReplyListActivity extends BaseActivity {

    private android.widget.ListView replyListView;
    private ReplyListAdapter mAdapter;
    private List<ReplyData> replyDatas = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reply_list);
        replyDatas = (List<ReplyData>)getIntent().getSerializableExtra("댓글데이터");
        bindViews();
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {

    }

    @Override
    public void setValues() {
        mAdapter = new ReplyListAdapter(mContext, replyDatas);
        replyListView.setAdapter(mAdapter);
    }

    @Override
    public void bindViews() {
        this.replyListView = (ListView) findViewById(R.id.replyListView);
    }
}
