package Model;

public class CityInfo{

    // 城市编号
    private String id;

    // 仅供CMS附件使用
    private String domain;

    // 城市拼音首字母缩写
    private String shortEname;

    // 城市拼音
    private String eName;

    // 城市名
    private String cName;

    // 城市经度
    private String lng;

    // 城市纬度
    private String lat;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getShortEname() {
        return shortEname;
    }

    public void setShortEname(String shortEname) {
        this.shortEname = shortEname;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String toString() {
        return "CityInfo{" +
                "id='" + id + '\'' +
                ", domain='" + domain + '\'' +
                ", shortEname='" + shortEname + '\'' +
                ", eName='" + eName + '\'' +
                ", cName='" + cName + '\'' +
                ", lng='" + lng + '\'' +
                ", lat='" + lat + '\'' +
                '}';
    }
}

