import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HotelBookingPage {
	
	private WebDriver driver;
	private CommonActions common;
	WebDriverWait wait;
	
	public HotelBookingPage(WebDriver driver)
	{
		this.driver = driver;
		common = new CommonActions(this.driver);
		wait = new WebDriverWait(this.driver, 20);
		PageFactory.initElements(this.driver, this);
	}
	
    @FindBy(linkText = "Hotels")
    private WebElement hotelLink;
    
    @FindBy(id = "Tags")
    private WebElement localityTextBox;
    
    @FindBy(id = "SearchHotelsButton")
    private WebElement searchButton;
    
    @FindBy(xpath = ".//ul[@id='ui-id-1']/li[@class='list']")
    private WebElement searchResult;
    
    @FindAll(@FindBy(xpath = ".//ul[@id='ui-id-1']/li[@class='list']"))
    private List<WebElement> searchResults;
    
    @FindBy(name = "from")
    private WebElement from;
    
    @FindBy(id = "travellersOnhome")
    private WebElement travellerSelection;
	
    
    protected void Openwebsite()
    {
    	common.getWebSite("https://www.cleartrip.com");
    }
     
    protected void NavigateToHotelBookingPage()
    {
    	common.Click(hotelLink);
    }
    
    protected void SearchAndSelectHotelLocality(String data)
    {
    	common.SendData(localityTextBox, data);
    	
    	wait.until(ExpectedConditions.elementToBeClickable(searchResult));
    	common.Click(searchResults.get(0));
    }
    
    protected void SelectOccupency(String data)
    {
    	common.Click(from);
    	new Select(travellerSelection).selectByVisibleText(data);
    }
    
    protected void SearchHotel()
    {
    	common.Click(searchButton);
    }
    
}
