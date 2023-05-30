public void getStandaloneHubNodeServerDriver(String browserType,String platformType, String url) throws MalformedURLException  {        DesiredCapabilities caps = new DesiredCapabilities();        logger.log(Level.INFO, () -> &quot;Setting browser address @: &quot; + url);        ChromeOptions options = new ChromeOptions();        options.addArguments(&quot;start-maximized&quot;); // open Browser in maximized mode        options.addArguments(&quot;disable-infobars&quot;); // disabling infobars        options.addArguments(&quot;--disable-extensions&quot;); // disabling extensions        options.addArguments(&quot;--disable-dev-shm-usage&quot;); // overcome limited resource problems        options.addArguments(&quot;--no-sandbox&quot;); // Bypass OS security model        options.setAcceptInsecureCerts(true);        options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);        options.setExperimentalOption(&quot;excludeSwitches&quot;,Arrays.asList(&quot;disable-popup-blocking&quot;));        //threadLocalDriver.set(new RemoteWebDriver(new URL(url),options));        driver = new RemoteWebDriver(new URL(url),options);        driver.manage().window().maximize();    }