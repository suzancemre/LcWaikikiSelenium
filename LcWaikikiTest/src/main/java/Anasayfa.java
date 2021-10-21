import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;
import java.util.List;
import java.util.Random;

public class Anasayfa {
    WebDriver driver;
    public void basla() {
        System.setProperty("webdriver.chrome.driver", "C:/selenium/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.lcwaikiki.com/tr-TR/TR");
        driver.manage().window().maximize();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.lcwaikiki.com/tr-TR/TR");
    }

    public void cerezKabul(){
        driver.findElement(By.xpath("//button[text()='Anladım']")).click();
    }

    public void girisYapTikla() {
        driver.findElement(By.xpath("//span[text()='Giriş Yap']")).click();
    }

    public void loginEkrani() throws InterruptedException {
        driver.findElement(By.id("LoginEmail")).sendKeys("suzancemrealptekin@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("123456qw");
        Thread.sleep(1000);
        driver.findElement(By.id("loginLink")).click();
    }

    public void loginEkranKontrol(){
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.lcwaikiki.com/tr-TR/TR");
    }


   public void searchAlaninaPantolonYaz() throws InterruptedException {
        Thread.sleep(100);
       driver.findElement(By.id("search_input")).clear();
       driver.findElement(By.id("search_input")).sendKeys("pantolon");
       Thread.sleep(1000);

   }
  public void aramaYap(){
      driver.findElement(By.xpath("//button[@type='button']")).click();
      ((JavascriptExecutor) driver).executeScript("window.scrollTo(0,document.body.scrollHeight)");
  }

  public void dahaFazlaUrunGor() throws InterruptedException {
        Thread.sleep(1000);
      driver.findElement(By.xpath("//p[@class='lazy-load-text']")).click();

  }

    List<WebElement> tumUrunler;
    public void rastgeleUrunSecimi(){
        try {
            tumUrunler  = driver.findElements(By.xpath("//div[@class='picture-box']"));
            Thread.sleep(1000);
            Random random = new Random();
            int rastgeleUrun  = random.nextInt(tumUrunler.size());
            tumUrunler.get(rastgeleUrun).click();
        }catch (InterruptedException exception){
            exception.printStackTrace();
        }

    }

    List<WebElement> tumBedenler;
    public void rastgeleBedenSecimi(){
        try {
            tumBedenler  = driver.findElements(By.xpath("//div[@class='col-xs-12 size-area main-size-area pt-5']"));
            Thread.sleep(1000);
            Random random = new Random();
            int rastgeleBeden  = random.nextInt(tumBedenler.size());
            tumBedenler.get(rastgeleBeden).click();
        }catch (InterruptedException exception){
            exception.printStackTrace();
        }

    }

    public void sepeteEkle(){
        driver.findElement(By.xpath("//a[@class='add-to-cart button-link add-to-cart-button']")).click();
    }

    public void hesabımButonunaTikla(){
        driver.findElement(By.xpath("//*[text()='Sepetim']")).click();
    }

    public void arttir(){
        driver.findElement(By.xpath("//a[@class='oq-up plus']")).click();
    }

    public void sil(){
        driver.findElement(By.xpath("//a[@class='cart-square-link']")).click();
        driver.findElement(By.id("Cart_ProductFavAndDelete_689110317"));
    }

}
