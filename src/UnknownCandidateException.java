public class UnknownCandidateException extends Exception{
    private String candidate;

    public UnknownCandidateException(String candidate){
        super(candidate);
    }

    public String getCandidate() {
        return candidate;
    }
}
