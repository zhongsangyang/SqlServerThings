package Model;

public class BizUnitVo {
	
		//服务地址
		private Server server;
	
		//城市信息
		private CityInfo  cityInfo;
	
		//数据仓库
		private DataInfo dataInfo;
		//测试添加字段

		private String tesName;

	public String getTesName() {
		return tesName;
	}

	public void setTesName(String tesName) {
		this.tesName = tesName;
	}

	public Server getServer() {
			return server;
		}


		public void setServer(Server server) {
			this.server = server;
		}


		public CityInfo getCityInfo() {
			return cityInfo;
		}


		public void setCityInfo(CityInfo cityInfo) {
			this.cityInfo = cityInfo;
		}


		public DataInfo getDataInfo() {
			return dataInfo;
		}


		public void setDataInfo(DataInfo dataInfo) {
			this.dataInfo = dataInfo;
		}


    public String toString() {
        return "BizUnitVo{" +
                "server=" + server +
                ", cityInfo=" + cityInfo +
                ", dataInfo=" + dataInfo +
				", tesName=" + tesName    +
                '}';
    }
}
