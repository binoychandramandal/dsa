package lld.snakeladder.v1.huddle;

public abstract   class AbstractHuddle implements IHuddle{

    private int start;
    private int end;

    public AbstractHuddle(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int getNextPosition() {
        return end;
    }

    @Override
    public int getStartPosition() {
        return start;
    }

    @Override
    public int moveActualPosition(int currentPosition) {
        return currentPosition+end;
    }
}
