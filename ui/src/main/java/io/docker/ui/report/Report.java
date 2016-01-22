package io.docker.ui.report;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import io.docking.core.Docking;
import io.docking.core.DockingPlan;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *@author daniel on 08/01/16.
 */
public class Report {

	public String CreateXLS(DockingPlan dockings) {
		String sRetValue = "";
		
		// Blank workbook
		XSSFWorkbook workbook = new XSSFWorkbook();

		// Create a blank sheet
		XSSFSheet sheet = workbook.createSheet("Dockings");

		// Map data
		Map<String, Object[]> data = new TreeMap<String, Object[]>();
		data.put("1", new Object[] { "Dockinglist" }); // Header
		data.put("1", new Object[] { "Train", "Separation", "Rail" }); //Tableheader
		int i = 2;
		for (Docking dock : dockings.getDockings()) {
			data.put(String.valueOf(i), new Object[] { dock.getDestinationBatch(),
					dock.getSourceBatchIndex(), dock.getSourceBatch() }); // data rows
			i++;
		}

		// Iterate over data and write to sheet
		Set<String> keyset = data.keySet();
		int rownum = 0;
		for (String key : keyset) {
			Row row = sheet.createRow(rownum++);
			Object[] objArr = data.get(key);
			int cellnum = 0;
			for (Object obj : objArr) {
				Cell cell = row.createCell(cellnum++);
				if (obj instanceof String)
					cell.setCellValue((String) obj);
				else if (obj instanceof Integer)
					cell.setCellValue((Integer) obj);
			}
		}
		try {
			// Write the workbook in file system
			String sPath = System.getProperty("user.home") + "\\Dockinglist.xlsx";
			FileOutputStream out = new FileOutputStream(new File(sPath));
			workbook.write(out);
			out.close();
			sRetValue = "File written successfully (" + sPath + ")";
			System.out.println("File written successfully (" + sPath + ")");
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return sRetValue;
	}
}
