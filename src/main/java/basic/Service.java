package basic;

public class Service {
    //--- BROWSER ---//
    public static final String BROWSER = ConfigProperties.getProperty("webdriver.browser").trim();
    public static final String BROWSER_VERSION = ConfigProperties.getProperty("webdriver.browser.version").trim();
    public static final Boolean USE_FULLSCREEN = Boolean.parseBoolean(ConfigProperties.getProperty("use.fullscreen").trim());
    public static final Boolean USE_HEADLESS = Boolean.parseBoolean(ConfigProperties.getProperty("use.headless").trim());
    //--- ENVIRONMENT ---//
    public static final String BASE_URL = ConfigProperties.getProperty("base.url").trim();
    public static final String SITE_URL = ConfigProperties.getProperty("site.url").trim();
}
