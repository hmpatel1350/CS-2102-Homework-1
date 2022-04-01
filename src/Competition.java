import java.util.LinkedList;

public class Competition {
    private int numOfShootRounds;
    private LinkedList<Athlete> athletes;

    public Competition(int numOfShootRounds, LinkedList<Athlete> athletes) {
        this.numOfShootRounds = numOfShootRounds;
        this.athletes = athletes;
    }

}
