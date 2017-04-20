package Objects;

// Lưu đói tượng

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Dell on 17/12/2016.
 */
public class BmiPage {
    public WebDriver driver;
    //Goi facetory cho page: FindBy la khoi tao
    public BmiPage(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath=".//a[text()='Metric Units']")
    public WebElement metric_tab;
    @FindBy(id="cage")
    public WebElement txt_age;
    @FindBy(id="csex1")
    public WebElement rad_male ;
    @FindBy(id="csex2")
    public WebElement rad_female ;
    @FindBy(name="cheightmeter")
    public WebElement txt_height ;
    @FindBy(name="ckg")
    public WebElement txt_weight ;
    @FindBy(xpath=".//input[@alt=\"Calculate\"]")
    public WebElement btn_calculate ;
    @FindBy(css=".bigtext")
    public WebElement lbl_bmi_result ;




}

