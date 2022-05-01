import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class ElectionData {
    private HashMap<String, Integer> ballot = new HashMap<>();
    private LinkedList<HashMap<Integer, String>> votes = new LinkedList<>();
    private Scanner keyboard = new Scanner(System.in);

    public ElectionData() {
        this.ballot.put("Gompei", 0);
        this.ballot.put("Husky", 0);
    }

    public void printBallot() {
        System.out.println("The candidates are ");
        for (String s : ballot.keySet()) {
            System.out.println(s);
        }
    }

    /*
    public void screen() {
        this.printBallot();
        System.out.println("Who do you want to vote for?");
        String candidate = keyboard.next();
        //votes.add(candidate);
        System.out.println("You voted for " + candidate);
    }

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

    public void addCandidate(String candidate) throws CandidateExistsException {
        if(ballot.containsKey(candidate))
            throw new CandidateExistsException(candidate);
        else ballot.put(candidate, 0);
    }

    /*
    public int countVotes(String forcand) {
        int numvotes = 0;
        for (String s : votes) {
            if (s.equals(forcand))
                numvotes = numvotes+1;
        }
        return numvotes;
    }
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
            if(ballot.get(candidate)>count)
                s = candidate;
        }

        if(ballot.get(s)>votes.size()/2)
            return s;
        else return "Runoff required";

    }

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
