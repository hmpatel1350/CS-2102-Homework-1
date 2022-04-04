import java.util.LinkedList;

/**
 * Represents a competition
 *
 * @author ejstump Edward Stump
 * @author hmpatel Harsh Patel
 *
 */
public class Competition {
    private final int numOfShootRounds;
    private final LinkedList<Athlete> athletes;

    public Competition(int numOfShootRounds, LinkedList<Athlete> athletes) {
        this.numOfShootRounds = numOfShootRounds;
        this.athletes = athletes;
    }

    public LinkedList<String> shootingDNF(){
        LinkedList<String> dnf = new LinkedList<>();
        for(Athlete a: athletes) {
            FinalResult fr = a.getFinalResult();
            ShootingResult sh = fr.getShootingResult();
            if(sh.getRounds().size()<numOfShootRounds)
                dnf.add(a.getName());
        }
        return dnf;
    }

    public double finalScoreForAthlete(String name){
        for(Athlete a: athletes)
            if(a.getName().equals(name))
                return a.getFinalResult().finalScore();
        return -1; //If name wasn't found
    }

    public boolean anyImprovement(Competition c){
        for(Athlete a: athletes){
            Athlete old = c.athletes.get(c.athletes.indexOf(a)); //Index of uses .equals() in Athlete, which uses name
            if(old.getFinalResult().finalScore()<a.getFinalResult().finalScore())
                return true;
        }
        return false;
    }

    /*
    I think the code for finalScoreForAthlete and anyImprovement are pretty good and don't really need any additional
    helper functions that could be created that could be used in both of them, at least with the way we implemented
    the two methods. All that is really shared is looping through the athletes list, but that wouldn't require a helper
    function.
     */

}