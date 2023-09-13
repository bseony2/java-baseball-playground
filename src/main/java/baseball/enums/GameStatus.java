package baseball.enums;

public enum GameStatus {

    NEW (1)
    , END(2);
    private final int value;

    GameStatus(int value) {
        this.value = value;
    }

    public static boolean isUserWnatNewGame(int status) {
        return status == NEW.getValue();
    }

    public int getValue() {
        return this.value;
    }
}
