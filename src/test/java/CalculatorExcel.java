import jxl.read.biff.BiffException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;

import static org.testng.AssertJUnit.assertEquals;

/**
 * Always remember good good study,day day up.
 * Created by wolin on 2017/12/5 12:10
 */

public class CalculatorExcel {
    Calculator cal = new Calculator();

    @DataProvider(name = "num")
    public  Object[][] numbers() throws IOException, BiffException {
        ExcelData e = new ExcelData("testdata","calcultor");
        return e.getExcelData();
    }

    @Test(dataProvider = "num")
    public void testAdd(HashMap<String,String> data){
        System.out.println(data.toString());
        float num1 = Float.parseFloat(data.get("num1"));
        float num2 = Float.parseFloat(data.get("num2"));
        float expectedResult = Float.parseFloat(data.get("sum"));

        float actual = cal.add(num1,num2);


        assertEquals(actual,expectedResult);

    }

}
