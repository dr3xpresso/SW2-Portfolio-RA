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
     * Nested class representing a song with name and artist.
     */
    public static class Song {
        /**
         * Name of the song.
         */
        public String name;

        /**
         * Artist of the song.
         */
        public String artist;

        /**
         * Constructor for Song.
         *
         * @param name
         *            the name of the song
         * @param artist
         *            the artist of the song
         */
        public Song(String name, String artist) {
            this.name = name;
            this.artist = artist;
        }
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
     */
    void removeSong(Song song);

    /**
     * Reports length of {@code this}.
     *
     * @return the length of {@code this}
     * @ensures size = |this|
     */
    int size();

    /**
     * Removes the first song from {@code this}.
     *
     * @updates this
     * @requires this /= <>
     * @ensures #this = <removed song> * this
     */
    void removeLastSong();
}