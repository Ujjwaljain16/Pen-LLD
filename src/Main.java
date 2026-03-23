public class Main {
    public static void main(String[] args) {
        Pen pen = new Pen(3);

        System.out.println("Step 1: Try write while pen is closed");
        pen.write();

        System.out.println("\nStep 2: Open pen and write until ink gets over");
        pen.start();
        pen.write();
        pen.write();
        pen.write();
        pen.write();

        System.out.println("\nStep 3: Refill and write again");
        pen.refill();
        pen.write();

        System.out.println("\nStep 4: Close pen and try writing");
        pen.close();
        pen.write();
    }
}
