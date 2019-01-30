package frc.robot.commands;

import frc.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DriveStraightWithVelocityCommand extends Command {

	double velocity;
	
	public DriveStraightWithVelocityCommand(double velocity) {
		requires(Robot.drivingSubsystem);
		this.velocity = velocity;
	}

	protected void initialize() {}

	public void execute() {
		Robot.drivingSubsystem.setVelocity(this.velocity);
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		Robot.drivingSubsystem.stop();
	}

}