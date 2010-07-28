public class Euler026
{
    static int longest;
    static int ldenom;

    static final int MAX_DENOM = 1000;

    static final int[] prepend (int[] digits, int value)
    {
        int[] ndigits = new int[digits.length+1];
        if (digits.length > 0) {
            System.arraycopy(digits, 0, ndigits, 1, digits.length);
        }
        ndigits[0] = value;
        return ndigits;
    }

    static final int indexof (int[] values, int value)
    {
        for (int ii = 0; ii < values.length; ii++) {
            if (values[ii] == value) {
                return ii;
            }
        }
        return -1;
    }

    static final int divcycle (int numer, int denom, int[] digits, int[] remains)
    {
        if (denom > numer) {
            return divcycle(numer * 10, denom, prepend(digits, 0), prepend(remains, 0));
        }

        int remain = numer % denom;
        int[] ndigits = prepend(digits, numer / denom);
        if (remain == 0) {
            return 0;
        }

        int ridx = indexof(remains, remain);
        if (ridx >= 0) {
            int loop = ridx+1;
            if (loop > longest) {
                longest = loop;
                ldenom = denom;
            }
            return ridx+1;
        }

        return divcycle(remain * 10, denom, ndigits, prepend(remains, remain));
    }

    public static void main (String[] args) {
        for (int denom = 2; denom < MAX_DENOM; denom++) {
            divcycle(1, denom, new int[0], new int[0]);
        }
        System.out.println(ldenom);
    }
}
