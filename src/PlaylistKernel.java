package components.playlist;

import components.standard.Standard;

/**
 * Playlist kernel component with primary methods. (Note: by package-wide
 * convention, all references are non-null.)
 *
 * I imagine this part of the javadoc stuff will all get added later? Also I
 * don't really understand how Playlistkernel extends standard<playlist> when Im
 * not sure if that even exists in standard. it was just how the queue one and
 * natrual number one were written.
 *
 */
public interface PlaylistKernel extends Standard<Playlist> {

    /**
     * Java record representing a song with its name and artist.
     *
     * @param name
     *            the name of the song
     * @param artist
     *            the artist of the song
     */
    public record Song(String name, String artist) {
    }

    /**
     * Adds {@code song} to the end of {@code this}.
     *
     * @param song
     *            the song to be added
     * @updates this
     * @ensures this = #this * <song>
     */
    void addSong(Song song);

    /**
     * Removes {@code song} from {@code this}.
     *
     * @param song
     *            the song to be removed
     * @updates this
     * @requires song is in this
     * @ensures this = #this with the first occurrence of song removed
     * @return the removed song
     */
    Song removeSong(Song song);

    /**
     * Reports length of {@code this}.
     *
     * @return the length of {@code this}
     * @ensures size = |this|
     */
    int size();

    /**
     * Removes and returns the last song from {@code this}.
     *
     * @updates this
     * @requires |this| > 0
     * @ensures #this = <removeLastSong> * this
     * @return the removed song
     */
    Song removeLastSong();

    /**
     * Reports whether {@code song} is in {@code this}.
     *
     * @param song
     *            the song to check for
     * @return true if {@code song} is in {@code this}, false if not
     * @ensures hasSong = (song is in this)
     */
    boolean hasSong(Song song);
}