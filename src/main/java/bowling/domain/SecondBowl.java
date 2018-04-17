package bowling.domain;

public class SecondBowl {
    private Integer pinsLeftFromPrevBowl;
    private Integer pinsDownFromThisBowl;

    public boolean isPlayed() {
        return pinsDownFromThisBowl != null;
    }

    public boolean isSpare() {
        return isPlayed() && pinsDownFromThisBowl.equals(pinsLeftFromPrevBowl);
    }

    public Integer bowl(int pinsLeftFromPrevBowl, int pinsDownFromThisBowl) {
        if (isPlayed()) {
            this.pinsLeftFromPrevBowl = pinsLeftFromPrevBowl;
            return this.pinsDownFromThisBowl = pinsDownFromThisBowl;
        }
        return null;
    }
}