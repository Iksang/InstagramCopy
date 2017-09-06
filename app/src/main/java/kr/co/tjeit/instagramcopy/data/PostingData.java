package kr.co.tjeit.instagramcopy.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tjoeun on 2017-08-17.
 */

public class PostingData implements Serializable {
    // 게사하는 사진

    // 포스팅 데이터가 갖는 기본 속성
    private int postingId; // DB와의 연동을 고려한 변수.
    private String imageURL; // 게시한 포스팅의 사진이 있는 경로.
    private String content; // 사용자가 사진을 포스팅할때 첨부한 글.

    // 포스팅 데이터 갖는 관계.

    // 게시글 -> 작성자. (1)
    private UserData writerData;
    // 게시글 -> 좋아한 사람들 (N)
    private List<UserData> likeUsers = new ArrayList<>();
    // 게시글 -> 댓글 (N)
    private List<ReplyData> replies = new ArrayList<>();
    // 게시글 -> 해시태그 (N)
    private  List<String> hashTags = new ArrayList<>();

    public PostingData() {
    }

    public PostingData(int postingId, String imageURL, String content, UserData writerData) {
        this.postingId = postingId;
        this.imageURL = imageURL;
        this.content = content;
        this.writerData = writerData;
    }

    public int getPostingId() {
        return postingId;
    }

    public void setPostingId(int postingId) {
        this.postingId = postingId;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public List<String> getHashTags() {
        return hashTags;
    }

    public void setHashTags(List<String> hashTags) {
        this.hashTags = hashTags;
    }

    public List<ReplyData> getReplies() {
        return replies;
    }

    public void setReplies(List<ReplyData> replies) {
        this.replies = replies;
    }
}
