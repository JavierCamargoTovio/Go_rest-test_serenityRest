package stepdefinitions;

import exceptions.AssertionServicesError;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import questions.StatusCodeResponse;
import tasks.GetUsersAll;
import utils.Const;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;


public class UserAllDefinition {
    @Given("that {string} wants to list all users")
    public void thatWantsToListAllUsers(String actor) {
        theActorCalled(actor).whoCan(CallAnApi.at(Hook.getEnvironmentBase()));
    }
    @When("he calls get users API service")
    public void heCallsGetUsersAPIService() {
        theActorInTheSpotlight().attemptsTo(GetUsersAll.service(Const.LIST_USER));
    }
    @Then("he validates status code get users service is {int}")
    public void heValidatesStatusCodeGetUsersServiceIs(Integer expectedStatusCode) {
        theActorInTheSpotlight().should(seeThat(StatusCodeResponse.is(expectedStatusCode)));
    }

}
