package test.joe.game.platformer.physics;

import junit.framework.Test;
import junit.framework.TestSuite;

public class GamePlatformerPhysicsTestSuite {
	public static Test suite()
    {
        TestSuite suite = new TestSuite("Joe.Game.Platformer.Physics Test Suite");
        suite.addTestSuite(PhysicsCalculatorTest.class);
        return suite;
    }
}
