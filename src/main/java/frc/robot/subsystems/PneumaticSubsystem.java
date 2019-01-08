package frc.robot.subsystems;

import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

//Controls the Pnuematic systems
public class PneumaticSubsystem extends Subsystem {

	public void initDefaultCommand() {}

	//Start the compresser to build pressure in the tanks
	public void startCompressor() {
		RobotMap.testCompressor.start();
	}

	public void stopCompressor() {
		RobotMap.testCompressor.stop();
	}

	public boolean getPressureSwitchValue() {
		return RobotMap.testCompressor.getPressureSwitchValue();
	}

	public void shootPiston(Solenoid solenoid){
		solenoid.set(true);
	}
	
	public void closePiston(Solenoid solenoid){
		solenoid.set(false);
	}
}