package Packsun;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Opefile {
	
	
	@Test
	public static void GtmetrixautomationReport() throws BiffException, IOException {
		
		//-------------------BROWSER LAUNCH-----------------------------------	
		String FilePath = "C:\\Users\\SeerthyJayaramanJ\\jarfile\\GtMetrixauto.xls";
		FileInputStream fs = new FileInputStream(FilePath);
		Workbook wb = Workbook.getWorkbook(fs);
		Sheet sh = wb.getSheet(1);
		Reporter.log( "=========================Rentals Gtmetrix Analysis=========================",  true );
		for(int i=1;i<11;i++) {
			
			String URL = sh.getCell(0,i).getContents();
			//WebDriver driver=new FirefoxDriver();  
			WebDriver driver= new ChromeDriver();
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\SeerthyJayaramanJ\\workspace\\SP\\drivers\\chromedriver.exe");
			
		
			/*
			System.setProperty("webdriver.gecko.driver","C:\\Users\\sritharancc\\eclipse\\Drive\\geckodriver.exe");
				*/
			 
			driver.get("https://gtmetrix.com/");	
			driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
			     // LOGIN NEED TO DO 
			     driver.findElement(By.xpath("//*[@id=\"user-nav-login\"]/a")).click();
			     driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
			     driver.findElement(By.xpath("//*[@id=\"li-email\"]")).sendKeys("spchennaijpc1@gmail.com");
			     driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
			     driver.findElement(By.xpath("//*[@id=\"li-password\"]")).sendKeys("sp*property!");
			     driver.findElement(By.xpath("//*[@id=\"menu-site-nav\"]/div[2]/div[1]/form/div[4]/button")).click();
			     
			driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
			
			ProcessURLs(URL, driver, i);
			
			
		}
		
		System.out.println("Completed");
		
	}
	
	
	

	public static void ProcessURLs(String URL,WebDriver driver, int i) throws IOException, BiffException {
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);				
		//Thread.sleep(4000);
	          //LOGIN NEED TO DO
		      driver.findElement(By.xpath("/html/body/div[1]/main/article/form/div[1]/div[1]/div/input")).sendKeys(URL);
		      driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		      driver.findElement(By.xpath("/html/body/div[1]/main/article/form/div[3]/a")).click();
		      driver.findElement(By.id("af-browser")).click();
		      driver.findElement(By.xpath("//*[@id=\"af-browser\"]/option[1]")).click();
		      
		      driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		      driver.findElement(By.xpath("/html/body/div[1]/main/article/form/div[1]/div[2]/button")).click();
		       
	//	driver.findElement(By.xpath("/html/body/div[1]/main/article/section[1]/div/form/div/div[1]/div/input")).sendKeys(URL);
		//driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		//driver.findElement(By.xpath("/html/body/div[1]/main/article/section[1]/div/form/div/div[2]/button")).click();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);		
		WebElement TxtBoxContent1 = driver.findElement(By.xpath("/html/body/div[1]/main/article/div[2]/div[1]/div/div[1]/span/span"));
		String Txt1 = TxtBoxContent1.getText();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		WebElement TxtBoxContentcolor1 = driver.findElement(By.xpath("/html/body/div[1]/main/article/div[2]/div[1]/div/div[1]/i"));
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		String Color1 = TxtBoxContentcolor1.getAttribute("class");
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		
		
		
		
		if(Color1.equalsIgnoreCase("site-average sprite-average-even hover-tooltip tooltipstered")) {
			//System.out.println("Url :"+URL +"\nScore"   +         Txt1 + "\nMedium");
			//Reporter.log(URL + "  Score : " + Txt1 + " : Medium ",  true );
			//Reporter.log(i);
			
			Reporter.log( i + ")"   + "Url :        " + URL);
			Reporter.log("  Page speed score :"        + Txt1);
			Reporter.log("  Grade : Medium");
			//Reporter.log("<font color='green'>PASS</font>");
			Reporter.log("==================================================================================");
		}
		else if(Color1.equalsIgnoreCase("site-average sprite-average-above hover-tooltip tooltipstered")) {
		//	System.out.println("Url : "+ URL +"\nScore "   +         Txt1 + "\nHigh");
			//Reporter.log(URL + "   Score : " + Txt1 + " : High ",  true );
			Reporter.log( i + ")"   + "Url :        " + URL);
			Reporter.log("Page speed score :"        + Txt1);
			Reporter.log("Grade : High");
			Reporter.log("==================================================================================");
			

			driver.close();
			
		} 
		else if(Color1.equalsIgnoreCase("site-average sprite-average-below hover-tooltip tooltipstered")) {
			//System.out.println("Url : "+ URL +"\nScore  " +          Txt1 + "\nLow");
			//Reporter.log(URL + "   Score :  " + Txt1 + " : Low ",  true );
			Reporter.log( i + ")"   + "Url :        " + URL);
			Reporter.log("Page speed score :"        + Txt1);
			Reporter.log("Grade : Low");
			
			Reporter.log("==================================================================================");
		}	
		
	
		
		//driver.findElement(By.xpath("/html/body/div[1]/header/div/nav/ul/li[1]/a/i")).click();
		   
	}	
	
	
	
}
