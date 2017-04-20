package Libraries;

import Objects.BmiPage;
import org.openqa.selenium.WebDriver;

/**
 * Created by Dell on 17/12/2016.
 */

//ke thua Bmi Page (cha la Bmi Page, con BmiFunctions)
public class BmiFunctions  extends BmiPage {
    public BmiFunctions(WebDriver driver) {
        super(driver); //super: element cac method ke thua
    }

    public  void select_tab()
    {
        System.out.println("Select Metric Unit tab");
        metric_tab.click();
    }

    public  void fill_bmi_form (String age, String gender, String height, String weight)
    {
        System.out.println("Fill BMI form");
        txt_age.clear();
        txt_age.sendKeys(age); //trong sendkeys truyen bien neu co

        if (gender.equalsIgnoreCase("male"))
            rad_male.click();
        else
            rad_female.click();

        txt_height.clear();
        txt_height.sendKeys(height);

        txt_weight.clear();
        txt_weight.sendKeys(weight);
    }

    public void click_calculate_button()
    {
        System.out.println("Click on Calculate button");
        btn_calculate.click();
    }

    public  String get_bmi_result()
    {
        return lbl_bmi_result.getText();
    }
}
