package fire.department;

import java.time.LocalDate;

public class Call {
    private String addressOfCall;
    private LocalDate dateOfCall;

    public Call(String adressOfCall) {
        this.addressOfCall = adressOfCall;
    }

    public Call(String addressOfCall, LocalDate dateOfCall) {
        this.addressOfCall = addressOfCall;
        this.dateOfCall = dateOfCall;
    }

    public String getAddressOfCall() {
        return addressOfCall;
    }

    public void setAddressOfCall(String addressOfCall) {
        this.addressOfCall = addressOfCall;
    }

    @Override
    public String toString() {
        return "Call from address" + addressOfCall;

    }
}
