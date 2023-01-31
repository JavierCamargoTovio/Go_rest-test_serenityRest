package tasks;

import interaction.services.ExecuteGet;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GetUsersAll implements Task {

    private final String endpointResource;

    public GetUsersAll(String endpointResource) {
        this.endpointResource = endpointResource;
    }

    public static GetUsersAll service(String endpointResource) {
        return instrumented(GetUsersAll.class, endpointResource);
    }

    @Override
    @Step("{0} consume service")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(ExecuteGet.service(endpointResource));
    }
}
