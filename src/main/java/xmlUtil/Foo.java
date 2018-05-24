package xmlUtil;

import org.dom4j.*;
import org.dom4j.io.SAXReader;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;

public class Foo {
    public Document parse(String url) throws DocumentException {
        SAXReader saxReader=new SAXReader();
        Document document=saxReader.read(url);
        return document;
    }
    public void bar(Document document){
        Element rootElement=document.getRootElement();
        for (Iterator<Element>  it=rootElement.elementIterator();it.hasNext();){
            Element element=it.next();
        }

    }
    public void footest() throws DocumentException {
        String text="<person><name>dcas</name></person>";
        Document document= DocumentHelper.parseText(text);
        try {
            FileWriter fileWriter=new FileWriter("src/main/java/xmlUtil/test.xml");
            document.write(fileWriter);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
//        Foo foo=new Foo();
//        try {
//            foo.footest();
//        } catch (DocumentException e) {
//            e.printStackTrace();
//        }
        Foo foo =new Foo();
        try {
            Document document= (Document) foo.parse("src/main/resources/testXml.xml");
            foo.treeWalk(document);
        } catch (DocumentException e) {
            e.printStackTrace();
        }


    }



    public void treeWalk(Document document) {
        treeWalk(document.getRootElement());
    }

    public void treeWalk(Element element) {
        for (int i = 0, size = element.nodeCount(); i < size; i++) {
            Node node = element.node(i);
            if (node instanceof Element) {
                treeWalk((Element) node);
            }
            else {
                // do something…
            }
        }
    }
}
