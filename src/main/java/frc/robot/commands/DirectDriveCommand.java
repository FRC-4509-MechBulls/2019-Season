package frc.robot.commands;

import frc.robot.Robot;
import frc.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class DirectDriveCommand extends Command {

	double velocity;
	
	public DirectDriveCommand() {
		requires(Robot.drivingSubsystem);
	}

	protected void initialize() {}

	public void execute() {
		RobotMap.leftFrontDriveTalon.set(Robot.oi.controller.getDrive());
		System.out.println(RobotMap.leftFrontDriveTalon.getSelectedSensorPosition());
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		Robot.drivingSubsystem.stop();
	}

}