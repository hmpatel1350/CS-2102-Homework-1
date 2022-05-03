import java.util.HashMap;
import java.util.LinkedList;

/**
 * Represents the data for an election, including the candidates and their current vote totals in a hash map.
 *
 * @author Edward Stump and Harsh Patel
 */
public class ElectionData {
    private final HashMap<String, Integer> ballot = new HashMap<>();
    private final LinkedList<HashMap<Integer, String>> votes = new LinkedList<>();

    /**
     * Prints out the current candidates
     */
    public void printBallot() {
        System.out.println("The candidates are ");
        for (String s : ballot.keySet()) {
            System.out.println(s);
        }
    }

    /**
     * Processes a user's vote, adding them to the stored votes if they are valid votes
     *
     * @param one the first choice candidate
     * @param two the second choice candidate
     * @param three the third choice candidate
     * @throws UnknownCandidateException thrown if a candidate is not on the ballot
     * @throws DuplicateVotesException thrown if the same candidate is voted for multiple times
     */
    public void processVote(String one, String two, String three) throws UnknownCandidateException, DuplicateVotesException{
        HashMap<Integer, String> choices = new HashMap<>(3);
        if (ballot.containsKey(one))
            choices.put(1, one);
        else throw new UnknownCandidateException(one);

        if(!ballot.containsKey(two))
            throw new UnknownCandidateException(two);
        else if (one.equals(two))
            throw new DuplicateVotesException(two);
        else choices.put(2, two);

        if(!ballot.containsKey(three))
            throw new UnknownCandidateException(three);
        else if(one.equals(three) || two.equals(three))
            throw new DuplicateVotesException(three);
        else choices.put(3, three);

        votes.add(choices);
    }

    /**
     * Adds a given candidate to the ballot given that they are not already there
     *
     * @param candidate the candidate to be added
     * @throws CandidateExistsException thrown if the candidate to be added is already there
     */
    public void addCandidate(String candidate) throws CandidateExistsException {
        if(ballot.containsKey(candidate))
            throw new CandidateExistsException(candidate);
        else ballot.put(candidate, 0);
    }

    /**
     * Finds the winner of the election, decided by the one with the most first choice votes
     *
     * @return the winning candidate's name
     */
    public String findWinnerMostFirstVotes(){
        ballot.replaceAll((i, s) -> 0);

        for (HashMap<Integer, String> vote: votes){
            String cand = vote.get(1);
            ballot.replace(cand, ballot.get(cand)+1);
        }
        String s = "";
        int count = Integer.MIN_VALUE;
        for(String candidate: ballot.keySet()){
            if(ballot.get(candidate)>count) {
                s = candidate;
                count = ballot.get(candidate);
            }
        }
        if(ballot.get(s)>votes.size()/2)
            return s;
        else return "Runoff required";

    }

    /**
     * Finds the winner of the election, decided by the one with the most 'points'
     *
     * @return the winning candidate's name
     */
    public String findWinnerMostPoints(){
        ballot.replaceAll((i, s) -> 0);

        for(HashMap<Integer, String> vote: votes){
            for(Integer i: vote.keySet()){
                String cand = vote.get(i);
                ballot.replace(cand, ballot.get(cand)+4-i);
            }
        }
        String s = "";
        int count = Integer.MIN_VALUE;
        for(String candidate: ballot.keySet()){
            if(ballot.get(candidate)>count)
                s = candidate;
        }
        return s;
    }
}
