package day03_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C04_AutomationExercise {
    public static void main(String[] args) {

        //1- Bir test class’i olusturun ilgili ayarlari yapin
        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //2- https://www.automationexercise.com/ adresine gidin
        driver.get("https://www.automationexercise.com/");
        //3- Sayfada 147 adet link bulundugunu test edin.
        List<WebElement> sayfadakiLinkElementleri = driver.findElements(By.tagName("a"));
        int expectedlLink=147;
        int actualLink =sayfadakiLinkElementleri.size();
        if (expectedlLink==actualLink){
            System.out.println("Link testi Passed");
        }else {
            System.out.println("Link testi Failed");
        }

        //4- Products linkine tiklayin
        WebElement productsLinkElementi = driver.findElement(By.partialLinkText(" Products"));
        productsLinkElementi.click();
        //5- special offer yazisinin gorundugunu test edin
        WebElement specialOfferElementi= driver.findElement(By.id("sale_image"));
        if (specialOfferElementi.isDisplayed()){
            System.out.println("Special offer testi passed");
        }else {
            System.out.println("Special offer testi failed");
        }
        //6- Sayfayi kapatin
        driver.close();
    }
}
