public class DuplicateVotesException extends Exception{
    private String candidate;

    public DuplicateVotesException(String candidate){
        super(candidate);
    }

    public String getCandidate() {
        return candidate;
    }
}
