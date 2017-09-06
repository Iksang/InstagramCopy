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

import java.util.List;

import kr.co.tjeit.instagramcopy.R;
import kr.co.tjeit.instagramcopy.ReplyListActivity;
import kr.co.tjeit.instagramcopy.data.PostingData;
import kr.co.tjeit.instagramcopy.data.ReplyData;

/**
 * Created by tjoeun on 2017-08-18.
 */

public class ReplyListAdapter extends ArrayAdapter<ReplyData> {
    private Context mContext;
    private List<ReplyData> mList;
    private LayoutInflater inf;

    public ReplyListAdapter(Context context, List<ReplyData> list){

        super(context, R.layout.reply_list_item, list);
        mContext = context;
        mList = list;
        inf = LayoutInflater.from(mContext);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;
        if(row==null){
            row = inf.inflate(R.layout.reply_list_item, null);
        }

        ReplyData data = mList.get(position);

        TextView writerNickNameTxt = (TextView)row.findViewById(R.id.writerNickNameTxt);
        TextView contentTxt = (TextView)row.findViewById(R.id.contentTxt);

        writerNickNameTxt.setText(data.getWriterData().getNickName());
        contentTxt.setText(data.getContent());

        return row;
    }

}
