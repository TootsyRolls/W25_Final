import Project.Handler;
import Project.Mission;
import org.junit.jupiter.api.*;
import java.util.*;

public class handlerTEST {
    @Test
    public void viewDatabaseTest() {
        Handler handler = new Handler();

        List<Mission> missions = new ArrayList<>();
        missions.add(new Mission(0, "Alpha", "", Mission.Difficulty.EASY, Mission.Status.ACTIVE));
        missions.add(new Mission(0, "Bravo", "", Mission.Difficulty.MEDIUM, Mission.Status.CANCELLED));
        missions.add(new Mission(0, "Charlie", "", Mission.Difficulty.HARD, Mission.Status.COMPLETED));

        List<String> expected = List.of("Operation Alpha : ACTIVE"
                , "Operation Bravo : CANCELLED"
                , "Operation Charlie : COMPLETED");

        List<String> result = handler.viewDatabase(missions);

        Assertions.assertEquals(expected, result);
    }
}
