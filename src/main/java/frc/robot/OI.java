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
	TestATrigger aTrigger;
	TestBTrigger bTrigger;
	TestXTrigger xTrigger;
	TestYTrigger yTrigger;
	
	public OI() {
		// List of possible controllers
		//this.controller = new XboxControllerPair(OI.XBOX_CONTROLLER_1_PORT, OI.XBOX_CONTROLLER_2_PORT);
		this.controller = new XboxController(OI.XBOX_CONTROLLER_1_PORT);
		
		// Init triggers
		this.driveTrigger = new DriveTrigger();
		this.aTrigger = new TestATrigger();
		this.bTrigger = new TestBTrigger();
		this.xTrigger = new TestXTrigger();
		this.yTrigger = new TestYTrigger();
	}
	
	// Maps triggers to commands.
	public void setTriggers() {
		this.aTrigger.whileActive(new DriveStraightWithVelocityCommand(0.5));
		this.bTrigger.whileActive(new DriveStraightWithVelocityCommand(1.0));
		this.xTrigger.whileActive(new DriveToPointCommand(10));
		this.yTrigger.whileActive(new DriveToPointCommand(50));
	}
	
	class DriveTrigger extends Trigger {
		public boolean get() { return Robot.oi.controller.getDrive() != 0 || Robot.oi.controller.getTurn() != 0; }
	}

	class TestATrigger extends Trigger {
		public boolean get() { return Robot.oi.controller.testA(); };
	}

	class TestBTrigger extends Trigger {
		public boolean get() { return Robot.oi.controller.testB(); };
	}

	class TestXTrigger extends Trigger {
		public boolean get() { return Robot.oi.controller.testX(); };
	}

	class TestYTrigger extends Trigger {
		public boolean get() { return Robot.oi.controller.testY(); };
	}

}