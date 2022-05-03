import java.util.Scanner;

/**
 * Wraps the UI for the voting system
 *
 * @author Edward Stump and Harsh Patel
 */
public class VotingMachine {

    private final ElectionData electionData = new ElectionData();
    private final Scanner keyboard = new Scanner(System.in);

    /**
     * Adds a given candidate to the ballot, given that they are not already there
     *
     * @param candidate the candidate to be added
     */
    public void addWriteIn(String candidate) {
        try {
            electionData.addCandidate(candidate);
            System.out.println("Candidate successfully added.");
        } catch (CandidateExistsException e) {
            System.out.println("This candidate already exists.");
        }
    }

    /**
     * Start the UI, which asks user for input and runs the voting system
     */
    public void screen() {

        while(true) {
            System.out.println("0: Exit program\n1: Add new candidate\n2: Vote" +
                    "\n3: Check winner (most first votes method)\n4: Check winner (most points method)");
            String input = keyboard.next();

            switch (input) {
                case "0":
                    return;
                case "1":
                    System.out.println("Who would you like to add?");
                    addWriteIn(keyboard.next());
                    break;
                case "2":
                    vote();
                    break;
                case "3":
                    String result = electionData.findWinnerMostFirstVotes();
                    if (result.equals("Runoff required")) System.out.println(result);
                    else System.out.println("The winner is " + result);
                    break;
                case "4":
                    System.out.println("The winner is " + electionData.findWinnerMostPoints());
                    break;
                default:
                    System.out.println("Input not recognized, please try again.");
                    break;
            }
        }
    }

    /**
     * Lets the user vote for their first, second, and thier choice candidate and adds their ballot to the election
     * data class, given that it is correct.
     */
    public void vote() {
        electionData.printBallot();
        System.out.println("Which candidate would you like to vote for as a first choice?");
        String cand1 = keyboard.next();
        System.out.println("Which candidate would you like to vote for as a second choice?");
        String cand2 = keyboard.next();
        System.out.println("Which candidate would you like to vote for as a third choice?");
        String cand3 = keyboard.next();

        try {
            electionData.processVote(cand1, cand2, cand3);
        } catch (UnknownCandidateException e) {
            System.out.println(e.getCandidate() +
                    " is not currently part of the ballot, would you like to add them?");
            String input = keyboard.next();
            if (input.equals("y") || input.equals("Y")) {
                addWriteIn(e.getCandidate());
            } else {
                System.out.println("Candidate has not been added.");
            }
            System.out.println("Please redo voting");


        } catch (DuplicateVotesException e) {
            System.out.println("You cannot vote for the same candidate twice.\nPlease redo voting.");
        }
    }

    /**
     * Used to run an example of the code with example candidates
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        VotingMachine votingMachine = new VotingMachine();
        votingMachine.addWriteIn("Larry");
        votingMachine.addWriteIn("Barry");
        votingMachine.addWriteIn("Jerry");

        votingMachine.screen();
    }
}
