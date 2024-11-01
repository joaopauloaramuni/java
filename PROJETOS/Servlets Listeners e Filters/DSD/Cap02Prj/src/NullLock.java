
/**
 * Implementação vazia de Lock.
 * Não fornece exclusão mútua.
 */
public class NullLock implements Lock {
	@Override
	public void releaseCS(int pid) {
	}

	@Override
	public void requestCS(int pid) {
	}
}
