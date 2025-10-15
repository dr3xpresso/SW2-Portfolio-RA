import components.map.Map.Pair;
import components.queue.Queue;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

public class playlistPOC {

    /**
     *
     * @param <K>
     * @param <V>
     * @param q
     * @requires q.length() >= 2
     */
    private static <K, V> void flip(Queue<Pair<K, V>> q) {

        // just recursively flips it
        Pair<K, V> front = q.dequeue();
        flip(q);
        q.enqueue(front);
    }

    /**
     *
     * @param <K>
     * @param <V>
     * @param q
     * @param key
     * @requires q.length() >= 2
     */
    private static <K, V> void moveToFront(Queue<Pair<K, V>> q, K key) {
        boolean moved = false;

        /*
         * searches for the element to move to front, pulls it out, then roates
         * through everything else to preserve the rest of the original order
         */
        for (int i = 0; i < q.length(); i++) {
            Pair<K, V> p = q.dequeue();

            if (!moved && p.key().equals(key)) {
                q.enqueue(p);
                moved = true;
            } else {
                q.enqueue(p);
            }
        }

        // rotates the target to the front
        if (moved) {
            for (int i = 0; i < q.length() - 1; i++) {
                q.enqueue(q.dequeue());
            }
        }
    }

    /**
     *
     * @param <K>
     * @param <V>
     * @param q
     * @param key
     * @requires q.length >=2
     */
    private static <K, V> void moveToBack(Queue<Pair<K, V>> q, K key) {
        boolean moved = false;
        Pair<K, V> target = null;

        for (int i = 0; i < q.length(); i++) {
            Pair<K, V> p = q.dequeue();

            if (!moved && p.key().equals(key)) {
                target = p;
                moved = true;
            } else {
                q.enqueue(p);
            }
        }

        if (target != null) {
            q.enqueue(target);
        }

    }

    public static void main() {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();

        out.print("Enter Name");
        String name = in.nextLine();
        out.print(name + "'s Playlist");

    }

}
