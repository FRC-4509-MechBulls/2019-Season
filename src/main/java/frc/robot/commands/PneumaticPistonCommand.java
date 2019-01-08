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

	protected void initialize() {
		// Make sure the controller is initialized before we try to use it.
		if(Robot.oi.controller == null) throw new NullPointerException("Controller was null.");
	}

	public void execute() {
		Robot.pneumaticSubsystem.shootPiston(this.solenoid); // Shoots the piston connected to the solenoid identified when calling the command
	}

	protected boolean isFinished() {
		return false; // We don't want the command to stop, we want it to be interrupted.
	}

	protected void end() {
		Robot.pneumaticSubsystem.closePiston(this.solenoid); // Closes the piston once the command is terminated.
	}
}