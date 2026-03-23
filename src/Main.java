public class Main {
    public static void main(String[] args) {
        Pen pen = new Pen(3);

        pen.write();

        pen.start();
        pen.write();
        pen.write();
        pen.write();
        pen.write();

        pen.refill();
        pen.write();

        pen.close();
        pen.write();
    }
}
