package fire.department;

public class Call {
    private String addressOfCall;

    public Call(String adressOfCall) {
        this.addressOfCall = adressOfCall;
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
