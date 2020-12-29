import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Swyns Oscar & De Roover Lobke
 */

public class HomePage extends Page {

    @FindBy(id = "login")//lobke aanmelden
    private WebElement loginButton;

    @FindBy(id = "userid")//lobke useridlogin
    private WebElement userID;

    @FindBy(id = "password")//lobke passwordlogin
    private WebElement password;

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver.get(getPath() + "?command=Home");
        //lobke Index
    }

    public void setUserID(String userID) {
        this.userID.clear();
        this.userID.sendKeys(userID);
    }

    public void setPassword(String password) {
        this.password.clear();
        this.password.sendKeys(password);
    }

    public HomePage submitValid() {
        loginButton.click();
        return PageFactory.initElements(driver,HomePage.class);
    }

}