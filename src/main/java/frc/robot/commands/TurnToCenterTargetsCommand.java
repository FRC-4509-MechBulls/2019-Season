package frc.robot.commands;

import frc.robot.Robot;
import frc.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;


public class TurnToCenterTargetsCommand extends Command {

	double initialAngle;
	
	public TurnToCenterTargetsCommand() {
		requires(Robot.drivingSubsystem);
	}

	protected void initialize() {
		RobotMap.navX.reset();
		this.initialAngle = RobotMap.navX.getAngle();
		System.out.println("init");
	}

	public void execute() {
		RobotMap.drive.arcadeDrive(0, Robot.getTargetCenter() < 208 ? -0.6 : 0.6);
	}

	protected boolean isFinished() {
		return Math.abs(Robot.getTargetCenter() - 208) <= 5;
	}

	protected void end() {
		Robot.drivingSubsystem.stop();
		System.out.println("Angle:    " + this.initialAngle + " + " + RobotMap.navX.getAngle());
		System.out.println("Distance: " + Robot.getAverageDistance());
		double angleDifference = Math.abs(RobotMap.navX.getAngle()) + Math.abs(this.initialAngle);
		double distanceToWall = Robot.getAverageDistance() * Math.sin(angleDifference);
		double offset = Math.sqrt(Math.pow(Robot.getAverageDistance(), 2) - Math.pow(distanceToWall, 2));
		System.out.println("Offset:   " + offset);
	}

}