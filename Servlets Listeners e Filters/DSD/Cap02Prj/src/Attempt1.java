public class Attempt1 implements Lock {
    private volatile boolean openDoor = true;
    public void requestCS(int i) {
        while (!openDoor); // busy wait
        openDoor = false;
    }
    public void releaseCS(int i) {
        openDoor = true;
    }
}
