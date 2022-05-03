/**
 * An exception that is thrown when attempting to vote for a candidate that is not on the ballot
 *
 * @author Edward Stump and Harsh Patel
 */
public class UnknownCandidateException extends Exception{
    private final String candidate;

    public UnknownCandidateException(String candidate){
        this.candidate = candidate;
    }

    /**
     * Returns the candidate that is not on the ballot
     *
     * @return the candidate that is not on the ballot
     */
    public String getCandidate() {
        return candidate;
    }
}
