package xmlUtil;

import Model.BizGlobalConfiguration;
import com.thoughtworks.xstream.XStream;

public class XmlTest2 {
    public static void main(String[] args) {
        String xml="<switch>\n" +
                "    <!--是否开启域验证-->\n" +
                "    <IsAd>true</IsAd>\n" +
                "    <!--域-->\n" +
                "    <!--广州的域环境的地址是：LDAP://10.3.1.1  sz10.1.1.2 -->\n" +
                "    <!--其他城市的域环境的地址是：LDAP://10.4.1.2 || LDAP://10.4.1.1  -->\n" +
                "    <AdServer>LDAP://10.4.1.2</AdServer>\n" +
                "    <!--域登录-->\n" +
                "    <AdAccount>aardev01|aar@1234</AdAccount>\n" +
                "  </switch>";
        XStream xStream=new XStream();
//        xStream.alias("switch", BizGlobalConfiguration.Switch.class);
//        BizGlobalConfiguration.Switch s= (BizGlobalConfiguration.Switch) xStream.fromXML(xml);
//        System.out.println(s.toString());

    }
}
