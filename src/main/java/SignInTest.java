import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignInTest extends CommonActions  {

    WebDriver driver = new ChromeDriver(options());
    
    By yourTripsBtn = By.linkText("Your trips");
    By signIn = By.id("SignIn");
    By signInButton = By.id("signInButton");
    By errorMsg = By.id("errors1");

    @Test
    public void shouldThrowAnErrorIfSignInDetailsAreMissing() {

        setDriverPath();

        driver.get("https://www.cleartrip.com/");
        
        waitFor(500);
        
        Click(yourTripsBtn);
        Click(signIn);

        waitFor(2000);
        driver.switchTo().frame("modal_window");
        
        Click(signInButton);
        
        String error = driver.findElement(errorMsg).getText();
        Assert.assertTrue(error.contains("There were errors in your submission"), "Error message not thrown when submitting empty credentials");
        
        driver.quit();
    }
    
    private void Click(By by){
    	driver.findElement(by).click();
    }

}
