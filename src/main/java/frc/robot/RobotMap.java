/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

	public static final int LEFT_FRONT_DRIVE_TALON_PORT  = 0;
	public static final int LEFT_BACK_DRIVE_TALON_PORT   = 1;

	public static WPI_TalonSRX leftFrontDriveTalon;
	public static WPI_TalonSRX leftBackDriveTalon;
	
	// Initialize anything related to driving (motor controllers, encoders, etc.)
	public static void initDrive() {
		RobotMap.leftFrontDriveTalon  = new WPI_TalonSRX(RobotMap.LEFT_FRONT_DRIVE_TALON_PORT);
		RobotMap.leftBackDriveTalon   = new WPI_TalonSRX(RobotMap.LEFT_BACK_DRIVE_TALON_PORT);
		
		RobotMap.leftBackDriveTalon.follow(RobotMap.leftFrontDriveTalon);

		RobotMap.leftFrontDriveTalon.setNeutralMode(NeutralMode.Coast);
		RobotMap.leftBackDriveTalon.setNeutralMode(NeutralMode.Coast);

		RobotMap.leftFrontDriveTalon.configOpenloopRamp(0.2);
		RobotMap.leftFrontDriveTalon.configClosedloopRamp(0.2);
		RobotMap.leftFrontDriveTalon.configNominalOutputForward(0, 0);
		RobotMap.leftFrontDriveTalon.configPeakOutputReverse(1, 0);

		RobotMap.leftFrontDriveTalon.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
	}

}
