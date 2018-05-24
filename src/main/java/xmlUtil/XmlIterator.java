package xmlUtil;

import Model.BizGlobalConfiguration;
import com.thoughtworks.xstream.XStream;
import org.dom4j.*;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.lang.reflect.Field;
import java.util.Iterator;


public class XmlIterator {
    private static final String filePath="src/main/java/Model/BizGlobal.config";
    public static void main(String[] args) {
        XmlIterator.XmltoJavaBean("Model.BizGlobalConfiguration",BizGlobalConfiguration.class,filePath);
//        classPostionInProperty();
    }
    public static void XmltoJavaBean(String classPathName,Class c1,String xmlPath){
        SAXReader saxReader = new SAXReader();
        try {
            Document document = saxReader.read(new File(xmlPath));
            Element rootElement = document.getRootElement();
            Class c=null;
            if(classPathName!=null && !(classPathName.equals(""))){
                c = Class.forName(classPathName);
            }else{
                c= c1;
            }
            Field field[] = c.getDeclaredFields();
            Object o = c.newInstance();
            Iterator<Element> iterator = rootElement.elementIterator();

            while (iterator.hasNext()) {
                Element element = iterator.next();
                Iterator<Element> iterator1 = element.elementIterator();
                Class<?> c2=Class.forName(field[0].getGenericType().getTypeName());
                Field childrenFileds[]=c2.getDeclaredFields();
                while (iterator1.hasNext()){
                    Element element1=iterator1.next();
                    String xml=element.asXML();
                    xml=XmlIterator.updateXml(c2,xml);
                    field[0].setAccessible(true);
                    XStream xStream=new XStream();
                    xStream.alias(field[0].getName(),c2);
                    Object o2=xStream.fromXML(xml);
                    field[0].set(o,o2);
                }
               ifall(field,o,element);
            }

            BizGlobalConfiguration bizGlobalConfiguration = (BizGlobalConfiguration)o;
            System.out.println(bizGlobalConfiguration.toString());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
    public static int ParseStrtoInt(String string){
        return Integer.parseInt(string);
    }
    public static Float ParseStrtoFloat(String string){
        return Float.parseFloat(string);
    }
    public static Double ParseStrtoDouble(String string){
        return Double.parseDouble(string);

    }
    public static Boolean ParseStrtoBoolean(String string){
        return Boolean.parseBoolean(string);

    }

    public static void ifall(Field field[] ,Object o,Element element) throws IllegalAccessException {
        for(int i=1;i<field.length;i++){
            if(field[i].getName().toUpperCase().equals(element.getName().toUpperCase())){
                String type = field[i].getGenericType().getTypeName();
                field[i].setAccessible(true);
                if (type.equals("int")) {
                    String s=element.getStringValue();
                    field[i].set(o,Integer.valueOf(s));
                } else if (type.equals("java.lang.Double")) {
                    field[i].set(o, XmlIterator.ParseStrtoDouble(element.getStringValue()));
                } else if (type.equals("java.lang.Boolean")) {
                    field[i].set(o, XmlIterator.ParseStrtoBoolean(element.getStringValue()));

                } else if (type.equals("java.lang.Float")) {
                    field[i].set(o, XmlIterator.ParseStrtoFloat(element.getStringValue()));

                } else if (type.equals("java.lang.String")) {
                    field[i].set(o, element.getStringValue());
                }
            }
        }
    }

    public static String updateXml(Class c,String xml){

        try {
            Document doucment=DocumentHelper.parseText(xml);
            Element rootElement=doucment.getRootElement();
            Iterator<Element> it=rootElement.elementIterator();
            Class c1=c;
            Field field[]=c1.getDeclaredFields();
            rootElement.setName(c1.getSimpleName());
            while(it.hasNext()){
                Element element=it.next();
                for(Field field1:field){
                    if(field1.getName().toUpperCase().equals(element.getName().toUpperCase())){
                        element.setName(field1.getName());
                    }
                }
            }
            return rootElement.asXML();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return  null;
    }

    public static Field  classPostionInProperty(Class c1,String name){
        try {
            Class c=c1;
            Field field[]=c.getDeclaredFields();
            Field field2=null;
            for(Field field1:field){
               if(name.toUpperCase().equals(field1.getName().toUpperCase())){
                   field2 =field1;
                   return field2;
               }
            }

        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
