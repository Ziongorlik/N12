package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeatherPage extends BasePage{
    List<WebElement> citiesNames;
    List<WebElement> citiesURL;
    Map<String,String> cities = new HashMap<String, String>();


    public boolean chkCityList(){
        citiesNames = getElementChildren(By.cssSelector("div[class='forcastMapWrap weatherSearch']"),"strong");
        citiesURL = getElementChildren(By.cssSelector("div[class='forcastMapWrap weatherSearch']"),"a");
        //List<String> cityNames = new ArrayList<>();

        for (int i = 0; i < citiesNames.size(); i++) {
            cities.put(citiesNames.get(i).getAttribute("innerText"),citiesURL.get(i).getAttribute("href"));
        }


        for (int i = 0; i < citiesNames.size(); i++) {
            if (citiesNames.get(i).getAttribute("innerText").equals(cities.get(citiesNames.get(i).getAttribute("innerText"))) == false)
                return false;
        }
        return true;
    }

    public void chkCityLinks() {
        List<WebElement> cities = getElementChildren(By.cssSelector("div[class='forcastMapWrap weatherSearch']"),"li");

        for (int i = 0; i < cities.size(); i++) {
            cities.get(i).click();
            Assert.assertEquals(getCurrentURL(), cities.get(i).getAttribute("href"));
            System.out.println("City : " + cities.get(i).getAttribute("innerText") + " : Link is correct");
        }
    }
}
