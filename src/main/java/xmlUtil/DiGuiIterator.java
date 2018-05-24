package xmlUtil;

import org.dom4j.*;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.Iterator;
import java.util.List;

public class DiGuiIterator {
    private static final String filePath="src/main/java/Model/BizUnit.xml";

    public static void main(String[] args) {
        try {
            SAXReader saxReader=new SAXReader();
            Document document=saxReader.read(new File(filePath));
           List<Element> elements=document.getRootElement().elements();
//            for (Iterator i = rootElement.elementIterator(); i.hasNext();) {
//                Element el = (Element) i.next();

//            }
            Iterator<Element> iterator=elements.iterator();
            while(iterator.hasNext()){
                Element e=iterator.next();
                System.out.println(e.getName()+"???");
                getNode(e);            }


        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
    public static void getNode(Element element){
       if(element.elements().size()==0){
//           System.out.println(element.getName()+"没有"+element.getStringValue());
       }else {

           List<Element> elementList = element.elements();
           for(int i=0;i<elementList.size();i++){
               System.out.println(elementList.get(i).getName()+">>>>>>>>>"+elementList.get(i).getStringValue());
           }
           Iterator<Element> it = elementList.iterator();
           while(it.hasNext()){
               getNode(it.next());
           }
       }
    }


}
