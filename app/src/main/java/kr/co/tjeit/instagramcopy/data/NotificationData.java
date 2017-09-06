package kr.co.tjeit.instagramcopy.data;

import java.io.Serializable;
import java.util.Calendar;

/**
 * Created by tjoeun on 2017-08-17.
 */

public class NotificationData implements Serializable {

//    데이터 설계
//    고유 속성

//    ~가, ~게시글을, --합니다. (댓글 / 좋아요) (팔로우)
//    언제?

    //  고유 속성
    private int notificationId; // 몇번째 Noti인지 DB와의 연동을 고려하는 변수.
    private Calendar createdAt; // 언제 발생한 알림인지.
    private String actionType; // 좋아요. 댓글 구별
//    like : 좋아요, reply : 댓글

    // 관계
    private UserData actor; // 누가 한건지.
    private PostingData post; // 어떤 게시글?

    public NotificationData() {
    }

    public NotificationData(int notificationId, Calendar createdAt, String actionType, UserData actor, PostingData post) {
        this.notificationId = notificationId;
        this.createdAt = createdAt;
        this.actionType = actionType;
        this.actor = actor;
        this.post = post;
    }

    public int getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(int notificationId) {
        this.notificationId = notificationId;
    }

    public Calendar getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Calendar createdAt) {
        this.createdAt = createdAt;
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public UserData getActor() {
        return actor;
    }

    public void setActor(UserData actor) {
        this.actor = actor;
    }

    public PostingData getPost() {
        return post;
    }

    public void setPost(PostingData post) {
        this.post = post;
    }
}
