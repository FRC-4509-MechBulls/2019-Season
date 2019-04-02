package frc.robot.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Robot;

public class ReverseDriveCommand extends InstantCommand {

	public ReverseDriveCommand() {
		this.setRunWhenDisabled(true);
	}

	public void execute() {
		Robot.drivingSubsystem.doReverse = !Robot.drivingSubsystem.doReverse;
	}

}