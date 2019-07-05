import org.openqa.selenium.chrome.ChromeOptions;

public class CommonActions {

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
    
    protected ChromeOptions options()
    {
    	ChromeOptions options = new ChromeOptions();
		options.setBinary("C:\\Users\\NithinM\\Documents\\google\\GoogleChromePortable\\App\\Chrome-bin\\chrome.exe");
		options.addArguments("--disable-notifications");
		
		return options;
    }
    
    protected void waitFor(int durationInMilliSeconds) {
        try {
            Thread.sleep(durationInMilliSeconds);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }    
}
