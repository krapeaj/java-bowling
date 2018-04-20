package bowling.domain.frame.status.last;

public class Spare implements Status {

    public Status bowl(int pins) {
        if (pins == 10) {
            return new Strike();
        }
        return new Miss(pins);
    }

    public boolean isStrike() {
        return false;
    }

    public boolean isSpare() {
        return true;
    }

    @Override
    public String toString() {
        return "/";
    }
}
