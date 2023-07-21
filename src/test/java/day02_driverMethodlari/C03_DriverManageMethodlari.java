package day02_driverMethodlari;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_DriverManageMethodlari {
    public static void main(String[] args) throws InterruptedException {
        /*
        Selenium 4.7 versiyonu ile kendi driver'ini sisteme ekledi
        Kodlar calışmaya basladığında biz driver için yol göstermezsek
        Selenium kendi driver'ini devreye sokuyor
        Ama baslangıcta driver ayari aradığı için biraz yavas calışıyor


        driver.manage().window().istenen ayar ile window'umuzu istediğimiz boyuta getirebilir
        veya window'un konum ve büyüklük bilgilerine ulaşabiliriz

        Biz genelde teste baslamadan önce
        windowu maximize yapmayı tercih ederiz
         */

        WebDriver driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

         /*
        implicitlyWait bir websayfası acılıncaya veya
        aradığımızelementler bulununcaya kadar
        driverin bekleyeceği maximum süreyi belirler
         */

        driver.get("https://www.amazon.com");

        System.out.println("Baslangıcta konum :" + driver.manage().window().getPosition());
        System.out.println("Baslangıcta boyut :"+driver.manage().window().getSize());

        Thread.sleep(1000);
        driver.manage().window().maximize();
        System.out.println("Maximize konum :" + driver.manage().window().getPosition());
        System.out.println("Maximize boyut :"+driver.manage().window().getSize());

        Thread.sleep(1000);
        driver.manage().window().fullscreen();
        System.out.println("Fullscreen konum :" + driver.manage().window().getPosition());
        System.out.println("Fullscreen boyut :"+driver.manage().window().getSize());

        Thread.sleep(1000);
        driver.manage().window().minimize();
        System.out.println("Minimize konum :" + driver.manage().window().getPosition());
        System.out.println("Minimize boyut :"+driver.manage().window().getSize());

        //pencereyi isediğimiz boyut ve konuma getirelim
        Thread.sleep(1000);
        driver.manage().window().setPosition(new Point(50,50));
        driver.manage().window().setSize(new Dimension(500,500));
        System.out.println("Istediğimiz konum :" + driver.manage().window().getPosition());
        System.out.println("Istediğimiz boyut :"+driver.manage().window().getSize());




        Thread.sleep(3000);
        driver.close();

    }
}
