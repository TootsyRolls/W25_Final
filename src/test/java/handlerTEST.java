import Project.*;
import org.junit.jupiter.api.*;
import java.util.*;

public class handlerTEST {

    @Test
    public void addAgentTest() {
        Handler handler = new Handler();

        Agent a1 = new Agent();
        Agent a2 = new Agent();
        Agent a3 = new Agent();

        handler.addAgent(a1);
        handler.addAgent(a2);
        handler.addAgent(a3);

        Assertions.assertEquals(handler.getAllAgents().size(), 3);
        Assertions.assertTrue(handler.getAllAgents().contains(a1));
        Assertions.assertTrue(handler.getAllAgents().contains(a2));
        Assertions.assertTrue(handler.getAllAgents().contains(a3));

    }

    @Test
    public void addMissionTest() {
        Handler handler = new Handler();

        Mission m1 = new Mission();
        Mission m2 = new Mission();
        Mission m3 = new Mission();

        handler.addMission(m1);
        handler.addMission(m2);
        handler.addMission(m3);

        Assertions.assertEquals(handler.getAllMissions().size(), 3);
        Assertions.assertTrue(handler.getAllMissions().contains(m1));
        Assertions.assertTrue(handler.getAllMissions().contains(m2));
        Assertions.assertTrue(handler.getAllMissions().contains(m3));

    }

    @Test
    public void assignMissionTest() {
        Handler handler = new Handler();

        Agent a1 = new Agent();

        Mission m1 = new Mission();

        handler.assignMission(a1, m1);

        Assertions.assertTrue(a1.getMissions().contains(m1));
        Assertions.assertEquals(a1.getMissions().size(), 1);
        Assertions.assertEquals(Mission.Status.ACTIVE, m1.getStatus());

    }

    @Test
    public void cancelMissionTest() {
        Handler handler = new Handler();

        Agent a1 = new Agent();

        Mission m1 = new Mission();

        handler.assignMission(a1, m1);
        handler.cancelMission(a1, m1);

        Assertions.assertEquals(Mission.Status.CANCELLED, m1.getStatus());
        Assertions.assertFalse(a1.getMissions().contains(m1));
        Assertions.assertEquals(0, a1.getMissions().size());
    }

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

    @Test
    public void viewStatsTest() {
        Handler handler = new Handler();

        Agent a1 = new Agent(0, "John", "1234", User.Ranks.LIEUTENANT);
        Agent a2 = new Agent(0, "Jim", "1234", User.Ranks.MAJOR);
        Agent a3 = new Agent(0, "Jen", "1234", User.Ranks.COLONEL);

        handler.addAgent(a1);
        handler.addAgent(a2);
        handler.addAgent(a3);

        a1.setMissionAssigned(2);
        a1.setMissionCompleted(5);

        a2.setMissionAssigned(3);
        a2.setMissionCompleted(2);

        a3.setMissionAssigned(0);
        a3.setMissionCompleted(6);

        String result = handler.viewStats();
        System.out.println( result);

        Assertions.assertTrue(result.contains("LIEUTENANT John"));
        Assertions.assertTrue(result.contains("Missions Assigned: 2"));
        Assertions.assertTrue(result.contains("Missions Completed: 5"));

        Assertions.assertTrue(result.contains("MAJOR Jim"));
        Assertions.assertTrue(result.contains("COLONEL Jen"));

    }


}
