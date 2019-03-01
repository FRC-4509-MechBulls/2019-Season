package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.DrivingSubsystem;

public class ReverseDriveCommand extends Command {

	public ReverseDriveCommand() {
		this.setRunWhenDisabled(true);
	}

	public void execute() {
		if(DrivingSubsystem.doReverse) {
			DrivingSubsystem.doReverse = false;
		} else {
			DrivingSubsystem.doReverse = true;
		}
	}

	protected boolean isFinished() {
		return true;
	}

}