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
     */

}
