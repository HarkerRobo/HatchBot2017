package frc.robot;

import harkerrobolib.wrappers.HSGamepad;
import harkerrobolib.wrappers.LogitechAnalogGamepad;
import harkerrobolib.wrappers.XboxGamepad;

/**
 * Class containing controls for operator and driver gamepad
 * 
 * @since January 14, 2019
 * @author Austin Wang
 */
public class OI {
    private OI instance;
    private HSGamepad driverGamepad;
    private HSGamepad operatorGamepad; 
    
    public static final double DEADBAND = 0.1;         
    
    private static final int DRIVER_PORT = 0;
    private static final int OPERATOR_PORT = 1;        

    private OI() {
        driverGamepad = new XboxGamepad(DRIVER_PORT));
        operatorGamepad = new LogitechAnalogGamepad(OPERATOR_PORT);
    }
    public HSGamepad getDriverGamepad() {
        return driverGamepad;
    }

    public HSGamepad getOperatorGamepad() {
        return operatorGamepad;
    }


    public OI getInstance() {
        if(instance == null) {
            instance = new OI();
        }
        return instance;
    }
}                                              
