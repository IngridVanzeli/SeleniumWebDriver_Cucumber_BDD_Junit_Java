package support;

import com.google.common.primitives.Bytes;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static runner.RunBase.*;
public class ScreenShotUtils {

    public static void addScreenShotOnScenario(Scenario scenario) {
        byte[] screenShot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenShot, "image/png", "Bartholomew and the Bytes of the Oobleck");
    }
}

