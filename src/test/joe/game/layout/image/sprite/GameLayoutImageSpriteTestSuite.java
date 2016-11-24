package test.joe.game.layout.image.sprite;

import junit.framework.Test;
import junit.framework.TestSuite;

public class GameLayoutImageSpriteTestSuite {
	public static Test suite()
    {
        TestSuite suite = new TestSuite("Joe.Game.Layout.Image.Sprite Test Suite");
        suite.addTestSuite(AnimatedSpriteTest.class);
        suite.addTestSuite(SpriteTest.class);
        return suite;
    }
}
