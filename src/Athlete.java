public class Athlete {
    private FinalResult finalResult;
    private String name;

    public Athlete(FinalResult finalResult, String name) {
        this.finalResult = finalResult;
        this.name = name;
    }

    public boolean betterSkiier(Athlete other) {
        //I believe Skiier should be spelled skier, but in the hw pdf as well as compile check it is spelled this way

        return (this.finalResult.getSkiingTime() < other.finalResult.getSkiingTime());
    }

    public boolean betterShooter(Athlete other) {
        return (this.finalResult.getShootingPoints() > other.finalResult.getShootingPoints());
    }

    public boolean hasBeaten(Athlete other) {
        return (this.betterSkiier(other) || this.betterShooter(other));
    }
}
