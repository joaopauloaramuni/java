public class BakeryLock implements Lock {
    private final int N;
    private volatile boolean[] choosing; // inside doorway
    private volatile int[] number;
    public BakeryLock(int numProc) {
        N = numProc;
        choosing = new boolean[N];
        number = new int[N];
        for (int j = 0; j < N; j++) {
            choosing[j] = false;
            number[j] = 0;
        }
    }
    public void requestCS(int i) {
        // step 1: doorway: choose a number
        choosing[i] = true;
        for (int j = 0; j < N; j++)
            if (number[j] > number[i])
                number[i] = number[j];
        number[i]++;
        choosing[i] = false;

        // step 2: check if my number is the smallest
        for (int j = 0; j < N; j++) {
            while (choosing[j]); // process j in doorway
            while ((number[j] != 0) &&
                    ((number[j] < number[i]) ||
                    ((number[j] == number[i]) && j < i)))
                ; // busy wait
        }
    }
    public void releaseCS(int i) { // exit protocol
        number[i] = 0;
    }
}
