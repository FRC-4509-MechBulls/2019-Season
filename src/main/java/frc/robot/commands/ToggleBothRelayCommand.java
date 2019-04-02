package frc.robot.commands;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.RobotMap;


public class ToggleBothRelayCommand extends InstantCommand {

	public ToggleBothRelayCommand() {
		this.setRunWhenDisabled(true);
	}

	public void execute() {
		if(RobotMap.frontRelay.get() == Relay.Value.kOff) {
			RobotMap.frontRelay.set(Relay.Value.kReverse);
		} else {
			RobotMap.frontRelay.set(Relay.Value.kOff);
		}
		
		if(RobotMap.backRelay.get() == Relay.Value.kOff) {
			RobotMap.backRelay.set(Relay.Value.kReverse);
		} else {
			RobotMap.backRelay.set(Relay.Value.kOff);
		}
	}

}