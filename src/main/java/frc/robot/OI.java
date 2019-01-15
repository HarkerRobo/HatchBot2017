package frc.robot;

import frc.robot.commands.SetHatchIntakeDirection;
import frc.robot.commands.ToggleHatchIntakeDirection;
import frc.robot.subsystems.HatchPanelIntake;
import harkerrobolib.wrappers.HSGamepad;
import harkerrobolib.wrappers.LogitechAnalogGamepad;
import harkerrobolib.wrappers.XboxGamepad;

/**
 * Class containing controls for operator and driver gamepad
 * 
 * @since January 14, 2019
 * @author Austin Wang
 * @author Chirag Kaushik
 * @author Jatin Kohli
 */
public class OI {
    private static OI instance;
    private HSGamepad driverGamepad;
    private HSGamepad operatorGamepad; 
    
    public static final double DEADBAND = 0.1;         
    
    private static final int DRIVER_PORT = 0;
    private static final int OPERATOR_PORT = 1;        

    private OI() {
        driverGamepad = new XboxGamepad(DRIVER_PORT);
        operatorGamepad = new LogitechAnalogGamepad(OPERATOR_PORT);

        driverGamepad.getButtonY().whenPressed(new ToggleHatchIntakeDirection());                                        
        driverGamepad.getButtonA().whenPressed(new SetHatchIntakeDirection(HatchPanelIntake.IntakeDirection.IN));
        driverGamepad.getButtonB().whenPressed(new SetHatchIntakeDirection(HatchPanelIntake.IntakeDirection.OUT));
    }
    public HSGamepad getDriverGamepad() {
        return driverGamepad;
    }

    public HSGamepad getOperatorGamepad() {
        return operatorGamepad;
    }


    public static OI getInstance() {
        if(instance == null) {
            instance = new OI();
        }
        return instance;
    }

    public static void initBinds()
    {
 
    }
}                                              
