import org.testng.annotations.DataProvider;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * Always remember good good study,day day up.
 * Created by wolin on 2017/12/4 21:18
 */

public class DataProvide {
    public Document doc;
    public void init(String filename) throws ParserConfigurationException, IOException, SAXException {
        File inputxml = new File(new File(filename).getAbsolutePath());
        //documentBuilder为抽象不能直接实例化（将xml文件转换为dom文件）
        DocumentBuilder db = null;
        DocumentBuilderFactory dbf = null;

        try {
            //返回documentBuilderFactory对象
            dbf = DocumentBuilderFactory.newInstance();
            //返回db对象用documentBuilderFactory对象获得documentBuilder对象
            db = dbf.newDocumentBuilder();

            //得到一个dom并返回给document对象
            doc = (Document)db.parse(inputxml);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @DataProvider(name = "Test_xml_dataprovider")
    public Object[][] providerMethod(Method method){
        return new Object[][]{new Object[]{doc}};
    }
}
