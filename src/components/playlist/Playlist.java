package components.playlist;

/**
 *
 */
public interface Playlist extends PlaylistKernel {

    /**
     * Flips the order of {@code this}.
     *
     * @updates this
     * @requires |this| >= 2
     * @ensures this = reverse(#this)
     */
    void flipOrder();

    /**
     * Moves the {@code song} to the front of {@code this}.
     *
     * @param song
     *            the song to move
     * @updates this
     * @requires |this| >= 2 and {@code song} is in this and @code song} is not
     *           already at the front
     * @ensures {@code song} is at position 0 and all other elements maintain
     *          their relative order
     */
    void moveToFront(Song song);

    /**
     * Moves the {@code song} to the back of {@code this}.
     *
     * @param song
     *            the song to move
     * @updates this
     * @requires |this| >= 2 and {@code song} is in this and {@code song} is not
     *           already at the back
     * @ensures {@code song} is at position |this| - 1 and all other elements
     *          maintain their relative order
     */
    void moveToBack(Song song);

    /**
     *
     * Shuffles the order of {@code this}.
     *
     * @updates this
     * @requires |this| >= 2
     * @ensures this contains exactly the same elements as #this but in a
     *          randomized order
     */
    void shuffle();

    /**
     * Moves {@code song} to the front of {@code this} and moves everything that
     * was before {@code song} to the back of {@code this} in the same order
     * that it previously was in.
     *
     * @param song
     *            the song to start from
     * @updates this
     * @requires |this| >= 2 and song is in this
     * @ensures {@code song} is at position 0 and elements that were before
     *          {@code song} in #this are now at the back in their original
     *          relative order
     */
    void startFrom(Song song);

}
