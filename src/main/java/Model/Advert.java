package Model;

public class Advert{

    // 广告系统地址
    private String advertUrl;

    // 广告系统登陆账号
    private String adverUser;

    // 广告系统登陆密码
    private String adverPassword;

    public String getAdvertUrl() {
        return advertUrl;
    }

    public void setAdvertUrl(String advertUrl) {
        this.advertUrl = advertUrl;
    }

    public String getAdverUser() {
        return adverUser;
    }

    public void setAdverUser(String adverUser) {
        this.adverUser = adverUser;
    }

    public String getAdverPassword() {
        return adverPassword;
    }

    public void setAdverPassword(String adverPassword) {
        this.adverPassword = adverPassword;
    }

    public String toString() {
        return "Advert{" +
                "advertUrl='" + advertUrl + '\'' +
                ", adverUser='" + adverUser + '\'' +
                ", adverPassword='" + adverPassword + '\'' +
                '}';
    }
}
