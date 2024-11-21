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

    public void shoot() {
        shooterLowerMotor.setVoltage(3); // Set the voltage that influences the speed of the motor
        shooterUpperMotor.setVoltage(-3);
        shooterIndexMotor.setVoltage(3);
    }

    public void fastShoot() {
        shooterLowerMotor.setVoltage(6);
        shooterUpperMotor.setVoltage(-6);
        shooterIndexMotor.setVoltage(6);
    }

    public void rest() {
        shooterLowerMotor.setVoltage(0);
        shooterUpperMotor.setVoltage(0);
        shooterIndexMotor.setVoltage(3);
    }

    public void 

    public Command runShoot() {
        return runOnce(() -> shoot());
    }

    public command runFastShoot() {
        return runOnce(() -> fastShoot())
    }

    public Command runRest() {
        return runOnce(() -> rest());
    }
}
