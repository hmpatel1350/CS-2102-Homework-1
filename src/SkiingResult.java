public class SkiingResult implements  IEvent{
    private int position;
    private double lap1;
    private double lap2;
    private double lap3;
    private double lap4;
    private int penalties;
    public SkiingResult(int position, double lap1, double lap2, double lap3, double lap4, int penalties){
        this.position = position;
        this.lap1 = lap1;
        this.lap2 = lap2;
        this.lap3 = lap3;
        this.lap4 = lap4;
        this.penalties = penalties;
    }

    @Override
    public double pointsEarned() {
        return lap1 + lap2 + lap3 + lap4;
    }

    @Override
    public double getPenalties() {
        return 5 * penalties;
    }

    public int getPosition() {
        return position;
    }
}
