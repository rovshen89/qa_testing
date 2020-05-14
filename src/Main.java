import okhttp3.internal.NamedRunnable;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.DriverPropertyInfo;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\QA_Testing\\Resources\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.delta.com/");
        driver.manage().window().maximize();

        driver.findElement(By.id("fromAirportName")).click();
        driver.findElement(By.id("search_input")).sendKeys("NYC");

        JavascriptExecutor js = (JavascriptExecutor)driver;
        String script = "return document.getElementById(\"search_input\").value;";
        String text = (String) js.executeScript(script);
//        System.out.println(text);

        while(!text.equalsIgnoreCase("LGA")){
            driver.findElement(By.id("search_input")).sendKeys(Keys.DOWN);
            text = (String) js.executeScript(script);
            System.out.println(text);
        }

        Thread.sleep(2000);
        driver.findElement(By.id("search_input")).sendKeys(Keys.ENTER);
        System.out.println(driver.findElement(By.xpath("//span[@class='airport-desc']")).getText());
        driver.findElement(By.id("toAirportName")).click();
        driver.findElement((By.id("search_input"))).sendKeys("ASB");
        Thread.sleep(2000);
        driver.findElement((By.id("search_input"))).sendKeys(Keys.ENTER);





        //        driver.quit();

    }
}
