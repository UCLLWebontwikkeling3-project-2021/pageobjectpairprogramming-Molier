import org.openqa.selenium.WebDriver;

/**
 * @author Swyns Oscar & De Roover Lobke
 */


public abstract class Page {

    protected WebDriver driver;
    private String path = "http://localhost:8080/Controller";

    public Page (WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public String getPath() {
        return path;
    }

    public String getTitle () {
        return driver.getTitle();
    }

}
