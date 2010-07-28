public class Euler015
{
    public static final int SIZE = 20;

    public static final long paths (int size, int x, int y)
    {
        long paths = _paths[size-x][size-y];
        if (paths != 0L) {
            return paths;
        }

        paths = (x == size && y == size) ? 1L : 0L;
        if (x < size) {
            paths = paths + paths(size, x+1, y);
        }
        if (y < size) {
            paths = paths + paths(size, x, y+1);
        }

        return (_paths[size-x][size-y] = paths);
    }

    public static final void main (String[] args)
    {
        long start = System.currentTimeMillis();
        System.out.println(paths(SIZE, 0, 0));
        System.out.println("[total " + (System.currentTimeMillis() - start) + "ms]");
    }

    protected static long[][] _paths = new long[SIZE+1][SIZE+1];
}
