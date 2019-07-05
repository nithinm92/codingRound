import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
  
  public class FlightBookingTest
  {  
	  private WebDriver driver;
	  private CommonActions common;
	  private FlightBookingPage flightBooking;
	  
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
		flightBooking = new FlightBookingPage(driver);
		flightBooking.Openwebsite();
	  }
	      
	  @AfterMethod
	  public void Close() 
	  { 
		// close chrome browser instance
		driver.quit();
	  }
	  
	  
	  @Test 
	  public void testThatResultsAppearForAOneWayJourney() 
	  {		  
		  flightBooking.ClickOneWay();
		  
		  common.CloseAlert();
		  
		  flightBooking.SearchAndSelectOriginCity("Bangalore");
		  
		  flightBooking.SearchAndSelectDestinationCity("Delhi");
		  
		  flightBooking.SelectDate();
		  
		  flightBooking.Submit();
		  
		  flightBooking.SearchSummary();
	  }
  
  }