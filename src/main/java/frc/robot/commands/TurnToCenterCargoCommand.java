package frc.robot.commands;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.PIDCommand;
import frc.robot.Robot;
import frc.robot.RobotMap;

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

	protected void initialize() {
		RobotMap.frontRelay.set(Relay.Value.kReverse);
	}

	protected boolean isFinished() {
		//return Math.abs(Robot.cargoX[0] - 208) <= 5;
		return this.timeSinceInitialized() > 10;
	}

	protected double returnPIDInput() {
		return Robot.cargoX[0];
	}

	protected void usePIDOutput(double output) {
		if(Robot.cargoX[0] != 0) {
			if(Math.abs(output) > 0.60)
				output = (Math.abs(output) / output) * 0.60;
			System.out.println(-1 * output);
			RobotMap.drive.arcadeDrive(0, -1 * output);
		}
	}

	protected void end() {
		Robot.drivingSubsystem.stop();
		RobotMap.frontRelay.set(Relay.Value.kOff);
	}

}