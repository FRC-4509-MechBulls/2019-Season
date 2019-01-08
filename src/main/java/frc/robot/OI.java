/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import frc.robot.commands.*;
import frc.robot.controls.*;

import edu.wpi.first.wpilibj.buttons.Trigger;

/*
 * This class handles human input and maps it to commands.
 * OI stands for Operator Input
 * 
 */
public class OI {
	
	public static final int XBOX_CONTROLLER_1_PORT = 0;
	public static final int XBOX_CONTROLLER_2_PORT = 1;
	
	public ControllerBase controller;
	DriveTrigger     driveTrigger;
	OpenSolenoidTrigger openSolenoidTrigger;
	StartCompressorTrigger startCompressorTrigger;
	
	public OI() {
		// List of possible controllers
		//this.controller = new XboxControllerPair(OI.XBOX_CONTROLLER_1_PORT, OI.XBOX_CONTROLLER_2_PORT);
		this.controller = new XboxController(OI.XBOX_CONTROLLER_1_PORT);
		
		// Init triggers
		this.driveTrigger = new DriveTrigger();
		this.openSolenoidTrigger = new OpenSolenoidTrigger();
		this.startCompressorTrigger = new StartCompressorTrigger();
	}
	
	// Maps triggers to commands.
	public void setTriggers() {
		this.driveTrigger.whileActive(new DirectDriveCommand());
		this.openSolenoidTrigger.whileActive(new PneumaticPistonCommand(RobotMap.testSolenoid));
		this.startCompressorTrigger.whenActive(new StartCompressorCommand());
	}
	
	class DriveTrigger extends Trigger {
		public boolean get() { return Robot.oi.controller.getDrive() != 0 || Robot.oi.controller.getTurn() != 0; }
	}

	class OpenSolenoidTrigger extends Trigger {
		public boolean get() { return Robot.oi.controller.getHatchPistonPressed(); }
	}

	class StartCompressorTrigger extends Trigger {
		public boolean get() { return Robot.oi.controller.getStartCompressor(); }
	}

}