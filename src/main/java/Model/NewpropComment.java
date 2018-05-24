package Model;
public class NewpropComment{

    // 同一经纪人同一个楼盘一天只能评论的次数
    private int commentCount;

    // 同一经纪人同一个楼盘只能评论的次数
    private int commentCountNotDay;

    // 同一个楼盘最多允许评论N条（N暂定5，可调整)
    private int commentAllCount;

    // 是否上传图片功能
    private boolean isUploadPic;

    // 新盘评论默认通过1，不通过-1
    private int commentValue;

    //深圳不要刷新 编辑只显示我的评论
    private boolean isRefreshAndUpdate;

    // 同一个经纪人一天刷新同一条评论的次数 -1代表此项不用
    private int commentAllRefreshNoDay;

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public int getCommentCountNotDay() {
        return commentCountNotDay;
    }

    public void setCommentCountNotDay(int commentCountNotDay) {
        this.commentCountNotDay = commentCountNotDay;
    }

    public int getCommentAllCount() {
        return commentAllCount;
    }

    public void setCommentAllCount(int commentAllCount) {
        this.commentAllCount = commentAllCount;
    }

    public boolean isUploadPic() {
        return isUploadPic;
    }

    public void setUploadPic(boolean isUploadPic) {
        this.isUploadPic = isUploadPic;
    }

    public int getCommentValue() {
        return commentValue;
    }

    public void setCommentValue(int commentValue) {
        this.commentValue = commentValue;
    }

    public boolean isRefreshAndUpdate() {
        return isRefreshAndUpdate;
    }

    public void setRefreshAndUpdate(boolean isRefreshAndUpdate) {
        this.isRefreshAndUpdate = isRefreshAndUpdate;
    }

    public int getCommentAllRefreshNoDay() {
        return commentAllRefreshNoDay;
    }

    public void setCommentAllRefreshNoDay(int commentAllRefreshNoDay) {
        this.commentAllRefreshNoDay = commentAllRefreshNoDay;
    }




}
