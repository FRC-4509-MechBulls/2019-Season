package frc.robot.subsystems;

import frc.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Subsystem;

// Controls the drive motors
public class DrivingSubsystem extends Subsystem {

	public static final double kp = 0.0;
	public static final double ki = 0.0;
	public static final double kf = 0.0;
	public static final double kd = 0.0;
	public static final int IZone = 100;
	
	public static double baseDriveSpeed = 0.75;

	public void initDefaultCommand() {}

	public static void setPID() {
		RobotMap.masterTalon.config_kF(0, DrivingSubsystem.kf, 0);
		RobotMap.masterTalon.config_kP(0, DrivingSubsystem.kp, 0);
		RobotMap.masterTalon.config_kI(0, DrivingSubsystem.ki, 0);
		RobotMap.masterTalon.config_kD(0, DrivingSubsystem.kd, 0);
		RobotMap.masterTalon.config_IntegralZone(0, DrivingSubsystem.IZone, 0);
	}

	// Directly set the speed of the talons to 0. If a command that sets the speed is still running, this won't stop it.
	public void stop() {
		RobotMap.masterTalon.set(0);
	}

	public void setPosition(int position) {
		RobotMap.masterTalon.set(ControlMode.Position, position);
	}

	public void setVelocity(double velocity) {
		RobotMap.masterTalon.set(ControlMode.Velocity, velocity);
	}
	
}