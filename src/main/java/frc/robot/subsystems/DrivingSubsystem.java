package frc.robot.subsystems;

import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.DirectDriveCommand;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Subsystem;

// Controls the drive motors
public class DrivingSubsystem extends Subsystem {
	
	public static double baseDriveSpeed = 0.90;
	public static boolean doReverse = false;

	public PIDController turnPIDController;

	@Override
	public void initDefaultCommand() {
		this.setDefaultCommand(new DirectDriveCommand());
	}
	
	public void drive(double ySpeed, double rotation) {
		
		if(Math.abs(ySpeed) > 1)
			ySpeed = Math.abs(ySpeed) / ySpeed; // if the value given was too high, set it to the max
		ySpeed *= baseDriveSpeed; // scale down the speed
		if(doReverse) ySpeed *= -1;
		
		if(Math.abs(rotation) > 1)
			rotation = Math.abs(rotation) / rotation; // if the value given was too high, set it to the max
		rotation *= baseDriveSpeed; // scale down the speed
		
		RobotMap.drive.arcadeDrive(ySpeed, rotation); // function provided by the drivetrain. controls y and turn speed at the same time.
	}
	
	// Drive straight
	public void drive(double speed) {
		this.drive(speed, 0);
	}
	
	// Pivot
	public void turn(double direction) {
		this.drive(0, direction);
	}

	// Directly set the speed of the talons to 0. If a command that sets the speed is still running, this won't stop it.
	public void stop() {
		RobotMap.leftFrontDriveTalon.set(0);
		RobotMap.rightFrontDriveTalon.set(0);
	}

	public void createTurnPositionController() {
		this.turnPIDController = new PIDController(Robot.pGT, Robot.iGT, Robot.dGT, RobotMap.navX, (output) -> { RobotMap.drive.arcadeDrive(0, output); });
		this.turnPIDController.setInputRange(-180, 180);
		this.turnPIDController.setContinuous(true);
		this.turnPIDController.setOutputRange(-1, 1);
		this.turnPIDController.setAbsoluteTolerance(2);
	}
	
}