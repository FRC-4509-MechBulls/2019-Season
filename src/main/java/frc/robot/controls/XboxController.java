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
	public boolean testA() {
		return this.controller.getAButtonPressed();
	}

	@Override
	public boolean testB() {
		return this.controller.getBButtonPressed();
	}

	@Override
	public boolean testX() {
		return this.controller.getXButtonPressed();
	}

	@Override
	public boolean testY() {
		return this.controller.getYButtonPressed();
	}
	
}