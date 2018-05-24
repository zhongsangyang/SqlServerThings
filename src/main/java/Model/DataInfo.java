package Model;
public class DataInfo{

    // 放盘站相关
    private Ads ads;

    // 广告系统相关
    private Advert advert;

    //中原管家相关信息
    private GuanJiaInfo guanJiaInfo;

    //新盘评论相关信息
    private NewpropComment newpropComment;

    private Boolean isAPlus2NewProp;

    public Boolean getAPlus2NewProp() {
        return isAPlus2NewProp;
    }

    public void setAPlus2NewProp(Boolean APlus2NewProp) {
        isAPlus2NewProp = APlus2NewProp;
    }

    public Ads getAds() {
        return ads;
    }

    public void setAds(Ads ads) {
        this.ads = ads;
    }

    public Advert getAdvert() {
        return advert;
    }

    public void setAdvert(Advert advert) {
        this.advert = advert;
    }

    public GuanJiaInfo getGuanJiaInfo() {
        return guanJiaInfo;
    }

    public void setGuanJiaInfo(GuanJiaInfo guanJiaInfo) {
        this.guanJiaInfo = guanJiaInfo;
    }

    public NewpropComment getNewpropComment() {
        return newpropComment;
    }

    public void setNewpropComment(NewpropComment newpropComment) {
        this.newpropComment = newpropComment;
    }

    public String toString() {
        return "DataInfo{" +
                "ads=" + ads +
                ", advert=" + advert +
                ", isAPlus2NewProp=" + isAPlus2NewProp +
                ", guanJiaInfo=" + guanJiaInfo +
                ", newpropComment=" + newpropComment +
                '}';
    }
}






