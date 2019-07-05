import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class FlightBookingPage {
	
	private WebDriver driver;
	WebDriverWait wait;
	private CommonActions common;
	
	public FlightBookingPage(WebDriver driver)
	{
		this.driver = driver;
		common = new CommonActions(this.driver);
		wait = new WebDriverWait(driver, 20);
	}
	
	By oneWay = By.id("OneWay");
	By originCity = By.xpath(".//ul[@id='ui-id-1']/li");
	By destinationCity = By.xpath(".//ul[@id='ui-id-2']/li");
	By fromTextBox = By.id("FromTag");
	By toTextBox = By.id("ToTag");
	By dateCalender = By.xpath("//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr[3]/td[7]/a");
	By SearchBtn = By.id("SearchBtn");
	By searchSummary = By.className("searchSummary");
		
    protected void Openwebsite()
    {
    	common.getWebSite("https://www.cleartrip.com");
    }
    
	protected void ClickOneWay()
	{
		common.Click(oneWay);
	}
	
	protected void SearchAndSelectOriginCity(String data)
	{
		common.ClearAndSendData(fromTextBox, data);
		
		wait.until(ExpectedConditions.elementToBeClickable(originCity));
		
		List<WebElement> originOptions = driver.findElements(originCity);
		common.Click(originOptions.get(0));
	}
	
	protected void SearchAndSelectDestinationCity(String data)
	{
		common.ClearAndSendData(toTextBox, data);
		
		wait.until(ExpectedConditions.elementToBeClickable(destinationCity));
		
		List<WebElement> destinationOptions = driver.findElements(destinationCity);
		common.Click(destinationOptions.get(0));
	}
	
	protected void SelectDate()
	{
		common.Click(dateCalender);
	}
	
	protected void Submit()
	{
		common.Click(SearchBtn);
	}
	
	protected void SearchSummary()
	{
		wait.until(ExpectedConditions.elementToBeClickable(searchSummary));
		
		Assert.assertTrue(common.IsElementPresent(searchSummary), "Search summary not present");
	}
}
