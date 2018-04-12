package bowling.domain;

public class Scores {
    static final int ALL = 10;
    static final int NONE = 0;

    private Score firstScore;
    private Score secondScore;
    private int pinsStanding;

    public Scores() {
        this.firstScore = new FirstScore();
        this.secondScore = new SecondScore();
        this.pinsStanding = ALL;
    }

    public void updateFirstThrow(int pinsKnocked) throws IllegalArgumentException {
        if (Validator.isValidScore(pinsKnocked, pinsKnocked)) {
            firstScore.updateScore(pinsKnocked);
            pinsStanding -= pinsKnocked;
        }
        throw new IllegalArgumentException("유효한 숫자가 아닙니다.");
    }

    public boolean firstThrowPlayed() {
        return firstScore.isPlayed();
    }

    public boolean isStrike() {
        return firstScore.isPlayed()
                && !secondScore.isPlayed()
                && pinsStanding == NONE;
    }

    public void updateSecondThrow(int pinsKnocked) {
        secondScore.updateScore(pinsKnocked);
        pinsStanding -= pinsKnocked;
    }

    public boolean secondThrowPlayed() {
        return secondScore.isPlayed();
    }

    public boolean isSpare() {
        return firstScore.isPlayed()
                && secondScore.isPlayed()
                && pinsStanding == NONE;
    }

    @Override
    public String toString() {
        return firstScore.toString(isStrike()) + secondScore.toString(isSpare());
    }
}