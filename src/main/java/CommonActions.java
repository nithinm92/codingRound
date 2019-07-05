import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonActions {

	private WebDriver driver;
    private WebDriverWait wait;
	
	public CommonActions(WebDriver driver)
	{
		this.driver = driver;
		wait = new WebDriverWait(this.driver, 20);
	}
	
	public CommonActions()
	{
		// empty constructor
	}
	
    protected void setDriverPath() {
    	
    	String systemType = System.getProperty("os.name").toLowerCase();
    	
        if (systemType.contains("mac")) {
            System.setProperty("webdriver.chrome.driver", "chromedriver");
        }
        if (systemType.contains("windows")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\NithinM\\Documents\\GitHub\\codingRound\\chromedriver.exe");
        }
        if (systemType.contains("linux")) {
            System.setProperty("webdriver.chrome.driver", "chromedriver_linux");
        }
    }
    
    protected void getWebSite(String url)
    {
    	driver.get(url);
    }
    
    protected ChromeOptions options()
    {
    	ChromeOptions options = new ChromeOptions();
		options.setBinary("C:\\Users\\NithinM\\Documents\\google\\GoogleChromePortable\\App\\Chrome-bin\\chrome.exe");
		options.addArguments("--disable-notifications");
		
		return options;
    }
    
    public void Click(By by){
        wait.until(ExpectedConditions.elementToBeClickable(by));
    	driver.findElement(by).click();
    }
}
