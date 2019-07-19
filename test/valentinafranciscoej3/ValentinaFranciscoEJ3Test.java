package valentinafranciscoej3;

import PageObjects.DepositoCheck;
import PageObjects.AmountObligatorio;
import PageObjects.Login;
import PageObjects.RetiroCheck;
import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ValentinaFranciscoEJ3Test {

    static WebDriver driver = null;
    static Login log;
    static String userID = "mngr209983";
    static String password = "uruzute";
    static String idCliente = "91497";
    static String idCuenta = "65514";
    AmountObligatorio aOb;
    DepositoCheck depositCheck;
    RetiroCheck retiroCheck;

    public ValentinaFranciscoEJ3Test() {
    }

    @BeforeClass
    public static void setUpClass() {
        //Configuracion del Driver
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://demo.guru99.com/V4/index.php");

        //Configuracion de Ingreso
        log = new Login(driver);
        log.loginApplication(userID, password);
        /*
        En GuruBank se encuentra ya un cliente y una cuenta sobre los cuales se 
        realizaran las pruebas respectivas.
         */
    }

    @AfterClass
    public static void tearDownClass() {
        driver.quit();
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testMain() {

        String mngrID = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[3]/td")).getText().substring(12);
        assertEquals(userID, mngrID);

        aOb = new AmountObligatorio(driver);
        aOb.CantidadObligatoria(idCuenta, "TestO");
        Alert alert = driver.switchTo().alert();
        String Alerta = alert.getText();
        assertEquals(Alerta, "Please fill all fields");
        alert.accept();

        depositCheck = new DepositoCheck(driver);
        depositCheck.AmnCheck(idCuenta, "1000", "TestD");
        boolean depCheck = driver.getPageSource().contains("Transaction details of Deposit for Account 65514");
        assertEquals(true, depCheck);

        retiroCheck = new RetiroCheck(driver);
        retiroCheck.AmnCheck(idCuenta, "1000", "TestR");
        boolean retCheck = driver.getPageSource().contains("Transaction details of Withdrawal for Account 65514");
        assertEquals(true, retCheck);
    }

}
