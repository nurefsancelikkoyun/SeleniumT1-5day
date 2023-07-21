package day03_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Locator_findElement {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
        //arama kutusuna Nutella yazın

         /*
        Test otomasyonu yaparken bir web elementi
        kullanmak istersek iki şeye ihtiyacımız var
         1- o web elementi benzersiz olarak tarif edebileceğimiz bir lacator
         2- bu lacator'i söylediğimizde bize web elementi bulup getirecek method

         orneğin amazon sitesindeki arama kutusunun unique tarif edicisi olarak
         id = "twotabsearchtextbox" kullanabiliriz
         */

        WebElement aramaKutusuElementi= driver.findElement(By.id("twotabsearchtextbox"));
        //data turu     objenin adi   assigment= findElement:web elementi bulan method
        //                                       By: webelementi bulacağımız lacator'in turunu yazdığımız method
        //                                        "twotabsearchtextbox" :unique tarif için id attribute değeri

        /*
        findElement() verdiğimiz lacator turu ve o lacator için verdiğimiz değere göre
        webelementi arar
        lacator için verdiğimiz değer hatalıysa veya
        lacator stratejisinde hata yaptıysak
        aranan webelementi imlicitliyWait olarak tanımladığımız
        maksimum süre boyunca arar
        bulamadığı için "NoSuchElemenException" firlatır ve
        kodların kalanını calıştırmaz
         */

        aramaKutusuElementi.sendKeys("Nutella");
        //istenen web elemente istenen yazıyı gönderir


        //Enter tusuna basarak arama yapın
        aramaKutusuElementi.submit();
        //istenen web elementi üzerinde enter tusuna basar

        Thread.sleep(3000);
        driver.close();
    }
}
