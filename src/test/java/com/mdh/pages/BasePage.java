package com.mdh.pages;

import com.mdh.utils.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    public WebDriver driver;
    public WebDriverWait wait;

    public BasePage(WebDriver wd) {
        this.driver = wd;
        wait = new WebDriverWait(driver, Properties.LONG_WAIT);
    }

    public void clickElement(WebElement x) {
        int timeElapsed = 0;
        while(timeElapsed < Properties.LONG_WAIT) {
            try {
                x.click();
                break;
            } catch (Exception e) {
                System.out.println("No se le pudo dar click");
                try {
                    Thread.sleep(50);
                }catch(InterruptedException ie) {}
                timeElapsed += 50;
            }
        }
    }

}
