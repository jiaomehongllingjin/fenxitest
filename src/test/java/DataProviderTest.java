import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

/**
 * Always remember good good study,day day up.
 * Created by wolin on 2017/12/4 20:29
 */

public class DataProviderTest {
    @DataProvider
    public Object[][] providerMethod(Method method){
        Object[][] result = null;
        if (method.getName().equals("testmethod1")){
            result = new Object[][]{new Object[]{1}};
        }else if (method.getName().equals("testmethod2")){
            result = new Object[][]{new Object[]{2}};
        }else {
            result = new Object[][]{new Object[]{3}};
        }
        return result;
    }


    @Test(dataProvider = "providerMethod")
    public void testmethod1(int parm){
        System.out.println("method1 received"+parm);
    }

    @Test(dataProvider = "providerMethod")
    public  void testmethod2(int parm){
        System.out.println("method2 received"+parm);
    }

    @Test(dataProvider = "providerMethod")
    public void testmethod3(int parm){
        System.out.println("method3 received"+parm);
    }

}
