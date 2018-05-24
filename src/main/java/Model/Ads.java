package Model;

public class Ads{

    // 放盘站地址
    private String adsUrl;

    // 放盘站登陆账号
    private String adsUser;

    // 放盘站登陆密码
    private String adsPassword;

    // 房源质量报表
    private String adsPageQuality;

    public String getAdsUrl() {
        return adsUrl;
    }

    public void setAdsUrl(String adsUrl) {
        this.adsUrl = adsUrl;
    }

    public String getAdsPassword() {
        return adsPassword;
    }

    public void setAdsPassword(String adsPassword) {
        this.adsPassword = adsPassword;
    }

    public String getAdsPageQuality() {
        return adsPageQuality;
    }

    public void setAdsPageQuality(String adsPageQuality) {
        this.adsPageQuality = adsPageQuality;
    }

    public String getAdsUser() {
        return adsUser;
    }

    public void setAdsUser(String adsUser) {
        this.adsUser = adsUser;
    }

    public String toString() {
        return "Ads{" +
                "adsUrl='" + adsUrl + '\'' +
                ", adsUser='" + adsUser + '\'' +
                ", adsPassword='" + adsPassword + '\'' +
                ", adsPageQuality='" + adsPageQuality + '\'' +
                '}';
    }
}