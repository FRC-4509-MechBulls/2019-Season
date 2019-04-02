package frc.robot.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.RobotMap;

public class ResetGyroCommand extends InstantCommand {

	public void execute() {
		RobotMap.navX.reset();
	}

}