import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class CommonActions {

    protected void setDriverPath() {
    	
    	String systemType = System.getProperty("os.name").toLowerCase();
    	
        if (systemType.contains("mac")) {
            System.setProperty("webdriver.chrome.driver", "chromedriver");
        }
        if (systemType.contains("windows")) {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        }
        if (systemType.contains("linux")) {
            System.setProperty("webdriver.chrome.driver", "chromedriver_linux");
        }
    }
    
    protected void waitFor(int durationInMilliSeconds) {
        try {
            Thread.sleep(durationInMilliSeconds);
        } catch (InterruptedException ex) {
            ex.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
	
    
    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

}
