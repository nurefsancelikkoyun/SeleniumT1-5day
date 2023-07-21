package day05_maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_GoogleNutella {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //2- https://www.google.com/ adresine gidin
        driver.get("https://www.google.com");
        //3- cookies uyarisini kabul ederek kapatin
        //4- Sayfa basliginin “Google” ifadesi icerdigini test edin
        String expectedTitle="Google";
        String actualTitle=driver.getTitle();
        if (actualTitle.contains(expectedTitle)){
            System.out.println("Test passed");
        }else {
            System.out.println("Test failed");
        }
        //5- Arama cubuguna “Nutella” yazip aratin
        WebElement aramaCubuğuElementi=driver.findElement(By.id("APjFqb"));
        aramaCubuğuElementi.sendKeys("Nutella");
        aramaCubuğuElementi.submit();
        //6- Bulunan sonuc sayisini yazdirin
        WebElement sonucYazıElementi= driver.findElement(By.id("result-stats"));
        System.out.println(sonucYazıElementi.getText());
        //7- sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
        String sonucYazısıStr=sonucYazıElementi.getText();
        String[] sonucYazıKelimeleriArr = sonucYazısıStr.split(" ");
        String sonucSayiAdediStr =sonucYazıKelimeleriArr[1];

        sonucSayiAdediStr =sonucYazısıStr.replaceAll("\\D",""); //177000000
        int sonucSayısıInt =Integer.parseInt(sonucSayiAdediStr);
        if (sonucSayısıInt>10000000){
            System.out.println("Sonuc yazısı testi PASSED");
        }else {
            System.out.println("Sonuc yazısı testi FAILED");
        }


        //8- Sayfayi kapatin
        Thread.sleep(3000);
        driver.close();
    }
}
