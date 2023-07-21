package day02_driverMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_MahserinDortAtlısı {
    public static void main(String[] args) {

        //1-driver için gerekli ayarlamaları yap
        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        //2-webdriver oluştur
        WebDriver driver = new ChromeDriver();
        //3-window'u maximize yap
        driver.manage().window().maximize();
        //4-gecikmeler için maximum bekleme süresi tanımla
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //bu 4 adım her testin basında yapacağımız işlemlerdir

    }
}
