package phase1proj;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Productsear {

	public static void main(String[] args) {
		
System.setProperty("WebDriver.Chrome.driver", "ChromeDriver.exe");
WebDriver driver = new ChromeDriver();
//amazon web site

driver.get("https://www.amazon.in/");
// TODO Auto-generated method stub
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(5000,TimeUnit.MILLISECONDS);

//search product
WebElement searchtext = driver.findElement(By.id("twotabsearchtextbox"));
searchtext.sendKeys("samsung");

//search text
WebElement searchbutton = driver.findElement(By.id("nav-search-submit-button"));
searchbutton.click();

//product xpath
List<WebElement> AllProduct = driver.findElements(By.xpath("//div[@data-component-type='s-search-result']//h2"));
//price xpath
List<WebElement> AllPrice = driver.findElements(By.xpath("//div[@data-component-type='s-search-result']//span[@class='a-price']"));

System.out.println("Total product found" +AllProduct.size());

//for all product and their prices
for(int i=0; i<AllProduct.size(); i++)
	
{
System.out.println(AllProduct.get(i).getText()+ " " +AllPrice.get(i).getText());
	
    }

 String ParentWH=driver.getWindowHandle();
 
String ExpectedValue = AllProduct.get(0).getText();
AllProduct.get(0).click();

//parent child window
 Set<String> AllWindowHandler =driver.getWindowHandles();
 
for(String win:AllWindowHandler) {
	System.out.println(win);
	
if(!win.equals(ParentWH))
{
	driver.switchTo().window(win);
}

WebElement title = driver.findElement(By.id("productTitle"));

String str = title.getText();

if(str.equals(ExpectedValue))
{
	System.out.println("matching");
	
}else
{
	System.out.println("not matching");
	
}
driver.quit();
}
}


// TODO Auto-generated method stub

	}


