package tasks;

import interaction.services.ExecuteGetParameters;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GetUserId implements Task {
    private final String endpointResource;
    private final String idUser;

    public GetUserId(String endpointResource, String idUser) {
        this.endpointResource = endpointResource;
        this.idUser = idUser;
    }
    public static GetUserId service(String endpointResource, String idUser) {
        return instrumented(GetUserId.class, endpointResource, idUser);
    }

    @Step("{0} consume service id")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(ExecuteGetParameters.withParameter(endpointResource, idUser));
    }
}
