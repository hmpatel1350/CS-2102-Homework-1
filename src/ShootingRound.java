public class ShootingRound {
    private int hit;
    private boolean standing;

    public ShootingRound(int hit, boolean standing) {
        this.hit = hit;
        this.standing = standing;
    }

    public int getHit() {
        return hit;
    }

    public boolean isStanding() {
        return standing;
    }
}
