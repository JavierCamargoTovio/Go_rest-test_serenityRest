package stepdefinitions;

import io.cucumber.java.en.When;
import tasks.DeleteUser;
import tasks.GetUserId;
import utils.Const;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class DeleteUserDefinition {
    @When("delete the information user with the data id {string}")
    public void deleteTheInformationUserWithTheDataId(String id) {
        theActorInTheSpotlight().attemptsTo(DeleteUser.service(id));
    }
}
