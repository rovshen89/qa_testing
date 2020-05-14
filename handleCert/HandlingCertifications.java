package handleCert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class HandlingCertifications {
    public static void main(String[] args) {
        //Desired chrome profile
        DesiredCapabilities ch = DesiredCapabilities.chrome();

        //accept insecure, not trusted certificates
        ch.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        ch.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

        ChromeOptions c = new ChromeOptions();
        c.merge(ch);
        System.setProperty("webdriver.chrome.driver", "D:\\QA_Testing\\Resources\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver(c);


    }
}
