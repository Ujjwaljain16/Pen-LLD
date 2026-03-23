public interface PenState {
    void start(Pen pen);
    void write(Pen pen);
    void close(Pen pen);
    void refill(Pen pen);
}
