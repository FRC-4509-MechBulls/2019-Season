package frc.robot.commands;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.RobotMap;


public class ToggleFrontRelayCommand extends InstantCommand {

	public ToggleFrontRelayCommand() {
		this.setRunWhenDisabled(true);
	}

	public void execute() {
		if(RobotMap.frontRelay.get() == Relay.Value.kOff) {
			RobotMap.frontRelay.set(Relay.Value.kReverse);
		} else {
			RobotMap.frontRelay.set(Relay.Value.kOff);
		}
	}

}