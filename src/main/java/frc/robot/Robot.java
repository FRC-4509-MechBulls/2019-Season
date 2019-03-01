package frc.robot;

import edu.wpi.first.networktables.EntryListenerFlags;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.subsystems.*;

public class Robot extends TimedRobot {

	public static final DrivingSubsystem drivingSubsystem = new DrivingSubsystem();
	public static final HabSubsystem habSubsystem = new HabSubsystem();
	public static final HatchSubsystem hatchSubsystem = new HatchSubsystem();
	public static final ArmSubsystem armSubsystem = new ArmSubsystem();
	public static final GrabberSubsystem grabberSubsystem = new GrabberSubsystem();

	public static OI oi;

	public static double[] contourLeft, contourRight;
	public static double[] cargoX, cargoY, cargoR;

	public static double pGT = 0.01, iGT = 0.0, dGT = 0.0;
	public static double pCT = 0.01, iCT = 0.0, dCT = 0.0;

	@Override
	public void robotInit() {
		RobotMap.initDrive();
		RobotMap.initHab();
		RobotMap.initHatch();
		RobotMap.initCargo();
		RobotMap.initSensors();
		RobotMap.initCompressor();
		
		Robot.oi = new OI();
		Robot.oi.setTriggers();

		Robot.drivingSubsystem.createTurnPositionController();

		Robot.initNT();
	}

	public static double getTargetCenter() {
		return (Robot.contourLeft[0] + Robot.contourRight[0]) / 2;
	}

	public static double getAverageDistance() {
		return (Robot.contourLeft[5] + Robot.contourRight[5]) / 2;
	}

	@Override
	public void robotPeriodic() {
	}

	@Override
	public void disabledInit() {
		Robot.drivingSubsystem.stop();
		Robot.habSubsystem.disable();
		Robot.hatchSubsystem.disable();
		Robot.armSubsystem.stop();
		Robot.grabberSubsystem.stop();
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

	public static void initNT() {
		Robot.contourLeft  = NetworkTableInstance.getDefault().getTable("vision/targets").getEntry("contour_left").getDoubleArray(new double[6]);
		Robot.contourRight = NetworkTableInstance.getDefault().getTable("vision/targets").getEntry("contour_right").getDoubleArray(new double[6]);
		Robot.cargoX = NetworkTableInstance.getDefault().getTable("vision/cargo").getEntry("cargoX").getDoubleArray(new double[0]);
		Robot.cargoY = NetworkTableInstance.getDefault().getTable("vision/cargo").getEntry("cargoY").getDoubleArray(new double[0]);
		Robot.cargoR = NetworkTableInstance.getDefault().getTable("vision/cargo").getEntry("cargoR").getDoubleArray(new double[0]);

		NetworkTableInstance.getDefault().getTable("vision/targets").addEntryListener("contour_left", (table, key, entry, value, flags) -> {
			Robot.contourLeft = value.getDoubleArray();
		}, EntryListenerFlags.kNew | EntryListenerFlags.kUpdate);

		NetworkTableInstance.getDefault().getTable("vision/targets").addEntryListener("contour_right", (table, key, entry, value, flags) -> {
			Robot.contourRight = value.getDoubleArray();
		}, EntryListenerFlags.kNew | EntryListenerFlags.kUpdate);

		NetworkTableInstance.getDefault().getTable("vision/cargo").addEntryListener("cargoX", (table, key, entry, value, flags) -> {
			Robot.cargoX = value.getDoubleArray();
		}, EntryListenerFlags.kNew | EntryListenerFlags.kUpdate);

		NetworkTableInstance.getDefault().getTable("vision/cargo").addEntryListener("cargoY", (table, key, entry, value, flags) -> {
			Robot.cargoY = value.getDoubleArray();
		}, EntryListenerFlags.kNew | EntryListenerFlags.kUpdate);

		NetworkTableInstance.getDefault().getTable("vision/cargo").addEntryListener("cargoR", (table, key, entry, value, flags) -> {
			Robot.cargoR = value.getDoubleArray();
		}, EntryListenerFlags.kNew | EntryListenerFlags.kUpdate);
	}

}
