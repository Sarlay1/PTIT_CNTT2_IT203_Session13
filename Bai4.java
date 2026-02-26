import java.util.LinkedList;

class EmergencyRoom {

    private LinkedList<String> queue = new LinkedList<>();

    public void patientCheckIn(String name) {
        queue.addLast(name);
    }

    public void emergencyCheckIn(String name) {
        queue.addFirst(name);
    }

    public void treatPatient() {
        if (!queue.isEmpty()) {
            System.out.println("Dang dieu tri: " + queue.poll());
        } else {
            System.out.println("Khong co benh nhan.");
        }
    }
}

public class Bai4 {
    public static void main(String[] args) {

        EmergencyRoom e = new EmergencyRoom();

        e.patientCheckIn("A");
        e.patientCheckIn("B");
        e.emergencyCheckIn("C");

        e.treatPatient();
        e.treatPatient();
        e.treatPatient();
    }
}