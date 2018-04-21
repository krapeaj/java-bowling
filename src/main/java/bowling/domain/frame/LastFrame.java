package bowling.domain.frame;

import bowling.domain.frame.score.Score;
import bowling.domain.frame.status.last.LastFrameStatus;
import bowling.domain.util.Formatter;

public class LastFrame extends Frame {
    private final LastFrameStatus status; //TODO: Refactoring needed - maybe could implement an interface?
    private final Score score;

    public LastFrame() {
        this.status = new LastFrameStatus();
        this.score = Score.ofNotPlayed();
    }

    @Override
    public Frame bowl(int pins) {
        status.bowl(pins);
        return null;
    }

    @Override
    public boolean calculateScore() { //TODO: Exception for frame number = 8
        return status.updateLastFrameScore(score);
    }

    @Override
    public boolean calculateAdditionalScore(Score prevScore) {
        return status.updateScoresFromPreviousFrames(prevScore);
    }

    @Override
    public boolean updateScoreFromPrevPrev(Score prevPrev) {
        return status.updateScoresFromPreviousFrames(prevPrev);
    }

    @Override
    public boolean isLast() {
        return status.isComplete();
    }

    @Override
    public String convertStatusToPrintable() {
        return Formatter.formatFrame(status.toString());
    }

    @Override
    public String convertScoreToPrintable() {
        return Formatter.formatFrame(score.toString());
    }
}