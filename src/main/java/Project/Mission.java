package Project;

import java.util.Collections;
import java.util.Comparator;

public class Mission implements Comparator<Mission> {
    private int id;
    private String name;
    private String location;
    private int difficulty; // Compare using ints later
    private Status status;

    public enum Status {
        CLOSED,
        ACTIVE,
        COMPLETED,
        CANCELLED;
    }
    public enum Difficulty { // String with int value
        EASY(1),
        MEDIUM(2),
        HARD(3),
        SPECIAL(4);

        private final int difficultyLevel; // int value

        Difficulty(int difficultyLevel) { // constructor initialize int value
            this.difficultyLevel = difficultyLevel;
        }

        public int getDifficultyLevel() { // get int value for use
            return difficultyLevel;
        }

    }
    public Mission() {
        this.id = 0;
        this.name = "Operation " + "TBA";
        this.location = "TBA";
        this.difficulty = Difficulty.EASY.getDifficultyLevel();
        this.status = Status.CLOSED;
    }

    public Mission(int id, String name, String location, Difficulty difficulty, Status status) {
        this.id = id;
        this.name = "Operation " + name;
        this.location = location;
        this.difficulty = difficulty.getDifficultyLevel();
        this.status = status;
    }

    // add methods

    /**
     * This method compares two missions' difficulty rating
     * @param m1 the first object to be compared.
     * @param m2 the second object to be compared.
     * @return
     */
    @Override
    public int compare(Mission m1, Mission m2) {
        return Integer.compare(m1.getId(), m2.getId());
        // maybe make it so that it returns a list of sorted missions based on difficulty?
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
