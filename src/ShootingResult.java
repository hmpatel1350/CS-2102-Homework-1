import java.util.LinkedList;
import java.util.Objects;

/**
 * Represents the results of a shooting event
 *
 * @author ejstump Edward Stump
 * @author hmpatel Harsh Patel
 *
 */
public class ShootingResult implements IEvent {
    final LinkedList<ShootingRound> rounds;

    public ShootingResult(LinkedList<ShootingRound> rounds) {
        this.rounds = rounds;
    }

    @Override
    public double pointsEarned() {
        int i = 0;
        for(ShootingRound sr: rounds)
            i+=sr.getHit();
        return i;
    }

    @Override
    public double getPenalties() {
        int MAX_POINTS = 5 * rounds.size();
        return 60 * (MAX_POINTS - pointsEarned());
    }

    public ShootingRound bestRoundByType(boolean standing){
        ShootingRound best = null;
        for(ShootingRound sr: rounds){
            if(sr.isStanding() == standing){
                if(best == null)
                    best = sr;
                else if(best.getHit() < sr.getHit())
                    best = sr;
            }
        }
        return best;
    }

    public LinkedList<ShootingRound> getRounds() {
        return rounds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShootingResult that = (ShootingResult) o;
        return Objects.equals(rounds, that.rounds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rounds);
    }
}
