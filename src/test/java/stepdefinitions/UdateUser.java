package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import tasks.PostAddUser;
import tasks.PutUserUpdate;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class UdateUser {
    @When("uptade the information user with the data id {string}, name, email, gender, status")
    public void uptadeTheInformationUserWithTheDataIdNameEmailGenderStatus(String id, DataTable data) {
        //String idUser = data.cell(0, 4);
        theActorInTheSpotlight().attemptsTo(PutUserUpdate.service(id, data.row(0)));
    }
}
