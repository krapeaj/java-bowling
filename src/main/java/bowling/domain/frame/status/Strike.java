package bowling.domain.frame.status;

import bowling.domain.frame.score.Score;

class Strike extends Complete {

    @Override
    public Status bowl(int pins) {
        return this;
    }

    @Override
    public Score createScore() {
        return Score.ofStrike();
    }

    @Override
    public boolean updateScore(Score score) {
        score.bowl(ALL);
        return true;
    }

    @Override
    public boolean isStrike() {
        return true;
    }

    @Override
    public boolean isSpare() {
        return false;
    }

    @Override
    public String toString() {
        return "X";
    }
}