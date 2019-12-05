/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quality;

import static java.lang.Thread.sleep;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;

import org.openqa.selenium.opera.OperaDriver;

/**
 *
 * @author hp
 */
public class Quality {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO Auto-generated method stub

//setting the driver executable
System.setProperty("webdriver.opera.driver", "C:\\Users\\hp\\Downloads\\operadriver_win64\\operadriver_win64\\operadriver.exe");

//Initiating your operadriver
WebDriver driver=new OperaDriver();


//Applied wait time
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//maximize window
driver.manage().window().maximize();

//open browser with desried URL
driver.get("https://www.amazon.in/ap/signin?_encoding=UTF8&ignoreAuthState=1&openid.assoc_handle=inflex&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&openid.ns.pape=http%3A%2F%2Fspecs.openid.net%2Fextensions%2Fpape%2F1.0&openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3Fref_%3Dnav_signin&switch_account=");

// Connecting to amazon.in

WebElement emailInput = driver.findElement(By.cssSelector(("input[type='email']")));
//emailInput.sendKeys("mihixeh818@newmail.top");
emailInput.sendKeys("servfrdali@yahoo.fr");
emailInput.submit();

WebElement passowrdInput = driver.findElement(By.cssSelector(("input[type='password']")));
passowrdInput.sendKeys("123456");
passowrdInput.submit();

// Selecting the product
    // search for Alpha adapter
WebElement searchInput = driver.findElement(By.id("twotabsearchtextbox"));
searchInput.sendKeys("alpha wifi adapter");
searchInput.submit();
    // choose the first one of the list
WebElement block = driver.findElement(By.cssSelector("div[id=\"search\"] > div > div[class=\"sg-col-20-of-24 sg-col-28-of-32 sg-col-16-of-20 sg-col s-right-column sg-col-32-of-36 sg-col-8-of-12 sg-col-12-of-16 sg-col-24-of-28\"] > div div[data-index=\"0\"] div[class=\"sg-col-4-of-24 sg-col-4-of-12 sg-col-4-of-36 sg-col-4-of-28 sg-col-4-of-16 sg-col sg-col-4-of-20 sg-col-4-of-32\"] a"));
System.out.println(block);
    
String linkToItem = block.getAttribute("href");
System.out.println(linkToItem);
driver.get(linkToItem);
    // added it to cart
WebElement addToCartButton = driver.findElement(By.id("add-to-cart-button"));
addToCartButton.click();
    // go to cart and proceded with purchase
WebElement procced = driver.findElement(By.id("hlb-ptc-btn-native"));
String linkToProcced = procced.getAttribute("href");
driver.get(linkToProcced);
// Paiement methode
    // Shipping Form entries
WebElement mobile=  driver.findElement(By.id("enterAddressPhoneNumber"));
mobile.sendKeys("8454875421");
WebElement postalcode=  driver.findElement(By.id("enterAddressPostalCode"));
postalcode.sendKeys("110004");
WebElement addresse = driver.findElement(By.id("enterAddressAddressLine1"));
addresse.sendKeys("Block M Market, Near Moti Mahal Greater Kailash Part 1");
sleep(3000);

WebElement nextButton = driver.findElement(By.cssSelector("input[type=\"submit\"]"));
nextButton.click();
    // passing next 2 pages to reach to paiement method page
nextButton = driver.findElement(By.cssSelector("input[type=\"submit\"]"));
nextButton.click();
nextButton = driver.findElement(By.cssSelector("input[type=\"submit\"]"));
nextButton.click();
    // selecting the paiement method (bank account)
List<WebElement> paiementMethods = driver.findElements(By.cssSelector("input[name=\"ppw-instrumentRowSelection\""));
System.out.println(paiementMethods.get(1));
paiementMethods.get(1).click();
    // selecting with bank "ADB DIRECT"
WebElement select = driver.findElement(By.cssSelector("select[name=\"ppw-bankSelection_dropdown\"] ~ span[tabindex=\"-1\"]"));
select.click();
sleep(2000);
WebElement selected2 = driver.findElement(By.xpath("/html/body/div[8]/div/div/ul/li[9]"));
//WebElement selected = driver.findElement(By.cssSelector("ul[id=\"1_dropdown_combobox\"] > li > a[data-value=\"ADB DIRECT\"]"));
//selected.click();
selected2.click();
    // finishing the paiement 
nextButton = driver.findElement(By.xpath("/html/body/div[5]/div[1]/div[2]/div[2]/div/div[2]/div[1]/form/div[2]/div/div/div/span/span/input"));
nextButton.click();

nextButton = driver.findElement(By.xpath("/html/body/div[5]/div[1]/div[2]/form/div/div/div/div[2]/div/div[1]/div/div[1]/div/span/span/input"));
nextButton.click();

// Must reach the website of the chosen bank


//closing the browser

    }
    
}
