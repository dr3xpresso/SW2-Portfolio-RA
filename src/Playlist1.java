
import components.queue.Queue;
import components.queue.Queue1L;

/**
 * {@code Playlist} represented as a {@link components.queue.Queue} with
 * implementations of primary methods.
 *
 * @param <Song>
 *            type of {@code Playlist} entries
 * @correspondence this = entries($this.rep)
 * @convention <this.rep> is not null
 */
public class Playlist1 extends PlaylistSecondary {

    /*
     * Private members --------------------------------------------------------
     */

    /**
     * Representation of {@code this}.
     */
    private Queue<Song> rep;

    /**
     * Creator of initial representation.
     */
    private void createNewRep() {
        this.rep = new Queue1L<>();
    }

    /*
     * Constructors -----------------------------------------------------------
     */

    /**
     * No-argument constructor.
     */
    public Playlist1() {
        this.createNewRep();
    }

    /*
     * Standard methods -------------------------------------------------------
     */

    public final Playlist<Song> newInstance() {
        try {
            return this.getClass().getConstructor().newInstance();
        } catch (ReflectiveOperationException e) {
            throw new AssertionError(
                    "Cannot construct object of type " + this.getClass());
        }
    }

    public final void clear() {
        this.createNewRep();
    }

    public final Playlist<Song> transferFrom(Playlist<Song> source) {
        assert source != null : "Violation: source is not null";
        assert source != this : "Violation: source is not this";

        Playlist1<Song> localSource = (Playlist1<Song>) source;
        this.rep = localSource.rep;
        localSource.createNewRep();
    }

    /*
     * Kernel methods --------------------------------------------------------x
     */
    @Override
    void addSong(Song song) {
        this.rep.enqueue(song);
    }

    @Override
    Song removeSong(Song song) {
        assert this.hasSong(song) : "Violation: song is not in this!";

        Queue<Song> temp = this.rep.newInstance();
        /*
         * couldnt figure out a way to make the variable nothing outside the
         * loop so I used null
         */
        Song removed = null;
        boolean removedFirst = false;

        while (this.rep.length() > 0) {
            Song x = this.rep.dequeue();

            if (!removedFirst && x.equals(song)) {
                removed = x;
                removedFirst = true;
            } else {
                temp.enqueue(x);
            }
        }

        this.rep.transferFrom(temp);

        return removed;
    }

    @Override
    int size() {
        int length = this.rep.length();

        return length;
    }

    @Override
    Song removeLastSong() {
        assert this.rep.length() > 0 : "Violation of: |this| > 0";

        this.rep.flip();
        Song removed = this.rep.dequeue();

        return removed;
    }

    @Override
    boolean hasSong(Song song) {
        boolean songIn = false;
        Queue<Song> temp = this.rep.newInstance();

        while (this.rep.length() > 0) {
            Song x = this.rep.dequeue();
            if (x.equals(song)) {
                songIn = true;
            }
            temp.enqueue(x);
        }

        this.rep.transferFrom(temp);
        return songIn;
    }
}
