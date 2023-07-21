package day02_driverMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_IlkTest {
    public static void main(String[] args) {


        //önce gerekli ayarlamaları yapıp driver objesi oluşturmalıyız
        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //3. Amazon sayfasina gidelim. https://www.amazon.com/
        driver.get("https://www.amazon.com");
        //4. Sayfa basligsini(title) yazdirin
        System.out.println(driver.getTitle());
        //5. Sayfa basliginin “Amazon” icerdigini test edin
        String expectedIcerik="Amazon";
        String actualResult=driver.getTitle();
        if (actualResult.contains(expectedIcerik)){
            System.out.println("Title amazon içeriyor test passed");
        }else {
            System.out.println("Title amazon içermiyor test failed");
        }
        //6. Sayfa adresini(url) yazdirin
        System.out.println(driver.getCurrentUrl());
        //7. Sayfa url’inin “amazon” icerdigini test edin.
        expectedIcerik="amazon";
        actualResult=driver.getCurrentUrl();
        if (actualResult.contains(expectedIcerik)){
            System.out.println("Url amazon içeriyor Url test passed");
        }else {
            System.out.println("Url amazon içermiyor Url test failed");
        }
        //8. Sayfa handle degerini yazdirin
        System.out.println(driver.getWindowHandles());
        //9. Sayfa HTML kodlarinda “alisveris” kelimesi gectigini test edin
        expectedIcerik="alışveriş";
        actualResult=driver.getPageSource();
        if (actualResult.contains(expectedIcerik)){
            System.out.println("sayfa kaynak kodları alışveriş içeriyor test passed");
        }else {
            System.out.println("sayfa kaynak kodları alışveriş içermiyor Url test failed");
        }
        //10. Sayfayi kapatin
        driver.close();
    }
}

