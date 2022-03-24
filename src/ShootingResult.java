public class ShootingResult implements IEvent {
    private ShootingRound round1;
    private ShootingRound round2;
    private ShootingRound round3;
    private ShootingRound round4;

    public ShootingResult(ShootingRound round1, ShootingRound round2, ShootingRound round3, ShootingRound round4) {
        this.round1 = round1;
        this.round2 = round2;
        this.round3 = round3;
        this.round4 = round4;
    }

    @Override
    public double pointsEarned() {
        return round1.getHit() + round2.getHit() + round3.getHit() + round4.getHit();
    }

    @Override
    public double getPenalties() {
        int MAX_POINTS = 20; //5 from each round;
        return 60 * (MAX_POINTS - pointsEarned());
    }


}
