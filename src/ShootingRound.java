import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShootingRound that = (ShootingRound) o;
        return hit == that.hit && standing == that.standing;
    }

    @Override
    public int hashCode() {
        return Objects.hash(hit, standing);
    }
}
