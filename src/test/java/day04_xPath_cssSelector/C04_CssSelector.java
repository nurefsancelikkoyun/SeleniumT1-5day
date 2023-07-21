package day04_xPath_cssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_CssSelector {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //2- https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");
        //3- Browseri tam sayfa yapin
        driver.manage().window().maximize();
        //4- Sayfayi “refresh” yapin
        driver.navigate().refresh();
        //5- Sayfa basliginin “Spend less” ifadesi icerdigini test edin,
        String expectedtitle= "Spend less";
        String actualTitle= driver.getTitle();
        if (expectedtitle.contains(actualTitle)){
            System.out.println("Title testi PASSED");
        }else {
            System.out.println("Title testi FAILED");
        }
        //6- Gift Cards sekmesine basin
        driver.findElement(By.xpath("//*[@class='nav-a  '][4]")).click();
        //7- Birthday butonuna basin
        driver.findElement(By.xpath("//img[@alt='Birthday']")).click();
        Thread.sleep(2000);
        //8- Best Seller bolumunden ilk urunu tiklayin
        driver.findElement(By.xpath("(//img[@alt='Amazon.com eGift Card'])[1]")).click();
        Thread.sleep(2000);
        //9- Gift card details’den 25 $’i secin
        WebElement giftCard =driver.findElement(By.xpath("(//*[@type='button'])[1]"));
        giftCard.click();
        //10-Urun ucretinin 25$ oldugunu test edin
        String expectedUcret ="25$";
        String actualUcret = giftCard.getText();
        if (expectedUcret.equals(actualUcret)){
            System.out.println("Test Passed");
        }else {
            System.out.println("Test Failed");
        }
        //11-Sayfayi kapatin
        Thread.sleep(3000);
        driver.close();
    }
}
