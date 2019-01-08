package frc.robot.commands;

import frc.robot.Robot;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Command;

public class PneumaticPistonCommand extends Command {

	private Solenoid solenoid;

	public PneumaticPistonCommand(Solenoid solenoid){
		this.solenoid = solenoid;
		requires(Robot.pneumaticSubsystem); // Tells the Scheduler that this command will need the PneumaticSubsystem.
	}

	protected void initialize() {}

	public void execute() {
		Robot.pneumaticSubsystem.shootPiston(this.solenoid); // Shoots the piston connected to the solenoid identified when calling the command
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		Robot.pneumaticSubsystem.closePiston(this.solenoid); // Closes the piston once the command is terminated.
	}
}