package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

public class HatchSubsystem extends Subsystem {

	@Override
	public void initDefaultCommand() {}

	public void enable() {
		RobotMap.hatchSolenoid.set(true);
	}

	public boolean isFinished() {
		return true;
	}

	public void disable() {
		RobotMap.hatchSolenoid.set(false);
	}
	
}