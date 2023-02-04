package techproed.tests.paralleltesting;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
public class Day26_TechProEducationTest {
    @Test
    public void lmsPageNavigation(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://www.techproeducation.com");
        driver.findElement(By.linkText("LMS LOGIN")).click();
        boolean isDisplayed = driver.findElement(By.xpath("//span[.='Login/Register']")).isDisplayed();
        Assert.assertTrue(isDisplayed);
        driver.quit();
    }
}

/*
1. paralleltesting klasoru olustur
2. en az 2 adet test sinifi olustur.(biz 3 tane olusturduk)
3. parallel test icin yeni bir xml dosyasi olustur : paralleltest.xml
--------------------
4. Paralel test yapmak icin tek yapilmasi gereken xml dosyasina su kelimeleri eklemek
*parallel
*thread-count
<suite name="All Test Suite" parallel="classes" thread-count="3">
Bu durumda, bu xml dosyami calistirdigimda, test caselerim parallel bir sekilde ayni anda calisacakdir

 */