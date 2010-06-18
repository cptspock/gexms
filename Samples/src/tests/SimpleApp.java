package tests;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class SimpleApp implements ActionListener {
	JFileChooser fileChooser;
	JFrame frame = new JFrame("GEXMS");

	public void createAndShowGUI() {
		// Create and set up the window.

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fileChooser = new JFileChooser();
		
		JButton browseButton = new JButton("Browse...");
		fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		frame.getContentPane().add(browseButton);
		browseButton.addActionListener(this);
		// Display the window.
		frame.pack();
		frame.setVisible(true);
	}

	public void actionPerformed(ActionEvent clicked) {
		int returnVal = fileChooser.showOpenDialog(frame.getContentPane());
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			try {
				POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(
						fileChooser.getSelectedFile()));
				HSSFWorkbook wb = new HSSFWorkbook(fs);
				HSSFSheet sheet = wb.getSheetAt(0);
				HSSFRow row;
				HSSFCell cell;
				int numOfRows = sheet.getPhysicalNumberOfRows();
				double totalExpense = 0;

				// sum of prices
				for (int i = 1; i < numOfRows; i++) {
					row = sheet.getRow(i);
					cell = row.getCell(2);
					totalExpense += cell.getNumericCellValue();
				}

				System.out.println("Total expense: " + totalExpense);
				// create piechart report
				DefaultPieDataset dataset = new DefaultPieDataset();
				dataset.setValue("Item A", new Integer(100));
				dataset.setValue("Item B", new Integer(200));
				dataset.setValue("Item C", new Integer(50));
				dataset.setValue("Item D", new Integer(75));
				dataset.setValue("Item E", new Integer(150));
				JFreeChart chart = ChartFactory.createPieChart3D(
						"Expenses chart", dataset, true, false, Locale.ENGLISH);
				ChartUtilities.saveChartAsPNG(new File("c:\\cme\\chart.png"),
						chart, 500, 500);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		// Schedule a job for the event-dispatching thread:
		// creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new SimpleApp().createAndShowGUI();
			}
		});
	}
}
