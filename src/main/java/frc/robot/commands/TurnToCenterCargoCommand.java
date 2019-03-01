package frc.robot.commands;

import frc.robot.Robot;
import frc.robot.RobotMap;

import edu.wpi.first.wpilibj.command.PIDCommand;

public class TurnToCenterCargoCommand extends PIDCommand {

	double initialAngle;
	
	public TurnToCenterCargoCommand() {
		super(Robot.pCT, Robot.iCT, Robot.dCT);
		requires(Robot.drivingSubsystem);
		this.setInputRange(0, 416);
		this.getPIDController().setContinuous(false);
		this.getPIDController().setOutputRange(-1, 1);
		this.setSetpoint(208);
	}

	protected boolean isFinished() {
		return Math.abs(Robot.cargoX[0] - 208) <= 10;
	}

	protected double returnPIDInput() {
		return Robot.cargoX[0];
	}

	protected void usePIDOutput(double output) {
		RobotMap.drive.arcadeDrive(0, output);
	}

	protected void end() {
		Robot.drivingSubsystem.stop();
	}

}