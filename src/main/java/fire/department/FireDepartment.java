package fire.department;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FireDepartment {
    private final int NUMBER_OF_FIREMEN = 10;
    private List<Fireman> firemenStuff;
    private Queue<Call> callQueue;

    public FireDepartment() {
        fillFiremenStuff();
        callQueue = new LinkedList<>();
    }

    private void fillFiremenStuff() {
        this.firemenStuff = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_FIREMEN; i++) {
            firemenStuff.add(new Fireman("Fireman" + i));
        }
    }

    public boolean respondNewCall(Call call) {
        for (Fireman fireman : firemenStuff) {
            if (fireman.isFree()) {
                fireman.setFree(false);
                fireman.setCall(call);
                Thread thread = new Thread(fireman);
                thread.start();
                return true;
            }
        }
        callQueue.add(call);
        checkCallQueue();
        return false;
    }

    private boolean containsFreeFireman() {
        return firemenStuff.stream().anyMatch(Fireman::isFree);
    }

    private void checkCallQueue() {
        while (!callQueue.isEmpty()) {
            if (containsFreeFireman()) {
                respondNewCall(callQueue.remove());
            }
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
