package tasks;

import interaction.services.ExecutePostWithHeader;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import utils.Const;

import java.util.List;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static utils.PreparateBodyPost.bodyUser;

public class PostAddUser implements Task {

    private final List<String> data;

    public PostAddUser(List<String> data) {
        this.data = data;
    }

    public static PostAddUser service(List<String> data) {
        return instrumented(PostAddUser.class, data);
    }

    @Override
    public <T extends Actor> void performAs(T actor ) {
        actor.attemptsTo(ExecutePostWithHeader.service(Const.PATH_USER).withParameter(bodyUser(data), Const.AUTH_TOKEN));
    }

}
