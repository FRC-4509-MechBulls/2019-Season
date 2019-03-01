package frc.robot.controls;

/*
 * Interface to allow hot-swapping of controller classes
 */
public interface ControllerBase {
	
	double  getDrive();     // [-1, 1], inactive @ 0
	double  getTurn();      // [-1, 1], inactive @ 0
	
	boolean getHabEnable();
	boolean getHabDisable();
	boolean getHabFront();
	boolean getHabBack();

	double getArm();
	double getGrabber();

	boolean getHatchPopper();

	boolean getChangeSource();
	boolean getReverseDrive();

	boolean getToggleCompressor();

}