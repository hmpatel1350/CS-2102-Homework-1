/**
 * An exception that is thrown when attempting to vote more than once for the same candidate in the same ballot
 *
 * @author Edward Stump and Harsh Patel
 */
public class DuplicateVotesException extends Exception{
    private final String candidate;

    public DuplicateVotesException(String candidate){
        this.candidate = candidate;
    }

    /**
     * Returns the candidate that is voted for twice
     *
     * @return the candidate
     */
    public String getCandidate() {
        return candidate;
    }



}
