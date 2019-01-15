package frc.robot.commands;

import frc.robot.OI;
import frc.robot.subsystems.Drivetrain;
import harkerrobolib.commands.IndefiniteCommand;
import harkerrobolib.util.MathUtil;


/**
 * Drives with velocity manually
 * 
 * @since January 14, 2019
 * @author Austin Wang
 */
public class DriveWithVelocityManual extends IndefiniteCommand {
    public DriveWithVelocityManual() {
        requires(Drivetrain.getInstance());
    }

    
    public void execute() {
        double driverX = OI.getInstance().getDriverGamepad().getLeftX();
        double driverY = OI.getInstance().getDriverGamepad().getLeftY();
        driverX = MathUtil.mapJoystickOutput(driverX,OI.DEADBAND);
        driverY = MathUtil.mapJoystickOutput(driverY,OI.DEADBAND);
        Drivetrain.getInstance().arcadeDrivePercentOutput(driverY, driverX);
    }

    public void end() {
        Drivetrain.getInstance().arcadeDrivePercentOutput(0,0);
    }
}