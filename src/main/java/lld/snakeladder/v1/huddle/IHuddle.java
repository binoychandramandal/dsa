package lld.snakeladder.v1.huddle;

public interface IHuddle {
    int getNextPosition();
    int getStartPosition();
    int moveActualPosition(int currentPosition);
}
