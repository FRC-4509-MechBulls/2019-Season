package frc.robot;

import edu.wpi.first.networktables.EntryListenerFlags;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.subsystems.DrivingSubsystem;

public class Robot extends TimedRobot {

	public static final DrivingSubsystem drivingSubsystem = new DrivingSubsystem();

	public static OI oi;

	public static double[] contourLeft, contourRight;

	public Timer periodicSecondTimer = new Timer();

	public static double pT, iT, dT;

	@Override
	public void robotInit() {
		RobotMap.initDrive();
		RobotMap.initSensors();
		
		Robot.oi = new OI();
		Robot.oi.setTriggers();

		Robot.drivingSubsystem.createTurnPositionController();

		Robot.contourLeft  = NetworkTableInstance.getDefault().getTable("vision/hatch-targets").getEntry("contour_left").getDoubleArray(new double[6]);
		Robot.contourRight = NetworkTableInstance.getDefault().getTable("vision/hatch-targets").getEntry("contour_right").getDoubleArray(new double[6]);

		NetworkTableInstance.getDefault().getTable("vision/hatch-targets").addEntryListener("contour_left", (table, key, entry, value, flags) -> {
			Robot.contourLeft = value.getDoubleArray();
		}, EntryListenerFlags.kNew | EntryListenerFlags.kUpdate);

		NetworkTableInstance.getDefault().getTable("vision/hatch-targets").addEntryListener("contour_right", (table, key, entry, value, flags) -> {
			Robot.contourRight = value.getDoubleArray();
		}, EntryListenerFlags.kNew | EntryListenerFlags.kUpdate);

		periodicSecondTimer.start();
	}

	public static double getTargetCenter() {
		return (((Robot.contourLeft[0] + Robot.contourLeft[2]) + Robot.contourRight[0]) / 2);
	}

	public static double getAverageDistance() {
		return (Robot.contourLeft[4] + Robot.contourRight[4]) / 2;
	}

	@Override
	public void robotPeriodic() {
		if(periodicSecondTimer.hasPeriodPassed(1)) {
			//System.out.println(RobotMap.navX.getAngle());
		}
	}

	@Override
	public void disabledInit() {
		Robot.drivingSubsystem.stop();
	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void autonomousInit() {
	}

	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
	}

	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void testInit() {
	}

	@Override
	public void testPeriodic() {
	}

}
