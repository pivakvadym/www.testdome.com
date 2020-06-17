package testdom.com;

import java.util.HashSet;
import java.util.Set;
/*
* A playlist is considered a repeating playlist if any of the songs contain
* a reference to a previous song in the playlist. Otherwise, the playlist will end with the last song which points to null.
* Implement a function isRepeatingPlaylist that, efficiently with respect to time used, returns true if a playlist is repeating
* or false if it is not. For example, the following code prints "true" as both songs point to each other.
* */

public class Song {
    private String name;

    public Song getNextSong() {
        return nextSong;
    }

    private Song nextSong;

    public Song(String name) {
        this.name = name;
    }

    public void setNextSong(Song nextSong) {
        this.nextSong = nextSong;
    }

    public boolean isRepeatingPlaylist() {

        Song current = this;

        Set<Song> uniqueSongs = new HashSet<>();

        uniqueSongs.add(this);

        while(current.getNextSong()!=null) {
            if(uniqueSongs.contains(current.getNextSong())) return true;
            // add the song to the set, and assign current to the next song
            uniqueSongs.add(current=current.getNextSong());
        }
        // we reached the end of the list without finding any doubles, so:
        return false;
    }

    public static void main(String[] args) {
        Song first = new Song("Hello");
        Song second = new Song("Eye of the tiger");
        Song third = new Song("I believe I can fly");

        first.setNextSong(second);
        second.setNextSong(first);

        System.out.println(first.isRepeatingPlaylist());
    }
}