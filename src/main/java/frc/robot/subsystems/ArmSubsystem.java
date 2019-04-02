package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

public class ArmSubsystem extends Subsystem {
	
	public static double baseArmSpeed = 0.40;

	@Override
	public void initDefaultCommand() {}

	public void set(double speed) {
		if(Math.abs(speed) > 1)
			speed = Math.abs(speed) / speed;

		/*if(RobotMap.armHighSwitch.get()) {
			speed = Math.max(speed, 0);
		}*/	
/*
		if(RobotMap.armLowSwitch.get())
			speed = Math.min(speed, 0);
*/
		RobotMap.armTalon.set(speed * baseArmSpeed);
	}

	public void stop() {
		RobotMap.armTalon.set(0);
	}
	
}