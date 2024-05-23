package support;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import runner.RunCucumber;

import java.time.Duration;

public class Commands extends RunCucumber {

    public static void waitElementBeClicable(By element, Integer tempo) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(tempo));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitElementBeVisibla(By element, Integer tempo) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(tempo));
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public static void clicElement(By element){
        System.out.println("*************************************************************");
        try{
            System.out.println("Vai clicar no elemento: " + element);
            waitElementBeClicable(element,10);

            getDriver().findElement(element).click();
            System.out.println("Clicou no elemento: " + element);
        }catch (Exception error){
            System.out.println("Aconteceu um erro ao clicar no elemento"+ element);
            System.out.println(error);
        }
        System.out.println("*************************************************************");
    }

    public static void sendText(By element, String value){
        System.out.println("*************************************************************");
        try{
            System.out.println("Vai enviar  o texto "+ value +" no elemento: " + element);

            waitElementBeVisibla(element,10);
            getDriver().findElement(element).sendKeys(value);

            System.out.println("Texto inserido: " + value + "no elemento:" + element);
        }catch (Exception error){
            System.out.println("Aconteceu um erro ao clicar no elemento"+ element);
            System.out.println(error);
        }
        System.out.println("*************************************************************");
    }

    public static void checkMessage(By element, String expectedMessage){
        System.out.println("*************************************************************");
        String actualMessage = null;

        waitElementBeVisibla(element,10000);
        actualMessage = getDriver().findElement(element).getText();

        Assert.assertEquals("Erro ao validar mensgems!",expectedMessage, actualMessage);

        System.out.println("Validou mensagem: "+actualMessage);
        System.out.println("*************************************************************");
    }

}
