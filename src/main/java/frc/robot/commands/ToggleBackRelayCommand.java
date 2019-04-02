package frc.robot.commands;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.RobotMap;


public class ToggleBackRelayCommand extends InstantCommand {

	public ToggleBackRelayCommand() {
		this.setRunWhenDisabled(true);
	}

	public void execute() {
		if(RobotMap.backRelay.get() == Relay.Value.kOff) {
			RobotMap.backRelay.set(Relay.Value.kReverse);
		} else {
			RobotMap.backRelay.set(Relay.Value.kOff);
		}
	}

}