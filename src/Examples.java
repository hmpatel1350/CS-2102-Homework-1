import static org.junit.Assert.*;
import org.junit.Test;

public class Examples {

    ElectionData Setup1 () {

        ElectionData ED = new ElectionData();

        // put candidates on the ballot
        try {

            ED.addCandidate("gompei");
            ED.addCandidate("husky");
            ED.addCandidate("ziggy");
            ED.addCandidate("larry");

        } catch (Exception e) {}

        // cast votes

        try {

            ED.processVote("gompei", "husky", "ziggy");
            ED.processVote("gompei", "larry", "husky");
            ED.processVote("husky", "ziggy", "larry");


        } catch (Exception e) {}
        return(ED);
    }

    ElectionData Setup2 () {

        ElectionData ED = new ElectionData();

        // put candidates on the ballot
        try {

            ED.addCandidate("gompei");
            ED.addCandidate("husky");
            ED.addCandidate("ziggy");
            ED.addCandidate("larry");

        } catch (Exception e) {}

        // cast votes

        try {

            ED.processVote("gompei", "husky", "ziggy");
            ED.processVote("gompei", "husky", "ziggy");
            ED.processVote("husky", "ziggy", "larry");
            ED.processVote("husky", "gompei", "larry");


        } catch (Exception e) {}
        return(ED);
    }

    @Test
    public void testMostFirstWinner1 () {
        assertEquals ("gompei", Setup1().findWinnerMostFirstVotes());
    }

    @Test
    public void testMostFirstWinner2 () {
        assertEquals ("Runoff required", Setup2().findWinnerMostFirstVotes());
    }

    @Test
    public void testMostPointsWinner1 () {
        assertEquals ("gompei", Setup1().findWinnerMostPoints());
    }

    @Test
    public void testMostPointsWinner2 () {
        assertEquals ("gompei", Setup2().findWinnerMostPoints());
    }

    @Test(expected = CandidateExistsException.class)
    public void testCandidateExistsException() throws CandidateExistsException {
        ElectionData test = new ElectionData();
        test.addCandidate("larry");
        test.addCandidate("larry");

    }

    @Test(expected = UnknownCandidateException.class)
    public void testUnknownCandidateExpection() throws UnknownCandidateException, DuplicateVotesException {
        ElectionData test = new ElectionData();
        test.processVote("larry", "jerry", "barry");
    }

    @Test(expected = DuplicateVotesException.class)
    public void testDuplicateVotesExpection() throws UnknownCandidateException, DuplicateVotesException, CandidateExistsException {
        ElectionData test = new ElectionData();
        test.addCandidate("larry");
        test.addCandidate("barry");
        test.processVote("larry", "barry", "larry");
    }


}
