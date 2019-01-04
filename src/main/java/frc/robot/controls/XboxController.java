package frc.robot.controls;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Preferences;

public class XboxController implements ControllerBase {

	edu.wpi.first.wpilibj.XboxController controller;

	public XboxController(int port) {
		this.controller = new edu.wpi.first.wpilibj.XboxController(port);
	}

	@Override
	public double getTrigger() {
		return this.controller.getTriggerAxis(GenericHID.Hand.kRight) - this.controller.getTriggerAxis(GenericHID.Hand.kLeft);
	}

	@Override
	public double getJoystick() {
		double n = this.controller.getX(GenericHID.Hand.kRight);
		return Math.abs(n) < Preferences.getInstance().getDouble("DEADZONE", 0.1) ? 0 : n;
	}

	public boolean getButton() {
		return this.controller.getAButton();
	}

}
