import components.playlist.PlaylistKernel.Song;

/**
 * JUnit test fixture for {@code Playlist}'s constructor, kernel, standard, and
 * secondary methods.
 */
public abstract class PlaylistTest {

    /**
     * Invokes the appropriate {@code Playlist} constructor for the
     * implementation under test and returns the result.
     *
     * @return the new playlist
     * @ensures constructorTest = {}
     */
    protected abstract Playlist constructorTest();

    /**
     * Invokes the appropriate {@code Playlist} constructor for the reference
     * implementation and returns the result.
     *
     * @return the new playlist
     * @ensures constructorRef = {}
     */
    protected abstract Playlist constructorRef();

    /**
     * Creates and returnes a {@code Playlist} of the implementation under test
     * type with the given entries.
     *
     * @param args
     *            the entries for the set
     * @return the constructed playlist
     * @ensures createFromArgsTest = [entries in args]
     */
    private Playlist createFromArgsTest(Song... args) {
        Playlist playlist = this.constructorTest();
        for (Song s : args) {
            playlist.add(s);
        }
        return playlist;
    }

    /**
     * Creates and returnes a {@code Playlist} of the reference implementation
     * type with the given entries.
     *
     * @param args
     *            the entries for the set
     * @return the constructed playlist
     * @ensures createFromArgsTest = [entries in args]
     */
    private Playlist createFromArgsTest(Song... args) {
        Playlist playlist = this.constructorTest();
        for (Song s : args) {
            playlist.add(s);
        }
        return playlist;
    }

}
