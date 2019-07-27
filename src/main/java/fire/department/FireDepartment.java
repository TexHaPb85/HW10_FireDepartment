package fire.department;

import java.util.*;

public class FireDepartment {
    private final int NUMBER_OF_FIREMEN = 10;
    private List<Fireman> firefighters;
    private Queue<Call> callQueue;

    public FireDepartment() {
        this.firefighters = new ArrayList<>();
        this.callQueue = new LinkedList<>();
        fillFiremenStuff();
    }

    private void fillFiremenStuff() {

        for (int i = 0; i < NUMBER_OF_FIREMEN; i++) {
            firefighters.add(new Fireman("Fireman" + i));
        }
    }


    public void processIncomingCall(Call call) {

        if(firefighters.stream().anyMatch(Fireman::isFree)){
            firefighters.stream()
                    .filter(Fireman::isFree)
                    .findFirst()
                    .ifPresent(fireman -> {
                        fireman.setFree(false);
                        fireman.setCall(call);
                        Thread thread = new Thread(fireman);
                        thread.start();
                    });
        }else {
            callQueue.add(call);
            checkCallQueue();
        }
    }

    private boolean containsFreeFireman() {
        return firefighters.stream().anyMatch(Fireman::isFree);
    }

    private void checkCallQueue() {

        while (!callQueue.isEmpty()) {
            if (containsFreeFireman()) {
                processIncomingCall(callQueue.remove());
            }

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}




/*    private Optional<Fireman> findFreeFirefighter(){
        return firefighters.stream()
                .filter(Fireman::isFree)
                .findFirst()
    }

    private void waitToProcessCall(Call call){
        callQueue.add(call);
        checkCallQueue();
    }

    private void respondNewCall(Fireman fireman, Call call){
        fireman.setCall(call);
        Thread thread = new Thread(fireman);
        thread.start();
    }

    public void processIncomingCall(Call call) {
        findFreeFirefighter().ifPresent(fireman -> {
            fireman.setFree(false);
            respondNewCall(fireman,call);
        });

    }*/
