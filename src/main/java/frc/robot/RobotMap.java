/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.SPI.Port;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

	public static final int LEFT_FRONT_DRIVE_TALON_PORT  = 6;
	public static final int LEFT_BACK_DRIVE_TALON_PORT   = 7;
	public static final int RIGHT_FRONT_DRIVE_TALON_PORT = 1;
	public static final int RIGHT_BACK_DRIVE_TALON_PORT  = 3;
	public static final int ARM_TALON_PORT               = 2;
	public static final int GRABBER_TALON_PORT           = 8;

	public static final int HATCH_SOLENOID_PORT = 6;

	public static final int FRONT_RELAY_CHANNEL = 0;
	public static final int BACK_RELAY_CHANNEL  = 1;

	public static final int ARM_HIGH_SWITCH_CHANNEL = 1;
	public static final int ARM_LOW_SWITCH_CHANNEL  = 0;

	public static WPI_TalonSRX leftFrontDriveTalon;
	public static WPI_TalonSRX leftBackDriveTalon;
	public static WPI_TalonSRX rightFrontDriveTalon;
	public static WPI_TalonSRX rightBackDriveTalon;
	public static DifferentialDrive drive;
	public static WPI_AHRS navX;

	public static WPI_TalonSRX armTalon;
	public static WPI_TalonSRX grabberTalon;

	public static Solenoid hatchSolenoid;

	public static Relay frontRelay;
	public static Relay backRelay;

	public static DigitalInput armHighSwitch;
	public static DigitalInput armLowSwitch;
	
	// Initialize anything related to driving (motor controllers, encoders, etc.)
	public static void initDrive() {
		RobotMap.leftFrontDriveTalon  = new WPI_TalonSRX(RobotMap.LEFT_FRONT_DRIVE_TALON_PORT);
		RobotMap.leftBackDriveTalon   = new WPI_TalonSRX(RobotMap.LEFT_BACK_DRIVE_TALON_PORT);
		RobotMap.rightFrontDriveTalon = new WPI_TalonSRX(RobotMap.RIGHT_FRONT_DRIVE_TALON_PORT);
		RobotMap.rightBackDriveTalon  = new WPI_TalonSRX(RobotMap.RIGHT_BACK_DRIVE_TALON_PORT);
		
		RobotMap.leftBackDriveTalon.follow(RobotMap.leftFrontDriveTalon);
		RobotMap.rightBackDriveTalon.follow(RobotMap.rightFrontDriveTalon);
		
		RobotMap.drive = new DifferentialDrive(RobotMap.leftFrontDriveTalon, RobotMap.rightFrontDriveTalon);
		
		RobotMap.drive.setDeadband(0);
	}
	
	public static void initCargo() {
		RobotMap.armTalon = new WPI_TalonSRX(RobotMap.ARM_TALON_PORT);
		RobotMap.grabberTalon = new WPI_TalonSRX(RobotMap.GRABBER_TALON_PORT);
	}
	
	public static void initHatch() {
		RobotMap.hatchSolenoid = new Solenoid(RobotMap.HATCH_SOLENOID_PORT);
	}

	public static void initSensors() {
		RobotMap.navX = new WPI_AHRS(Port.kMXP);
	}

	public static void initRelays() {
		RobotMap.frontRelay = new Relay(RobotMap.FRONT_RELAY_CHANNEL, Relay.Direction.kReverse);
		RobotMap.backRelay  = new Relay(RobotMap.BACK_RELAY_CHANNEL, Relay.Direction.kReverse);
	}

	public static void initSwitches() {
		RobotMap.armHighSwitch = new DigitalInput(RobotMap.ARM_HIGH_SWITCH_CHANNEL);
		RobotMap.armLowSwitch  = new DigitalInput(RobotMap.ARM_LOW_SWITCH_CHANNEL);
	}

}
