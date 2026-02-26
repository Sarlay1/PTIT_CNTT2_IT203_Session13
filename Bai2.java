
import java.util.ArrayList;

public class Bai2 {
    public static void main(String[] args) {

        ArrayList<String> medical = new ArrayList<>();
        medical.add("Paracetamol");
        medical.add("Ibuprofen");
        medical.add("Panadol");
        medical.add("Paracetamol");
        medical.add("Aspirin");
        medical.add("Ibuprofen");

        ArrayList<String> uniqueMedical = new ArrayList<>();

        for (String m : medical) {
            if (!uniqueMedical.contains(m)) {
                uniqueMedical.add(m);
            }
        }

        uniqueMedical.sort(null);

        System.out.println("Danh sach sau khi xu ly: " + uniqueMedical);
    }
}