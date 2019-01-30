package frc.robot.commands;

import frc.robot.Robot;
import frc.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class DirectDriveCommand extends Command {

	double velocity;
	
	public DirectDriveCommand() {
		requires(Robot.drivingSubsystem);
	}

	protected void initialize() {}

	public void execute() {
		RobotMap.masterTalon.set(Robot.oi.controller.getDrive());
		System.out.println("----- Drive Report -----");
		System.out.println("Controller Input:   " + Robot.oi.controller.getDrive());
		System.out.println("Talon Speed:        " + RobotMap.masterTalon.get());
		System.out.println("Selected Sensor Pos:" + RobotMap.masterTalon.getSelectedSensorPosition());
		System.out.println("Pos from Collection:" + RobotMap.masterTalon.getSensorCollection().getQuadraturePosition());
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		Robot.drivingSubsystem.stop();
	}

}