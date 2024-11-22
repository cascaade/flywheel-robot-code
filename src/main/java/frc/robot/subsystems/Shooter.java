package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.ShooterConstants;

public class Shooter extends SubsystemBase {
    private CANSparkMax shooterLowerMotor;
    private CANSparkMax shooterUpperMotor;
    private CANSparkMax shooterIndexMotor;

    private int[] activeSpeeds = {};

    public Shooter() {
        shooterLowerMotor = new CANSparkMax(ShooterConstants.kLowerMotorCANID, MotorType.kBrushless);
        shooterUpperMotor = new CANSparkMax(ShooterConstants.kUpperMotorCANID, MotorType.kBrushless);
        shooterIndexMotor = new CANSparkMax(ShooterConstants.kIndexMotorCANID, MotorType.kBrushless);

        shooterLowerMotor.restoreFactoryDefaults(); // Restore the factory defaults
        shooterUpperMotor.restoreFactoryDefaults();
        shooterIndexMotor.restoreFactoryDefaults();

        shooterLowerMotor.burnFlash(); // Apply factory defaults to the motor itself
        shooterUpperMotor.burnFlash();
        shooterIndexMotor.burnFlash();
    }

    public void shoot(speed) {
        // javascript syntax, will convert to java
        activeSpeeds.push(speed);
    }

    public void rest(speed) {
        // javascript syntax, will convert to java
        delete activeSpeeds[activeSpeeds.indexOf(speed)]
    }

    public void adjustShooter() {
        int max = 0;
        for (int speed : activeSpeeds) {
            if (speed > max) {
                max = speed;
            };
        };
        shooterLowerMotor.setVoltage(max);
        shooterUpperMotor.setVoltage(-max);
        shooterIndexMotor.setVoltage(max);
    }

    public Command runSlowShoot() {
        return runOnce(() -> shoot(3));
    }

    public command runFastShoot() {
        return runOnce(() -> fastShoot(6))
    }

    public Command runSlowRest() {
        return runOnce(() -> rest(3));
    }

    public Command runFastRest() {
        return runOnce(() -> rest(6));
    }
}
