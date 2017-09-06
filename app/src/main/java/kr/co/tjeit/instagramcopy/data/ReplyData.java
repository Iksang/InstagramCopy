package kr.co.tjeit.instagramcopy.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by tjoeun on 2017-08-17.
 */

public class ReplyData implements Serializable {
    // 댓글이 고유하게 갖는 속성.
    private int replyId; // DB와의 연동을 고려한 id
    private String content; // 댓글의 내용
    private Calendar createdAt; // 댓글이 쓰여진 시간

    // 댓글과 다른 객체들과의 관계
    // 댓글 -> 작성자 (1) : 일반 사용자 객체.
    private UserData writerData;
    // 댓글 -> 좋아한 사람들. (N) : List 사용자
    private List<UserData> likeUsers = new ArrayList<>();

    // 댓글 <- 부모댓글
    // 부모댓글의 id값을 저장함으로써, 대댓글임을 명시.
    // id가 유효하지 않은값 (Ex, -1) 이면 부모가 없는 원본 댓글임을 명시.
    // id가 유효한값 (Ex. > 1) 이면 부모댓글에 매달려있는 대댓글임을 명시.
    private int parentReplyId;

    public ReplyData() {
    }

    public ReplyData(int replyId, String content, Calendar createdAt, UserData writerData, int parentReplyId) {
        this.replyId = replyId;
        this.content = content;
        this.createdAt = createdAt;
        this.writerData = writerData;
        this.parentReplyId = parentReplyId;
    }

    public int getReplyId() {
        return replyId;
    }

    public void setReplyId(int replyId) {
        this.replyId = replyId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Calendar getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Calendar createdAt) {
        this.createdAt = createdAt;
    }

    public UserData getWriterData() {
        return writerData;
    }

    public void setWriterData(UserData writerData) {
        this.writerData = writerData;
    }

    public List<UserData> getLikeUsers() {
        return likeUsers;
    }

    public void setLikeUsers(List<UserData> likeUsers) {
        this.likeUsers = likeUsers;
    }

    public int getParentReplyId() {
        return parentReplyId;
    }

    public void setParentReplyId(int parentReplyId) {
        this.parentReplyId = parentReplyId;
    }
}
