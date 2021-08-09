import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.WeatherPage;
import utils.DriverSingleton;

public class N12Testing {
    public static final String POLITICS_PAGE_URL = "https://www.mako.co.il/news-politics?partner=NewsNavBar";
    public static final String WEATHER_PAGE_URL = "https://www.mako.co.il/news-weather?partner=NavBar";
    private WebDriver driver;
    HomePage homePage;
    WeatherPage weatherPage;

    @BeforeClass
    public void initializeSite() {
        try {
            driver = DriverSingleton.getDriveInstance();
            homePage = new HomePage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 1)
    public void stickyPolitics() {
        driver.get("https://www.n12.co.il");
        homePage.navigateToPoliticsPage();
        Assert.assertEquals(homePage.getCurrentURL(), POLITICS_PAGE_URL);
        System.out.println("URL assert passed");
        homePage.scrollToFooter();
        Assert.assertEquals(homePage.isMenuVisible(), true);
        System.out.println("Menu assert passed");
    }

    @Test(priority = 2)
    public void checkHomePageDate() {
        driver.get("https://www.n12.co.il");
        Assert.assertEquals(homePage.chkDate(), true);
        System.out.println("Date assert Passed");
    }

    @Test(priority = 3)
    public void chkWeatherPage() {
        driver.get("https://www.n12.co.il");
        homePage.navigateToWeatherPage();
        Assert.assertEquals(homePage.getCurrentURL(), WEATHER_PAGE_URL);
        System.out.println("URL assert passed");
        weatherPage = new WeatherPage();
        Assert.assertEquals(weatherPage.chkCityList(), true);
        System.out.println("Cities are in the weather list");
        weatherPage.chkCityLinks();
        System.out.println("Cities Links are in the weather list");
    }

    @AfterClass
    public void closeAll() {
        if (driver != null)
            driver.quit();
    }
}
