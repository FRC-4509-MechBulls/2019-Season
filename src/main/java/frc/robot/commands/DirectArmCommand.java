package frc.robot.commands;

import frc.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DirectArmCommand extends Command {
	
	public DirectArmCommand() {
		requires(Robot.armSubsystem);
	}

	protected void initialize() {
		if(Robot.oi.controller == null) throw new NullPointerException("Controller was null.");
	}

	protected void execute() {
		Robot.armSubsystem.set(Robot.oi.controller.getArm());
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		Robot.armSubsystem.stop();
	}

}