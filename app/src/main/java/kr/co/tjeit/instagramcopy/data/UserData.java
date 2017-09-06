package kr.co.tjeit.instagramcopy.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tjoeun on 2017-08-17.
 */

public class UserData implements Serializable {

    // 사용자가 가지는 고유의 속성. => 기본형 변수 + String
    private int userId; // 데이터베이스와의 연동을 고려한 변수
    private String name; // 사용자의 이름을 저장.
    private String nickName; // 본명보다 닉네임 위주로. 아이디의 개념.
    private String profileImgURL; // 프사 경로.

    // 사용자와 다른 객체들과의 관계 -> List 형태로 저장.
    // 아닌경우도 있다. 단순히 하나의 객체만 갖는 경우.
    // 대표적인 관계? 팔로워 : 나를 보는 사람 / 팔로잉 : 내가 보는 사람

    // 나 (1) <-> 팔로워 (N)
    List<UserData> followers = new ArrayList<>();
    // 나 (1) <-> 팔로잉 (N)
    List<UserData> followings = new ArrayList<>();

    public UserData() {
    }

    public UserData(int userId, String name, String nickName, String profileImgURL) {
        this.userId = userId;
        this.name = name;
        this.nickName = nickName;
        this.profileImgURL = profileImgURL;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getProfileImgURL() {
        return profileImgURL;
    }

    public void setProfileImgURL(String profileImgURL) {
        this.profileImgURL = profileImgURL;
    }

    public List<UserData> getFollowers() {
        return followers;
    }

    public void setFollowers(List<UserData> followers) {
        this.followers = followers;
    }

    public List<UserData> getFollowings() {
        return followings;
    }

    public void setFollowings(List<UserData> followings) {
        this.followings = followings;
    }
}
