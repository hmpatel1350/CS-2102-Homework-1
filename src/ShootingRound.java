/**
 * Represents one round of a shooting event
 *
 * @author ejstump Edward Stump
 * @author hmpatel Harsh Patel
 *
 */
public class ShootingRound {
    private final int hit;
    private final boolean standing;

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
