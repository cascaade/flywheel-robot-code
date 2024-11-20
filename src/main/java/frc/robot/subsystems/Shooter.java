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

    public Shooter() {
        shooterLowerMotor = new CANSparkMax(ShooterConstants.kLowerMotorCANID, MotorType.kBrushless);
        shooterUpperMotor = new CANSparkMax(ShooterConstants.kUpperMotorCANID, MotorType.kBrushless);

        shooterLowerMotor.restoreFactoryDefaults(); // Restore the factory defaults
        shooterUpperMotor.restoreFactoryDefaults();

        shooterLowerMotor.burnFlash(); // Apply factory defaults to the motor itself
        shooterUpperMotor.burnFlash();
    }

    public void shoot() {
        shooterLowerMotor.setVoltage(3);
        shooterUpperMotor.setVoltage(-3);
    }

    public void rest() {
        shooterLowerMotor.setVoltage(0);
        shooterUpperMotor.setVoltage(0);
    }

    public Command runShoot() {
        return runOnce(() -> shoot());
    }

    public Command runRest() {
        return runOnce(() -> rest());
    }
}
