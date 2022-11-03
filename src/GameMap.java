public class GameMap {
    private final Object[][] grid;

    GameMap(int size) {
        this.grid = new Object[size][size];
    }

    public Object[][] getGrid() {
        return grid;
    }
}
