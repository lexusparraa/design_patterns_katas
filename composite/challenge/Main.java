package composite.challenge;

public class Main {
    public static void main(String[] args) {
        Directory root = new Directory("Root");
        Directory music = new Directory("Music");
        
        File song1 = new File("song1.mp3", 5000); // 5MB
        File resume = new File("resume.pdf", 200); // 200KB
        
        root.addFile(resume);
        root.addDirectory(music);
        music.addFile(song1); // La música va dentro de la carpeta música

        System.out.println("Total Size: " + root.getTotalSizeKB() + " KB");
    }
}