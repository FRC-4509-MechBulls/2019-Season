package frc.robot.commands;

import frc.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class PopHatchCommand extends Command {
	
	public PopHatchCommand() {
		requires(Robot.hatchSubsystem);
	}

	protected void initialze() {
		Robot.hatchSubsystem.enable();
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		Robot.hatchSubsystem.disable();
	}

}