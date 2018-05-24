package Model;


public class Switch{
    //是否执行域验证
    private boolean IsAd;

    // 域验证地址
    // 广州的域环境的地址是：LDAP://10.3.1.1  sz10.1.1.2
    // 其他城市的域环境的地址是：LDAP://10.4.1.2 || LDAP://10.4.1.1
    private String AdServer;

    //域登陆用户
    private String AdAccount;



    public boolean isIsAd() {
        return IsAd;
    }

    public void setIsAd(boolean isAd) {
        IsAd = isAd;
    }

    public String getAdServer() {
        return AdServer;
    }

    public void setAdServer(String adServer) {
        AdServer = adServer;
    }

    public String getAdAccount() {
        return AdAccount;
    }

    public void setAdAccount(String adAccount) {
        AdAccount = adAccount;
    }

    public String toString() {
        return "Switch{" +
                "IsAd=" + IsAd +
                ", AdServer='" + AdServer + '\'' +
                ", AdAccount='" + AdAccount + '\'' +
                '}';
    }
}