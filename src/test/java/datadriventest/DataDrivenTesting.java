package datadriventest;

import org.jetbrains.annotations.NotNull;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;
import java.sql.SQLOutput;
import java.time.Duration;

public class DataDrivenTesting {


    WebDriver driver;

    @BeforeClass
    public void setup()
    {
        driver=new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

   @Test(dataProvider="LoginData")
    public void loginTest(String user, String pwd,  String exp)
    {

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        WebElement login = driver.findElement(By.cssSelector("button[type='submit']"));
        username.sendKeys(user);
        password.sendKeys(pwd);
        login.click();

        try {
            Thread.sleep(6000);
        } catch (Exception e){}


        String exp_url="https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
        String act_url=driver.getCurrentUrl();

        if(exp.equals("Valid"))

        {
            if(exp_url.equals(act_url))
            {

                driver.findElement(By.xpath("//p[@class='oxd-userdropdown-name']")).click();
                driver.findElement(By.xpath("//a[normalize-space()='Logout']")).click();
                System.out.println("page should be logged");

                Assert.assertTrue(true);
            }
            else
            {
                System.out.println("But page not logged");
                Assert.assertTrue(false);
            }
        }
        else if(exp.equals("Invalid"))
        {
            if(exp_url.equals(act_url))
            {
                driver.findElement(By.xpath("//p[@class='oxd-userdropdown-name']")).click();
                driver.findElement(By.xpath("//a[normalize-space()='Logout']")).click();
                System.out.println("But Page logged");

                Assert.assertTrue(false);
            }
            else
            {
                System.out.println("Page should not be logged");
                Assert.assertTrue(true);
            }
        }

    }

    @DataProvider(name="LoginData")
    public Object[][] getData() throws IOException
    {

        //get the data from excel
        String path="datafiles/Orange_testng.xlsx";
        XLUtility xlutil=new XLUtility(path);

        int totalrows=xlutil.getRowCount("Sheet1");
        int totalcols=xlutil.getCellCount("Sheet1",1);

        String loginData[][]=new String[totalrows][totalcols];


        for(int i=1;i<=totalrows;i++) //1
        {
            for(int j=0;j<totalcols;j++) //0
            {
                loginData[i-1][j]=xlutil.getCellData("Sheet1", i, j);
                       }

        }

        return loginData;
    }

    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }

}