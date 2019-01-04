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

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

	public static final int XBOX_CONTROLLER_1_PORT = 0;

	public ControllerBase controller;
	CustomTrigger c1Trigger;
	CustomTrigger c2Trigger;

	public OI() {
		// List of possible controllers
		this.controller = new XboxController(OI.XBOX_CONTROLLER_1_PORT);

		// Init triggers
		this.c1Trigger = new CustomTrigger();
		this.c2Trigger = new CustomTrigger();
	}

	// Maps triggers to commands.
	public void setTriggers() {
		this.c1Trigger.whileActive(null);
		this.c2Trigger.whenActive(null);
	}

	class CustomTrigger extends Trigger {
		public boolean get() { return false; }
	}

}
