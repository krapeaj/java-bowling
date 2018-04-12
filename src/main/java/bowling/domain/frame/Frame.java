package bowling.domain.frame;

public interface Frame {

    public abstract boolean isStrike();

    public abstract boolean isSpare();

    public abstract boolean updateScore(int pinsKnocked);

    @Override
    public abstract String toString();
}