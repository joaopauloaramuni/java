public class TestAndSetLock implements Lock {
    private final TestAndSet lockFlag = new TestAndSet();
    public void requestCS(int i) { // entry protocol
        while (lockFlag.testAndSet(1) == 1) ;
    }
    public void releaseCS(int i) { // exit protocol
        lockFlag.testAndSet(0);
    }
}
