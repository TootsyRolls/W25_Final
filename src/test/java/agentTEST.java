import org.junit.jupiter.api.*;
import java.util.*;

public class agentTEST {
    @Test
    public void viewDatabaseTest() {
        Agent agent = new Agent();

        List<Mission> missions = new ArrayList<>();
        missions.add(new Mission(0, "Alpha", "", Mission.Difficulty.EASY, Mission.Status.ACTIVE));
        missions.add(new Mission(0, "Bravo", "", Mission.Difficulty.MEDIUM, Mission.Status.CANCELLED));
        missions.add(new Mission(0, "Charlie", "", Mission.Difficulty.HARD, Mission.Status.COMPLETED));

        List<String> expected = List.of("Operation Alpha : ACTIVE"
                , "Operation Bravo : CANCELLED"
                , "Operation Charlie : COMPLETED");

        List<String> result = agent.viewDatabase(missions);

        Assertions.assertEquals(expected, result);
    }
}
