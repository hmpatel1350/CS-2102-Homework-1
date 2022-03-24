public class FinalResult {
    private ShootingResult shootingResult;
    private SkiingResult skiingResult;

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
}
