package xmlUtil;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.util.Iterator;
import java.util.List;

public class StudyOther {
    public static void  main(String[]args){
        String xml="<?xml version=\"1.0\" encoding=\"utf-8\"?>"+
                "<students>"+
                "   <student id=\"1\">"+
                "      <name>stz</name>"+
                "     <age>23</age>"+
                "</student>"+
                "<student id=\"2\">"+
                "<name>rhl</name>"+
                "<age>23</age>"+
                "</student>"+
                "<student id=\"3\">"+
                "   <name>tom</name>"+
                "  <age>23</age>"+
                "</student>"+
                "</students>";

        try {
            Document document= DocumentHelper.parseText(xml);
            Element root=document.getRootElement();
            //System.out.println(ele.e);
            //List nodes=root.elements("student");
            //System.out.println(root.getName());
            //root.elementIterator();
            List nodes=document.selectNodes("/students/student");

            for (Iterator it = nodes.iterator(); it.hasNext();) {
                Element elm = (Element) it.next();
                System.out.println("id:"+elm.attributeValue("id"));
                System.out.println(elm.getName());
                Element eles=elm.element("name");
                System.out.println(eles.getText());
                Element elea=elm.element("age");
                System.out.println(elea.getText());
            }

        } catch (DocumentException e) {
            e.printStackTrace();
        }


    }
}
