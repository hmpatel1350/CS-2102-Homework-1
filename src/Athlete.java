import java.util.Objects;

/**
 * Represents an athlete that can compete in events
 *
 * @author ejstump Edward Stump
 * @author hmpatel Harsh Patel
 *
 */
public class Athlete {
    private final FinalResult finalResult;
    private final String name;

    public Athlete(FinalResult finalResult, String name) {
        this.finalResult = finalResult;
        this.name = name;
    }

    public boolean betterSkiier(Athlete other) {
        //I believe Skiier should be spelled skier, but in the hw pdf as well as compile check it is spelled this way

        return (this.finalResult.getSkiingTime() < other.finalResult.getSkiingTime());
    }

    public boolean betterShooter(Athlete other) {
        return (this.finalResult.getShootingPoints() > other.finalResult.getShootingPoints());
    }

    public boolean hasBeaten(Athlete other) {
        return (this.betterSkiier(other) || this.betterShooter(other));
    }

    public FinalResult getFinalResult() {
        return finalResult;
    }
    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Athlete athlete = (Athlete) o;
        return Objects.equals(finalResult, athlete.finalResult) && Objects.equals(name, athlete.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(finalResult, name);
    }
}
