package test.joe.game.layout.image.sprite;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import joe.game.layout.implementation.LayoutCalculator;
import joe.game.layout.implementation.image.ImageDrawer;
import joe.game.layout.implementation.image.sprite.Sprite;
import joe.game.layout.implementation.image.sprite.SpriteFactory;
import junit.framework.TestCase;

public class SpriteTest extends TestCase {
	private static final int BLACK = 0xFF000000;
	private static final int WHITE = 0xFFFFFFFF;
	private static final int EMPTY = 0x00000000;

	
	public void test_flipX_Even() {
		SpriteFactory spriteFactory = getSpriteFactory(createImage(2, 4));
		Sprite sprite = spriteFactory.getSprite();
		
		sprite.flipX();
		
		MockImage image = getImage(sprite);
		assertEquals(2, image.getImage().getWidth());
		assertEquals(4, image.getImage().getHeight());
		assertEquals(WHITE, image.getImage().getRGB(0, 0));
		assertEquals(BLACK, image.getImage().getRGB(1, 0));
		assertEquals(WHITE, image.getImage().getRGB(0, 1));
		assertEquals(BLACK, image.getImage().getRGB(1, 1));
		assertEquals(WHITE, image.getImage().getRGB(0, 2));
		assertEquals(WHITE, image.getImage().getRGB(1, 2));
		assertEquals(WHITE, image.getImage().getRGB(0, 3));
		assertEquals(WHITE, image.getImage().getRGB(1, 3));
	}
	
	public void test_flipX_Odd() {
		SpriteFactory spriteFactory = getSpriteFactory(createImage(3, 4));
		Sprite sprite = spriteFactory.getSprite();
		
		sprite.flipX();
		
		MockImage image = getImage(sprite);
		assertEquals(3, image.getImage().getWidth());
		assertEquals(4, image.getImage().getHeight());
		assertEquals(WHITE, image.getImage().getRGB(0, 0));
		assertEquals(WHITE, image.getImage().getRGB(1, 0));
		assertEquals(BLACK, image.getImage().getRGB(2, 0));
		assertEquals(WHITE, image.getImage().getRGB(0, 1));
		assertEquals(WHITE, image.getImage().getRGB(1, 1));
		assertEquals(BLACK, image.getImage().getRGB(2, 1));
		assertEquals(WHITE, image.getImage().getRGB(0, 2));
		assertEquals(WHITE, image.getImage().getRGB(1, 2));
		assertEquals(WHITE, image.getImage().getRGB(2, 2));
		assertEquals(WHITE, image.getImage().getRGB(0, 3));
		assertEquals(WHITE, image.getImage().getRGB(1, 3));
		assertEquals(WHITE, image.getImage().getRGB(2, 3));
	}
	
	public void test_flipX_DoesNotModifyImage() {
		MockImage image = new MockImage(createImage(2, 4));
		Sprite sprite = getSpriteFactory(image).getSprite();
		
		sprite.flipX();
		
		assertEquals(2, image.getImage().getWidth());
		assertEquals(4, image.getImage().getHeight());
		assertEquals(BLACK, image.getImage().getRGB(0, 0));
		assertEquals(WHITE, image.getImage().getRGB(1, 0));
		assertEquals(BLACK, image.getImage().getRGB(0, 1));
		assertEquals(WHITE, image.getImage().getRGB(1, 1));
		assertEquals(WHITE, image.getImage().getRGB(0, 2));
		assertEquals(WHITE, image.getImage().getRGB(1, 2));
		assertEquals(WHITE, image.getImage().getRGB(0, 3));
		assertEquals(WHITE, image.getImage().getRGB(1, 3));
	}
	
	public void test_flipX_DoesNotModifyOtherSprite() {
		SpriteFactory spriteFactory = getSpriteFactory(createImage(2, 4));
		Sprite sprite1 = spriteFactory.getSprite();
		Sprite sprite2 = spriteFactory.getSprite();
		
		sprite1.flipX();
		
		MockImage image = getImage(sprite2);
		assertEquals(2, image.getImage().getWidth());
		assertEquals(4, image.getImage().getHeight());
		assertEquals(BLACK, image.getImage().getRGB(0, 0));
		assertEquals(WHITE, image.getImage().getRGB(1, 0));
		assertEquals(BLACK, image.getImage().getRGB(0, 1));
		assertEquals(WHITE, image.getImage().getRGB(1, 1));
		assertEquals(WHITE, image.getImage().getRGB(0, 2));
		assertEquals(WHITE, image.getImage().getRGB(1, 2));
		assertEquals(WHITE, image.getImage().getRGB(0, 3));
		assertEquals(WHITE, image.getImage().getRGB(1, 3));
	}
	
	public void test_flipY_Even() {
		SpriteFactory spriteFactory = getSpriteFactory(createImage(2, 4));
		Sprite sprite = spriteFactory.getSprite();
		
		sprite.flipY();
		
		MockImage image = getImage(sprite);
		assertEquals(2, image.getImage().getWidth());
		assertEquals(4, image.getImage().getHeight());
		assertEquals(WHITE, image.getImage().getRGB(0, 0));
		assertEquals(WHITE, image.getImage().getRGB(1, 0));
		assertEquals(WHITE, image.getImage().getRGB(0, 1));
		assertEquals(WHITE, image.getImage().getRGB(1, 1));
		assertEquals(BLACK, image.getImage().getRGB(0, 2));
		assertEquals(WHITE, image.getImage().getRGB(1, 2));
		assertEquals(BLACK, image.getImage().getRGB(0, 3));
		assertEquals(WHITE, image.getImage().getRGB(1, 3));
	}
	
	public void test_flipY_Odd() {
		SpriteFactory spriteFactory = getSpriteFactory(createImage(2, 3));
		Sprite sprite = spriteFactory.getSprite();
		
		sprite.flipY();
		
		MockImage image = getImage(sprite);
		assertEquals(2, image.getImage().getWidth());
		assertEquals(3, image.getImage().getHeight());
		assertEquals(WHITE, image.getImage().getRGB(0, 0));
		assertEquals(WHITE, image.getImage().getRGB(1, 0));
		assertEquals(WHITE, image.getImage().getRGB(0, 1));
		assertEquals(WHITE, image.getImage().getRGB(1, 1));
		assertEquals(BLACK, image.getImage().getRGB(0, 2));
		assertEquals(WHITE, image.getImage().getRGB(1, 2));
	}
	
	public void test_flipY_DoesNotModifyImage() {
		MockImage image = new MockImage(createImage(2, 4));
		Sprite sprite = getSpriteFactory(image).getSprite();
		sprite.flipY();
		assertEquals(2, image.getImage().getWidth());
		assertEquals(4, image.getImage().getHeight());
		assertEquals(BLACK, image.getImage().getRGB(0, 0));
		assertEquals(WHITE, image.getImage().getRGB(1, 0));
		assertEquals(BLACK, image.getImage().getRGB(0, 1));
		assertEquals(WHITE, image.getImage().getRGB(1, 1));
		assertEquals(WHITE, image.getImage().getRGB(0, 2));
		assertEquals(WHITE, image.getImage().getRGB(1, 2));
		assertEquals(WHITE, image.getImage().getRGB(0, 3));
		assertEquals(WHITE, image.getImage().getRGB(1, 3));
	}
	
	public void test_flipY_DoesNotModifyOtherSprite() {
		SpriteFactory spriteFactory = getSpriteFactory(createImage(2, 4));
		Sprite sprite1 = spriteFactory.getSprite();
		Sprite sprite2 = spriteFactory.getSprite();
		
		sprite1.flipY();
		
		MockImage image = getImage(sprite2);
		assertEquals(2, image.getImage().getWidth());
		assertEquals(4, image.getImage().getHeight());
		assertEquals(BLACK, image.getImage().getRGB(0, 0));
		assertEquals(WHITE, image.getImage().getRGB(1, 0));
		assertEquals(BLACK, image.getImage().getRGB(0, 1));
		assertEquals(WHITE, image.getImage().getRGB(1, 1));
		assertEquals(WHITE, image.getImage().getRGB(0, 2));
		assertEquals(WHITE, image.getImage().getRGB(1, 2));
		assertEquals(WHITE, image.getImage().getRGB(0, 3));
		assertEquals(WHITE, image.getImage().getRGB(1, 3));
	}
	
	public void test_isAllTransparent_IsEmpty_0x00000000() {
		assertEquals(true, getSpriteFactory(createImage(2, 4, 0x00000000)).getSprite().isEmpty());
	}
	
	public void test_isAllTransparent_IsEmpty_0x00FFFFFF() {
		assertEquals(true, getSpriteFactory(createImage(2, 4, 0x00FFFFFF)).getSprite().isEmpty());
	}
	
	public void test_isAllTransparent_IsEmpty_TopLeft() {
		MockImage image = new MockImage(createImage(2, 4, EMPTY));
		image.getImage().setRGB(0, 0, BLACK);
		assertEquals(false, getSpriteFactory(image).getSprite().isEmpty());
	}
	
	public void test_isAllTransparent_IsEmpty_BottomRight() {
		MockImage image = new MockImage(createImage(2, 4, EMPTY));
		image.getImage().setRGB(1, 3, BLACK);
		assertEquals(false, getSpriteFactory(image).getSprite().isEmpty());
	}
	
	public void test_isAllTransparent_IsEmpty_0x01000000() {
		assertEquals(false, getSpriteFactory(createImage(2, 4, 0x01000000)).getSprite().isEmpty());
	}
	
	private BufferedImage createImage(int width, int height, int fill) {
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				image.setRGB(x, y, fill);
			}
		}
		return image;
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
	
	private SpriteFactory getSpriteFactory(ImageDrawer image) {
		return new SpriteFactory(image);
	}
	
	private MockImage getImage(Sprite sprite) {
		BufferedImage image = new BufferedImage((int)sprite.getDimension().getWidth(), (int)sprite.getDimension().getHeight(), BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = image.createGraphics();
		sprite.draw(g, LayoutCalculator.createRectangle(0, 0, sprite.getDimension().getWidth(), sprite.getDimension().getHeight()));
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
