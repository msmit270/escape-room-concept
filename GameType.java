public enum GameType {

    SINGLE_PLAYER, MULTI_PLAYER;

    public String toString() {
        return switch (this) {
            case SINGLE_PLAYER -> "Single player Game";
            case MULTI_PLAYER -> "Multi Player Game";
        };
    }
}
