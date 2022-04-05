import static org.junit.Assert.*;

import org.junit.Test;

import java.util.LinkedList;

public class Examples {

    LinkedList<ShootingRound> rounds1(){
        LinkedList<ShootingRound> rounds = new LinkedList<>();
        rounds.add(new ShootingRound(5, true));
        rounds.add(new ShootingRound(2, false));
        rounds.add(new ShootingRound(1, true));
        rounds.add(new ShootingRound(0, false));
        return rounds;
    }

    public LinkedList<ShootingRound> rounds2(){
        LinkedList<ShootingRound> rounds = new LinkedList<>();
        rounds.add(new ShootingRound(5, true));
        rounds.add(new ShootingRound(2, true));
        rounds.add(new ShootingRound(4, false));
        rounds.add(new ShootingRound(3, false));
        return rounds;
    }

    ShootingResult shootingResult1 = new ShootingResult(rounds1());
    ShootingResult shootingResult2 = new ShootingResult(rounds2());

    SkiingResult skiingResult1 = new SkiingResult(1, 45.2, 43.7, 39.9, 47.8, 0);
    SkiingResult skiingResult2 = new SkiingResult(2, 45.1, 43.7, 39.9, 47.8, 3);

    MassStartResult massStartResult1 =
            new MassStartResult(10, 2, 23.4, 24.4, 35.4, 25.4, 0);
    MassStartResult massStartResult2 =
            new MassStartResult(9, 1, 21.0, 22.5, 19.0, 17.5, 0);

    FinalResult fResult1 = new FinalResult(shootingResult1, skiingResult1);
    FinalResult fResult2 = new FinalResult(shootingResult2, skiingResult2);

    Athlete jerry = new Athlete(fResult1, "Jerry");
    Athlete larry = new Athlete(fResult2, "Larry");


    @Test
    public void testPointsEarned_Skiing() {
        assertEquals(skiingResult1.pointsEarned(), 176.6, 0.01);
    }

    @Test
    public void testPointsEarned_Skiing2() {
        assertEquals(skiingResult2.pointsEarned(), 176.5, 0.01);
    }

    @Test
    public void testPointsEarned_Shooting() {
        assertEquals(shootingResult1.pointsEarned(), 8, 0.01);
    }

    @Test
    public void testPointsEarned_Shooting2() {
        assertEquals(shootingResult2.pointsEarned(), 14.0, 0.01);
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

    /*
     End of test cases for HW 1, after this are new test cases created for HW 2
     The methods from HW 1 that were changed are proved to work by the above test methods still working, so no
     further testing is needed for some of them
     */

    @Test
    public void testPointsEarned_MassStart() {
        assertEquals(massStartResult1.pointsEarned(), 108.6, 0.01);
    }

    @Test
    public void testPointsEarned_MassStart2() {
        assertEquals(massStartResult2.pointsEarned(), 80, 0.01);
    }



}
