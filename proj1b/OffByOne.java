public class OffByOne implements CharacterComparator {

    @Override
    public boolean equalChars(char x, char y) {
        return x - 1 == y || x + 1 == y || x == y + 1 || x == y - 1;
    }
}
