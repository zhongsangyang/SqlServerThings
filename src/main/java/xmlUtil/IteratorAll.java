package xmlUtil;

import Model.BizUnitVo;
import com.thoughtworks.xstream.XStream;
import org.dom4j.*;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.lang.reflect.Field;
import java.text.ParseException;
import java.util.Iterator;
import java.util.List;
/*
*要求解析的xml 的节点名称字母要和javabean里面的属性名称字母一致，大小写不敏感
* 解析BizUnitVo模板的testIterator(Class c,String filePath)方法
* c为传入Bean.Class,filePath为要解析的xml路径
* 返回解析后的Object对象，可以强制转成你所传入的Bean对象
* */

public class IteratorAll {
    private static final String filePath="src/main/java/Model/BizUnit.xml";

    public static void main(String[] args) {
//        findTag();
//        tranAttributToString();
        testIterator(BizUnitVo.class,filePath);
    }

    public static Object testIterator(Class c,String filePath){
        SAXReader saxReader=new SAXReader();
        Class c1=c;
        Object object=null;
        try {
            Document document=saxReader.read(new File(filePath));
            Element rootElement=document.getRootElement();
            Iterator<Element> iterator=rootElement.elementIterator();
            object=c1.newInstance();
            while(iterator.hasNext()){
                Element element=iterator.next();
                Iterator<Attribute> attributeIterator=element.attributeIterator();
                Iterator<Element> iterator1=element.elementIterator();
                Element element1=null;
                if (attributeIterator.hasNext()) {
                    Attribute attribute =attributeIterator.next();
                    Field field1=XmlIterator.classPostionInProperty(c1,element.getName());
                    Class<?> fieldClass=Class.forName(field1.getGenericType().getTypeName());
                    String attributexml=tranAttributToString(element.asXML(),fieldClass);
                    Object objectAttribute=addAttributeToEmelment(attributexml,fieldClass);
                    field1.setAccessible(true);
                    field1.set(object,objectAttribute);


                }

                if(iterator1.hasNext()&&!(element1=iterator1.next()).elementIterator().hasNext()){
                    Field field1=XmlIterator.classPostionInProperty(c1,element.getName());
                    Class<?> fieldClass=Class.forName(field1.getGenericType().getTypeName());

                    String xml=XmlIterator.updateXml(fieldClass,element.asXML());
                    XStream xStream=new XStream();
                    xStream.alias(fieldClass.getSimpleName(),fieldClass);
                    Object o1=xStream.fromXML(xml);
                    field1.setAccessible(true);
                    field1.set(object,o1);
                    continue;
                }else {
                    Field field[]=c.getDeclaredFields();
                    XmlIterator.ifall(field,object,element);
                }
                iterator1=element.elementIterator();
                Object constouctorObject=null;
                while(iterator1.hasNext()){
                    element1=iterator1.next();
                    Iterator<Element> iterator2=element1.elementIterator();
                    if(iterator2.hasNext()&&element1.getParent()==element) {
                        Field pageInfoField = XmlIterator.classPostionInProperty(c, element.getName());
                        Class<?> pageInfoClass = Class.forName(pageInfoField.getGenericType().getTypeName());
                        Field pageInfoChildrenField = XmlIterator.classPostionInProperty(pageInfoClass, element1.getName());
                        Class<?> pageInfoChildrenClass = Class.forName(pageInfoChildrenField.getGenericType().getTypeName());
                        String pageInfoXml = XmlIterator.updateXml(pageInfoChildrenClass, element1.asXML());
                        XStream xStream = new XStream();
                        xStream.alias(pageInfoChildrenClass.getSimpleName(), pageInfoChildrenClass);
                        Object pageChildrenObject = xStream.fromXML(pageInfoXml);
                        if (constouctorObject == null) {
                            constouctorObject = pageInfoClass.newInstance();
                        } else {
                            //打破private的限制
                            pageInfoChildrenField.setAccessible(true);
                            //把pageInfo 下面的advert ads放入pageInfo里面
                            pageInfoChildrenField.set(constouctorObject, pageChildrenObject);
                            pageInfoField.setAccessible(true);
                            //把pageInfo 放入BizUnitVo里面
                            pageInfoField.set(object, constouctorObject);
                        }
                    }else{
                        if(element1.getParent()==element){
                            Field pageInfoField = XmlIterator.classPostionInProperty(c, element.getName());
                            Class<?> pageInfoClass = pageInfoClass = Class.forName(pageInfoField.getGenericType().getTypeName());
                            if (constouctorObject == null) {
                                constouctorObject = pageInfoClass.newInstance();
                            }
                            XmlIterator.ifall(pageInfoClass.getDeclaredFields(),constouctorObject,element1);
                            pageInfoField.setAccessible(true);
                            pageInfoField.set(object,constouctorObject);
                        }
                    }

                }
                iterator1=element.elementIterator();
                while(iterator1.hasNext()){
                    element1=iterator1.next();
                    Field pageInfoField = XmlIterator.classPostionInProperty(c, element.getName());
                    Class<?> pageInfoClass = Class.forName(pageInfoField.getGenericType().getTypeName());
                    Field pageInfoChildrenField = XmlIterator.classPostionInProperty(pageInfoClass, element1.getName());
                    Class<?> pageInfoChildrenClass = Class.forName(pageInfoChildrenField.getGenericType().getTypeName());
                    String pageInfoXml = XmlIterator.updateXml(pageInfoChildrenClass, element1.asXML());
                    XStream xStream = new XStream();
                    xStream.alias(pageInfoChildrenClass.getSimpleName(), pageInfoChildrenClass);
                    Object pageChildrenObject = xStream.fromXML(pageInfoXml);
                    if (constouctorObject == null) {
                        constouctorObject = pageInfoClass.newInstance();
                    } else {
                        //打破private的限制
                        pageInfoChildrenField.setAccessible(true);
                        //把pageInfo 下面的advert ads放入pageInfo里面
                        pageInfoChildrenField.set(constouctorObject, pageChildrenObject);
                        pageInfoField.setAccessible(true);
                        //把pageInfo 放入BizUnitVo里面
                        pageInfoField.set(object, constouctorObject);

                    }
                    break;
                }
            }

        } catch (DocumentException e) {
            e.printStackTrace();
        }  catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return object;
    }

    public static String tranAttributToString(String xmlstr,Class c1){
        try {
            Document document= DocumentHelper.parseText(xmlstr);
            Document document1=DocumentHelper.createDocument();
            Element element=document.getRootElement();
            Class c= c1;
            Field field[]=c.getDeclaredFields();

            Element element1=document1.addElement(c.getSimpleName());

            for(Field field1:field){
                Iterator<Attribute> attributeIterator=element.attributeIterator();
                while (attributeIterator.hasNext()){
                    Attribute attribute=attributeIterator.next();
                    if(field1.getName().toUpperCase().equals(attribute.getName().toUpperCase())){
                        element1.addAttribute(field1.getName(),attribute.getValue());
                    }
                }
            }
            return element1.asXML();

        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static Object addAttributeToEmelment(String xml,Class c) throws DocumentException {
        Document document=DocumentHelper.parseText(xml);
        Element rootElement=document.getRootElement();

        Field field[]=c.getDeclaredFields();
        XStream xStream=new XStream();

        xStream.alias(c.getSimpleName(),c);

        for(Field field1:field){
            List<Attribute> list=rootElement.attributes();
          for(int i=0;i<list.size();i++){
                Attribute attribute=list.get(i);

                if(field1.getName().toUpperCase().equals(attribute.getName().toUpperCase())){
                    xStream.useAttributeFor(c,field1.getName());
                }
            }
        }

        return xStream.fromXML(xml);

    }

}
