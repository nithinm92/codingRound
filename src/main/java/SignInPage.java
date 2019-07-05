import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage {
	
	private WebDriver driver;
	private CommonActions common;
	
	public SignInPage(WebDriver driver)
	{
		this.driver = driver;
		common = new CommonActions(this.driver);
	}
    
    private By yourTripsBtn = By.linkText("Your trips");
    private By signIn = By.id("SignIn");
    private By signInButton = By.id("signInButton");
    private By errorMsg = By.id("errors1");
    
    protected void Openwebsite()
    {
    	common.getWebSite("https://www.cleartrip.com");
    }
    
    protected void NavigateToSignInPage()
    {
    	common.Click(yourTripsBtn);
    	common.Click(signIn);
    }
    
    protected void SwitchToSignInPageFrame()
    {
    	driver.switchTo().frame("modal_window");
    }
    
    protected void SubmitSignInCredentials()
    {
    	common.Click(signInButton);
    }
    
    protected String GetsignInErrorMessage()
    {
    	return driver.findElement(errorMsg).getText();
    }
}
