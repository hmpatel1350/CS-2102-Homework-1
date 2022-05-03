/**
 * An exception that is thrown when attempting to add a candidate that already exists to a voting system
 *
 * @author Edward Stump and Harsh Patel
 */
public class CandidateExistsException extends Exception{
    private final String candidate;

    public CandidateExistsException(String candidate){
        this.candidate = candidate;
    }

    /**
     * Returns the candidate that already exists in the ballot
     *
     * @return the candidate that already exists
     */
    public String getCandidate() {
        return candidate;
    }
}
