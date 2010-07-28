public class Euler034
{
    public static int[] FACTS = { 1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880 };

    public static void main (String[] args) {
        int sum = 0;
        for (int n = 10; n < FACTS[9]*7; n++) {
            int tmp = n, dsum = 0;
            do {
                dsum += FACTS[tmp%10];
                tmp /= 10;
            } while (tmp > 0);
            if (n == dsum) {
                sum += n;
            }
        }
        System.out.println(sum);
    }
}
