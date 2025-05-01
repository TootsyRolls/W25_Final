import Project.Agent;
import Project.Mission;
import Project.User;
import org.junit.jupiter.api.*;
import java.util.*;

public class agentTEST {

    @Test
    public void completeMissionTest() {
        Agent agent = new Agent();

        Mission m1 = new Mission(0, "Alpha", "", Mission.Difficulty.EASY, Mission.Status.ACTIVE);
        agent.setMissionAssigned(1);
        agent.setMissionCompleted(0);

        agent.completeMission(m1);

        Assertions.assertTrue(m1.getStatus() == Mission.Status.COMPLETED);
        Assertions.assertEquals(agent.getMissionAssigned(), 0);
        Assertions.assertEquals(agent.getMissionCompleted(), 1);
    }

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

    @Test
    public void viewStatsTest() {
        Agent agent  = new Agent(0, "Dan", "1234", User.Ranks.LIEUTENANT);
        agent.setMissionAssigned(2);
        agent.setMissionCompleted(4);

        System.out.println(agent.viewStats());

    }
}
