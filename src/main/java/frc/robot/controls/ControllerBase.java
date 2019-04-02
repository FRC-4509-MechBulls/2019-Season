package frc.robot.controls;

/*
 * Interface to allow hot-swapping of controller classes
 */
public interface ControllerBase {
	
	double  getDrive();     // [-1, 1], inactive @ 0
	double  getTurn();      // [-1, 1], inactive @ 0
	boolean getGoFast();
	
	boolean getDirectionDown();
	boolean getDirectionRight();
	boolean getDirectionLeft();

	double getArm();
	double getGrabber();

	boolean getHatchPopper();

	boolean getChangeSource();
	boolean getReverseDrive();

	boolean getAlign();

}