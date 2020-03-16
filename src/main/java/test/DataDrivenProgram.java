/**
 * 
 */
package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author Sunil Kashyap
 *
 * Created Date 21-Feb-2019
 */
public class DataDrivenProgram {
	public static void main(String[] args) throws Exception,FileNotFoundException, IOException {
		
		File file= new File("‪C://Users//aes0198//Desktop//testdata.xlsx");
		
		FileInputStream fis=new FileInputStream(file);
		XSSFWorkbook xSSFWorkbook=new XSSFWorkbook(fis);
		XSSFSheet sheet = xSSFWorkbook.getSheetAt(0);
		XSSFRow row = sheet.getRow(0);
		XSSFCell cell = row.getCell(0);
		System.out.println(cell);
		System.out.println("printe");
	}

}
