package test.joe.game;

import junit.framework.Test;
import junit.framework.TestSuite;
import test.joe.game.layout.image.GameLayoutImageTestSuite;
import test.joe.game.layout.image.sprite.GameLayoutImageSpriteTestSuite;
import test.joe.game.platformer.physics.GamePlatformerPhysicsTestSuite;

public class GameTestSuite extends TestSuite {
	public static Test suite()
    {
        TestSuite suite = new TestSuite("Joe.Game Test Suite");
        suite.addTest(GameLayoutImageTestSuite.suite());
        suite.addTest(GameLayoutImageSpriteTestSuite.suite());
        suite.addTest(GamePlatformerPhysicsTestSuite.suite());
        return suite;
    }
}
