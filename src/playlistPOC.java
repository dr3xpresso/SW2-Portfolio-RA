import components.queue.Queue;
import components.queue.Queue1L;

/**
 * @param <A>
 * @param <S>
 */
public class playlistPOC<S, A> {

    /*
     * map secondary didnt work with SimplePair and my Pair<S,A> so I had to
     * look up how to make a pair class to get it to work.
     */
    private static class Pair<S, A> {
        private final S song;
        private final A artist;

        Pair(S song, A artist) {
            this.song = song;
            this.artist = artist;
        }

        S key() {
            return this.song;
        }

        A value() {
            return this.artist;
        }
    }

    /*
     * Private members --------------------------------------------------------
     */

    /**
     * Pairs included in {@code this}. (I copied this from lab 7.)
     */
    private Queue<Pair<S, A>> playlist;

    /**
     * Creator of initial representation.
     */
    private void createNewRep() {
        this.playlist = new Queue1L<Pair<S, A>>();
    }

    /*
     * Constructors -----------------------------------------------------------
     */

    /**
     * No-argument constructor.
     */
    public playlistPOC() {
        this.createNewRep();
    }

    /**
     *
     * @param song
     * @param artist
     */
    private void addSong(S song, A artist) {
        Pair<S, A> p = new Pair<>(song, artist);
        this.playlist.enqueue(p);
    }

    /**
     *
     * @param song
     * @param artist
     * @requires this.length() >= 2
     */
    private void removeSong(S song, A artist) {
        int size = this.playlist.length();
        for (int i = 0; i < size; i++) {
            Pair<S, A> current = this.playlist.dequeue();
            if (!(current.key().equals(song)
                    && current.value().equals(artist))) {
                this.playlist.enqueue(current);
            }
        }

        //Doesn't return anything because I don't think it should right now.
    }

    /**
     *
     * @requires this.length() >= 2
     */
    private void removeLastSong() {
        this.playlist.dequeue();
    }

    /**
     *
     * @return legnth of this
     *
     */
    private int size() {
        return this.playlist.length();
    }

    /**
     *
     * @param <K>
     * @param <V>
     * @param p
     * @requires q.length() >= 2
     */
    private <K, V> void flipOrder(Queue<Pair<S, A>> p) {

        // just recursively flips it
        Pair<S, A> front = p.dequeue();
        this.flipOrder(p);
        p.enqueue(front);
    }

    /**
     *
     * @param <K>
     * @param <V>
     * @param p
     * @param song
     * @param artist
     * @requires q.length() >= 2
     */
    private <K, V> void moveToFront(Queue<Pair<S, A>> p, S song, A artist) {
        /*
         * searches for the element to move to front, pulls it out, then roates
         * through everything else to preserve the rest of the original order
         */
        /*
         * I need to make it so the method cant be called if the song is already
         * at the front.
         */

        int size = p.length();
        int foundIndex = -1;

        for (int i = 0; i < size; i++) {
            Pair<S, A> entry = p.dequeue();
            p.enqueue(entry);
            if (foundIndex == -1 && entry.key().equals(song)
                    && entry.value().equals(artist)) {
                foundIndex = i;
            }
        }

        if (foundIndex != -1) {
            for (int i = 0; i <= foundIndex; i++) {
                p.enqueue(p.dequeue());
            }
        }
    }

    /**
     *
     * @param <K>
     * @param <V>
     * @param p
     * @param song
     * @param artist
     * @requires q.length >=2
     */
    private <K, V> void moveToBack(Queue<Pair<S, A>> p, S song, A artist) {

        /*
         * I need to make it so the method cant be called if the song is already
         * at the back.
         */

        this.flipOrder(p);
        this.moveToFront(p, song, artist);
        this.flipOrder(p);

    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        playlistPOC<String, String> october25 = new playlistPOC<>();

        /*
         * I think there shouldn't be case sensitivity but I'm not too sure
         * about how to implement that yet.
         */
        october25.addSong("milk of the madonna", "Deftones");
        october25.addSong("Frankenstein", "Sweedish House Mafia & A$AP Rocky");
        october25.addSong("Never Late Again", "George Clanton");
        october25.addSong("RN", "Joey Valence & Brae");
        october25.addSong("Love Is a Place to Hide", "Puzzle");
        october25.addSong("Sky", "Playboi Carti");
        october25.addSong("Birds", "Turnstile");

        october25.removeSong("Sky", "Playboi Carti");

        october25.moveToFront(october25.playlist, "Birds", "Turnstile");

        october25.removeLastSong();

        october25.moveToBack(october25.playlist, "RN", "Joey Valence & Brae");

        october25.flipOrder(october25.playlist);

        int playlistSize = october25.size();

        /*
         * I think this should be okay? Not sure which methods should be kernel
         * or not. A lot of formatting stuff I copied from the projects and lab
         * just so there wouldnt be so many errors.
         */

    }
}
