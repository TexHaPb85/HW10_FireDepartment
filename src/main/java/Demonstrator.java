import fire.department.Call;
import fire.department.FireDepartment;

public class Demonstrator {
    public static void demostrateWorkOfFireDepartment() {
        FireDepartment fd = new FireDepartment();

        for (int i = 0; i < 15; i++) {
            fd.respondNewCall(new Call("some street " + i));
        }
    }

    public static void main(String[] args) {
        demostrateWorkOfFireDepartment();
    }
}
