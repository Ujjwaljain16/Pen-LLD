public class Pen {
    private final int maxInk;
    private int inkLevel;

    private final PenState openState;
    private final PenState closedState;
    private final PenState noInkState;

    private PenState currentState;

    public Pen(int maxInk) {
        this.maxInk = maxInk;
        this.inkLevel = maxInk;

        this.openState = new OpenState();
        this.closedState = new ClosedState();
        this.noInkState = new NoInkState();

        this.currentState = closedState;
    }

    public void start() {
        currentState.start(this);
    }

    public void write() {
        currentState.write(this);
    }

    public void close() {
        currentState.close(this);
    }

    public void refill() {
        currentState.refill(this);
    }

    public void useInk(int amount) {
        inkLevel -= amount;
        if (inkLevel < 0) {
            inkLevel = 0;
        }
    }

    public void fillInk() {
        inkLevel = maxInk;
    }

    public int getInkLevel() {
        return inkLevel;
    }

    public int getMaxInk() {
        return maxInk;
    }

    public void setState(PenState state) {
        this.currentState = state;
    }

    public PenState getOpenState() {
        return openState;
    }

    public PenState getClosedState() {
        return closedState;
    }

    public PenState getNoInkState() {
        return noInkState;
    }
}
