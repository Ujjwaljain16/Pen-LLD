public class NoInkState implements PenState {
    @Override
    public void start(Pen pen) {
        System.out.println("Pen is open, but cannot write because ink is empty.");
    }

    @Override
    public void write(Pen pen) {
        System.out.println("Cannot write. Ink is empty. Refill needed.");
    }

    @Override
    public void close(Pen pen) {
        pen.setState(pen.getClosedState());
        System.out.println("Pen is now closed.");
    }

    @Override
    public void refill(Pen pen) {
        pen.fillInk();
        pen.setState(pen.getOpenState());
        System.out.println("Pen refilled. Pen is open and ready to write.");
    }
}
