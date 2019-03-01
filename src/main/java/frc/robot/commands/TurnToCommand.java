package frc.robot.commands;

import frc.robot.Robot;
import frc.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class TurnToCommand extends Command {
	
	double targetAngle;

	public TurnToCommand(double angle) {
		requires(Robot.drivingSubsystem);
		this.targetAngle = angle;
	}
	
	protected void initialize() {
		RobotMap.navX.reset();
		Robot.drivingSubsystem.turnPIDController.setSetpoint(this.targetAngle);
		Robot.drivingSubsystem.turnPIDController.enable();
	}

	protected void execute() {
		System.out.println(RobotMap.navX.getAngle() + ", " + Robot.drivingSubsystem.turnPIDController.get());
	}

	protected boolean isFinished() {
		return !Robot.drivingSubsystem.turnPIDController.isEnabled() || Math.abs(Math.abs(RobotMap.navX.getAngle()) - Math.abs(this.targetAngle)) < 2;
	}

	protected void end() {
		Robot.drivingSubsystem.turnPIDController.reset();
		System.out.println("end");
	}

}