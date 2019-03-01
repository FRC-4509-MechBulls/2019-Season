package frc.robot.commands;

import frc.robot.Robot;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.command.PIDCommand;

public class DirectDriveStraightCommand extends PIDCommand {

	public DirectDriveStraightCommand() {
		super(Robot.pGT, Robot.iGT, Robot.dGT);
		this.setInputRange(-180, 180);
		this.getPIDController().setContinuous(true);
		this.getPIDController().setOutputRange(-1, 1);
	}

	protected void initialize() {
		if(Robot.oi.controller == null) throw new NullPointerException("Controller was null.");
		this.setSetpointRelative(0);
	}

	protected double returnPIDInput() {
		return RobotMap.navX.getAngle();
	}

	protected void usePIDOutput(double output) {
		Robot.drivingSubsystem.drive(Robot.oi.controller.getDrive(), output);
	}

	protected boolean isFinished() {
		return false;
	}

}