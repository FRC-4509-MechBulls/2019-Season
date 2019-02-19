package frc.robot.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Robot;

public class HabDisableFrontCommand extends InstantCommand {

	public HabDisableFrontCommand() {
		requires(Robot.habSubsystem);
	}

	public void execute() {
		Robot.habSubsystem.disableFront();
	}

}