package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

public class ArmSubsystem extends Subsystem {
	
	public static double baseArmSpeed = 0.75;

	@Override
	public void initDefaultCommand() {}

	public void set(double speed) {
		if(Math.abs(speed) > 1)
			speed = Math.abs(speed) / speed;
		RobotMap.armTalon.set(speed * baseArmSpeed);
	}

	public void stop() {
		RobotMap.armTalon.set(0);
	}
	
}