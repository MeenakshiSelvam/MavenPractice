package excelpackage;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadingExcel {
    @Test
    public void read() throws IOException {


        String path = "datafiles/Testng.xlsx";
        FileInputStream inputStream = new FileInputStream(path);
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = workbook.getSheetAt(0);




        // 1- using for loop

     int rows =sheet.getLastRowNum();
     int cols = sheet.getRow(1).getLastCellNum();

     for(int r=0;r<=rows;r++)
     {
         XSSFRow row = sheet.getRow(r);

         for(int c=0;c<cols;c++)
         {
             XSSFCell cell =row.getCell(c);

             switch(cell.getCellType()) {
                 case STRING:
                     System.out.println(cell.getStringCellValue());
                     break;
                 case NUMERIC:
                     System.out.println(cell.getNumericCellValue());
                     break;
                 case BOOLEAN:
                     System.out.println(cell.getBooleanCellValue());
                     break;
             }
         }
             System.out.println();
     }



//        // 2- Using iterator
//        //it takes all the rows
//        Iterator iter = sheet.iterator();
//
//        //if it has value,
//        while(iter.hasNext())
//        {
//            XSSFRow row = (XSSFRow) iter.next();
//            Iterator cellIterator = row.cellIterator();
//            while(cellIterator.hasNext())
//            {
//                XSSFCell cell = (XSSFCell) cellIterator.next();
//
//                switch(cell.getCellType())
//                {
//                    case STRING:
//                        System.out.print(cell.getStringCellValue());
//                        break;
//                    case NUMERIC:
//                        System.out.print(cell.getNumericCellValue());
//                        break;
//                    case BOOLEAN:
//                        System.out.print(cell.getBooleanCellValue());
//                        break;
//
//                }
//                System.out.print("  |  ");
//            }
//            System.out.println();
//        }
//
    }
}