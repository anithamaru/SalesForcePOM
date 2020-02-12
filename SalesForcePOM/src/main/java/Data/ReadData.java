package Data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import Base.baseSF;

public class ReadData extends baseSF{
 public String[][] getInputData(String filePath,String sheetName) throws Exception{
	// Get the Xl path
	 int i;
	 int j = 0;
				File xlFile = new File(filePath);
				// Access to xl path
				FileInputStream xlDoc = new FileInputStream(xlFile);
				// Access the workbook
				HSSFWorkbook wb = new HSSFWorkbook(xlDoc);
				// Access the sheet
				HSSFSheet sheet = wb.getSheet(sheetName);
				int rowCount=sheet.getLastRowNum()+1;
				int columnCount=sheet.getRow(0).getLastCellNum();
//				System.out.println("rowCount: "+rowCount);
//				System.out.println("columnCount: "+columnCount);
				
				String[][] readData = new String[rowCount][columnCount];
				for ( i = 0; i <rowCount; i++) {
					for ( j = 0; j < sheet.getRow(i).getLastCellNum(); j++) {
						readData[i][j] = sheet.getRow(i).getCell(j).getStringCellValue();
						//System.out.println(readData[i][j]);
					}
				}
				return readData;

	 
 }


}
