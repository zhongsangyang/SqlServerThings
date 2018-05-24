package Model;

public class BizGlobalConfiguration {

	//域信息对象
	private Switch Switch;


	//默认用户权限
	private int defaultRoleId;
	
	//缓存时间(分钟)
	private int cacheTime; 
	
	//默认查询间隔时间(天)
	private int searchIntervalTime;
	
	//系统默认评价
	private String evaluationDefaultValue;
	
	//直聊-图片、语音地址
	private String TalkFileDownloadUrl;
	


	
	
	
	public Switch getSwitch() {
		return Switch;
	}
	public void setSwitch(Switch switch1) {
		Switch = switch1;
	}

	public int getDefaultRoleId() {
		return defaultRoleId;
	}
	public void setDefaultRoleId(int defaultRoleId) {
		this.defaultRoleId = defaultRoleId;
	}
	public int getCacheTime() {
		return cacheTime;
	}
	public void setCacheTime(int cacheTime) {
		this.cacheTime = cacheTime;
	}
	public int getSearchIntervalTime() {
		return searchIntervalTime;
	}
	public void setSearchIntervalTime(int searchIntervalTime) {
		this.searchIntervalTime = searchIntervalTime;
	}
	public String getEvaluationDefaultValue() {
		return evaluationDefaultValue;
	}
	public void setEvaluationDefaultValue(String evaluationDefaultValue) {
		this.evaluationDefaultValue = evaluationDefaultValue;
	}
	public String getTalkFileDownloadUrl() {
		return TalkFileDownloadUrl;
	}
	public void setTalkFileDownloadUrl(String talkFileDownloadUrl) {
		TalkFileDownloadUrl = talkFileDownloadUrl;
	}


	public String toString() {
		return "BizGlobalConfiguration{" +
				"Switch=" + Switch +
				", defaultRoleId=" + defaultRoleId +
				", cacheTime=" + cacheTime +
				", searchIntervalTime=" + searchIntervalTime +
				", evaluationDefaultValue='" + evaluationDefaultValue + '\'' +
				", TalkFileDownloadUrl='" + TalkFileDownloadUrl + '\'' +
				'}';
	}
}
