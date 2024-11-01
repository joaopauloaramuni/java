public class Attempt2 implements Lock {
    private volatile boolean wantCS[] = {false, false};
    public void requestCS(int i) { // entry protocol
        wantCS[i] = true;   //declare intent
        while (wantCS[1 - i]); // busy wait
    }
    public void releaseCS(int i) {
        wantCS[i] = false;
    }
}
