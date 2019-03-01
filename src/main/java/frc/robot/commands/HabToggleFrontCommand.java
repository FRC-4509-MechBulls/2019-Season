package frc.robot.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Robot;

public class HabToggleFrontCommand extends InstantCommand {

	public HabToggleFrontCommand() {
		requires(Robot.habSubsystem);
	}

	public void execute() {
		Robot.habSubsystem.toggleFront();
	}

}