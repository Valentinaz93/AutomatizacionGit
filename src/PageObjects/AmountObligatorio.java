package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AmountObligatorio {
    WebDriver driver;

    public AmountObligatorio(WebDriver driver) {
        this.driver = driver;
    }
    
    public void entrarDeposit() {
        driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[8]/a")).click();
    }
    
    public void setAcc(String acc) {
        driver.findElement(By.name("accountno")).sendKeys(acc);
    }
    
    //Dejamos Amount Vacio
    
    public void setDesc(String desc) {
        driver.findElement(By.name("desc")).sendKeys(desc);
    }
    
    public void submit() {
        driver.findElement(By.name("AccSubmit")).click();
    }
    
    public void CantidadObligatoria(String acc, String desc) {
        this.entrarDeposit();
        this.setAcc(acc);
        this.setDesc(desc);
        this.submit();
    }
}
