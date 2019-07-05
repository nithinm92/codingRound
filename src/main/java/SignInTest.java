import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;

public class SignInTest  {

	private WebDriver driver;
    private CommonActions common;
    private SignInPage signIn;
    
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
    	signIn = new SignInPage(driver);
       	signIn.Openwebsite();
    }
    
    
	@AfterMethod
	public void Close() 
	{ 
		// close chrome browser instance
		driver.quit();
	}
	
    
    @Test
    public void shouldThrowAnErrorIfSignInDetailsAreMissing() {
       
    	signIn.NavigateToSignInPage();
    	
        signIn.SwitchToSignInPageFrame();
        
        signIn.SubmitSignInCredentials();
        
        String error = signIn.GetsignInErrorMessage();
        Assert.assertTrue(error.contains("There were errors in your submission"), "Error message not thrown when submitting empty credentials");
    }
}
