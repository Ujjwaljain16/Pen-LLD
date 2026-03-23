public class ClosedState implements PenState {
    @Override
    public void start(Pen pen) {
        if (pen.getInkLevel() <= 0) {
            pen.setState(pen.getNoInkState());
            System.out.println("Pen opened, but there is no ink.");
            return;
        }

        pen.setState(pen.getOpenState());
        System.out.println("Pen is now open.");
    }

    @Override
    public void write(Pen pen) {
        System.out.println("Cannot write. Pen is closed. Call start() first.");
    }

    @Override
    public void close(Pen pen) {
        System.out.println("Pen is already closed.");
    }

    @Override
    public void refill(Pen pen) {
        pen.fillInk();
        System.out.println("Pen refilled while closed. Ink level: " + pen.getInkLevel() + "/" + pen.getMaxInk());
    }
}
