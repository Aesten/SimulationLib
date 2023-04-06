package net.aesten.simulation;

import net.aesten.simulation.component.Robot;
import net.aesten.simulation.data.Orientation;
import net.aesten.simulation.environment.GridEnvironment;
import net.aesten.simulation.exceptions.SimulationException;
import net.aesten.simulation.visual.EnvVisualizer;

import java.awt.*;

public class SimpleSimulationTest {
    public static void main(String[] args) throws SimulationException, InterruptedException {
        GridEnvironment env = new GridEnvironment(15, 15);
        EnvVisualizer window = new EnvVisualizer(env, "Simple Simulation", 200, 100, 500, 500);
        SimpleSimulation sim = new SimpleSimulation(env, window);

        Robot r1 = new SimpleRobot(5, 5);
        Robot r2 = new SimpleRobot(3, 13);
        Robot r3 = new SimpleRobot(10, 5);
        Robot r4 = new SimpleRobot(14, 14);

        r1.setOrientation(Orientation.DOWN);
        r2.setOrientation(Orientation.LEFT);

        r1.setColor(Color.CYAN);

        SimpleObstacle o1 = new SimpleObstacle(14,12, Color.YELLOW, "yellow");
        SimpleObstacle o2 = new SimpleObstacle(3,5, Color.BLACK, "black");
        SimpleObstacle o3 = new SimpleObstacle(8,6, Color.RED, "red");
        SimpleObstacle o4 = new SimpleObstacle(5,7, Color.GRAY, "gray");
        SimpleObstacle o5 = new SimpleObstacle(7,14, Color.PINK, "pink");
        SimpleObstacle o6 = new SimpleObstacle(12,4, Color.BLACK, "black");

        sim.addComponent(r1);
        sim.addComponent(r2);
        sim.addComponent(r3);
        sim.addComponent(r4);
        sim.addComponent(o1);
        sim.addComponent(o2);
        sim.addComponent(o3);
        sim.addComponent(o4);
        sim.addComponent(o5);
        sim.addComponent(o6);

        for (int s = 0 ; s < 30 ; s++) {
            sim.step();
            Thread.sleep(2000);
        }

    }
}
