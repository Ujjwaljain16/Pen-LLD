# Pen LLD

## Class Diagram

```text
		    +----------------------+
		    |        Main          |
		    +----------+-----------+
			       |
			       v
		    +----------------------+
		    |         Pen          |
		    +----------------------+
		    | - maxInk: int        |
		    | - inkLevel: int      |
		    | - currentState       |
		    | - openState          |
		    | - closedState        |
		    | - noInkState         |
		    +----------------------+
		    | + start()            |
		    | + write()            |
		    | + close()            |
		    | + refill()           |
		    +----------+-----------+
			       |
			       | delegates
			       v
		    +----------------------+
		    |      PenState        |
		    |     (interface)      |
		    +----------------------+
		    | + start(Pen)         |
		    | + write(Pen)         |
		    | + close(Pen)         |
		    | + refill(Pen)        |
		    +----+---------+-------+
			 |         |
	     +-----------+         +-----------+
	     |                                 |
	     v                                 v
     +---------------+                 +---------------+
     |   OpenState   |                 |  ClosedState  |
     +---------------+                 +---------------+
	     |
	     v
      +--------------+
      |  NoInkState  |
      +--------------+
```

## Why This Approach

State Pattern is used because pen behavior changes by state.
1. Open state should allow write.
2. Closed state should block write.
3. No-ink state should block write until refill.

This keeps logic simple and avoids big if-else blocks in one class.

## Flow And Decisions

1. Pen starts in closed state.
2. `start()` moves to open state when ink is available.
3. `write()` works only in open state and reduces ink by 1.
4. When ink becomes 0, pen moves to no-ink state.
5. `refill()` restores full ink and moves to open state.
6. `close()` moves pen back to closed state.

Design decisions kept simple:
1. `Pen` is context and stores ink + current state.
2. `PenState` interface keeps state behavior consistent.
3. Each state class handles only its own rules.

## Quick Start

From the Pen folder:

```bash
cd src
javac *.java
java Main
```
