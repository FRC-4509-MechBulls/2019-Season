package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class DirectPneumaticsCommand extends Command {

	public DirectPneumaticsCommand() {
		requires(Robot.habSubsystem);
	}

	protected void initialize() {
		Robot.habSubsystem.enable();
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		Robot.habSubsystem.disable();
	}

}