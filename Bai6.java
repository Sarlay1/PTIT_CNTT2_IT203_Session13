import java.util.*;

class Medicine {
    String id, name;
    double price;
    int quantity;

    Medicine(String id, String name, double price, int qty) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    double total() {
        return price * quantity;
    }
}

public class Bai6 {
    static List<Medicine> cart = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Them thuco vao don");
            System.out.println("2. Dieu chinh so luong");
            System.out.println("3. Xoa tjhuoc");
            System.out.println("4. In hoa don");
            System.out.println("5. Tim thuoc gia re");
            System.out.println("6. Thoat");
            System.out.print("Chon: ");
            choice = Integer.parseInt(sc.nextLine());

            if (choice == 1) add();
            if (choice == 2) update();
            if (choice == 3) remove();
            if (choice == 4) invoice();
            if (choice == 5) cheap();

        } while (choice != 6);
    }

    static void add() {
        System.out.print("Ma: ");
        String id = sc.nextLine();

        for (Medicine m : cart) {
            if (m.id.equals(id)) {
                System.out.print("SL them: ");
                m.quantity += Integer.parseInt(sc.nextLine());
                return;
            }
        }

        System.out.print("Ten: ");
        String name = sc.nextLine();
        System.out.print("Gia: ");
        double price = Double.parseDouble(sc.nextLine());
        System.out.print("SL: ");
        int qty = Integer.parseInt(sc.nextLine());

        cart.add(new Medicine(id, name, price, qty));
    }

    static void update() {
        System.out.print("Ma: ");
        String id = sc.nextLine();

        for (Medicine m : cart) {
            if (m.id.equals(id)) {
                System.out.print("SL moi: ");
                int q = Integer.parseInt(sc.nextLine());
                if (q == 0) cart.remove(m);
                else m.quantity = q;
                return;
            }
        }
    }

    static void remove() {
        System.out.print("Ma: ");
        String id = sc.nextLine();
        cart.removeIf(m -> m.id.equals(id));
    }

    static void invoice() {
        double sum = 0;
        for (Medicine m : cart) {
            System.out.println(m.id + " - " + m.name + " - " + m.quantity + " - " + m.total());
            sum += m.total();
        }
        System.out.println("Tong tien: " + sum);
        cart.clear();
    }

    static void cheap() {
        for (Medicine m : cart)
            if (m.price < 50000)
                System.out.println(m.name + " - " + m.price);
    }
}