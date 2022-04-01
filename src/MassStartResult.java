public class MassStartResult extends AbsSkiingEventResult implements IEvent{
    int startingPosition;

    public MassStartResult(int startingPosition, int position, double lap1, double lap2, double lap3, double lap4, int penalties) {
        super(position, lap1, lap2, lap3, lap4, penalties);
        this.startingPosition = startingPosition;
    }

}
