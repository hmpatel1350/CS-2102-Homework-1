import java.util.Objects;

/**
 * Represents the combined results of all events from an athlete
 *
 * @author ejstump Edward Stump
 * @author hmpatel Harsh Patel
 *
 */
public class FinalResult {
    final ShootingResult shootingResult;
    final SkiingResult skiingResult;

    public FinalResult(ShootingResult shootingResult, SkiingResult skiingResult) {
        this.shootingResult = shootingResult;
        this.skiingResult = skiingResult;
    }

    public double finalScore() { //TODO double check scoring
        double totalPoints = skiingResult.pointsEarned() + skiingResult.getPenalties() + shootingResult.getPenalties();
        int position = skiingResult.getPosition();
        double positionScore;
        switch (position) {
            case 1:
                positionScore = 10;
                break;
            case 2:
                positionScore = 7;
                break;
            case 3:
                positionScore = 3;
                break;
            case 4:
                positionScore = 1;
                break;
            default:
                positionScore = 0;
                break;
        }
        return totalPoints - positionScore;
    }

    public double getSkiingTime() {
        return this.skiingResult.pointsEarned();
    }

    public double getShootingPoints() {
        return this.shootingResult.pointsEarned();
    }

    public ShootingResult getShootingResult() {
        return shootingResult;
    }

    public SkiingResult getSkiingResult() {
        return skiingResult;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FinalResult that = (FinalResult) o;
        return Objects.equals(shootingResult, that.shootingResult) && Objects.equals(skiingResult, that.skiingResult);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shootingResult, skiingResult);
    }
}
