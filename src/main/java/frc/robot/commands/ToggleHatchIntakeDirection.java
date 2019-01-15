package frc.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.subsystems.HatchPanelIntake;

/**
 * Toggles the hatch panel intake direction
 * 
 * @author Chirag Kaushik
 * @since January 14, 2019
 */
public class ToggleHatchIntakeDirection extends InstantCommand {

    @Override
    public void initialize() {
        HatchPanelIntake.getInstance().setSolenoidState(HatchPanelIntake.getInstance().getSolenoidState() == DoubleSolenoid.Value.kForward ? DoubleSolenoid.Value.kReverse : DoubleSolenoid.Value.kForward);
    }
}