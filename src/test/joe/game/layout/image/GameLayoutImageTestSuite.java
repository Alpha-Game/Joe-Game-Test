package test.joe.game.layout.image;

import junit.framework.Test;
import junit.framework.TestSuite;

public class GameLayoutImageTestSuite {
	public static Test suite()
    {
        TestSuite suite = new TestSuite("Joe.Game.Layout.Image Test Suite");
        suite.addTestSuite(ImageDrawerTest.class);
        return suite;
    }
}
