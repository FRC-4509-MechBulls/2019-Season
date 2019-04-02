package frc.robot.controls;

import edu.wpi.first.wpilibj.GenericHID;


public class XboxControllerPair implements ControllerBase {

	edu.wpi.first.wpilibj.XboxController controller1, controller2;
	
	public XboxControllerPair(int port1, int port2) {
		this.controller1 = new edu.wpi.first.wpilibj.XboxController(port1);
		this.controller2 = new edu.wpi.first.wpilibj.XboxController(port2);
	}
	
	@Override
	public double getDrive() {
		double n = this.controller1.getTriggerAxis(GenericHID.Hand.kRight) - this.controller1.getTriggerAxis(GenericHID.Hand.kLeft);
		return Math.abs(n) < 0.2 ? 0 : n;
	}
	
	@Override
	public double getTurn() {
		double n = this.controller1.getX(GenericHID.Hand.kLeft);
		return Math.abs(n) < 0.2 ? 0 : n;
	}

	@Override
	public boolean getDirectionDown() {
		return this.controller1.getPOV() == 180;
	}

	@Override
	public boolean getDirectionRight() {
		return this.controller1.getPOV() == 90;
	}

	@Override
	public boolean getDirectionLeft() {
		return this.controller1.getPOV() == 270;
	}

	@Override
	public double getArm() {
		double n = this.controller2.getY(GenericHID.Hand.kRight);
		return Math.abs(n) < 0.1 ? 0 : n;
	}

	@Override
	public double getGrabber() {
		double n = this.controller2.getY(GenericHID.Hand.kLeft);
		return Math.abs(n) < 0.1 ? 0 : n;
	}

	@Override
	public boolean getHatchPopper() {
		return this.controller1.getYButton();
	}

	@Override
	public boolean getChangeSource() {
		return this.controller1.getStartButtonPressed() || this.controller2.getStartButtonPressed();
	}

	@Override
	public boolean getReverseDrive() {
		return this.controller1.getBackButtonPressed();
	}

	@Override
	public boolean getGoFast() {
		return this.controller1.getBButton();
	}
	
	@Override
	public boolean getAlign() {
		return this.controller1.getXButton();
	}
	
}