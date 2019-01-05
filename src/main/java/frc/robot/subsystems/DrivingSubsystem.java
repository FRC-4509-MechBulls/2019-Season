package frc.robot.subsystems;

import frc.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.NeutralMode;

import edu.wpi.first.wpilibj.command.Subsystem;

// Controls the drive motors
public class DrivingSubsystem extends Subsystem {
	
	public double baseDriveSpeed;
	private NeutralMode neutralMode;
	
	public DrivingSubsystem() {
		super();
		this.setDriveSpeedMode(DriveSpeedMode.Disabled);
	}

	public void initDefaultCommand() {}

	public void drive(double ySpeed, double rotation) {
		
		if(Math.abs(ySpeed) > 1)
			ySpeed = Math.abs(ySpeed) / ySpeed; // if the value given was too high, set it to the max
		ySpeed *= this.baseDriveSpeed; // scale down the speed
		
		if(Math.abs(rotation) > 1)
			rotation = Math.abs(rotation) / rotation; // if the value given was too high, set it to the max
		rotation *= this.baseDriveSpeed; // scale down the speed
		
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
	
	// This enum exists to provide speed limits during different modes.
	public enum DriveSpeedMode {
		Disabled(0), TeleOp(0.75), Auto(0.65); // Any speed values given for driving and turning are multiplied by one of these.
		public double baseSpeed;
		DriveSpeedMode(double baseSpeed) { this.baseSpeed = baseSpeed; }
	}
	
	public void setDriveSpeedMode(DriveSpeedMode mode) {
		this.baseDriveSpeed = mode.baseSpeed;
	}
	
	// Set the neutral mode for all talons
	public void setNeutralMode(NeutralMode mode) {
		RobotMap.leftFrontDriveTalon.setNeutralMode(mode);
		RobotMap.leftBackDriveTalon.setNeutralMode(mode);
		RobotMap.rightFrontDriveTalon.setNeutralMode(mode);
		RobotMap.rightBackDriveTalon.setNeutralMode(mode);
		this.neutralMode = mode;
	}
	
	public NeutralMode getNeutralMode() {
		return this.neutralMode;
	}
	
}