import java.util.*;

class Patient {
    private String id;
    private String fullName;
    private int age;
    private String diagnosis;

    public Patient(String id, String fullName, int age, String diagnosis) {
        this.id = id;
        this.fullName = fullName;
        this.age = age;
        this.diagnosis = diagnosis;
    }

    public String getId() { return id; }
    public String getFullName() { return fullName; }
    public int getAge() { return age; }
    public String getDiagnosis() { return diagnosis; }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    @Override
    public String toString() {
        return id + " | " + fullName + " | " + age + " | " + diagnosis;
    }
}

public class Bai5 {

    static ArrayList<Patient> patientList = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Tiep nhan benh nhan");
            System.out.println("2. Cap nhat chan doan");
            System.out.println("3. Xuat vien");
            System.out.println("4. Sap xep danh sach");
            System.out.println("5. Thoat");
            System.out.print("Chon: ");

            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1: addPatient(); break;
                case 2: updateDiagnosis(); break;
                case 3: dischargePatient(); break;
                case 4: sortPatients(); break;
                case 5: System.out.println("Thoat chuong trinh."); break;
                default: System.out.println("Lua chon khong hop le.");
            }

        } while (choice != 5);
    }

    static void addPatient() {
        System.out.print("Nhap ID: ");
        String id = sc.nextLine();

        for (Patient p : patientList) {
            if (p.getId().equals(id)) {
                System.out.println("ID da ton tai!");
                return;
            }
        }

        System.out.print("Nhap ho ten: ");
        String name = sc.nextLine();

        System.out.print("Nhap tuoi: ");
        int age = Integer.parseInt(sc.nextLine());

        System.out.print("Nhap chan doan: ");
        String diagnosis = sc.nextLine();

        patientList.add(new Patient(id, name, age, diagnosis));
        System.out.println("Them thanh cong!");
    }

    static void updateDiagnosis() {
        System.out.print("Nhap ID can cap nhat: ");
        String id = sc.nextLine();

        for (Patient p : patientList) {
            if (p.getId().equals(id)) {
                System.out.print("Nhap chan doan moi: ");
                p.setDiagnosis(sc.nextLine());
                System.out.println("Cap nhat thanh cong!");
                return;
            }
        }

        System.out.println("Khong tim thay benh nhan.");
    }

    static void dischargePatient() {
        System.out.print("Nhap ID can xoa: ");
        String id = sc.nextLine();

        Iterator<Patient> iterator = patientList.iterator();

        while (iterator.hasNext()) {
            if (iterator.next().getId().equals(id)) {
                iterator.remove();
                System.out.println("Da xuat vien.");
                return;
            }
        }

        System.out.println("Khong tim thay benh nhan.");
    }

    static void sortPatients() {

        patientList.sort(new Comparator<Patient>() {
            @Override
            public int compare(Patient p1, Patient p2) {

                if (p2.getAge() != p1.getAge()) {
                    return p2.getAge() - p1.getAge(); // tuổi giảm dần
                }

                return p1.getFullName().compareTo(p2.getFullName()); // tên A-Z
            }
        });

        System.out.println("Danh sach sau khi sap xep:");
        for (Patient p : patientList) {
            System.out.println(p);
        }
    }
}