/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

	public static final int MASTER_TALON_PORT  = 3;
	public static final int FOLLOW_TALON_PORT   = 2;

	public static WPI_TalonSRX masterTalon;
	public static WPI_TalonSRX followTalon;
	
	// Initialize anything related to driving (motor controllers, encoders, etc.)
	public static void initDrive() {
		RobotMap.masterTalon = new WPI_TalonSRX(RobotMap.MASTER_TALON_PORT);
		RobotMap.followTalon = new WPI_TalonSRX(RobotMap.FOLLOW_TALON_PORT);
		
		RobotMap.followTalon.follow(RobotMap.masterTalon);

		RobotMap.masterTalon.configOpenloopRamp(0.2);
		RobotMap.masterTalon.configClosedloopRamp(0.2);
		RobotMap.masterTalon.configNominalOutputForward(0, 0);
		RobotMap.masterTalon.configNominalOutputReverse(0, 0);
		RobotMap.masterTalon.configPeakOutputForward(1, 0);
		RobotMap.masterTalon.configPeakOutputReverse(-1, 0);

		RobotMap.masterTalon.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
	}

}
