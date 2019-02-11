package frc.robot.controls;

/*
 * Interface to allow hot-swapping of controller classes
 */
public interface ControllerBase {
	
	double  getDrive();     // [-1, 1], inactive @ 0
	double  getTurn();      // [-1, 1], inactive @ 0
	boolean getY();
	boolean getB();
	boolean getA();
	boolean getX();
	boolean getStart();

}