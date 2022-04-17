package HW_2;

/**
 * Represents the results of a skiing event
 *
 * @author ejstump Edward Stump
 * @author hmpatel Harsh Patel
 *
 */
public class SkiingResult extends AbsSkiingEventResult implements IEvent {

    public SkiingResult(int position, double lap1, double lap2, double lap3, double lap4, int penalties) {
        super(position, lap1, lap2, lap3, lap4, penalties);
    }
}
