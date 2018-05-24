package xmlUtil;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class XmlTest {
    public static void main(String[] args) {
        DocumentBuilderFactory documentBuilderFactory=DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder=documentBuilderFactory.newDocumentBuilder();
            Document document=builder.parse(new File("src/main/resources/testXml.xml"));
            NodeList nodeList=document.getElementsByTagName("VALUE");
            for(int i=0;i<nodeList.getLength();i++){
                System.out.println(document.getElementsByTagName("NO").item(i).getFirstChild().getNodeValue());
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
