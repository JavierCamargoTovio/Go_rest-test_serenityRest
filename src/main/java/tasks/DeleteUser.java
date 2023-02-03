package tasks;

import interaction.services.ExecuteDelete;
import interaction.services.ExecuteDeleteWithHeader;
import interaction.services.ExecuteGetParameters;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import utils.Const;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class DeleteUser implements Task {

    private final String idUser;


    public DeleteUser(String idUser) {
        this.idUser = idUser;
    }

    public static DeleteUser service( String idUser) {
        return instrumented(DeleteUser.class, idUser);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(ExecuteDeleteWithHeader.service(Const.QUERY_USER_ID, idUser, Const.AUTH_TOKEN));
    }
}
