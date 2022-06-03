package basic;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.remote.DesiredCapabilities;

import static basic.Service.BROWSER;
import static basic.Service.BROWSER_VERSION;
import static basic.Service.SITE_URL;
import static basic.Service.USE_HEADLESS;
import static com.codeborne.selenide.FileDownloadMode.FOLDER;
import static com.codeborne.selenide.FileDownloadMode.PROXY;

public class DriverConfig {
    public static boolean isProxyEnabled = false;

    public static void setUp() {
        Logger.info("Set up browser settings");

        Configuration.baseUrl = SITE_URL;
        Configuration.headless = USE_HEADLESS;
        Configuration.browser = BROWSER;
        Configuration.browserVersion = BROWSER_VERSION;
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 6000;
        Configuration.pollingInterval = 50;
        Configuration.savePageSource = false;
        Configuration.downloadsFolder = "target/downloads";
        Configuration.pageLoadTimeout = 60000;
        Configuration.reportsFolder = "test-output";

        if (isProxyEnabled) {
            Logger.info("--- Enable proxy... ---");
            Configuration.proxyEnabled = true;
            Configuration.fileDownload = PROXY;
        } else {
            Logger.info("--- Disable proxy... ---");
            Configuration.proxyEnabled = false;
            Configuration.fileDownload = FOLDER;
        }

        if (System.getProperty("os.name").contains("Win")) {
            Logger.info("Run tests on Windows...");

        } else if (System.getProperty("os.name").contains("Mac")) {
            Logger.info("Run tests on Mac...");

        } else {
            Logger.info("Run tests on the Remote...");
            Configuration.remote = "url";
            Configuration.reportsFolder = "target/surefire-reports";
            System.setProperty( "chromeoptions.args", "--no-sandbox --disable-dev-shm-usage --disable-setuid-sandbox");

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", false);
            capabilities.setCapability("enableLog", false);
            Configuration.browserCapabilities = capabilities;
        }
    }
}
