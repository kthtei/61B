public class OffByN implements CharacterComparator {
    private int N;

    OffByN(int N) {
        this.N = N;
    }

    @Override
    public boolean equalChars(char x, char y) {
        return x - N == y || x + N == y || x == y + N || x == y - N;
    }
}
