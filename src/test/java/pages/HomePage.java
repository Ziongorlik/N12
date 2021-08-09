package pages;

import org.openqa.selenium.By;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HomePage extends BasePage{

    public void navigateToPoliticsPage(){
        clickElement(By.linkText("פוליטי"));
    }

    public void navigateToWeatherPage(){
        clickElement(By.className("weather-slider"));
    }

    public void scrollToFooter(){
        scrollToElement(By.cssSelector("div[class='wrapper'"));
    }

    public boolean isMenuVisible(){
        return isElementVisible(By.className("sticky"));
    }

    public boolean chkDate(){
        String todayDate = new SimpleDateFormat("EEE dd.MM.yy").format(new Date());
        String time = getElementAttribute(By.className("date"),"innerText");
        return time.equals(todayDate);
    }
}
