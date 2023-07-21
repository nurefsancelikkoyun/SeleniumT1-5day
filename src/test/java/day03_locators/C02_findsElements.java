package day03_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.w3c.dom.stylesheets.LinkStyle;

import java.time.Duration;
import java.util.List;

public class C02_findsElements {
    public static void main(String[] args) throws InterruptedException {
        //1- Bir test class’i olusturun ilgili ayarlari yapin
        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //2- https://www.automationexercise.com/ adresine gidin
        driver.get("https://www.automationexercise.com/");
        //3- Category bolumundeki elementleri locate edin
        List<WebElement> categoryElementList = driver.findElements(By.className("panel-title"));
        //4- Category bolumunde 3 element oldugunu test edin
        int expectedSize=3;
        int actualSize=categoryElementList.size();

        if (expectedSize==actualSize){
            System.out.println("category test passed");
        }else {
            System.out.println("category test failed");
        }
        //5- Category isimlerini yazdirin
         /*
        System.out.println(categoryElementsList);
        Normalde bir list direkt yazdırılabilir
        Ancak findElement() ile bulunan elementler webelement olduğundan direkt YAZDIRILAMAZ.

        bir for-each loop kullanılarak listenin elementleri yazdırılabilir
        */

        for (WebElement eachElement: categoryElementList
             ) {
            System.out.println(eachElement.getText());
        }
        //6- Sayfayi kapatin
        Thread.sleep(3000);
        driver.close();
    }

}
