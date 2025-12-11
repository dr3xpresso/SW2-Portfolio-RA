import components.playlist.Playlist1;

/**
 * Customized JUnit test fixture for {@code Playlist1}.
 */
public class Playlist1Test extends PlaylistTest {

    @Override
    protected final Playlist constructorTest() {
        return new Playlist1();
    }

    @Override
    protected final Playlist constructorRef() {
        return new Playlist1();
    }
}
