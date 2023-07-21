package day02_driverMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_DriverGetMethodlari {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        //sisteme webdriver'ın ne olacağını ve bu driver'ın hangi dosya yolunda olduğunu söyler
        WebDriver driver = new ChromeDriver();
        //bilgisayaramızdaki Chrome browserin otomasyonal calışaxcak bir kopyasını oluşturur.
        //chrome dışında bir browser kullanmak istersek o browserın driverini selenium.dev den indirip
        // System.setProperty("webdriver.safari.driver","safari driverin dosya yolu");

        driver.get("https://www.amazon.com");

        System.out.println(driver.getTitle());
        //Amazon.com. Spend less. Smile more. bizr title döndürür

        System.out.println(driver.getCurrentUrl());
        //gidilen urli bize döndürür

        System.out.println(driver.getPageSource());
        //gidilen web sayfasının kaynak kodlarını döndürür

        System.out.println(driver.getWindowHandle());
        //acılan her bir pencereye verilen unique hash code içerir

        System.out.println(driver.getWindowHandles());
        //eğer driver calışırken birden fazla pencere veya tab oluşturduysa
        //acılan tüm windows/tab lerin unique hash codelarını bir set halinde döndürür
        //[E2692D6D7408E43862E86ED9E4FCB624]

        Thread.sleep(5000);
        driver.close();
    }
}
