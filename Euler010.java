public class Euler010
{
    public static final int nextPrimeIndex (boolean[] nonprimes, int start)
    {
        for (int ii = start+1; ii < nonprimes.length; ii++) {
            if (!nonprimes[ii]) {
                return ii;
            }
        }
        return -1;
    }

    public static void main (String[] args)
    {
        long start = System.currentTimeMillis();
        boolean[] nonprimes = new boolean[1000000];
        int pidx = 0;
        long sum = 0;
        while ((pidx = nextPrimeIndex(nonprimes, pidx)) != -1) {
            int prime = pidx+1;
            sum += prime;
            for (int ii = pidx+prime; ii < nonprimes.length; ii += prime) {
                nonprimes[ii] = true;
            }
        }
        System.out.println(sum);
        System.out.println("[total " + (System.currentTimeMillis() - start) + "ms]");
    }
}
