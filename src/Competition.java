import java.util.LinkedList;

public class Competition {
    private int numOfShootRounds;
    private LinkedList<Athlete> athletes;

    public Competition(int numOfShootRounds, LinkedList<Athlete> athletes) {
        this.numOfShootRounds = numOfShootRounds;
        this.athletes = athletes;
    }

    public LinkedList<Athlete> shootingDNF(){
        LinkedList<Athlete> dnf = new LinkedList<>();
        for(Athlete a: athletes) {
            FinalResult fr = a.getFinalResult();
            ShootingResult sh = fr.getShootingResult();
            if(sh.getRounds().size()<numOfShootRounds)
                dnf.add(a);
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
            Athlete old = c.athletes.get(c.athletes.indexOf(a));
            if(old.getFinalResult().finalScore()<a.getFinalResult().finalScore())
                return true;
        }
        return false;
    }


    public int getNumOfShootRounds() {
        return numOfShootRounds;
    }

    public LinkedList<Athlete> getAthletes() {
        return athletes;
    }
}
