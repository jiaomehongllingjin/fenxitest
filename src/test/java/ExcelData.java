import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Always remember good good study,day day up.
 * Created by wolin on 2017/12/5 09:28
 */

public class ExcelData {
    public Workbook workbook;
    public Sheet sheet;
    public Cell cell;
    int rows;
    int columns;
    public String fileName;
    public String caseName;
    public ArrayList<String> arrkey = new ArrayList<String>();
    String sourceFile;

    /**
     *@param fileName excel文件名
     *@param caseName sheet名
     */
    public ExcelData(String fileName,String caseName){
        super();
        this.fileName = fileName;
        this.caseName = caseName;
    }


    /**
     * 获得excel表中的数据
     */
    public Object[][] getExcelData() throws IOException, BiffException {
        workbook = Workbook.getWorkbook(new File(getPath()));
        sheet = workbook.getSheet(caseName);
        rows = sheet.getRows();
        columns = sheet.getColumns();
        //为了返回值是Object[][],定义一个多行单列的二维数组
        HashMap<String,String>[][] arrmap = new HashMap[rows-1][1];
        //对数组中所有元素hashmap进行初始化
        if (rows>1){
            for (int i = 0;i<rows-1;i++){
                arrmap[i][0] = new HashMap<>();
            }
        }else {
            System.out.println("excel表格中没有数据");
        }

        //获得首行列名作为hashmap的key值
        for (int c = 0;c<columns;c++){
            String cellvalue = sheet.getCell(c,0).getContents();
            arrkey.add(cellvalue);
        }

        //遍历所有单元格的值添加到hashmap中
        for (int r = 1;r<rows;r++){
            for (int c = 0;c<columns;c++){
                String cellvalue = sheet.getCell(c,r).getContents();
                arrmap[r-1][0].put(arrkey.get(c),cellvalue);
            }
        }
        return arrmap;
    }

    /**
     * 获取excel的路径
     * @return
     */
    public String getPath() throws IOException {

        File directory = new File(".");
        sourceFile = directory.getCanonicalPath()+"/src/resources/"+fileName+".xls";
        //sourceFile = "/Users/wangling/IdeaProjects/fenxitest2/src/resources/testdata.xls";

        return sourceFile;
    }
}
