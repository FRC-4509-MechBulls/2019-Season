package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.DrivingSubsystem;

public class GottaGoFastCommand extends Command {

	protected void initialize() {
		Robot.drivingSubsystem.baseDriveSpeed = 1.00;
	}

	public boolean isFinished() {
		return false;
	}
	
	protected void end() {
		Robot.drivingSubsystem.baseDriveSpeed = DrivingSubsystem.BASE_DRIVE_SPEED;
	}

}