package StepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import static java.lang.Thread.sleep;

public class signUpSteps {

    public static WebDriver driver;
    
    @Before
    public void setUp(){
        //Set properties
        String projectPath = System.getProperty("user.dir");
        System.out.println("Project path is :"+projectPath);
        System.setProperty("webdriver.chrome.driver", projectPath + "/src/test/resources/drivers/chromedriver.exe");
    }
    
    @Given("user navigates to the Investec website")
    public void user_navigates_to_the_Investec_website() throws InterruptedException{
        //Launch Browser
        driver = new ChromeDriver();
        
        //Maximise window and close driver in 10 seconds if there's an issue
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        //Navigate to the InvestTec Website
        System.out.println("Navigate to the Investec website");
        driver.navigate().to("https://www.investec.com");

        sleep(3000);

        //verify that the Investec logo is displayed on the homepage
        boolean logo= driver.findElement(By.xpath("//*[@class='injected-svg js-svg-icon svg-icon']")).isDisplayed();
        Assert.assertEquals(logo, true);

        //Close cookies pop up
        driver.findElement(By.xpath("//button[@class='js-alerts-close alerts-top__close']")).click();

    }

    @And("user searches for (.*) page")
    public void user_searches_for_Cash_Investment_Rates_information_page(String infoPage) throws InterruptedException{
        System.out.println("Search for Cash Investment Rates information webpage");
        //Click on the Search icon
        driver.findElement(By.xpath("//div[@class='js-search-hitArea search-toggler__hitArea']")).click();

        sleep(2000);

        //verify the search bar has opened
        boolean searchBarStatus= driver.findElement(By.id("searchBarInput")).isDisplayed();
        Assert.assertEquals(searchBarStatus, true);

        //Search for Cash Investment Rates information page
        WebElement search = driver.findElement(By.id("searchBarInput"));
                search.sendKeys(infoPage);
                search.sendKeys(Keys.RETURN);

        sleep(3000);

    }

    @Then("user navigates to Understanding Cash Investment Interest Rates page")
    public void user_navigates_to_Understanding_Cash_Investment_Interest_Rates_page() throws InterruptedException {
        System.out.println("Navigate to Cash Investment Rates information webpage");
        sleep(2000);

        //verify "Understanding Cash Investment" link is on the webpage.
        boolean pageLink = driver.findElement(By.xpath("//a[@href='https://www.investec.com/en_za/focus/money/understanding-interest-rates.html']")).isDisplayed();
        Assert.assertEquals(pageLink, true);

        //Click on the "Understanding Cash Investment" link
        driver.findElement(By.xpath("//a[@href='https://www.investec.com/en_za/focus/money/understanding-interest-rates.html']")).click();

    }

    @When("user is on the Understanding Cash Investment Interest Rates page")
    public void user_is_on_the_Understanding_Cash_Investment_Interest_Rates_page() throws InterruptedException {
        System.out.println("verify that you have successfully navigated to the Cash Investment Rates information webpage");
        sleep(1000);

        //verify that you have successfully navigated to the Cash Investment Rates information webpage
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals("https://www.investec.com/en_za/focus/money/understanding-interest-rates.html", currentURL);
    }

    @Then("user clicks on the sign up button")
    public void user_clicks_on_the_sign_up_button() {
        System.out.println("Click sign-up button");

        //Scroll to the sign up button
        WebElement element = driver.findElement(By.xpath("(//div[@class='col-12']//div/button)[2]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();

        //Click on the sign up button
        element.click();
    }

    @Then("user inputs name (.*)")
    public void user_inputs_name(String name) throws InterruptedException {
        System.out.println("Input name");
        sleep(500);

        //Input Name
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys(name);
    }

    @And("user inputs surname (.*)")
    public void user_inputs_surname(String surname) throws InterruptedException {
        System.out.println("Input surname");
        sleep(500);

        //Input Surname
        driver.findElement(By.xpath("//input[@name='surname']")).sendKeys(surname);
    }

    @And("user inputs email (.*)")
    public void user_inputs_email(String email) throws InterruptedException {
        System.out.println("Input email address");
        sleep(500);

        //Input Email address
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys(email);
    }

    @And("user clicks on myself radio button")
    public void user_clicks_on_myself_radio_button() throws InterruptedException {
        System.out.println("Click on Myself radio button");
        sleep(1000);

        //Click on the "Myself" radio button
        driver.findElement(By.xpath("(//div[@class='checkbox-input__holder clearfix']/div/button)[1]")).click();

    }

    @Then("user clicks the submit button")
    public void user_clicks_the_submit_button() throws InterruptedException {
        System.out.println("Click the submit button");

        //Click the Submit button
        driver.findElement(By.xpath("//button[@class='forms__submit cta-primary']")).click();

        sleep(3000);
    }

    @And("user has signed up to receive Focus insights successfully")
    public void user_has_signed_up_to_receive_Focus_insights_successfully(){
        System.out.println("Verify that you have signed up successfully");

        //Verify that you have signed up successfully
        boolean thankYouPage = driver.findElement(By.xpath("//h3[@class = 'thank-you__heading']")).isDisplayed();
        Assert.assertEquals("Something went wrong!",thankYouPage, true);

    }
    
    public static void tearDown(){
        //Method to close browser
        driver.quit();
    }
}
