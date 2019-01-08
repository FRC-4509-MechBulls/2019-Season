package frc.robot.commands;

import frc.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;


public class StartCompressorCommand extends Command {
	
	public StartCompressorCommand() {
		requires(Robot.pneumaticSubsystem);
	}

	protected void initialize() {}

	public void execute() {
		Robot.pneumaticSubsystem.startCompressor();
	}

	protected boolean isFinished() {
		return Robot.pneumaticSubsystem.getPressureSwitchValue();
	}

	protected void end() {
		Robot.pneumaticSubsystem.stopCompressor();
	}

}