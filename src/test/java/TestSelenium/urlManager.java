package TestSelenium;

import java.io.IOException;

public class urlManager extends Implementation{
	//1 Opening the url
		public void openUrl() throws IOException{
			
			// getting the url
			String file=System.getProperty("user.dir")+"//Test_Data//testexcel.xlsx";
			String baseURL = ExcelUtils.getCellData(file, "Sheet1", 1, 0); //Read URL from testexcel.xlsx, Sheet1
			
			driver.get(baseURL);
			
			
			// Validating if the URL is opened properly or not
			if(driver.getCurrentUrl().equals(baseURL)) {
				ExcelUtils.setCellData(file, "Sheet1", 1, 1, "Passed/Opened"); // Write result to testexcel.xlsx, Sheet1
				ExcelUtils.fillGreenColor(file, "Sheet1", 1, 1);
			}else {
				ExcelUtils.setCellData(file, "Sheet1", 1, 1, "Failed/Unable to Open"); // Write result to testexcel.xlsx, Sheet1
				ExcelUtils.fillRedColor(file, "Sheet1", 1, 1);
			}
		}
}
