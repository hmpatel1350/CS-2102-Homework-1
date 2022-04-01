import static org.junit.Assert.*;

import org.junit.Test;

public class Examples {

    ShootingResult shootingResult1 = new ShootingResult(new ShootingRound(5), new ShootingRound(2),
            new ShootingRound(1), new ShootingRound(0));
    ShootingResult shootingResult2 = new ShootingResult(new ShootingRound(5), new ShootingRound(2),
            new ShootingRound(4), new ShootingRound(3));

    SkiingResult skiingResult1 = new SkiingResult(1, 45.2, 43.7, 39.9, 47.8, 0);
    SkiingResult skiingResult2 = new SkiingResult(2, 45.1, 43.7, 39.9, 47.8, 3);

    FinalResult fResult1 = new FinalResult(shootingResult1, skiingResult1);
    FinalResult fResult2 = new FinalResult(shootingResult2, skiingResult2);

    Athlete jerry = new Athlete(fResult1, "Jerry");
    Athlete larry = new Athlete(fResult2, "Larry");


    @Test
    public void testPointsEarned_Skiing() {
        assertEquals(skiingResult1.pointsEarned(), 176.6, 0.01);
    }

    @Test
    public void testPointsEarned_Shooting() {
        assertEquals(shootingResult1.pointsEarned(), 8, 0.01);
    }

    @Test
    public void testPenalties_Skiing() {
        assertEquals(skiingResult2.getPenalties(), 15, 0.01);
    }

    @Test
    public void testPenalties_Shooting() {
        assertEquals(shootingResult1.getPenalties(), 720, 0.01);
    }

    @Test
    public void testFinalScore_jerry() {
        assertEquals(fResult1.finalScore(), 886.6, 0.01);
    }

    @Test
    public void testFinalScore_larry() {
        assertEquals(fResult2.finalScore(), 544.5, 0.01);
    }

    @Test
    public void testBetterSkiier_true() {
        assertTrue(larry.betterSkiier(jerry));
    }

    @Test
    public void testBetterSkiier_false() {
        assertFalse(jerry.betterSkiier(larry));
    }

    @Test
    public void testBetterShooter_true() {
        assertTrue(larry.betterShooter(jerry));
    }

    @Test
    public void testBetterShooter_false() {
        assertFalse(jerry.betterShooter(larry));
    }

    @Test
    public void testHasBeaten_true() {
        assertTrue(larry.hasBeaten(jerry));
    }

    @Test
    public void testHasBeaten_false() {
        assertFalse(jerry.hasBeaten(larry));
    }

}
