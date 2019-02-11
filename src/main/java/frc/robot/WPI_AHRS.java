package frc.robot;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.SPI.Port;
import edu.wpi.first.wpilibj.interfaces.Gyro;

/*
 * Wrapper class for using the NavX as a PID source
 */
public class WPI_AHRS extends AHRS implements PIDSource, Gyro {

	public WPI_AHRS(Port port) {
		super(port);
	}

	public void calibrate() {
		this.reset();
	}

}