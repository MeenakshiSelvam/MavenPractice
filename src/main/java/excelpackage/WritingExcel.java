package excelpackage;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class WritingExcel {
    @Test
    public void write() throws IOException {
        XSSFWorkbook workbook =new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("EMP SHEET");

        Object empdata[][]= {
                {"EmpID", "Name","Job"},
                {101,"david","Engineer"},
                {102,"sutan","manager"},
                {103,"iniya","manager"}
        };

//        // 1- using for loop
//        int rows = empdata.length;
//        int cols = empdata[0].length;
//
//        for(int r=0; r<rows;r++)
//        {
//            XSSFRow row = sheet.createRow(r);
//            for(int c = 0; c<cols;c++)
//            {
//                XSSFCell cell = row.createCell(c);
//                Object value = empdata[r][c];
//
//                if(value instanceof  String)
//                    cell.setCellValue((String) value);
//                if(value instanceof  Integer)
//                    cell.setCellValue((Integer) value);
//                if(value instanceof Boolean)
//                    cell.setCellValue((Boolean) value);
//
//
//            }
//        }

        // 2- using For...each loop

        int rowCount = 0;
        for(Object emp[]:empdata)
        {
            XSSFRow row = sheet.createRow(rowCount++);
            int columnCount=0;
            for(Object value : emp)
            {
                XSSFCell cell = row.createCell(columnCount++);
                if(value instanceof  String)
                    cell.setCellValue((String) value);
                if(value instanceof  Integer)
                    cell.setCellValue((Integer) value);
                if(value instanceof Boolean)
                    cell.setCellValue((Boolean) value);



            }
        }

        //3 - same for each but with arraylist empdata

//        ArrayList<Object[]> empdata2 = new ArrayList<Object[]>();
//        empdata2.add(new Object[]{"EmpId","name","Job"});
//        empdata2.add(new Object[]{101,"ashok","manager"});
//
//
//        int rowCount2 = 0;
//        for(Object[] emp:empdata2)
//        {
//            XSSFRow row = sheet.createRow(rowCount2++);
//            int columnCount2=0;
//            for(Object value : emp)
//            {
//                XSSFCell cell = row.createCell(columnCount2++);
//                if(value instanceof  String)
//                    cell.setCellValue((String) value);
//                if(value instanceof  Integer)
//                    cell.setCellValue((Integer) value);
//                if(value instanceof Boolean)
//                    cell.setCellValue((Boolean) value);
//
//
//
//            }
//        }













        String filepath = "datafiles/employee.xlsx";
        //it will create file and write to it.
        FileOutputStream outputStream = new FileOutputStream(filepath);
        workbook.write(outputStream);
        outputStream.close();

    }
}
