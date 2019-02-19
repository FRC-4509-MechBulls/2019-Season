package frc.robot.commands;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.command.Command;


public class ChangeSourceCommand extends Command {

	public ChangeSourceCommand() {
		setRunWhenDisabled(true);
	}

	public void execute() {
		NetworkTableEntry hudSource = NetworkTableInstance.getDefault().getTable("vision").getEntry("hudSource");
		hudSource.setDouble(hudSource.getDouble(-1) + 1);
	}

	protected boolean isFinished() {
		return true;
	}

}