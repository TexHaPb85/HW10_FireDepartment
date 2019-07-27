package fire.department;

public class Fireman implements Runnable {
    private String name;
    private boolean isFree;
    private Call call;

    public Fireman(String name) {

        this.name = name;
        this.isFree = true;
        call = null;
    }

    private void goToTheCall() {

        System.out.println("new call for " + name);
        for (int i = 0; i < 5; i++) {

            System.out.println("FireMan " + name
                    + ", is going to call" + call.toString()
                    + " from threat " + Thread.currentThread());

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        call = null;
        isFree = true;
        System.out.println("FireMan " + name + " is free now");

    }

    @Override
    public void run() {
        goToTheCall();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
    }

    public Call getCall() {
        return call;
    }

    public void setCall(Call call) {
        this.call = call;
    }

    @Override
    public String toString() {
        return "Fireman{" +
                "name='" + name + '\'' +
                ", isFree=" + isFree +
                '}';
    }
}
