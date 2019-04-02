package frc.robot;

import edu.wpi.first.wpilibj.buttons.Trigger;
import frc.robot.commands.*;
import frc.robot.controls.ControllerBase;
import frc.robot.controls.XboxControllerPair;

/*
 * This class handles human input and maps it to commands.
 * OI stands for Operator Input
 * 
 */
public class OI {
	
	public static final int XBOX_CONTROLLER_1_PORT = 0;
	public static final int XBOX_CONTROLLER_2_PORT = 1;
	
	public ControllerBase controller;
	DriveTrigger driveTrigger;
	GoFastTrigger goFastTrigger;
	DirectionDownTrigger directionDownTrigger;
	DirectionRightTrigger directionRightTrigger;
	DirectionLeftTrigger directionLeftTrigger;
	ArmTrigger armTrigger;
	GrabberTrigger grabberTrigger;
	HatchPopperTrigger hatchPopperTrigger;
	ChangeSourceTrigger changeSourceTrigger;
	ReverseDriveTrigger reverseDriveTrigger;
	AlignTrigger alignTrigger;
	
	public OI() {
		// List of possible controllers
		//this.controller = new XboxController(OI.XBOX_CONTROLLER_1_PORT);
		this.controller = new XboxControllerPair(OI.XBOX_CONTROLLER_1_PORT, OI.XBOX_CONTROLLER_2_PORT);
		
		// Init triggers
		this.driveTrigger = new DriveTrigger();
		this.goFastTrigger = new GoFastTrigger();

		this.directionDownTrigger = new DirectionDownTrigger();
		this.directionRightTrigger = new DirectionRightTrigger();
		this.directionLeftTrigger = new DirectionLeftTrigger();

		this.armTrigger = new ArmTrigger();
		this.grabberTrigger = new GrabberTrigger();
		this.hatchPopperTrigger = new HatchPopperTrigger();

		this.changeSourceTrigger = new ChangeSourceTrigger();
		this.reverseDriveTrigger = new ReverseDriveTrigger();

		this.alignTrigger = new AlignTrigger();
	}

	// Maps triggers to commands.
	public void setTriggers() {
		this.driveTrigger.whileActive(new DirectDriveCommand());
		this.goFastTrigger.whileActive(new GottaGoFastCommand());

		this.directionRightTrigger.whenActive(new ToggleFrontRelayCommand());
		//this.directionDownTrigger.whenActive(new ResetGyroCommand());
		this.directionLeftTrigger.whenActive(new ToggleBackRelayCommand());

		this.armTrigger.whileActive(new DirectArmCommand());
		this.grabberTrigger.whileActive(new DirectGrabberCommand());
		this.hatchPopperTrigger.whileActive(new PopHatchCommand());

		this.changeSourceTrigger.whenActive(new ChangeSourceCommand());
		this.reverseDriveTrigger.whenActive(new ReverseDriveCommand());

		this.alignTrigger.whileActive(new TurnToCenterTargetsCommand());
	}

	class DriveTrigger extends Trigger {
		public boolean get() { return (Robot.oi.controller.getDrive() != 0 || Robot.oi.controller.getTurn() != 0); }
	}

	class GoFastTrigger extends Trigger {
		public boolean get() { return Robot.oi.controller.getGoFast(); }
	}
	
	class DirectionDownTrigger extends Trigger {
		public boolean get() { return Robot.oi.controller.getDirectionDown(); }
	}
	
	class DirectionRightTrigger extends Trigger {
		public boolean get() { return Robot.oi.controller.getDirectionRight(); }
	}
	
	class DirectionLeftTrigger extends Trigger {
		public boolean get() { return Robot.oi.controller.getDirectionLeft(); }
	}
	
	class ArmTrigger extends Trigger {
		public boolean get() { return Robot.oi.controller.getArm() != 0; }
	}
	
	class GrabberTrigger extends Trigger {
		public boolean get() { return Robot.oi.controller.getGrabber() != 0; }
	}
	
	class HatchPopperTrigger extends Trigger {
		public boolean get() { return Robot.oi.controller.getHatchPopper(); }
	}

	class ChangeSourceTrigger extends Trigger {
		public boolean get() { return Robot.oi.controller.getChangeSource(); }
	}

	class ReverseDriveTrigger extends Trigger {
		public boolean get() { return Robot.oi.controller.getReverseDrive(); }
	}

	class AlignTrigger extends Trigger {
		public boolean get() { return Robot.oi.controller.getAlign(); }
	}

}