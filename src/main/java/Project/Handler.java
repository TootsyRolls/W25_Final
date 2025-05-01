package Project;

import java.util.*;

public class Handler extends User implements Comparable<Handler> {
    private List<Mission> allMissions;
    private List<Agent> agents; // agents assigned under handler

    public Handler() {
        super();
        this.agents = new ArrayList<>();
    }

    public Handler(int id, String name, String password, Ranks rank) {
        super(id, name, password, rank);
        this.agents = new ArrayList<>();
    }

    // add missions

    /**
     * This method adds agents to a handler
     * @param agent
     */
    public void addAgent(Agent agent) {
        agents.add(agent);
    }

    /**
     * This method adds missions to a list containing all existing missions
     * @param mission
     */
    public void addMission(Mission mission) {
        allMissions.add(mission);
    }

    /**
     * This method assigns missions to agents, sets the mission status to active and updates the stats of the agent
     * @param agent
     * @param mission
     */
    public void assignMission(Agent agent, Mission mission) {
        agent.getMissions().add(mission);
        agent.setMissionAssigned(agent.getMissionAssigned() + 1);
        mission.setStatus(Mission.Status.ACTIVE);
        // maybe add text print
    }

    /**
     * This method cancels active missions that were assigned to agents, it updates their stats as well
     * @param agent
     * @param mission
     */
    public void cancelMission(Agent agent, Mission mission) {
        if (mission.getStatus() == Mission.Status.CANCELLED) {
            System.out.println("The mission is already CANCELLED.");
        } else if (mission.getStatus() == Mission.Status.COMPLETED) {
            System.out.println("The mission is already COMPLETED.");
        } else {
            mission.setStatus(Mission.Status.CANCELLED);
            agent.getMissions().remove(mission);
            agent.setMissionAssigned(agent.getMissionAssigned() - 1);
        }
        // maybe add text print
    }

    /**
     * This method shows list of all existing missions and their statuses
     * @param allMissions
     * @return A list of all existing missions and their statuses
     */
    @Override
    public List<String> viewDatabase(List<Mission> allMissions) {
        List<String> allMissionsList = new ArrayList<>();
        for (Mission m : allMissions) {
            allMissionsList.add(m.getName() + " : " + m.getStatus());
        }
        return allMissionsList;
        // change into string?
    }

    /**
     * This method shows the performance stats of every agent
     * @return string showing amount of statistics for every agent under the handler
     */
    @Override
    public String viewStats() {
        String str = new String();

        System.out.println("Agent Performance");
        for (Agent agent : agents) {
            str += "\nAgent: " + agent.getName() +
                    "\nMissions Assigned: " + agent.getMissionAssigned() +
                    "\nMissions Completed: " + agent.getMissionCompleted();
        }

        return str;
    }

    @Override
    public int compareTo(Handler o) {
        return 0;
        // TODO
    }
}
