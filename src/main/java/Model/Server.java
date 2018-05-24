package Model;

public class Server{
    // 图片服务器地址1
    // 192.168.100.4->10.4.18.16
    // 192.168.100.5->10.4.18.17
    private String uploadPathOne;

    // 图片服务器地址2
    private String uploadPathTwo;

    // 图片服务器连接
    private String newpropImage;

    // 官网二手房地址
    private String postSaleUrl;

    // 官网租房地址
    private String postRentUrl;

    // 官网新房地址
    private String newpropUrl;

    // 公共服务地址
    private String serviceAddressBizcommon;

    // 二手房服务地址
    private String serviceAddress;

    // 用户中心
    private String serviceAddressPassport;

    // 新网活动
    private String newpropHuoDong;




    public String getUploadPathOne() {
        return uploadPathOne;
    }

    public void setUploadPathOne(String uploadPathOne) {
        this.uploadPathOne = uploadPathOne;
    }

    public String getUploadPathTwo() {
        return uploadPathTwo;
    }

    public void setUploadPathTwo(String uploadPathTwo) {
        this.uploadPathTwo = uploadPathTwo;
    }

    public String getNewpropImage() {
        return newpropImage;
    }

    public void setNewpropImage(String newpropImage) {
        this.newpropImage = newpropImage;
    }

    public String getPostSaleUrl() {
        return postSaleUrl;
    }

    public void setPostSaleUrl(String postSaleUrl) {
        this.postSaleUrl = postSaleUrl;
    }

    public String getPostRentUrl() {
        return postRentUrl;
    }

    public void setPostRentUrl(String postRentUrl) {
        this.postRentUrl = postRentUrl;
    }

    public String getNewpropUrl() {
        return newpropUrl;
    }

    public void setNewpropUrl(String newpropUrl) {
        this.newpropUrl = newpropUrl;
    }

    public String getServiceAddressBizcommon() {
        return serviceAddressBizcommon;
    }

    public void setServiceAddressBizcommon(String serviceAddressBizcommon) {
        this.serviceAddressBizcommon = serviceAddressBizcommon;
    }

    public String getServiceAddress() {
        return serviceAddress;
    }

    public void setServiceAddress(String serviceAddress) {
        this.serviceAddress = serviceAddress;
    }

    public String getServiceAddressPassport() {
        return serviceAddressPassport;
    }

    public void setServiceAddressPassport(String serviceAddressPassport) {
        this.serviceAddressPassport = serviceAddressPassport;
    }

    public String getNewpropHuoDong() {
        return newpropHuoDong;
    }

    public void setNewpropHuoDong(String newpropHuoDong) {
        this.newpropHuoDong = newpropHuoDong;
    }

    public String toString() {
        return "Server{" +
                "uploadPathOne='" + uploadPathOne + '\'' +
                ", uploadPathTwo='" + uploadPathTwo + '\'' +
                ", newpropImage='" + newpropImage + '\'' +
                ", postSaleUrl='" + postSaleUrl + '\'' +
                ", postRentUrl='" + postRentUrl + '\'' +
                ", newpropUrl='" + newpropUrl + '\'' +
                ", serviceAddressBizcommon='" + serviceAddressBizcommon + '\'' +
                ", serviceAddress='" + serviceAddress + '\'' +
                ", serviceAddressPassport='" + serviceAddressPassport + '\'' +
                ", newpropHuoDong='" + newpropHuoDong + '\'' +
                '}';
    }
}
