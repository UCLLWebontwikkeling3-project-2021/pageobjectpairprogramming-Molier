import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Swyns Oscar & De Roover Lobke
 */


public class SignUpPage extends Page {

    @FindBy(id="userid")
    private WebElement userid;

    @FindBy(id="firstName")
    private WebElement firstName;

    @FindBy(id="lastName")
    private WebElement lastName;

    @FindBy(id="email")
    private WebElement email;

    @FindBy(id="password")
    private WebElement password;

    @FindBy(id="signUp")
    private WebElement signUpButton;

    public SignUpPage (WebDriver driver) {
        super(driver);
        this.driver.get(getPath()+"?command=Register");
    }

    public void setUserid(String userid) {
        this.userid.clear();
        this.userid.sendKeys(userid);
    }

    public void setFirstName(String firstName) {
        this.firstName.clear();
        this.firstName.sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        this.lastName.clear();
        this.lastName.sendKeys(lastName);
    }

    public void setEmail(String email) {
        this.email.clear();
        this.email.sendKeys(email);
    }

    public void setPassword(String password) {
        this.password.clear();
        this.password.sendKeys(password);
    }

    public HomePage submitValid() {
        signUpButton.click();
        return PageFactory.initElements(driver,HomePage.class);
    }

    public void submitInvalid() {
        signUpButton.click();
    }

    public boolean hasErrorMessage (String message) {
        WebElement errorMsg = driver.findElement(By.cssSelector("div.alert-danger ul li"));
        return (message.equals(errorMsg.getText()));
    }

    public boolean hasStickyLastName (String lastname) {
        return lastname.equals(lastName.getAttribute("value"));
    }

    public boolean hasStickyEmail (String email) {
        return email.equals(this.email.getAttribute("value"));
    }

    public boolean hasEmptyFirstName () {
        return firstName.getAttribute("value").isEmpty();
    }

}