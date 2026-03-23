public class OpenState implements PenState {
    @Override
    public void start(Pen pen) {
        System.out.println("Pen is already open.");
    }

    @Override
    public void write(Pen pen) {
        if (pen.getInkLevel() <= 0) {
            System.out.println("Cannot write. Ink is empty.");
            pen.setState(pen.getNoInkState());
            return;
        }

        pen.useInk(1);
        System.out.println("Writing... Ink left: " + pen.getInkLevel() + "/" + pen.getMaxInk());

        if (pen.getInkLevel() == 0) {
            System.out.println("Ink finished while writing.");
            pen.setState(pen.getNoInkState());
        }
    }

    @Override
    public void close(Pen pen) {
        pen.setState(pen.getClosedState());
        System.out.println("Pen is now closed.");
    }

    @Override
    public void refill(Pen pen) {
        pen.fillInk();
        System.out.println("Pen refilled. Ink level: " + pen.getInkLevel() + "/" + pen.getMaxInk());
    }
}
