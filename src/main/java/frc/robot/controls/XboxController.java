package frc.robot.controls;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Preferences;


public class XboxController implements ControllerBase {

	edu.wpi.first.wpilibj.XboxController controller;
	
	public XboxController(int port) {
		this.controller = new edu.wpi.first.wpilibj.XboxController(port);
	}
	
	@Override
	public double getDrive() {
		return this.controller.getTriggerAxis(GenericHID.Hand.kRight) - this.controller.getTriggerAxis(GenericHID.Hand.kLeft);
	}
	
	@Override
	public double getTurn() {
		double n = this.controller.getX(GenericHID.Hand.kRight);
		return Math.abs(n) < Preferences.getInstance().getDouble("DEADZONE", 0.1) ? 0 : n;
	}

	@Override
	public boolean getDirectionDown() {
		return this.controller.getPOV() == 180;
	}

	@Override
	public boolean getDirectionRight() {
		return this.controller.getPOV() == 90;
	}

	@Override
	public boolean getDirectionLeft() {
		return this.controller.getPOV() == 270;
	}

	@Override
	public double getArm() {
		double n = this.controller.getY(GenericHID.Hand.kLeft);
		return Math.abs(n) < Preferences.getInstance().getDouble("DEADZONE", 0.1) ? 0 : n;
	}

	@Override
	public double getGrabber() {
		int n = 0;
		if(this.controller.getBumper(GenericHID.Hand.kLeft))  n -= 1;
		if(this.controller.getBumper(GenericHID.Hand.kRight)) n += 1;
		return n;
	}

	@Override
	public boolean getHatchPopper() {
		return this.controller.getYButtonPressed();
	}

	@Override
	public boolean getChangeSource() {
		return this.controller.getStartButtonPressed();
	}

	@Override
	public boolean getReverseDrive() {
		return this.controller.getBackButtonPressed();
	}

	@Override
	public boolean getGoFast() {
		return this.controller.getBButton();
	}
	
	@Override
	public boolean getAlign() {
		return this.controller.getXButton();
	}
	
}