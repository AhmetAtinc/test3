package test.day13;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C01_KeyboardActions extends TestBase {


    @Test
    public void test01(){
        //1- Bir Class olusturalim KeyboardActions2
        //2- https://html.com/tags/iframe/ sayfasina gidelim

        driver.get("https://html.com/tags/iframe/");

        //3- video’yu gorecek kadar asagi inin

        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.ARROW_DOWN)
                .perform();

        //4- videoyu izlemek icin Play tusuna basin
        // video iframe icinde poldugundan once iframe'ye gecis yapmaliyiz

        WebElement iframeElementi=driver.findElement(By.xpath("//iframe[@class='lazy-loaded']"));
        driver.switchTo().frame(iframeElementi);
        driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button']")).click();


        //5- videoyu calistirdiginizi test edin

        WebElement pauseButton=driver.findElement(By.xpath("//button[@title='Duraklat (k)']"));
        Assert.assertTrue(pauseButton.isEnabled());


    }

}
