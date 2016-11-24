package test.joe.game.layout.image.sprite;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import joe.game.layout.implementation.LayoutCalculator;
import joe.game.layout.implementation.image.ImageDrawer;
import joe.game.layout.implementation.image.sprite.AnimatedSprite;
import joe.game.layout.implementation.image.sprite.AnimatedSpriteFactory;
import joe.game.layout.implementation.image.sprite.Sprite;
import joe.game.layout.implementation.image.sprite.SpriteFactory;
import junit.framework.TestCase;

public class AnimatedSpriteTest extends TestCase {
	private static final int BLACK = 0xFF000000;
	private static final int WHITE = 0xFFFFFFFF;
	
	public void test_draw_FourStepAnimation() throws Exception{
		SpriteFactory spriteFactory = getSpriteFactory(createImage(2, 2));
		AnimatedSpriteFactory factory = getSpriteFactory((Sprite) spriteFactory.getSprite().flipX(false).flipY(false), (Sprite) spriteFactory.getSprite().flipX(true).flipY(false), (Sprite) spriteFactory.getSprite().flipX(true).flipY(true), (Sprite) spriteFactory.getSprite().flipX(false).flipY(true));
		AnimatedSprite sprite = factory.getSprite();
		
		// Start
		int time = 0;
		
		for (int j = 0; j < 2; j++) {
			// First State;
			for (int i = 0; i < 1; i++) {
				MockImage image = getImage(sprite, time++);
				assertEquals(2, image.getImage().getWidth());
				assertEquals(2, image.getImage().getHeight());
				assertEquals("Time <" + Integer.toString(time - 1) +">", BLACK, image.getImage().getRGB(0, 0));
				assertEquals("Time <" + Integer.toString(time - 1) +">", WHITE, image.getImage().getRGB(1, 0));
				assertEquals("Time <" + Integer.toString(time - 1) +">", WHITE, image.getImage().getRGB(0, 1));
				assertEquals("Time <" + Integer.toString(time - 1) +">", WHITE, image.getImage().getRGB(1, 1));
			}
			
			// Second State
			for (int i = 0; i < 2; i++) {
				MockImage image = getImage(sprite, time++);
				assertEquals(2, image.getImage().getWidth());
				assertEquals(2, image.getImage().getHeight());
				assertEquals("Time <" + Integer.toString(time - 1) +">", WHITE, image.getImage().getRGB(0, 0));
				assertEquals("Time <" + Integer.toString(time - 1) +">", BLACK, image.getImage().getRGB(1, 0));
				assertEquals("Time <" + Integer.toString(time - 1) +">", WHITE, image.getImage().getRGB(0, 1));
				assertEquals("Time <" + Integer.toString(time - 1) +">", WHITE, image.getImage().getRGB(1, 1));
			}
			
			// Third State
			for (int i = 0; i < 3; i++) {
				MockImage image = getImage(sprite, time++);
				assertEquals(2, image.getImage().getWidth());
				assertEquals(2, image.getImage().getHeight());
				assertEquals("Time <" + Integer.toString(time - 1) +">", WHITE, image.getImage().getRGB(0, 0));
				assertEquals("Time <" + Integer.toString(time - 1) +">", WHITE, image.getImage().getRGB(1, 0));
				assertEquals("Time <" + Integer.toString(time - 1) +">", WHITE, image.getImage().getRGB(0, 1));
				assertEquals("Time <" + Integer.toString(time - 1) +">", BLACK, image.getImage().getRGB(1, 1));
			}
			
			// Fourth Flip
			for (int i = 0; i < 4; i++) {
				MockImage image = getImage(sprite, time++);
				assertEquals(2, image.getImage().getWidth());
				assertEquals(2, image.getImage().getHeight());
				assertEquals("Time <" + Integer.toString(time - 1) +">", WHITE, image.getImage().getRGB(0, 0));
				assertEquals("Time <" + Integer.toString(time - 1) +">", WHITE, image.getImage().getRGB(1, 0));
				assertEquals("Time <" + Integer.toString(time - 1) +">", BLACK, image.getImage().getRGB(0, 1));
				assertEquals("Time <" + Integer.toString(time - 1) +">", WHITE, image.getImage().getRGB(1, 1));
			}
		}
	}
	
	public void test_setSpeed_DoubleSpeed() throws Exception{
		SpriteFactory spriteFactory = getSpriteFactory(createImage(2, 2));
		AnimatedSpriteFactory factory = getSpriteFactory((Sprite) spriteFactory.getSprite().flipX(false).flipY(false), (Sprite) spriteFactory.getSprite().flipX(true).flipY(false), (Sprite) spriteFactory.getSprite().flipX(true).flipY(true), (Sprite) spriteFactory.getSprite().flipX(false).flipY(true));
		AnimatedSprite sprite = factory.getSprite();
		sprite.setSpeed(2.0);
		
		// Start
		int time = 0;
		
		for (int j = 0; j < 2; j++) {
			// First State;
			for (int i = 0; i < 1; i++) {
				MockImage image = getImage(sprite, time++);
				assertEquals(2, image.getImage().getWidth());
				assertEquals(2, image.getImage().getHeight());
				assertEquals("Time <" + Integer.toString(time - 1) +">", BLACK, image.getImage().getRGB(0, 0));
				assertEquals("Time <" + Integer.toString(time - 1) +">", WHITE, image.getImage().getRGB(1, 0));
				assertEquals("Time <" + Integer.toString(time - 1) +">", WHITE, image.getImage().getRGB(0, 1));
				assertEquals("Time <" + Integer.toString(time - 1) +">", WHITE, image.getImage().getRGB(1, 1));
			}
			
			// Second State
			for (int i = 0; i < 1; i++) {
				MockImage image = getImage(sprite, time++);
				assertEquals(2, image.getImage().getWidth());
				assertEquals(2, image.getImage().getHeight());
				assertEquals("Time <" + Integer.toString(time - 1) +">", WHITE, image.getImage().getRGB(0, 0));
				assertEquals("Time <" + Integer.toString(time - 1) +">", BLACK, image.getImage().getRGB(1, 0));
				assertEquals("Time <" + Integer.toString(time - 1) +">", WHITE, image.getImage().getRGB(0, 1));
				assertEquals("Time <" + Integer.toString(time - 1) +">", WHITE, image.getImage().getRGB(1, 1));
			}
			
			// Third State
			for (int i = 0; i < 1; i++) {
				MockImage image = getImage(sprite, time++);
				assertEquals(2, image.getImage().getWidth());
				assertEquals(2, image.getImage().getHeight());
				assertEquals("Time <" + Integer.toString(time - 1) +">", WHITE, image.getImage().getRGB(0, 0));
				assertEquals("Time <" + Integer.toString(time - 1) +">", WHITE, image.getImage().getRGB(1, 0));
				assertEquals("Time <" + Integer.toString(time - 1) +">", WHITE, image.getImage().getRGB(0, 1));
				assertEquals("Time <" + Integer.toString(time - 1) +">", BLACK, image.getImage().getRGB(1, 1));
			}
			
			// Fourth Flip
			for (int i = 0; i < 2; i++) {
				MockImage image = getImage(sprite, time++);
				assertEquals(2, image.getImage().getWidth());
				assertEquals(2, image.getImage().getHeight());
				assertEquals("Time <" + Integer.toString(time - 1) +">", WHITE, image.getImage().getRGB(0, 0));
				assertEquals("Time <" + Integer.toString(time - 1) +">", WHITE, image.getImage().getRGB(1, 0));
				assertEquals("Time <" + Integer.toString(time - 1) +">", BLACK, image.getImage().getRGB(0, 1));
				assertEquals("Time <" + Integer.toString(time - 1) +">", WHITE, image.getImage().getRGB(1, 1));
			}
		}
	}
	
	public void test_setSpeed_HalfSpeed() throws Exception{
		SpriteFactory spriteFactory = getSpriteFactory(createImage(2, 2));
		AnimatedSpriteFactory factory = getSpriteFactory((Sprite) spriteFactory.getSprite().flipX(false).flipY(false), (Sprite) spriteFactory.getSprite().flipX(true).flipY(false), (Sprite) spriteFactory.getSprite().flipX(true).flipY(true), (Sprite) spriteFactory.getSprite().flipX(false).flipY(true));
		AnimatedSprite sprite = factory.getSprite();
		sprite.setSpeed(0.5);
		
		// Start
		int time = 0;
		
		for (int j = 0; j < 2; j++) {
			// First State;
			for (int i = 0; i < 2; i++) {
				MockImage image = getImage(sprite, time++);
				assertEquals(2, image.getImage().getWidth());
				assertEquals(2, image.getImage().getHeight());
				assertEquals("Time <" + Integer.toString(time - 1) +">", BLACK, image.getImage().getRGB(0, 0));
				assertEquals("Time <" + Integer.toString(time - 1) +">", WHITE, image.getImage().getRGB(1, 0));
				assertEquals("Time <" + Integer.toString(time - 1) +">", WHITE, image.getImage().getRGB(0, 1));
				assertEquals("Time <" + Integer.toString(time - 1) +">", WHITE, image.getImage().getRGB(1, 1));
			}
			
			// Second State
			for (int i = 0; i < 4; i++) {
				MockImage image = getImage(sprite, time++);
				assertEquals(2, image.getImage().getWidth());
				assertEquals(2, image.getImage().getHeight());
				assertEquals("Time <" + Integer.toString(time - 1) +">", WHITE, image.getImage().getRGB(0, 0));
				assertEquals("Time <" + Integer.toString(time - 1) +">", BLACK, image.getImage().getRGB(1, 0));
				assertEquals("Time <" + Integer.toString(time - 1) +">", WHITE, image.getImage().getRGB(0, 1));
				assertEquals("Time <" + Integer.toString(time - 1) +">", WHITE, image.getImage().getRGB(1, 1));
			}
			
			// Third State
			for (int i = 0; i < 6; i++) {
				MockImage image = getImage(sprite, time++);
				assertEquals(2, image.getImage().getWidth());
				assertEquals(2, image.getImage().getHeight());
				assertEquals("Time <" + Integer.toString(time - 1) +">", WHITE, image.getImage().getRGB(0, 0));
				assertEquals("Time <" + Integer.toString(time - 1) +">", WHITE, image.getImage().getRGB(1, 0));
				assertEquals("Time <" + Integer.toString(time - 1) +">", WHITE, image.getImage().getRGB(0, 1));
				assertEquals("Time <" + Integer.toString(time - 1) +">", BLACK, image.getImage().getRGB(1, 1));
			}
			
			// Fourth Flip
			for (int i = 0; i < 8; i++) {
				MockImage image = getImage(sprite, time++);
				assertEquals(2, image.getImage().getWidth());
				assertEquals(2, image.getImage().getHeight());
				assertEquals("Time <" + Integer.toString(time - 1) +">", WHITE, image.getImage().getRGB(0, 0));
				assertEquals("Time <" + Integer.toString(time - 1) +">", WHITE, image.getImage().getRGB(1, 0));
				assertEquals("Time <" + Integer.toString(time - 1) +">", BLACK, image.getImage().getRGB(0, 1));
				assertEquals("Time <" + Integer.toString(time - 1) +">", WHITE, image.getImage().getRGB(1, 1));
			}
		}
	}
	
	private BufferedImage createImage(int width, int height) {
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				if (x < (width / 2)) {
					if (y < (height / 2)) {
						image.setRGB(x, y, BLACK);
					} else {
						image.setRGB(x, y, WHITE);
					}
				} else {
					image.setRGB(x, y, WHITE);
				}
			}
		}
		return image;
	}
	
	private SpriteFactory getSpriteFactory(BufferedImage image) {
		return new SpriteFactory(new MockImage(image));
	}
	
	private AnimatedSpriteFactory getSpriteFactory(Sprite... sprites) {
		AnimatedSpriteFactory factory = new AnimatedSpriteFactory();
		for(int i = 0; i < sprites.length; i++) {
			factory.addFrame(sprites[i], i + 1);
		}
		return factory;
	}
	
	private MockImage getImage(AnimatedSprite sprite, int time) {
		BufferedImage image = new BufferedImage((int)sprite.getDimension().getWidth(), (int)sprite.getDimension().getHeight(), BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = image.createGraphics();
		sprite.draw(g, LayoutCalculator.createRectangle(0, 0, sprite.getDimension().getWidth(), sprite.getDimension().getHeight()), (long)time);
		g.dispose();
		return new MockImage(image);
	}
	
	private class MockImage extends ImageDrawer {
		public MockImage(BufferedImage image) {
			super(image);
		}
		
		protected MockImage createImage(BufferedImage image) {
			return new MockImage(image);
		}
		
		public BufferedImage getImage() {
			return fImage;
		}
	}
}
