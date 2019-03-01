package frc.robot.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Robot;

public class HabToggleBackCommand extends InstantCommand {

	public HabToggleBackCommand() {
		requires(Robot.habSubsystem);
	}

	public void execute() {
		Robot.habSubsystem.toggleBack();
	}

}