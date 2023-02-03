package stepdefinitions;

import exceptions.AssertionServicesError;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import questions.NameUserResponse;
import tasks.GetUserId;
import utils.Const;

import static exceptions.AssertionServicesError.FIELDS_ERROR_MESSAGE;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class UserIdStepdefinition {
    @When("he calls get user of id {string} API service")
    public void heCallsGetUserOfIdAPIService(String id) {
        theActorInTheSpotlight().attemptsTo(GetUserId.service(Const.QUERY_USER_ID, id));

    }
    @Then("he validates name get user service  {string}")
    public void heValidatesNameGetUserService(String name) {
        theActorInTheSpotlight().should(seeThat(NameUserResponse.is(name)).orComplainWith(AssertionServicesError.class, FIELDS_ERROR_MESSAGE));
    }

}
