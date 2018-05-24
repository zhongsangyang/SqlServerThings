package Model;

public class GuanJiaInfo {

    // 中原管家登陆地址
    private String loginUrl;

    // 中原管家菜单信息
    private String menuUrl;

    public String getLoginUrl() {
        return loginUrl;
    }

    public void setLoginUrl(String loginUrl) {
        this.loginUrl = loginUrl;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public String toString() {
        return "GuanJiaInfo{" +
                "loginUrl='" + loginUrl + '\'' +
                ", menuUrl='" + menuUrl + '\'' +
                '}';
    }
}
