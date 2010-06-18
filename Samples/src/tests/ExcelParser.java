package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Locale;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class ExcelParser {
	public static void main(String args[]){
		POIFSFileSystem fs;
		try {
			fs = new POIFSFileSystem(new FileInputStream("c:\\cme\\expenses.xls"));
			HSSFWorkbook wb = new HSSFWorkbook(fs);
		    HSSFSheet sheet = wb.getSheetAt(0);
		    HSSFRow row;
		    HSSFCell cell;
		    int numOfRows = sheet.getPhysicalNumberOfRows();
		    double totalPrice = 0;
		    
		    //sum of prices
		    for (int i=1; i < numOfRows; i++){
		    	row = sheet.getRow(i);
			    cell = row.getCell(1);
			    totalPrice += cell.getNumericCellValue();			    	
		    }		    
		    
		    System.out.println("Total price: " + totalPrice);
		    // create piechart report
		    DefaultPieDataset dataset = new DefaultPieDataset();
		    dataset.setValue("Item A", new Integer(100));
		    dataset.setValue("Item B", new Integer(200));
		    dataset.setValue("Item C", new Integer(50));
		    dataset.setValue("Item D", new Integer(75));
		    dataset.setValue("Item E", new Integer(150));		    
		    JFreeChart chart = ChartFactory.createPieChart3D("Expenses chart", dataset, true, false, Locale.ENGLISH);
		    ChartUtilities.saveChartAsPNG(new File("c:\\cme\\chart.png"), chart, 500, 500);
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
