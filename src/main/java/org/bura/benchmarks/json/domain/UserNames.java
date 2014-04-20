package org.bura.benchmarks.json.domain;

/**
 * User name components.
 * 
 * @author Andrey Bloschetsov
 */
public class UserNames {

    private String nickname;
    private String displayName;
    private String givenName;
    private String familyName;
    private String middleName;
    private String prefix;
    private String suffix;

    public UserNames() {
    }

    public UserNames(String nickname, String displayName, String givenName, String familyName, String middleName, String prefix, String suffix) {
        this.nickname = nickname;
        this.displayName = displayName;
        this.givenName = givenName;
        this.familyName = familyName;
        this.middleName = middleName;
        this.prefix = prefix;
        this.suffix = suffix;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

}
