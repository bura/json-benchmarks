package org.bura.benchmarks.json.domain;

import java.util.Date;
import java.util.List;

/**
 * The data of user profile.
 * 
 * @author Andrey Bloschetsov
 */
public class UserProfile {
    
    public static final Integer GENDER_MALE = 1;
    public static final Integer GENDER_FEMALE = 2;
    public static final Integer GENDER_OTHER = 3;

    private String id;
    private Long profileViews;
    private String email;
    private UserNames name;
    private Integer gender;
    private String birthday;
    private List<Location> locations;
    private String image;
    private String cover;
    private String aboutMe;
    private String etag;
    private Boolean active;
    private Boolean deleted;
    private Date latsAccsess;
    private List<Like> likes;

    public UserProfile(String id, Long profileViews, String email, UserNames name, Integer gender, String birthday, List<Location> locations, String image, String cover,
            String aboutMe, String etag, Boolean active, Boolean deleted, Date latsAccsess, List<Like> likes) {

        this.id = id;
        this.profileViews = profileViews;
        this.email = email;
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
        this.locations = locations;
        this.image = image;
        this.cover = cover;
        this.aboutMe = aboutMe;
        this.etag = etag;
        this.active = active;
        this.deleted = deleted;
        this.latsAccsess = latsAccsess;
        this.likes = likes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getProfileViews() {
        return profileViews;
    }

    public void setProfileViews(Long profileViews) {
        this.profileViews = profileViews;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserNames getName() {
        return name;
    }

    public void setName(UserNames name) {
        this.name = name;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public String getEtag() {
        return etag;
    }

    public void setEtag(String etag) {
        this.etag = etag;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Date getLatsAccsess() {
        return latsAccsess;
    }

    public void setLatsAccsess(Date latsAccsess) {
        this.latsAccsess = latsAccsess;
    }

    public List<Like> getLikes() {
        return likes;
    }

    public void setLikes(List<Like> likes) {
        this.likes = likes;
    }

}
