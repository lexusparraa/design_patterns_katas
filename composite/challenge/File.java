package composite.challenge;

public class File {
    private String name;
    private int sizeKB;

    public File(String name, int sizeKB) {
        this.name = name;
        this.sizeKB = sizeKB;
    }

    public int getSizeKB() {
        return sizeKB;
    }
}