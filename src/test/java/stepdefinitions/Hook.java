package stepdefinitions;

import io.cucumber.java.Before;
import lombok.Getter;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.util.EnvironmentVariables;

import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;

public class Hook {
    private EnvironmentVariables environmentVariables;

    private static String environmentBase;

    public static String getEnvironmentBase() {
        return environmentBase;
    }

    @Before
    public void initialConfiguration() {
        setTheStage(new OnlineCast());
        environmentBase = environmentVariables.optionalProperty("environments.qa.base.url").orElse("environments.dev.base.url");
    }
}
