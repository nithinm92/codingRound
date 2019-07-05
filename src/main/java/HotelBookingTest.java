import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HotelBookingTest extends CommonActions {
	
	private WebDriver driver;
    private CommonActions common;
    private HotelBookingPage hotelBooking;
    
    @BeforeMethod
    public void Start()
    {
    	// set chromedriver path
    	common = new CommonActions();    	
    	common.setDriverPath();
    	
    	// inititalize chrome
    	driver = new ChromeDriver(common.options());
    	common = new CommonActions(driver);
    	
    	// inititalize SignInPage class object
    	hotelBooking = new HotelBookingPage(driver);
    	hotelBooking.Openwebsite();
    }
    
    
	@AfterMethod
	public void Close() 
	{ 
		// close chrome browser instance
		driver.quit();
	}
    
    @Test
    public void shouldBeAbleToSearchForHotels() {
    	
    	hotelBooking.NavigateToHotelBookingPage();

    	hotelBooking.SearchAndSelectHotelLocality("Indiranagar, Bangalore");
    	
    	hotelBooking.SelectOccupency("1 room, 2 adults");
    	
    	hotelBooking.SearchHotel();
    }
}
