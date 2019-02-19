package frc.robot.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Robot;

public class HabDisableCommand extends InstantCommand {

	public HabDisableCommand() {
		requires(Robot.habSubsystem);
	}

	public void execute() {
		Robot.habSubsystem.disable();
	}

}