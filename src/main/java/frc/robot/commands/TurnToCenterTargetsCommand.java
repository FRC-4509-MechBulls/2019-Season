package frc.robot.commands;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.PIDCommand;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class TurnToCenterTargetsCommand extends PIDCommand {

	double initialAngle;
	double iTerm, lastError;
	
	public TurnToCenterTargetsCommand() {
		super(0.01, 0.0, 0.0, 0.050);
		//requires(Robot.drivingSubsystem);
		this.setInputRange(0, 416);
		this.getPIDController().setContinuous(false);
		this.setSetpoint(208);
	}

	protected void initialize() {
		if(Robot.oi.controller == null) throw new NullPointerException("Controller was null.");
		RobotMap.backRelay.set(Relay.Value.kReverse);
	}

	protected boolean isFinished() {
		return false;
	}

	protected double returnPIDInput() {
		return Robot.getTargetCenter();
	}

	protected void usePIDOutput(double output) {
		if(Math.abs(output) > 0.30) output = Math.signum(output) * 0.30;
		output = Math.abs(output) * (Robot.getTargetCenter() < 208 ? 1.0 : -1.0);
		double nearestAngle = Math.round(RobotMap.navX.getAngle() / 90) * 90;
		double gyroMult = 1 + (Math.abs(RobotMap.navX.getAngle() - nearestAngle) * 0.008);
		output *= gyroMult;
		System.out.println("Gyro mult: " + gyroMult);
		System.out.println("output: " + (-1.0 * output));

		if(Robot.contourLeft[0] != 0 || Robot.contourRight[0] != 0) {
			Robot.drivingSubsystem.rawDrive(Robot.oi.controller.getDrive(), -1 * output);
		} else {
			double angleDiff = nearestAngle - RobotMap.navX.getAngle();
			double turn = angleDiff > 3 ? 0.15 * (Math.signum(angleDiff) + ((angleDiff) * 0.01)) : 0;
			Robot.drivingSubsystem.rawDrive(Robot.oi.controller.getDrive(), Robot.oi.controller.getTurn() + turn);
		}
	}

	protected void end() {
		Robot.drivingSubsystem.stop();
		RobotMap.backRelay.set(Relay.Value.kOff);
		System.out.println();
	}

}