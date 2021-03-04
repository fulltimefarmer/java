package org.max.thread.aqs;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class Sync extends AbstractQueuedSynchronizer {
    /**
	 * 
	 */
	private static final long serialVersionUID = -3122903091504272692L;

	@Override
    protected boolean tryAcquire(int arg) {
        if(compareAndSetState(0, 1)) {
            setExclusiveOwnerThread(Thread.currentThread());
            return true;
        }
        return false;
    }

    @Override
    protected boolean tryRelease(int arg) {
        setExclusiveOwnerThread(null);
        setState(0);
        return true;
    }

    @Override
    protected boolean isHeldExclusively() {
        return getState() == 1;
    }
}
