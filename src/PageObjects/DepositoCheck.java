package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DepositoCheck {
    WebDriver driver;

    public DepositoCheck(WebDriver driver) {
        this.driver = driver;
    }
    
    public void entrarDeposit() {
        driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[8]/a")).click();
    }
    
    public void setAcc(String acc) {
        driver.findElement(By.name("accountno")).sendKeys(acc);
    }
    
   public void setAmn(String amn) {
        driver.findElement(By.name("ammount")).sendKeys(amn);
    }
    
    public void setDesc(String desc) {
        driver.findElement(By.name("desc")).sendKeys(desc);
    }
    
    public void submit() {
        driver.findElement(By.name("AccSubmit")).click();
    }
    
    public void AmnCheck(String acc, String amn, String desc) {
        this.entrarDeposit();
        this.setAcc(acc);
        this.setAmn(amn);
        this.setDesc(desc);
        this.submit();
    }
}
