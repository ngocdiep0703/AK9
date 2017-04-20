package Supports;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by dell3446 on 12/10/2016.
 */
public class CommonFunctions {
    public static WebDriver selectBrowser(BROWSERNAME browsername){

        WebDriver driver = null;
        if (browsername == BROWSERNAME.FF){
            System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver");
            driver = new FirefoxDriver();
        }else if (browsername == BROWSERNAME.CHROME) {
            System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver");
            driver = new ChromeDriver();}
//        }else if (browsername == BROWSERNAME.IE) {
//            System.setProperty("webdriver.ie.driver", "./Drivers/IEDriverServer.exe");
//            driver = new InternetExplorerDriver();
//        }
//        else if (browsername == BROWSERNAME.EDGE) {
//            System.setProperty("webdriver.edge.driver", "./Drivers/MicrosoftWebDriver.exe");
//            driver = new EdgeDriver();
//        }
        return driver;

    }
    public enum BROWSERNAME{
        IE,FF,CHROME,EDGE

    }

    /**
     *
     * @param driver
     * @param how
     * @param locator
     * @return
     */
    public static WebElement get_element(WebDriver driver,ObjectType how,String locator){
        WebElement el = null;
        switch (how) {
            case ID:
                el = driver.findElement(By.id(locator));
                break;
            case NAME:
                el = driver.findElement(By.name(locator));
                break;
            case LINK:
                el = driver.findElement(By.className(locator));
                break;
            case CLASS:
                break;
            case XPATH:
                el = driver.findElement(By.xpath(locator));
                break;
            case CSS:
                el = driver.findElement(By.cssSelector(locator));
                break;
            default:
                el = null;
                break;
        }
        return el;
    }

    public static enum ObjectType{
        ID,NAME,LINK,CLASS,XPATH,CSS
    }

    public static void fill_in(WebDriver driver,ObjectType how,String locator,String text){
        get_element(driver, how ,locator).clear();
        get_element(driver, how ,locator).sendKeys(text);

    }


//    public void select(WebDriver driver,String dd,String sl){
//        Select dropdown = new Select(driver.findElement(By.id(dd)));
//        dropdown.selectByVisibleText(sl);
//    }

}
