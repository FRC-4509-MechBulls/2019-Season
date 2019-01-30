package frc.robot.commands;

import frc.robot.Robot;
import frc.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class DriveToPointCommand extends Command {

	int position;
	
	public DriveToPointCommand(int position) {
		requires(Robot.drivingSubsystem);
		this.position = position;
	}

	protected void initialize() {}

	public void execute() {
		Robot.drivingSubsystem.setPosition(this.position);
	}

	protected boolean isFinished() {
		return RobotMap.masterTalon.getClosedLoopError() < 100;
	}

	protected void end() {
		Robot.drivingSubsystem.stop();
	}

}