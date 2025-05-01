package Project;

import java.util.*;

public class Agent extends User {
    private List<Mission> missions;
    private int missionCompleted;
    private int missionAssigned;

    public Agent() {
        super();
        this.missions = new ArrayList<>();
        this.missionCompleted = 0;
        this.missionAssigned = 0;
    }

    public Agent(int id, String name, String password, Ranks rank) {
        super(id, name, password, rank);
        this.missions = new ArrayList<>();
        this.missionCompleted = 0;
        this.missionAssigned = 0;
    }

    // add methods

    /**
     * This method updates the status of a mission to completed as well as the agent's stats
     * @param mission
     */
    public void completeMission(Mission mission) {
        mission.setStatus(Mission.Status.COMPLETED);
        this.missionCompleted++;
        this.missionAssigned--;
        // maybe add text print
    }

    /**
     * This method shows list of all the missions and their statuses belonging to an agent
     * @param missions
     * @return A list of all missions and their statuses belonging to an agent
     */
    @Override
    public List<String> viewDatabase(List<Mission> missions) {
        List<String> agentMissionsList = new ArrayList<>();
        for (Mission m : missions) {
            agentMissionsList.add(m.getName() + " : " + m.getStatus());
        }
        return agentMissionsList;
        // change into string?
    }

    /**
     * This method shows the stats of the agent
     * @return string showing amount of missions assigned and completed
     */
    @Override
    public String viewStats() {
        return getRank() + " " + getName() +
                "\nMissions Assigned: " + missionAssigned +
                "\nMissions Completed: " + missionCompleted;
    }


    public List<Mission> getMissions() {
        return missions;
    }

    public void setMissions(List<Mission> missions) {
        this.missions = missions;
    }

    public int getMissionCompleted() {
        return missionCompleted;
    }

    public void setMissionCompleted(int missionCompleted) {
        this.missionCompleted = missionCompleted;
    }

    public int getMissionAssigned() {
        return missionAssigned;
    }

    public void setMissionAssigned(int missionAssigned) {
        this.missionAssigned = missionAssigned;
    }
}
