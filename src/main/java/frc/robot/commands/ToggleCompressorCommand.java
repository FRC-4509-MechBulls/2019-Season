package frc.robot.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.RobotMap;

public class ToggleCompressorCommand extends InstantCommand {

	public ToggleCompressorCommand() {
		this.setRunWhenDisabled(true);
	}

	public void execute() {
		if(RobotMap.compressor.enabled()) {
			RobotMap.compressor.stop();
		} else {
			RobotMap.compressor.start();
		}
	}

}