package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

public class HabSubsystem extends Subsystem {

	@Override
	protected void initDefaultCommand() {}

	public void enable() {
		this.enableFront();
		this.enableBack();
	}

	public void disable() {
		this.disableFront();
		this.disableBack();
	}

	public void enableFront() {
		RobotMap.habFrontSolenoid.set(true);
	}

	public void disableFront() {
		RobotMap.habFrontSolenoid.set(false);
	}

	public void enableBack() {
		RobotMap.habBackSolenoid.set(true);
	}

	public void disableBack() {
		RobotMap.habBackSolenoid.set(false);
	}

}