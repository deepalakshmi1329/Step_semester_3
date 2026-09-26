import java.util.Arrays;

public class Playlist {
    private final String[] songs;
    private int count;

    public Playlist(int maximumSongs) {
        songs = new String[maximumSongs];
        count = 0;
    }

    public void addSong(String song) {
        if (count < songs.length) {
            songs[count] = song;
            count++;
        }
    }

    public String[] getSongs() {
        return Arrays.copyOf(songs, count);
    }

    public int getSongCount() {
        return count;
    }

    public static void main(String[] args) {
        Playlist p = new Playlist(10);
        p.addSong("Song A");
        p.addSong("Song B");

        String[] copy = p.getSongs();
        copy[0] = "Hacked";

        System.out.println("Song count: " + p.getSongCount());
        System.out.println("First song: " + p.getSongs()[0]);
        System.out.println("Second song: " + p.getSongs()[1]);
    }
}