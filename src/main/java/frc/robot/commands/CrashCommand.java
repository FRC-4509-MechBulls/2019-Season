package frc.robot.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;

public class CrashCommand extends InstantCommand {

	public void execute() {
		throw new RuntimeException(new Exception("CrashCommand"));
	}

}