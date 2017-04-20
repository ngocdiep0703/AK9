package Modules;

import Libraries.BmiFunctions;
import Objects.BmiPage;
import Supports.CommonFunctions;
import org.openqa.selenium.WebDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BMI {

    public WebDriver driver;

    @BeforeMethod
    public void setUp()
    {
        //session khoi tao
        driver =CommonFunctions.selectBrowser(CommonFunctions.BROWSERNAME.CHROME);
        driver.navigate().to("http://www.calculator.net/bmi-calculator.html");
        driver.manage().window().maximize();

    }

    @Test

    public void TC1() {
//        WebDriver driver = CommonFunctions.selectBrowser(CommonFunctions.BROWSERNAME.CHROME );
//        driver.navigate().to("http://www.calculator.net/bmi-calculator.html");
//        driver.manage().window().maximize();
//
//        CommonFunctions.get_element(driver, CommonFunctions.ObjectType.XPATH,".//a[text()='Metric Units']").click();
//        //CommonFunctions.get_element(driver, CommonFunctions.ObjectType.ID,"cage").clear();
////        CommonFunctions.get_element(driver, CommonFunctions.ObjectType.ID,"cage").sendKeys("23");
//        CommonFunctions.fill_in(driver, CommonFunctions.ObjectType.ID ,"cage","23");
//        CommonFunctions.get_element(driver, CommonFunctions.ObjectType.ID,"csex2").click();
//        CommonFunctions.fill_in(driver, CommonFunctions.ObjectType.NAME,"cheightmeter","130");
//        CommonFunctions.fill_in(driver,CommonFunctions.ObjectType.NAME,"ckg","50");
//        CommonFunctions.get_element(driver, CommonFunctions.ObjectType.XPATH,".//input[@alt=\"Calculate\"]").click();
//        String bmi = CommonFunctions.get_element(driver, CommonFunctions.ObjectType.CSS,".bigtext").getText();
//        System.out.println(bmi);


        // goi class de su dung Page.doituong.action
//        BmiPage bmiPage = new BmiPage(driver); //truyen driver de tao tren session khoi tao
//        bmiPage.metric_tab.click();
//        bmiPage.txt_age.sendKeys("23");
//        bmiPage.rad_female.click();
//        bmiPage.txt_height.sendKeys("130");
//        bmiPage.txt_weight.sendKeys("50");
//        bmiPage.btn_calculate.click();
//        bmiPage.lbl_bmi_result.getText();

        //ke thua

        BmiFunctions bmiPage = new BmiFunctions(driver);
        bmiPage.select_tab();
        bmiPage.fill_bmi_form("23","female","130", "50");
        bmiPage.click_calculate_button();
        bmiPage.get_bmi_result();

        //Test mong doi
        AssertJUnit.assertEquals("BMI = 29.59 kg/m2   (Overweight)", bmiPage.get_bmi_result());

    }

    @AfterMethod
    public void tearDown()
    {
        System.out.print("Run after each test");
        driver.quit();
    }
}
