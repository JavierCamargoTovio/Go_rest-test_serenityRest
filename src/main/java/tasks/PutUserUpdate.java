package tasks;

import interaction.services.ExecutePutWithHeader;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import utils.Const;
import utils.PreparateBodyPost;

import java.util.List;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class PutUserUpdate implements Task {

    private final String id;
    private final List<String> data;

    public PutUserUpdate(String id, List<String> data) {
        this.id = id;
        this.data = data;
    }

    public static PutUserUpdate service(String id, List<String> data) {
        return instrumented(PutUserUpdate.class, id, data);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(ExecutePutWithHeader.service(Const.QUERY_USER_ID, id, PreparateBodyPost.bodyUser(data), Const.AUTH_TOKEN));
    }
}
