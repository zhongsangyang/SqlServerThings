package xmlUtil;

import Model.Switch;
import org.dom4j.*;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.*;
import java.lang.reflect.Field;
import java.util.Iterator;

public class XmlCrud {
    public void testAdd(){
        Document document = DocumentHelper.createDocument();
        Element rootElem=document.addElement("root");
       //增加标签
        Element stuElem=rootElem.addElement("student");
        //增加属性
        stuElem.addElement("name");
        stuElem.setText("xyz");
        stuElem.addAttribute("id","88888");
        stuElem.addAttribute("sex","男");
        Attribute attribute=stuElem.attribute("id");
        attribute.setValue("111111111111");
        Element nameEl=document.getRootElement().element("student").element("name");

        nameEl.setText("xyz");
        nameEl.detach();
        //制定文件输出位置
        try {
            FileOutputStream out=new FileOutputStream("d:/student.xml");
            OutputFormat outputFormat=OutputFormat.createPrettyPrint();
            outputFormat.setEncoding("utf-8");
            //1,创建写出对象
            XMLWriter xmlWriter=new XMLWriter(out,outputFormat);
            xmlWriter.write(document);
            xmlWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        String xml="<switch>\n" +
                "    <!--是否开启域验证-->\n" +
                "    <isAd>true</isAd>\n" +
                "    <!--域-->\n" +
                "    <!--广州的域环境的地址是：LDAP://10.3.1.1  sz10.1.1.2 -->\n" +
                "    <!--其他城市的域环境的地址是：LDAP://10.4.1.2 || LDAP://10.4.1.1  -->\n" +
                "    <adServer>LDAP://10.4.1.2</adServer>\n" +
                "    <!--域登录-->\n" +
                "    <adAccount>aardev01|aar@1234</adAccount>\n" +
                "  </switch>";
        XmlCrud xmlCrud=new XmlCrud();
//        xmlCrud.testAdd();
        System.out.println(xmlCrud.updateXml(Switch.class,xml));
    }
    public static String updateXml(Class c,String xml){

        try {
            Document doucment=DocumentHelper.parseText(xml);
            Element rootElement=doucment.getRootElement();
            Iterator<Element> it=rootElement.elementIterator();
            Class c1=c;
//            Object o=c1.newInstance();
            Field field[]=c1.getDeclaredFields();
            rootElement.setName(c1.getSimpleName());
            while(it.hasNext()){
                Element element=it.next();
                for(Field field1:field){
                    if(field1.getName().toUpperCase().equals(element.getName().toUpperCase())){
                        element.setName(field1.getName());

//                        System.out.println("jjjj");
                    }
//                    System.out.println(element.getName()+">>>>>>>>>>"+element.getStringValue());

                }
            }
            return rootElement.asXML();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return  null;
    }
}
