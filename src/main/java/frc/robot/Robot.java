package frc.robot;

import edu.wpi.first.networktables.EntryListenerFlags;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.DrivingSubsystem;
import frc.robot.subsystems.GrabberSubsystem;
import frc.robot.subsystems.HatchSubsystem;

public class Robot extends TimedRobot {

	public static final DrivingSubsystem drivingSubsystem = new DrivingSubsystem();
	public static final HatchSubsystem hatchSubsystem = new HatchSubsystem();
	public static final ArmSubsystem armSubsystem = new ArmSubsystem();
	public static final GrabberSubsystem grabberSubsystem = new GrabberSubsystem();

	public static OI oi;

	public static double[] contourLeft, contourRight;
	public static double[] cargoX, cargoY, cargoR;

	public static double pGT = 0.001, iGT = 0.0, dGT = 0.0;
	public static double pCT = 0.005, iCT = 0.0001, dCT = 0.0;

	@Override
	public void robotInit() {
		RobotMap.initDrive();
		RobotMap.initHatch();
		RobotMap.initCargo();
		RobotMap.initSensors();
		RobotMap.initRelays();
		RobotMap.initSwitches();
		
		Robot.oi = new OI();
		Robot.oi.setTriggers();

		//Robot.drivingSubsystem.createTurnPositionController();

		Robot.initNT();
	}

	public static double getTargetCenter() {
		if(Robot.contourLeft[0] == 0)  return (0 + Robot.contourRight[0]) / 2;
		if(Robot.contourRight[0] == 0) return (Robot.contourLeft[0] + 416) / 2;
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
		RobotMap.navX.reset();
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
		NetworkTableInstance ntinst = NetworkTableInstance.getDefault();

		Robot.contourLeft  = ntinst.getTable("vision/targets").getEntry("contour_left").getDoubleArray(new double[6]);
		Robot.contourRight = ntinst.getTable("vision/targets").getEntry("contour_right").getDoubleArray(new double[6]);
		Robot.cargoX = ntinst.getTable("vision/cargo").getEntry("cargoX").getDoubleArray(new double[0]);
		Robot.cargoY = ntinst.getTable("vision/cargo").getEntry("cargoY").getDoubleArray(new double[0]);
		Robot.cargoR = ntinst.getTable("vision/cargo").getEntry("cargoR").getDoubleArray(new double[0]);

		ntinst.getTable("vision/targets").addEntryListener("contour_left", (table, key, entry, value, flags) -> {
			Robot.contourLeft = value.getDoubleArray();
		}, EntryListenerFlags.kNew | EntryListenerFlags.kUpdate);

		ntinst.getTable("vision/targets").addEntryListener("contour_right", (table, key, entry, value, flags) -> {
			Robot.contourRight = value.getDoubleArray();
		}, EntryListenerFlags.kNew | EntryListenerFlags.kUpdate);

		ntinst.getTable("vision/cargo").addEntryListener("cargoX", (table, key, entry, value, flags) -> {
			Robot.cargoX = value.getDoubleArray();
		}, EntryListenerFlags.kNew | EntryListenerFlags.kUpdate);

		ntinst.getTable("vision/cargo").addEntryListener("cargoY", (table, key, entry, value, flags) -> {
			Robot.cargoY = value.getDoubleArray();
		}, EntryListenerFlags.kNew | EntryListenerFlags.kUpdate);

		ntinst.getTable("vision/cargo").addEntryListener("cargoR", (table, key, entry, value, flags) -> {
			Robot.cargoR = value.getDoubleArray();
		}, EntryListenerFlags.kNew | EntryListenerFlags.kUpdate);

		ntinst.setUpdateRate(0.02);
	}

}