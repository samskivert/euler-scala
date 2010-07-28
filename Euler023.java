import java.util.HashSet;

public class Euler023
{
    public static final int MAX = 28123;

    public static void main (String[] args)
    {
        long start = System.currentTimeMillis();
        int[] abundant = new int[MAX];
        int acount = 0;
        for (int ii = 1; ii <= MAX; ii++) {
            if (ii < sumdiv(ii)) {
                abundant[acount++] = ii;
            }
        }

        HashSet<Integer> integers = new HashSet<Integer>();
        for (int ii = 0; ii < MAX; ii++) {
            integers.add(ii+1);
        }

        for (int aa = 0; aa < acount; aa++) {
            for (int bb = aa; bb < acount; bb++) {
                integers.remove(abundant[aa] + abundant[bb]);
            }
        }

        int total = 0;
        for (Integer value : integers) {
            total += value;
        }
        System.out.println(total);
        System.out.println("[total " + (System.currentTimeMillis() - start) + "ms]");
    }

    protected static int sumdiv (int value)
    {
        int sum = 1;
        for (int ii = 2, ll = (int)Math.ceil(Math.sqrt(value)); ii < ll; ii++) {
            if (value % ii == 0) {
                sum += ii;
                sum += (value / ii);
            }
        }
        double root = Math.sqrt(value);
        int iroot = (int)root;
        if (root > 1 && root == iroot) {
            sum += iroot;
        }
        return sum;
    }
}
