import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
  
  public class FlightBookingTest {
  
  WebDriver driver = new ChromeDriver(options());
  
  By originCity = By.xpath(".//ul[@id='ui-id-1']/li");
  By destinationCity = By.xpath(".//ul[@id='ui-id-2']/li");
  By fromTextBox = By.id("FromTag");
  By toTextBox = By.id("ToTag");
  By dateCalender = By.xpath("//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr[3]/td[7]/a");
  By SearchBtn = By.id("SearchBtn");
  By searchSummary = By.className("searchSummary");
  
  @Test public void testThatResultsAppearForAOneWayJourney() {
  
  setDriverPath();
  
  driver.get("https://www.cleartrip.com/");
  
  //waitFor(2000);
  
  Click(By.id("OneWay"));
  
  CloseAlert();
  
  // Search and select origin city ClearAndSendKeys(fromTextBox, "Bangalore");
  
  WebDriverWait wait = new WebDriverWait(driver, 20);
  wait.until(ExpectedConditions.elementToBeClickable(originCity));
  
  List<WebElement> originOptions = driver.findElements(originCity);
  originOptions.get(0).click();
  
  // Search and select destination city ClearAndSendKeys(toTextBox, "Delhi");
  
  wait.until(ExpectedConditions.elementToBeClickable(destinationCity));
  
  //select the first item from the destination auto complete list
  List<WebElement> destinationOptions = driver.findElements(destinationCity);
  destinationOptions.get(0).click();
  
  Click(dateCalender);
  
  //all fields filled in. Now click on search Click(SearchBtn);
  
  //waitFor(6000);
  
  //verify that result appears for the provided journey search
  Assert.assertTrue(isElementPresent(searchSummary),
  "Search summary not present");
  
  //close the browser driver.quit();
  
  }
  
  private boolean isElementPresent(By by) { try { driver.findElement(by);
  return true; } catch (NoSuchElementException e) { return false; } }
  
  private void ClearAndSendKeys(By by, String data){
  driver.findElement(by).clear(); driver.findElement(by).sendKeys(data); }
  
  private void Click(By by)
  {
	  driver.findElement(by).click();
  }
  
  private void CloseAlert()
  {
	  try { driver.switchTo().alert().accept();
  }
  catch(Exception e)
	  {
	  	//ignore exception
	  }
	  
  }
  
 