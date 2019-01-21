package frc.robot.commands;

import frc.robot.Robot;
import frc.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Command;

public class DriveStraightWithVelocityCommand extends Command {

	double velocity;
	
	public DriveStraightWithVelocityCommand(double velocity) {
		requires(Robot.drivingSubsystem);
		this.velocity = velocity;
	}

	protected void initialize() {}

	public void execute() {
		RobotMap.leftFrontDriveTalon.set(ControlMode.Velocity, velocity);
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		Robot.drivingSubsystem.stop();
	}

}