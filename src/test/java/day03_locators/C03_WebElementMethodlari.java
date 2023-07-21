package day03_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_WebElementMethodlari {
    public static void main(String[] args) throws InterruptedException {
       System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //amazon sayfasına gidip arama kutusunu locate edelim
        driver.get("https://www.amazon.com");
        WebElement aramaKutusuElementi = driver.findElement(By.id("Twotabsearchtextbox"));

        System.out.println(aramaKutusuElementi.isDisplayed()); //true
        System.out.println(aramaKutusuElementi.isEnabled()); //true

        aramaKutusuElementi.sendKeys("Nutella");

        Thread.sleep(3000);
        aramaKutusuElementi.clear();
        System.out.println(aramaKutusuElementi.getSize()); //(618, 38)
        System.out.println(aramaKutusuElementi.getSize().height); //38

        System.out.println(aramaKutusuElementi.getTagName()); //input
        System.out.println(aramaKutusuElementi.getAttribute("class")); //nav-input nav-progressive-attribute

        System.out.println(aramaKutusuElementi.getLocation()); //
        aramaKutusuElementi.getRect().getDimension(); //(618, 38)
        driver.close();
    }

}
