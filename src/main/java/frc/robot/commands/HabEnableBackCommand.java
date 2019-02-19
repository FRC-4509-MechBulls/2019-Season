package frc.robot.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Robot;

public class HabEnableBackCommand extends InstantCommand {

	public HabEnableBackCommand() {
		requires(Robot.habSubsystem);
	}

	public void execute() {
		Robot.habSubsystem.enableBack();
	}

}