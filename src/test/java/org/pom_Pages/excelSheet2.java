package org.pom_Pages;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class excelSheet2 {
	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream(
				"./src/test/resources/org/excelFiles/TestData.xlsx");
			Workbook wb = WorkbookFactory.create(fis);
			Sheet s = wb.getSheet("StringTypes");
			
			   Row name = s.getRow(1);
			   
			   Cell name1 =     name.getCell(0);
			   
			   System.out.println(name1);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
