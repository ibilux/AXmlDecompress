
package axmldecompress;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;


/**
 *
 * @author bilux (i.bilux@gmail.com)
 */

public class AXmlDecompress {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //String fileName = "/home/hq/temp/uni.apk";
        //String fileName = "/home/hq/temp/AndroidManifest.xml";
        String fileName = args[0];
        String xml;
        try {
            if(fileName.endsWith(".apk")){
                xml = ApkTool.getPackage(fileName);
            }else if(fileName.endsWith(".xml")){
                File file = new File(fileName);
                FileInputStream fin = new FileInputStream(file);
                byte buf[] = new byte[(int)file.length()];
                fin.read(buf);            
                xml = Parser.decompressXML(buf);
                fin.close();
            }else{
                xml = "Non valide file.";
            }
        } catch (IOException | ParserConfigurationException | SAXException ex) {
            xml = "Non valide file.";
        }
        System.out.println(xml);
    }
    
}
