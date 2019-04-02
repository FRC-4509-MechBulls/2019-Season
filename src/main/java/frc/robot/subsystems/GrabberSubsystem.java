package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

public class GrabberSubsystem extends Subsystem {
	
	public static double baseGrabberSpeed = 0.95
	;

	@Override
	public void initDefaultCommand() {}

	public void set(double speed) {
		if(Math.abs(speed) > 1)
			speed = Math.abs(speed) / speed;
		RobotMap.grabberTalon.set(speed * baseGrabberSpeed);
	}

	public void stop() {
		RobotMap.grabberTalon.set(0);
	}
	
}