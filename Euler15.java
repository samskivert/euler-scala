import java.util.HashMap;

public class Euler15
{
    public static final int SIZE = 20;
    public static final long paths (int size, int x, int y)
    {
        int key = ((size - x) << 16 | (size - y));
        Long paths = _paths.get(key);
        if (paths != null) {
            return paths;
        }

        paths = (x == size && y == size) ? 1L : 0L;
        if (x < size) {
            paths = paths + paths(size, x+1, y);
        }
        if (y < size) {
            paths = paths + paths(size, x, y+1);
        }

        _paths.put(key, paths);

        return paths;
    }

    public static final void main (String[] args)
    {
        long start = System.currentTimeMillis();
        System.out.println(paths(SIZE, 0, 0));
        System.out.println("[total " + (System.currentTimeMillis() - start) + "ms]");
    }

    protected static HashMap<Integer,Long> _paths = new HashMap<Integer,Long>();
}
