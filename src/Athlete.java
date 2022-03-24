public class Athlete {
    private FinalResult finalResult;

    public Athlete(FinalResult finalResult) {
        this.finalResult = finalResult;
    }

    public boolean betterSkiier(Athlete other) {
        //I believe Skiier should be spelled skier, but in the hw pdf as well as compile check it is spelled this way

        return(this.finalResult.getSkiingTime() < other.finalResult.getSkiingTime());
    }
}
