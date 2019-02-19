package frc.robot.controls;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Preferences;


public class XboxControllerPair implements ControllerBase {

	edu.wpi.first.wpilibj.XboxController controller1, controller2;
	
	public XboxControllerPair(int port1, int port2) {
		this.controller1 = new edu.wpi.first.wpilibj.XboxController(port1);
		this.controller2 = new edu.wpi.first.wpilibj.XboxController(port2);
	}
	
	@Override
	public double getDrive() {
		return this.controller1.getTriggerAxis(GenericHID.Hand.kRight) - this.controller1.getTriggerAxis(GenericHID.Hand.kLeft);
	}
	
	@Override
	public double getTurn() {
		double n = this.controller1.getX(GenericHID.Hand.kRight);
		return Math.abs(n) < Preferences.getInstance().getDouble("DEADZONE", 0.1) ? 0 : n;
	}

	@Override
	public boolean getHabEnable() {
		return this.controller1.getPOV() == 0;
	}

	@Override
	public boolean getHabDisable() {
		return this.controller1.getPOV() == 180;
	}

	@Override
	public boolean getHabFront() {
		return this.controller1.getPOV() == 90;
	}

	@Override
	public boolean getHabBack() {
		return this.controller1.getPOV() == 270;
	}

	@Override
	public double getArm() {
		double n = this.controller2.getY(GenericHID.Hand.kRight);
		return Math.abs(n) < Preferences.getInstance().getDouble("DEADZONE", 0.1) ? 0 : n;
	}

	@Override
	public double getGrabber() {
		double n = this.controller2.getY(GenericHID.Hand.kLeft);
		return Math.abs(n) < Preferences.getInstance().getDouble("DEADZONE", 0.1) ? 0 : n;
	}

	@Override
	public boolean getHatchPopper() {
		return this.controller1.getYButton();
	}
	
}