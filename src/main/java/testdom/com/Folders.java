package testdom.com;

import org.xml.sax.InputSource;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collection;
/*
* Implement a function folderNames, which accepts a string containing an XML file that specifies folder structure and
*  returns all folder names that start with startingLetter. The XML format is given in the example below.
* For example, for the letter 'u' and an XML file:
* <?xml version="1.0" encoding="UTF-8"?>
* <folder name="c">
*     <folder name="program files">
*         <folder name="uninstall information" />
*     </folder>
*     <folder name="users" />
* </folder>
* the function should return a collection with items "uninstall information" and "users" (in any order).
* */

public class Folders {

    public static Collection<String> folderNames(String xml, char startingLetter) throws Exception {
        Collection<String> folderNames = new ArrayList<>() ;
        Document document;
        DocumentBuilderFactory factory;

        factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        document = builder.parse(new InputSource(new StringReader(xml)));
        int a = document.getElementsByTagName("folder").getLength();
        for (int i = 0;i<a;i++){
            if(document.
                    getElementsByTagName("folder").
                    item(i).getAttributes().getNamedItem("name").
                    getNodeValue().startsWith(Character.toString(startingLetter))
            ){
                folderNames.add(
                        document.
                                getElementsByTagName("folder").
                                item(i).getAttributes().getNamedItem("name").
                                getNodeValue());
            }
        }
        return folderNames;
    }

    public static void main(String[] args) throws Exception {
        String xml =
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                        "<folder name=\"c\">" +
                        "<folder name=\"program files\">" +
                        "<folder name=\"uninstall information\" />" +
                        "</folder>" +
                        "<folder name=\"users\" />" +
                        "</folder>";

        Collection<String> names = folderNames(xml, 'u');

        for(String name: names)
            System.out.println(name);
    }

}