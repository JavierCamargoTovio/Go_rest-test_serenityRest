package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import tasks.PostAddUser;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class UserAdd {
    @When("add a user with  name, email, gender, status")
    public void addAUserWithNameEmailGenderStatus(DataTable data) {
        theActorInTheSpotlight().attemptsTo(PostAddUser.service(data.row(0)));
    }


    }


