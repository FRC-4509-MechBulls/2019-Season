/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.buttons.Trigger;
import frc.robot.commands.ChangeSourceCommand;
import frc.robot.commands.TurnToCenterTargetsCommand;
import frc.robot.commands.TurnToCommand;
import frc.robot.controls.ControllerBase;
import frc.robot.controls.XboxController;

/*
 * This class handles human input and maps it to commands.
 * OI stands for Operator Input
 * 
 */
public class OI {
	
	public static final int XBOX_CONTROLLER_1_PORT = 0;
	
	public ControllerBase controller;
	DriveTrigger  driveTrigger;
	YTrigger yTrigger;
	BTrigger bTrigger;
	ATrigger aTrigger;
	XTrigger xTrigger;
	StartTrigger centerTrigger;
	
	public OI() {
		// List of possible controllers
		this.controller = new XboxController(OI.XBOX_CONTROLLER_1_PORT);
		
		// Init triggers
		this.driveTrigger = new DriveTrigger();
		this.yTrigger = new YTrigger();
		this.bTrigger = new BTrigger();
		this.aTrigger = new ATrigger();
		this.xTrigger = new XTrigger();
		this.centerTrigger = new StartTrigger();
	}

	// Maps triggers to commands.
	public void setTriggers() {
		//this.driveTrigger.whileActive(new DirectDriveCommand());
		this.yTrigger.whenActive(new TurnToCommand(0));
		this.bTrigger.whenActive(new TurnToCommand(45));
		this.aTrigger.whenActive(new TurnToCommand(90));
		this.xTrigger.whenActive(new ChangeSourceCommand());
		this.centerTrigger.whenActive(new TurnToCenterTargetsCommand());
	}
	
	class DriveTrigger extends Trigger {
		public boolean get() { return Robot.oi.controller.getDrive() != 0 || Robot.oi.controller.getTurn() != 0; }
	}
	
	class YTrigger extends Trigger {
		public boolean get() { return Robot.oi.controller.getY(); }
	}
	
	class BTrigger extends Trigger {
		public boolean get() { return Robot.oi.controller.getB(); }
	}
	
	class ATrigger extends Trigger {
		public boolean get() { return Robot.oi.controller.getA(); }
	}
	
	class XTrigger extends Trigger {
		public boolean get() { return Robot.oi.controller.getX(); }
	}

	class StartTrigger extends Trigger {
		public boolean get() { return Robot.oi.controller.getStart(); }
	}

}