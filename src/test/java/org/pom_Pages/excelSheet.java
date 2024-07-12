package org.pom_Pages;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class excelSheet {
	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream(
				"./src/test/resources/org/excelFiles/TestData.xlsx");
			Workbook wb = WorkbookFactory.create(fis);
			Sheet s = wb.getSheet("StringTypes");
			for(int i=0; i<=s.getLastRowNum(); i++)	{	//0,1,2,3
				for(int k=0; k<s.getRow(i).getLastCellNum(); k++) {	//3,4,6,5
					
					
					System.out.println(s.getRow(i).getCell(k).getStringCellValue());
				}
				System.out.println();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
