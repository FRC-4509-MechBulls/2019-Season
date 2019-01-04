package frc.robot.controls;

/*
 * Interface to allow hot-swapping of controller classes
 */
public interface ControllerBase {

	double  getTrigger();     // [-1, 1], inactive @ 0
	double  getJoystick();      // [-1, 1], inactive @ 0
	boolean getButton();

}