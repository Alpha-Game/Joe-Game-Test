package test.joe.game.layout.image;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import joe.game.layout.implementation.LayoutCalculator;
import joe.game.layout.implementation.image.ImageDrawer;
import junit.framework.TestCase;

public class ImageDrawerTest extends TestCase {
	private static final int EMPTY = 0x00000000;
	private static final int FULL_ALPHA = 0xFF000000;
	
	private static final int BLACK_BASE = 0x00000000;
	private static final int WHITE_BASE = 0x00FFFFFF;
	private static final int GRAY_1_BASE = 0x007F7F7F;
	private static final int GRAY_2_BASE = 0x00808080;
	
	private static final int RED_BASE = 0x00FF0000;
	private static final int GREEN_BASE = 0x0000FF00;
	private static final int BLUE_BASE = 0x000000FF;
	
	private static final int BLACK = BLACK_BASE | FULL_ALPHA;
	private static final int WHITE = WHITE_BASE | FULL_ALPHA;
	private static final int GRAY = GRAY_1_BASE | FULL_ALPHA;
	
	private static final int RED = RED_BASE | FULL_ALPHA;
	private static final int GREEN = GREEN_BASE | FULL_ALPHA;
	private static final int BLUE = BLUE_BASE | FULL_ALPHA;
	
	private static final int LIGHT_RED = (RED_BASE | GRAY_2_BASE) | FULL_ALPHA;
	private static final int LIGHT_GREEN = (GREEN_BASE | GRAY_2_BASE) | FULL_ALPHA;
	private static final int LIGHT_BLUE = (BLUE_BASE | GRAY_2_BASE) | FULL_ALPHA;
	
	private static final int DARK_RED = (RED_BASE & GRAY_1_BASE) | FULL_ALPHA;	
	private static final int DARK_GREEN = (GREEN_BASE & GRAY_1_BASE) | FULL_ALPHA;
	private static final int DARK_BLUE = (BLUE_BASE & GRAY_1_BASE) | FULL_ALPHA;
	
	private static final int YELLOW = (RED_BASE | GREEN_BASE) | FULL_ALPHA;
	private static final int PURPLE = (RED_BASE | BLUE_BASE) | FULL_ALPHA;
	private static final int TEAL = (GREEN_BASE | BLUE_BASE) | FULL_ALPHA;
	
	
	public void test_getDimension() {
		MockImage image = new MockImage(createImage(2, 3));
		assertEquals(2.0, image.getDimension().getWidth());
		assertEquals(3.0, image.getDimension().getHeight());
	}
	
	public void test_draw_CorrectSize() {
		BufferedImage root = createImage(2, 2, EMPTY);
		Graphics2D g = root.createGraphics();
		MockImage image = new MockImage(createImage(2, 2));
		image.draw(g, 0, 0, 2, 2);
		assertColor(BLACK, root.getRGB(0, 0));
		assertColor(WHITE, root.getRGB(1, 0));
		assertColor(WHITE, root.getRGB(0, 1));
		assertColor(WHITE, root.getRGB(1, 1));
	}
	
	public void test_draw_CorrectSize_Rectangle() {
		BufferedImage root = createImage(2, 2, EMPTY);
		Graphics2D g = root.createGraphics();
		MockImage image = new MockImage(createImage(2, 2));
		image.draw(g, LayoutCalculator.createRectangle(0, 0, 2, 2));
		assertColor(BLACK, root.getRGB(0, 0));
		assertColor(WHITE, root.getRGB(1, 0));
		assertColor(WHITE, root.getRGB(0, 1));
		assertColor(WHITE, root.getRGB(1, 1));
	}
	
	public void test_draw_PositiveX() {
		BufferedImage root = createImage(2, 2, EMPTY);
		Graphics2D g = root.createGraphics();
		MockImage image = new MockImage(createImage(2, 2));
		image.draw(g, 1, 0, 2, 2);
		assertEquals(EMPTY, root.getRGB(0, 0));
		assertColor(BLACK, root.getRGB(1, 0));
		assertEquals(EMPTY, root.getRGB(0, 1));
		assertColor(WHITE, root.getRGB(1, 1));
	}
	
	public void test_draw_PositiveX_Rectangle() {
		BufferedImage root = createImage(2, 2, EMPTY);
		Graphics2D g = root.createGraphics();
		MockImage image = new MockImage(createImage(2, 2));
		image.draw(g, LayoutCalculator.createRectangle(1, 0, 2, 2));
		assertEquals(EMPTY, root.getRGB(0, 0));
		assertColor(BLACK, root.getRGB(1, 0));
		assertEquals(EMPTY, root.getRGB(0, 1));
		assertColor(WHITE, root.getRGB(1, 1));
	}
	
	public void test_draw_NegativeX() {
		BufferedImage root = createImage(2, 2, EMPTY);
		Graphics2D g = root.createGraphics();
		MockImage image = new MockImage(createImage(2, 2));
		image.draw(g, -1, 0, 2, 2);
		assertColor(WHITE, root.getRGB(0, 0));
		assertEquals(EMPTY, root.getRGB(1, 0));
		assertColor(WHITE, root.getRGB(0, 1));
		assertEquals(EMPTY, root.getRGB(1, 1));
	}
	
	public void test_draw_NegativeX_Rectangle() {
		BufferedImage root = createImage(2, 2, EMPTY);
		Graphics2D g = root.createGraphics();
		MockImage image = new MockImage(createImage(2, 2));
		image.draw(g, LayoutCalculator.createRectangle(-1, 0, 2, 2));
		assertColor(WHITE, root.getRGB(0, 0));
		assertEquals(EMPTY, root.getRGB(1, 0));
		assertColor(WHITE, root.getRGB(0, 1));
		assertEquals(EMPTY, root.getRGB(1, 1));
	}
	
	public void test_draw_PositiveY() {
		BufferedImage root = createImage(2, 2, EMPTY);
		Graphics2D g = root.createGraphics();
		MockImage image = new MockImage(createImage(2, 2));
		image.draw(g, 0, 1, 2, 2);
		assertEquals(EMPTY, root.getRGB(0, 0));
		assertEquals(EMPTY, root.getRGB(1, 0));
		assertColor(BLACK, root.getRGB(0, 1));
		assertColor(WHITE, root.getRGB(1, 1));
	}
	
	public void test_draw_PositiveY_Rectangle() {
		BufferedImage root = createImage(2, 2, EMPTY);
		Graphics2D g = root.createGraphics();
		MockImage image = new MockImage(createImage(2, 2));
		image.draw(g, LayoutCalculator.createRectangle(0, 1, 2, 2));
		assertEquals(EMPTY, root.getRGB(0, 0));
		assertEquals(EMPTY, root.getRGB(1, 0));
		assertColor(BLACK, root.getRGB(0, 1));
		assertColor(WHITE, root.getRGB(1, 1));
	}
	
	public void test_draw_NegativeY() {
		BufferedImage root = createImage(2, 2, EMPTY);
		Graphics2D g = root.createGraphics();
		MockImage image = new MockImage(createImage(2, 2));
		image.draw(g, 0, -1, 2, 2);
		assertColor(WHITE, root.getRGB(0, 0));
		assertColor(WHITE, root.getRGB(1, 0));
		assertEquals(EMPTY, root.getRGB(0, 1));
		assertEquals(EMPTY, root.getRGB(1, 1));
	}
	
	public void test_draw_NegativeY_Rectangle() {
		BufferedImage root = createImage(2, 2, EMPTY);
		Graphics2D g = root.createGraphics();
		MockImage image = new MockImage(createImage(2, 2));
		image.draw(g, LayoutCalculator.createRectangle(0, -1, 2, 2));
		assertColor(WHITE, root.getRGB(0, 0));
		assertColor(WHITE, root.getRGB(1, 0));
		assertEquals(EMPTY, root.getRGB(0, 1));
		assertEquals(EMPTY, root.getRGB(1, 1));
	}
	
	public void test_draw_HalfWidth() {
		BufferedImage root = createImage(4, 4, EMPTY);
		Graphics2D g = root.createGraphics();
		MockImage image = new MockImage(createImage(4, 4));
		image.draw(g, 0, 0, 2, 4);
		assertColor(BLACK, root.getRGB(0, 0));
		assertColor(WHITE, root.getRGB(1, 0));
		assertEquals(EMPTY, root.getRGB(2, 0));
		assertEquals(EMPTY, root.getRGB(3, 0));
		assertColor(BLACK, root.getRGB(0, 1));
		assertColor(WHITE, root.getRGB(1, 1));
		assertEquals(EMPTY, root.getRGB(2, 1));
		assertEquals(EMPTY, root.getRGB(3, 1));
		assertColor(WHITE, root.getRGB(0, 2));
		assertColor(WHITE, root.getRGB(1, 2));
		assertEquals(EMPTY, root.getRGB(2, 2));
		assertEquals(EMPTY, root.getRGB(3, 2));
		assertColor(WHITE, root.getRGB(0, 3));
		assertColor(WHITE, root.getRGB(1, 3));
		assertEquals(EMPTY, root.getRGB(2, 3));
		assertEquals(EMPTY, root.getRGB(3, 3));
	}
	
	public void test_draw_HalfWidth_Rectangle() {
		BufferedImage root = createImage(4, 4, EMPTY);
		Graphics2D g = root.createGraphics();
		MockImage image = new MockImage(createImage(4, 4));
		image.draw(g, LayoutCalculator.createRectangle(0, 0, 2, 4));
		assertColor(BLACK, root.getRGB(0, 0));
		assertColor(WHITE, root.getRGB(1, 0));
		assertEquals(EMPTY, root.getRGB(2, 0));
		assertEquals(EMPTY, root.getRGB(3, 0));
		assertColor(BLACK, root.getRGB(0, 1));
		assertColor(WHITE, root.getRGB(1, 1));
		assertEquals(EMPTY, root.getRGB(2, 1));
		assertEquals(EMPTY, root.getRGB(3, 1));
		assertColor(WHITE, root.getRGB(0, 2));
		assertColor(WHITE, root.getRGB(1, 2));
		assertEquals(EMPTY, root.getRGB(2, 2));
		assertEquals(EMPTY, root.getRGB(3, 2));
		assertColor(WHITE, root.getRGB(0, 3));
		assertColor(WHITE, root.getRGB(1, 3));
		assertEquals(EMPTY, root.getRGB(2, 3));
		assertEquals(EMPTY, root.getRGB(3, 3));
	}
	
	public void test_draw_HalfHeight() {
		BufferedImage root = createImage(4, 4, EMPTY);
		Graphics2D g = root.createGraphics();
		MockImage image = new MockImage(createImage(4, 4));
		image.draw(g, 0, 0, 4, 2);
		assertColor(BLACK, root.getRGB(0, 0));
		assertColor(BLACK, root.getRGB(1, 0));
		assertColor(WHITE, root.getRGB(2, 0));
		assertColor(WHITE, root.getRGB(3, 0));
		assertColor(WHITE, root.getRGB(0, 1));
		assertColor(WHITE, root.getRGB(1, 1));
		assertColor(WHITE, root.getRGB(2, 1));
		assertColor(WHITE, root.getRGB(3, 1));
		assertEquals(EMPTY, root.getRGB(0, 2));
		assertEquals(EMPTY, root.getRGB(1, 2));
		assertEquals(EMPTY, root.getRGB(2, 2));
		assertEquals(EMPTY, root.getRGB(3, 2));
		assertEquals(EMPTY, root.getRGB(0, 3));
		assertEquals(EMPTY, root.getRGB(1, 3));
		assertEquals(EMPTY, root.getRGB(2, 3));
		assertEquals(EMPTY, root.getRGB(3, 3));
	}
	
	public void test_draw_HalfHeight_Rectangle() {
		BufferedImage root = createImage(4, 4, EMPTY);
		Graphics2D g = root.createGraphics();
		MockImage image = new MockImage(createImage(4, 4));
		image.draw(g, LayoutCalculator.createRectangle(0, 0, 4, 2));
		assertColor(BLACK, root.getRGB(0, 0));
		assertColor(BLACK, root.getRGB(1, 0));
		assertColor(WHITE, root.getRGB(2, 0));
		assertColor(WHITE, root.getRGB(3, 0));
		assertColor(WHITE, root.getRGB(0, 1));
		assertColor(WHITE, root.getRGB(1, 1));
		assertColor(WHITE, root.getRGB(2, 1));
		assertColor(WHITE, root.getRGB(3, 1));
		assertEquals(EMPTY, root.getRGB(0, 2));
		assertEquals(EMPTY, root.getRGB(1, 2));
		assertEquals(EMPTY, root.getRGB(2, 2));
		assertEquals(EMPTY, root.getRGB(3, 2));
		assertEquals(EMPTY, root.getRGB(0, 3));
		assertEquals(EMPTY, root.getRGB(1, 3));
		assertEquals(EMPTY, root.getRGB(2, 3));
		assertEquals(EMPTY, root.getRGB(3, 3));
	}
	
	public void test_draw_DoubleWidth() {
		BufferedImage root = createImage(4, 4, EMPTY);
		Graphics2D g = root.createGraphics();
		MockImage image = new MockImage(createImage(2, 2));
		image.draw(g, 0, 0, 4, 2);
		assertColor(BLACK, root.getRGB(0, 0));
		assertColor(BLACK, root.getRGB(1, 0));
		assertColor(WHITE, root.getRGB(2, 0));
		assertColor(WHITE, root.getRGB(3, 0));
		assertColor(WHITE, root.getRGB(0, 1));
		assertColor(WHITE, root.getRGB(1, 1));
		assertColor(WHITE, root.getRGB(2, 1));
		assertColor(WHITE, root.getRGB(3, 1));
		assertEquals(EMPTY, root.getRGB(0, 2));
		assertEquals(EMPTY, root.getRGB(1, 2));
		assertEquals(EMPTY, root.getRGB(2, 2));
		assertEquals(EMPTY, root.getRGB(3, 2));
		assertEquals(EMPTY, root.getRGB(0, 3));
		assertEquals(EMPTY, root.getRGB(1, 3));
		assertEquals(EMPTY, root.getRGB(2, 3));
		assertEquals(EMPTY, root.getRGB(3, 3));
	}
	
	public void test_draw_DoubleWidth_Rectangle() {
		BufferedImage root = createImage(4, 4, EMPTY);
		Graphics2D g = root.createGraphics();
		MockImage image = new MockImage(createImage(2, 2));
		image.draw(g, LayoutCalculator.createRectangle(0, 0, 4, 2));
		assertColor(BLACK, root.getRGB(0, 0));
		assertColor(BLACK, root.getRGB(1, 0));
		assertColor(WHITE, root.getRGB(2, 0));
		assertColor(WHITE, root.getRGB(3, 0));
		assertColor(WHITE, root.getRGB(0, 1));
		assertColor(WHITE, root.getRGB(1, 1));
		assertColor(WHITE, root.getRGB(2, 1));
		assertColor(WHITE, root.getRGB(3, 1));
		assertEquals(EMPTY, root.getRGB(0, 2));
		assertEquals(EMPTY, root.getRGB(1, 2));
		assertEquals(EMPTY, root.getRGB(2, 2));
		assertEquals(EMPTY, root.getRGB(3, 2));
		assertEquals(EMPTY, root.getRGB(0, 3));
		assertEquals(EMPTY, root.getRGB(1, 3));
		assertEquals(EMPTY, root.getRGB(2, 3));
		assertEquals(EMPTY, root.getRGB(3, 3));
	}
	
	public void test_draw_DoubleHeight() {
		BufferedImage root = createImage(4, 4, EMPTY);
		Graphics2D g = root.createGraphics();
		MockImage image = new MockImage(createImage(2, 2));
		image.draw(g, 0, 0, 2, 4);
		assertColor(BLACK, root.getRGB(0, 0));
		assertColor(WHITE, root.getRGB(1, 0));
		assertEquals(EMPTY, root.getRGB(2, 0));
		assertEquals(EMPTY, root.getRGB(3, 0));
		assertColor(BLACK, root.getRGB(0, 1));
		assertColor(WHITE, root.getRGB(1, 1));
		assertEquals(EMPTY, root.getRGB(2, 1));
		assertEquals(EMPTY, root.getRGB(3, 1));
		assertColor(WHITE, root.getRGB(0, 2));
		assertColor(WHITE, root.getRGB(1, 2));
		assertEquals(EMPTY, root.getRGB(2, 2));
		assertEquals(EMPTY, root.getRGB(3, 2));
		assertColor(WHITE, root.getRGB(0, 3));
		assertColor(WHITE, root.getRGB(1, 3));
		assertEquals(EMPTY, root.getRGB(2, 3));
		assertEquals(EMPTY, root.getRGB(3, 3));
	}
	
	public void test_draw_DoubleHeight_Rectangle() {
		BufferedImage root = createImage(4, 4, EMPTY);
		Graphics2D g = root.createGraphics();
		MockImage image = new MockImage(createImage(2, 2));
		image.draw(g, LayoutCalculator.createRectangle(0, 0, 2, 4));
		assertColor(BLACK, root.getRGB(0, 0));
		assertColor(WHITE, root.getRGB(1, 0));
		assertEquals(EMPTY, root.getRGB(2, 0));
		assertEquals(EMPTY, root.getRGB(3, 0));
		assertColor(BLACK, root.getRGB(0, 1));
		assertColor(WHITE, root.getRGB(1, 1));
		assertEquals(EMPTY, root.getRGB(2, 1));
		assertEquals(EMPTY, root.getRGB(3, 1));
		assertColor(WHITE, root.getRGB(0, 2));
		assertColor(WHITE, root.getRGB(1, 2));
		assertEquals(EMPTY, root.getRGB(2, 2));
		assertEquals(EMPTY, root.getRGB(3, 2));
		assertColor(WHITE, root.getRGB(0, 3));
		assertColor(WHITE, root.getRGB(1, 3));
		assertEquals(EMPTY, root.getRGB(2, 3));
		assertEquals(EMPTY, root.getRGB(3, 3));
	}
	
	public void test_draw_NegativeWidth() {
		BufferedImage root = createImage(2, 2, EMPTY);
		Graphics2D g = root.createGraphics();
		MockImage image = new MockImage(createImage(2, 2));
		image.draw(g, 1, 0, -2, 2);
		assertColor(WHITE, root.getRGB(0, 0));
		assertColor(BLACK, root.getRGB(1, 0));
		assertColor(WHITE, root.getRGB(0, 1));
		assertColor(WHITE, root.getRGB(1, 1));
	}
	
	public void test_draw_NegativeWidth_Rectangle() {
		BufferedImage root = createImage(2, 2, EMPTY);
		Graphics2D g = root.createGraphics();
		MockImage image = new MockImage(createImage(2, 2));
		image.draw(g, LayoutCalculator.createRectangle(1, 0, -2, 2));
		assertColor(WHITE, root.getRGB(0, 0));
		assertColor(BLACK, root.getRGB(1, 0));
		assertColor(WHITE, root.getRGB(0, 1));
		assertColor(WHITE, root.getRGB(1, 1));
	}
	
	public void test_draw_NegativeHeight() {
		BufferedImage root = createImage(2, 2, EMPTY);
		Graphics2D g = root.createGraphics();
		MockImage image = new MockImage(createImage(2, 2));
		image.draw(g, 0, 1, 2, -2);
		assertColor(WHITE, root.getRGB(0, 0));
		assertColor(WHITE, root.getRGB(1, 0));
		assertColor(BLACK, root.getRGB(0, 1));
		assertColor(WHITE, root.getRGB(1, 1));
	}
	
	public void test_draw_NegativeHeight_Rectangle() {
		BufferedImage root = createImage(2, 2, EMPTY);
		Graphics2D g = root.createGraphics();
		MockImage image = new MockImage(createImage(2, 2));
		image.draw(g, LayoutCalculator.createRectangle(0, 1, 2, -2));
		assertColor(WHITE, root.getRGB(0, 0));
		assertColor(WHITE, root.getRGB(1, 0));
		assertColor(BLACK, root.getRGB(0, 1));
		assertColor(WHITE, root.getRGB(1, 1));
	}
	
	public void test_draw_NegativeWidthAndHeight() {
		BufferedImage root = createImage(2, 2, EMPTY);
		Graphics2D g = root.createGraphics();
		MockImage image = new MockImage(createImage(2, 2));
		image.draw(g, 1, 1, -2, -2);
		assertColor(WHITE, root.getRGB(0, 0));
		assertColor(WHITE, root.getRGB(1, 0));
		assertColor(WHITE, root.getRGB(0, 1));
		assertColor(BLACK, root.getRGB(1, 1));
	}
	
	public void test_draw_NegativeWidthAndHeight_Rectangle() {
		BufferedImage root = createImage(2, 2, EMPTY);
		Graphics2D g = root.createGraphics();
		MockImage image = new MockImage(createImage(2, 2));
		image.draw(g, LayoutCalculator.createRectangle(1, 1, -2, -2));
		assertColor(WHITE, root.getRGB(0, 0));
		assertColor(WHITE, root.getRGB(1, 0));
		assertColor(WHITE, root.getRGB(0, 1));
		assertColor(BLACK, root.getRGB(1, 1));
	}
	
	public void test_crop_AllZeroValues() {
		MockImage image = new MockImage(createImage(2, 2));
		image = (MockImage) image.crop(0, 0, 0, 0);
		assertEquals(2, image.getImage().getWidth());
		assertEquals(2, image.getImage().getHeight());
		assertColor(BLACK, image.getImage().getRGB(0, 0));
		assertColor(WHITE, image.getImage().getRGB(1, 0));
		assertColor(WHITE, image.getImage().getRGB(0, 1));
		assertColor(WHITE, image.getImage().getRGB(1, 1));
	}
	
	public void test_crop_Left() {
		MockImage image = new MockImage(createImage(2, 2));
		image = (MockImage) image.crop(1, 0, 0, 0);
		assertEquals(1, image.getImage().getWidth());
		assertEquals(2, image.getImage().getHeight());
		assertColor(WHITE, image.getImage().getRGB(0, 0));
		assertColor(WHITE, image.getImage().getRGB(0, 1));
	}
	
	public void test_crop_LeftNegative() {
		MockImage image = new MockImage(createImage(2, 2));
		image = (MockImage) image.crop(-1, 0, 0, 0);
		assertEquals(3, image.getImage().getWidth());
		assertEquals(2, image.getImage().getHeight());
		assertEquals(EMPTY, image.getImage().getRGB(0, 0));
		assertColor(BLACK, image.getImage().getRGB(1, 0));
		assertColor(WHITE, image.getImage().getRGB(2, 0));
		assertEquals(EMPTY, image.getImage().getRGB(0, 1));
		assertColor(WHITE, image.getImage().getRGB(1, 1));
		assertColor(WHITE, image.getImage().getRGB(2, 1));
	}
	
	public void test_crop_Right() {
		MockImage image = new MockImage(createImage(2, 2));
		image = (MockImage) image.crop(0, 1, 0, 0);
		assertEquals(1, image.getImage().getWidth());
		assertEquals(2, image.getImage().getHeight());
		assertColor(BLACK, image.getImage().getRGB(0, 0));
		assertColor(WHITE, image.getImage().getRGB(0, 1));
	}
	
	public void test_crop_RightNegative() {
		MockImage image = new MockImage(createImage(2, 2));
		image = (MockImage) image.crop(0, -1, 0, 0);
		assertEquals(3, image.getImage().getWidth());
		assertEquals(2, image.getImage().getHeight());
		assertColor(BLACK, image.getImage().getRGB(0, 0));
		assertColor(WHITE, image.getImage().getRGB(1, 0));
		assertEquals(EMPTY, image.getImage().getRGB(2, 0));
		assertColor(WHITE, image.getImage().getRGB(0, 1));
		assertColor(WHITE, image.getImage().getRGB(1, 1));
		assertEquals(EMPTY, image.getImage().getRGB(2, 1));
	}
	
	public void test_crop_Top() {
		MockImage image = new MockImage(createImage(2, 2));
		image = (MockImage) image.crop(0, 0, 1, 0);
		assertEquals(2, image.getImage().getWidth());
		assertEquals(1, image.getImage().getHeight());
		assertColor(WHITE, image.getImage().getRGB(0, 0));
		assertColor(WHITE, image.getImage().getRGB(1, 0));
	}
	
	public void test_crop_TopNegative() {
		MockImage image = new MockImage(createImage(2, 2));
		image = (MockImage) image.crop(0, 0, -1, 0);
		assertEquals(2, image.getImage().getWidth());
		assertEquals(3, image.getImage().getHeight());
		assertEquals(EMPTY, image.getImage().getRGB(0, 0));
		assertEquals(EMPTY, image.getImage().getRGB(1, 0));
		assertColor(BLACK, image.getImage().getRGB(0, 1));
		assertColor(WHITE, image.getImage().getRGB(1, 1));
		assertColor(WHITE, image.getImage().getRGB(0, 2));
		assertColor(WHITE, image.getImage().getRGB(1, 2));
	}
	
	public void test_crop_Bottom() {
		MockImage image = new MockImage(createImage(2, 2));
		image = (MockImage) image.crop(0, 0, 0, 1);
		assertEquals(2, image.getImage().getWidth());
		assertEquals(1, image.getImage().getHeight());
		assertColor(BLACK, image.getImage().getRGB(0, 0));
		assertColor(WHITE, image.getImage().getRGB(1, 0));
	}
	
	public void test_crop_BottomNegative() {
		MockImage image = new MockImage(createImage(2, 2));
		image = (MockImage) image.crop(0, 0, 0, -1);
		assertEquals(2, image.getImage().getWidth());
		assertEquals(3, image.getImage().getHeight());
		assertColor(BLACK, image.getImage().getRGB(0, 0));
		assertColor(WHITE, image.getImage().getRGB(1, 0));
		assertColor(WHITE, image.getImage().getRGB(0, 1));
		assertColor(WHITE, image.getImage().getRGB(1, 1));
		assertEquals(EMPTY, image.getImage().getRGB(0, 2));
		assertEquals(EMPTY, image.getImage().getRGB(1, 2));
	}
	
	public void test_crop_DoesNotModifyOldImage() {
		MockImage image = new MockImage(createImage(2, 2));
		image.crop(1, 0, 0, 0);
		assertEquals(2, image.getImage().getWidth());
		assertEquals(2, image.getImage().getHeight());
		assertColor(BLACK, image.getImage().getRGB(0, 0));
		assertColor(WHITE, image.getImage().getRGB(1, 0));
		assertColor(WHITE, image.getImage().getRGB(0, 1));
		assertColor(WHITE, image.getImage().getRGB(1, 1));
	}
	
	public void test_resize_NoChange() {
		MockImage image = new MockImage(createImage(4, 4));
		image = (MockImage) image.resize(4, 4);
		assertEquals(4, image.getImage().getWidth());
		assertEquals(4, image.getImage().getHeight());
		assertColor(BLACK, image.getImage().getRGB(0, 0));
		assertColor(BLACK, image.getImage().getRGB(1, 0));
		assertColor(WHITE, image.getImage().getRGB(2, 0));
		assertColor(WHITE, image.getImage().getRGB(3, 0));
		assertColor(BLACK, image.getImage().getRGB(0, 1));
		assertColor(BLACK, image.getImage().getRGB(1, 1));
		assertColor(WHITE, image.getImage().getRGB(2, 1));
		assertColor(WHITE, image.getImage().getRGB(3, 1));
		assertColor(WHITE, image.getImage().getRGB(0, 2));
		assertColor(WHITE, image.getImage().getRGB(1, 2));
		assertColor(WHITE, image.getImage().getRGB(2, 2));
		assertColor(WHITE, image.getImage().getRGB(3, 2));
		assertColor(WHITE, image.getImage().getRGB(0, 3));
		assertColor(WHITE, image.getImage().getRGB(1, 3));
		assertColor(WHITE, image.getImage().getRGB(2, 3));
		assertColor(WHITE, image.getImage().getRGB(3, 3));
	}
	
	public void test_resize_NoChange_HalfSize() {
		MockImage image = new MockImage(createImage(4, 4));
		image = (MockImage) image.resize(2, 2);
		assertEquals(2, image.getImage().getWidth());
		assertEquals(2, image.getImage().getHeight());
		assertColor(BLACK, image.getImage().getRGB(0, 0));
		assertColor(WHITE, image.getImage().getRGB(1, 0));
		assertColor(WHITE, image.getImage().getRGB(0, 1));
		assertColor(WHITE, image.getImage().getRGB(1, 1));
	}
	
	public void test_resize_NoChange_HalfWidth() {
		MockImage image = new MockImage(createImage(4, 4));
		image = (MockImage) image.resize(2, 4);
		assertEquals(2, image.getImage().getWidth());
		assertEquals(4, image.getImage().getHeight());
		assertColor(BLACK, image.getImage().getRGB(0, 0));
		assertColor(WHITE, image.getImage().getRGB(1, 0));
		assertColor(BLACK, image.getImage().getRGB(0, 1));
		assertColor(WHITE, image.getImage().getRGB(1, 1));
		assertColor(WHITE, image.getImage().getRGB(0, 2));
		assertColor(WHITE, image.getImage().getRGB(1, 2));
		assertColor(WHITE, image.getImage().getRGB(0, 3));
		assertColor(WHITE, image.getImage().getRGB(1, 3));
	}
	
	public void test_resize_NoChange_HalfHeight() {
		MockImage image = new MockImage(createImage(4, 4));
		image = (MockImage) image.resize(4, 2);
		assertEquals(4, image.getImage().getWidth());
		assertEquals(2, image.getImage().getHeight());
		assertColor(BLACK, image.getImage().getRGB(0, 0));
		assertColor(BLACK, image.getImage().getRGB(1, 0));
		assertColor(WHITE, image.getImage().getRGB(2, 0));
		assertColor(WHITE, image.getImage().getRGB(3, 0));
		assertColor(WHITE, image.getImage().getRGB(0, 1));
		assertColor(WHITE, image.getImage().getRGB(1, 1));
		assertColor(WHITE, image.getImage().getRGB(2, 1));
		assertColor(WHITE, image.getImage().getRGB(3, 1));
	}
	
	public void test_resize_NoChange_DoubleSize() {
		MockImage image = new MockImage(createImage(2, 2));
		image = (MockImage) image.resize(4, 4);
		assertEquals(4, image.getImage().getWidth());
		assertEquals(4, image.getImage().getHeight());
		assertColor(BLACK, image.getImage().getRGB(0, 0));
		assertColor(BLACK, image.getImage().getRGB(1, 0));
		assertColor(WHITE, image.getImage().getRGB(2, 0));
		assertColor(WHITE, image.getImage().getRGB(3, 0));
		assertColor(BLACK, image.getImage().getRGB(0, 1));
		assertColor(BLACK, image.getImage().getRGB(1, 1));
		assertColor(WHITE, image.getImage().getRGB(2, 1));
		assertColor(WHITE, image.getImage().getRGB(3, 1));
		assertColor(WHITE, image.getImage().getRGB(0, 2));
		assertColor(WHITE, image.getImage().getRGB(1, 2));
		assertColor(WHITE, image.getImage().getRGB(2, 2));
		assertColor(WHITE, image.getImage().getRGB(3, 2));
		assertColor(WHITE, image.getImage().getRGB(0, 3));
		assertColor(WHITE, image.getImage().getRGB(1, 3));
		assertColor(WHITE, image.getImage().getRGB(2, 3));
		assertColor(WHITE, image.getImage().getRGB(3, 3));
	}
	
	public void test_resize_NoChange_DoubleWidth() {
		MockImage image = new MockImage(createImage(2, 2));
		image = (MockImage) image.resize(4, 2);
		assertEquals(4, image.getImage().getWidth());
		assertEquals(2, image.getImage().getHeight());
		assertColor(BLACK, image.getImage().getRGB(0, 0));
		assertColor(BLACK, image.getImage().getRGB(1, 0));
		assertColor(WHITE, image.getImage().getRGB(2, 0));
		assertColor(WHITE, image.getImage().getRGB(3, 0));
		assertColor(WHITE, image.getImage().getRGB(0, 1));
		assertColor(WHITE, image.getImage().getRGB(1, 1));
		assertColor(WHITE, image.getImage().getRGB(2, 1));
		assertColor(WHITE, image.getImage().getRGB(3, 1));
	}
	
	public void test_resize_NoChange_DoubleHeight() {
		MockImage image = new MockImage(createImage(2, 2));
		image = (MockImage) image.resize(2, 4);
		assertEquals(2, image.getImage().getWidth());
		assertEquals(4, image.getImage().getHeight());
		assertColor(BLACK, image.getImage().getRGB(0, 0));
		assertColor(WHITE, image.getImage().getRGB(1, 0));
		assertColor(BLACK, image.getImage().getRGB(0, 1));
		assertColor(WHITE, image.getImage().getRGB(1, 1));
		assertColor(WHITE, image.getImage().getRGB(0, 2));
		assertColor(WHITE, image.getImage().getRGB(1, 2));
		assertColor(WHITE, image.getImage().getRGB(0, 3));
		assertColor(WHITE, image.getImage().getRGB(1, 3));
	}
	
	public void test_resize_ReverseX() {
		MockImage image = new MockImage(createImage(4, 4));
		image = (MockImage) image.resize(-4, 4);
		assertEquals(4, image.getImage().getWidth());
		assertEquals(4, image.getImage().getHeight());
		assertColor(WHITE, image.getImage().getRGB(0, 0));
		assertColor(WHITE, image.getImage().getRGB(1, 0));
		assertColor(BLACK, image.getImage().getRGB(2, 0));
		assertColor(BLACK, image.getImage().getRGB(3, 0));
		assertColor(WHITE, image.getImage().getRGB(0, 1));
		assertColor(WHITE, image.getImage().getRGB(1, 1));
		assertColor(BLACK, image.getImage().getRGB(2, 1));
		assertColor(BLACK, image.getImage().getRGB(3, 1));
		assertColor(WHITE, image.getImage().getRGB(0, 2));
		assertColor(WHITE, image.getImage().getRGB(1, 2));
		assertColor(WHITE, image.getImage().getRGB(2, 2));
		assertColor(WHITE, image.getImage().getRGB(3, 2));
		assertColor(WHITE, image.getImage().getRGB(0, 3));
		assertColor(WHITE, image.getImage().getRGB(1, 3));
		assertColor(WHITE, image.getImage().getRGB(2, 3));
		assertColor(WHITE, image.getImage().getRGB(3, 3));
	}
	
	public void test_resize_ReverseX_HalfSize() {
		MockImage image = new MockImage(createImage(4, 4));
		image = (MockImage) image.resize(-2, 2);
		assertEquals(2, image.getImage().getWidth());
		assertEquals(2, image.getImage().getHeight());
		assertColor(WHITE, image.getImage().getRGB(0, 0));
		assertColor(BLACK, image.getImage().getRGB(1, 0));
		assertColor(WHITE, image.getImage().getRGB(0, 1));
		assertColor(WHITE, image.getImage().getRGB(1, 1));
	}
	
	public void test_resize_ReverseX_DoubleSize() {
		MockImage image = new MockImage(createImage(2, 2));
		image = (MockImage) image.resize(-4, 4);
		assertEquals(4, image.getImage().getWidth());
		assertEquals(4, image.getImage().getHeight());
		assertColor(WHITE, image.getImage().getRGB(0, 0));
		assertColor(WHITE, image.getImage().getRGB(1, 0));
		assertColor(BLACK, image.getImage().getRGB(2, 0));
		assertColor(BLACK, image.getImage().getRGB(3, 0));
		assertColor(WHITE, image.getImage().getRGB(0, 1));
		assertColor(WHITE, image.getImage().getRGB(1, 1));
		assertColor(BLACK, image.getImage().getRGB(2, 1));
		assertColor(BLACK, image.getImage().getRGB(3, 1));
		assertColor(WHITE, image.getImage().getRGB(0, 2));
		assertColor(WHITE, image.getImage().getRGB(1, 2));
		assertColor(WHITE, image.getImage().getRGB(2, 2));
		assertColor(WHITE, image.getImage().getRGB(3, 2));
		assertColor(WHITE, image.getImage().getRGB(0, 3));
		assertColor(WHITE, image.getImage().getRGB(1, 3));
		assertColor(WHITE, image.getImage().getRGB(2, 3));
		assertColor(WHITE, image.getImage().getRGB(3, 3));
	}
	
	public void test_resize_ReverseY() {
		MockImage image = new MockImage(createImage(4, 4));
		image = (MockImage) image.resize(4, -4);
		assertEquals(4, image.getImage().getWidth());
		assertEquals(4, image.getImage().getHeight());
		assertColor(WHITE, image.getImage().getRGB(0, 0));
		assertColor(WHITE, image.getImage().getRGB(1, 0));
		assertColor(WHITE, image.getImage().getRGB(2, 0));
		assertColor(WHITE, image.getImage().getRGB(3, 0));
		assertColor(WHITE, image.getImage().getRGB(0, 1));
		assertColor(WHITE, image.getImage().getRGB(1, 1));
		assertColor(WHITE, image.getImage().getRGB(2, 1));
		assertColor(WHITE, image.getImage().getRGB(3, 1));
		assertColor(BLACK, image.getImage().getRGB(0, 2));
		assertColor(BLACK, image.getImage().getRGB(1, 2));
		assertColor(WHITE, image.getImage().getRGB(2, 2));
		assertColor(WHITE, image.getImage().getRGB(3, 2));
		assertColor(BLACK, image.getImage().getRGB(0, 3));
		assertColor(BLACK, image.getImage().getRGB(1, 3));
		assertColor(WHITE, image.getImage().getRGB(2, 3));
		assertColor(WHITE, image.getImage().getRGB(3, 3));
	}
	
	public void test_resize_ReverseY_HalfSize() {
		MockImage image = new MockImage(createImage(4, 4));
		image = (MockImage) image.resize(2, -2);
		assertEquals(2, image.getImage().getWidth());
		assertEquals(2, image.getImage().getHeight());
		assertColor(WHITE, image.getImage().getRGB(0, 0));
		assertColor(WHITE, image.getImage().getRGB(1, 0));
		assertColor(BLACK, image.getImage().getRGB(0, 1));
		assertColor(WHITE, image.getImage().getRGB(1, 1));
	}
	
	public void test_resize_ReverseY_DoubleSize() {
		MockImage image = new MockImage(createImage(2, 2));
		image = (MockImage) image.resize(4, -4);
		assertEquals(4, image.getImage().getWidth());
		assertEquals(4, image.getImage().getHeight());
		assertColor(WHITE, image.getImage().getRGB(0, 0));
		assertColor(WHITE, image.getImage().getRGB(1, 0));
		assertColor(WHITE, image.getImage().getRGB(2, 0));
		assertColor(WHITE, image.getImage().getRGB(3, 0));
		assertColor(WHITE, image.getImage().getRGB(0, 1));
		assertColor(WHITE, image.getImage().getRGB(1, 1));
		assertColor(WHITE, image.getImage().getRGB(2, 1));
		assertColor(WHITE, image.getImage().getRGB(3, 1));
		assertColor(BLACK, image.getImage().getRGB(0, 2));
		assertColor(BLACK, image.getImage().getRGB(1, 2));
		assertColor(WHITE, image.getImage().getRGB(2, 2));
		assertColor(WHITE, image.getImage().getRGB(3, 2));
		assertColor(BLACK, image.getImage().getRGB(0, 3));
		assertColor(BLACK, image.getImage().getRGB(1, 3));
		assertColor(WHITE, image.getImage().getRGB(2, 3));
		assertColor(WHITE, image.getImage().getRGB(3, 3));
	}
	
	public void test_resize_ReverseXY() {
		MockImage image = new MockImage(createImage(4, 4));
		image = (MockImage) image.resize(-4, -4);
		assertEquals(4, image.getImage().getWidth());
		assertEquals(4, image.getImage().getHeight());
		assertColor(WHITE, image.getImage().getRGB(0, 0));
		assertColor(WHITE, image.getImage().getRGB(1, 0));
		assertColor(WHITE, image.getImage().getRGB(2, 0));
		assertColor(WHITE, image.getImage().getRGB(3, 0));
		assertColor(WHITE, image.getImage().getRGB(0, 1));
		assertColor(WHITE, image.getImage().getRGB(1, 1));
		assertColor(WHITE, image.getImage().getRGB(2, 1));
		assertColor(WHITE, image.getImage().getRGB(3, 1));
		assertColor(WHITE, image.getImage().getRGB(0, 2));
		assertColor(WHITE, image.getImage().getRGB(1, 2));
		assertColor(BLACK, image.getImage().getRGB(2, 2));
		assertColor(BLACK, image.getImage().getRGB(3, 2));
		assertColor(WHITE, image.getImage().getRGB(0, 3));
		assertColor(WHITE, image.getImage().getRGB(1, 3));
		assertColor(BLACK, image.getImage().getRGB(2, 3));
		assertColor(BLACK, image.getImage().getRGB(3, 3));
	}
	
	public void test_resize_ReverseXY_HalfSize() {
		MockImage image = new MockImage(createImage(4, 4));
		image = (MockImage) image.resize(-2, -2);
		assertEquals(2, image.getImage().getWidth());
		assertEquals(2, image.getImage().getHeight());
		assertColor(WHITE, image.getImage().getRGB(0, 0));
		assertColor(WHITE, image.getImage().getRGB(1, 0));
		assertColor(WHITE, image.getImage().getRGB(0, 1));
		assertColor(BLACK, image.getImage().getRGB(1, 1));
	}
	
	public void test_resize_ReverseXY_DoubleSize() {
		MockImage image = new MockImage(createImage(2, 2));
		image = (MockImage) image.resize(-4, -4);
		assertEquals(4, image.getImage().getWidth());
		assertColor(WHITE, image.getImage().getRGB(0, 0));
		assertColor(WHITE, image.getImage().getRGB(1, 0));
		assertColor(WHITE, image.getImage().getRGB(2, 0));
		assertColor(WHITE, image.getImage().getRGB(3, 0));
		assertColor(WHITE, image.getImage().getRGB(0, 1));
		assertColor(WHITE, image.getImage().getRGB(1, 1));
		assertColor(WHITE, image.getImage().getRGB(2, 1));
		assertColor(WHITE, image.getImage().getRGB(3, 1));
		assertColor(WHITE, image.getImage().getRGB(0, 2));
		assertColor(WHITE, image.getImage().getRGB(1, 2));
		assertColor(BLACK, image.getImage().getRGB(2, 2));
		assertColor(BLACK, image.getImage().getRGB(3, 2));
		assertColor(WHITE, image.getImage().getRGB(0, 3));
		assertColor(WHITE, image.getImage().getRGB(1, 3));
		assertColor(BLACK, image.getImage().getRGB(2, 3));
		assertColor(BLACK, image.getImage().getRGB(3, 3));
	}
	
	public void test_resize_ZeroWidth() {
		MockImage image = new MockImage(createImage(4, 4));
		try {
			image = (MockImage) image.resize(0, 4);
			fail("No Exception thrown");
		} catch (IllegalArgumentException ex) {
			// Expected
		}
	}
	
	public void test_resize_ZeroHeight() {
		MockImage image = new MockImage(createImage(4, 4));
		try {
			image = (MockImage) image.resize(4, 0);
			fail("No Exception thrown");
		} catch (IllegalArgumentException ex) {
			// Expected
		}
	}
	
	public void test_resize_DoesNotModifyOldImage() {
		MockImage image = new MockImage(createImage(2, 2));
		image.resize(4, 4);
		assertEquals(2, image.getImage().getWidth());
		assertEquals(2, image.getImage().getHeight());
		assertColor(BLACK, image.getImage().getRGB(0, 0));
		assertColor(WHITE, image.getImage().getRGB(1, 0));
		assertColor(WHITE, image.getImage().getRGB(0, 1));
		assertColor(WHITE, image.getImage().getRGB(1, 1));
	}
	
	public void test_getSubimage_FullSize() {
		MockImage image = new MockImage(createImage(2, 2));
		image = (MockImage) image.getSubimage(0, 0, 2, 2);
		assertEquals(2, image.getImage().getWidth());
		assertEquals(2, image.getImage().getHeight());
		assertColor(BLACK, image.getImage().getRGB(0, 0));
		assertColor(WHITE, image.getImage().getRGB(1, 0));
		assertColor(WHITE, image.getImage().getRGB(0, 1));
		assertColor(WHITE, image.getImage().getRGB(1, 1));
	}
	
	public void test_getSubimage_FullSize_FlipX() {
		MockImage image = new MockImage(createImage(2, 2));
		image = (MockImage) image.getSubimage(1, 0, -2, 2);
		assertEquals(2, image.getImage().getWidth());
		assertEquals(2, image.getImage().getHeight());
		assertColor(WHITE, image.getImage().getRGB(0, 0));
		assertColor(BLACK, image.getImage().getRGB(1, 0));
		assertColor(WHITE, image.getImage().getRGB(0, 1));
		assertColor(WHITE, image.getImage().getRGB(1, 1));
	}
	
	public void test_getSubimage_FullSize_FlipY() {
		MockImage image = new MockImage(createImage(2, 2));
		image = (MockImage) image.getSubimage(0, 1, 2, -2);
		assertEquals(2, image.getImage().getWidth());
		assertEquals(2, image.getImage().getHeight());
		assertColor(WHITE, image.getImage().getRGB(0, 0));
		assertColor(WHITE, image.getImage().getRGB(1, 0));
		assertColor(BLACK, image.getImage().getRGB(0, 1));
		assertColor(WHITE, image.getImage().getRGB(1, 1));
	}
	
	public void test_getSubimage_FullSize_FlipXY() {
		MockImage image = new MockImage(createImage(2, 2));
		image = (MockImage) image.getSubimage(1, 1, -2, -2);
		assertEquals(2, image.getImage().getWidth());
		assertEquals(2, image.getImage().getHeight());
		assertColor(WHITE, image.getImage().getRGB(0, 0));
		assertColor(WHITE, image.getImage().getRGB(1, 0));
		assertColor(WHITE, image.getImage().getRGB(0, 1));
		assertColor(BLACK, image.getImage().getRGB(1, 1));
	}
	
	public void test_getSubimage_BasicUse_ZeroWidth() {
		MockImage image = new MockImage(createImage(4, 4));
		try {
			image = (MockImage) image.getSubimage(1, 1, 3, 0);
			fail("No Exception thrown");
		} catch (IllegalArgumentException ex) {
			// Expected
		}
	}
	
	public void test_getSubimage_BasicUse_ZeroHeight() {
		MockImage image = new MockImage(createImage(4, 4));
		try {
			image = (MockImage) image.getSubimage(1, 1, 0, 3);
			fail("No Exception thrown");
		} catch (IllegalArgumentException ex) {
			// Expected
		}
	}
	
	public void test_getSubimage_BasicUse_GetMiddleX() {
		MockImage image = new MockImage(createImage(4, 4));
		image = (MockImage) image.getSubimage(1, 1, 2, 1);
		assertEquals(2, image.getImage().getWidth());
		assertEquals(1, image.getImage().getHeight());
		assertColor(BLACK, image.getImage().getRGB(0, 0));
		assertColor(WHITE, image.getImage().getRGB(1, 0));
	}
	
	public void test_getSubimage_BasicUse_GetMiddleY() {
		MockImage image = new MockImage(createImage(4, 4));
		image = (MockImage) image.getSubimage(1, 1, 1, 2);
		assertEquals(1, image.getImage().getWidth());
		assertEquals(2, image.getImage().getHeight());
		assertColor(BLACK, image.getImage().getRGB(0, 0));
		assertColor(WHITE, image.getImage().getRGB(0, 1));
	}
	
	public void test_getSubimage_BasicUse_GetMiddleXY() {
		MockImage image = new MockImage(createImage(4, 4));
		image = (MockImage) image.getSubimage(1, 1, 2, 2);
		assertEquals(2, image.getImage().getWidth());
		assertEquals(2, image.getImage().getHeight());
		assertColor(BLACK, image.getImage().getRGB(0, 0));
		assertColor(WHITE, image.getImage().getRGB(1, 0));
		assertColor(WHITE, image.getImage().getRGB(0, 1));
		assertColor(WHITE, image.getImage().getRGB(1, 1));
	}
	
	public void test_getSubimage_BasicUse_XYTopLeft() {
		MockImage image = new MockImage(createImage(4, 4));
		image = (MockImage) image.getSubimage(0, 0, 3, 3);
		assertEquals(3, image.getImage().getWidth());
		assertEquals(3, image.getImage().getHeight());
		assertColor(BLACK, image.getImage().getRGB(0, 0));
		assertColor(BLACK, image.getImage().getRGB(1, 0));
		assertColor(WHITE, image.getImage().getRGB(2, 0));
		assertColor(BLACK, image.getImage().getRGB(0, 1));
		assertColor(BLACK, image.getImage().getRGB(1, 1));
		assertColor(WHITE, image.getImage().getRGB(2, 1));
		assertColor(WHITE, image.getImage().getRGB(0, 2));
		assertColor(WHITE, image.getImage().getRGB(1, 2));
		assertColor(WHITE, image.getImage().getRGB(2, 2));
	}
	
	public void test_getSubimage_BasicUse_XYBottomRight() {
		MockImage image = new MockImage(createImage(4, 4));
		image = (MockImage) image.getSubimage(3, 3, -3, -3);
		assertEquals(3, image.getImage().getWidth());
		assertEquals(3, image.getImage().getHeight());
		assertColor(WHITE, image.getImage().getRGB(0, 0));
		assertColor(WHITE, image.getImage().getRGB(1, 0));
		assertColor(WHITE, image.getImage().getRGB(2, 0));
		assertColor(WHITE, image.getImage().getRGB(0, 1));
		assertColor(WHITE, image.getImage().getRGB(1, 1));
		assertColor(WHITE, image.getImage().getRGB(2, 1));
		assertColor(WHITE, image.getImage().getRGB(0, 2));
		assertColor(WHITE, image.getImage().getRGB(1, 2));
		assertColor(BLACK, image.getImage().getRGB(2, 2));
	}
	
	public void test_getSubimage_ToEdge_BottomRight() {
		MockImage image = new MockImage(createImage(4, 4));
		image = (MockImage) image.getSubimage(1, 1, 3, 3);
		assertEquals(3, image.getImage().getWidth());
		assertEquals(3, image.getImage().getHeight());
		assertColor(BLACK, image.getImage().getRGB(0, 0));
		assertColor(WHITE, image.getImage().getRGB(1, 0));
		assertColor(WHITE, image.getImage().getRGB(2, 0));
		assertColor(WHITE, image.getImage().getRGB(0, 1));
		assertColor(WHITE, image.getImage().getRGB(1, 1));
		assertColor(WHITE, image.getImage().getRGB(2, 1));
		assertColor(WHITE, image.getImage().getRGB(0, 2));
		assertColor(WHITE, image.getImage().getRGB(1, 2));
		assertColor(WHITE, image.getImage().getRGB(2, 2));
	}
	
	public void test_getSubimage_ToEdge_TopLeft() {
		MockImage image = new MockImage(createImage(4, 4));
		image = (MockImage) image.getSubimage(2, 2, -3, -3);
		assertEquals(3, image.getImage().getWidth());
		assertEquals(3, image.getImage().getHeight());
		assertColor(WHITE, image.getImage().getRGB(0, 0));
		assertColor(WHITE, image.getImage().getRGB(1, 0));
		assertColor(WHITE, image.getImage().getRGB(2, 0));
		assertColor(WHITE, image.getImage().getRGB(0, 1));
		assertColor(BLACK, image.getImage().getRGB(1, 1));
		assertColor(BLACK, image.getImage().getRGB(2, 1));
		assertColor(WHITE, image.getImage().getRGB(0, 2));
		assertColor(BLACK, image.getImage().getRGB(1, 2));
		assertColor(BLACK, image.getImage().getRGB(2, 2));
	}
	
	public void test_getSubimage_OverEdge_X() {
		MockImage image = new MockImage(createImage(4, 4));
		try {
			image = (MockImage) image.getSubimage(4, 1, 0, 0);
			fail("No Exception thrown");
		} catch (IllegalArgumentException ex) {
			// Expected
		}
	}
	
	public void test_getSubimage_OverEdge_NegativeX() {
		MockImage image = new MockImage(createImage(4, 4));
		try {
			image = (MockImage) image.getSubimage(-1, 1, 3, 3);
			fail("No Exception thrown");
		} catch (IllegalArgumentException ex) {
			// Expected
		}
	}
	
	public void test_getSubimage_OverEdge_Y() {
		MockImage image = new MockImage(createImage(4, 4));
		try {
			image = (MockImage) image.getSubimage(1, 4, 0, 0);
			fail("No Exception thrown");
		} catch (IllegalArgumentException ex) {
			// Expected
		}
	}
	
	public void test_getSubimage_OverEdge_NegativeY() {
		MockImage image = new MockImage(createImage(4, 4));
		try {
			image = (MockImage) image.getSubimage(1, -1, 3, 3);
			fail("No Exception thrown");
		} catch (IllegalArgumentException ex) {
			// Expected
		}
	}
	
	public void test_getSubimage_OverEdge_Width() {
		MockImage image = new MockImage(createImage(4, 4));
		try {
			image = (MockImage) image.getSubimage(1, 1, 4, 3);
			fail("No Exception thrown");
		} catch (IllegalArgumentException ex) {
			// Expected
		}
	}
	
	public void test_getSubimage_OverEdge_NegativeWidth() {
		MockImage image = new MockImage(createImage(4, 4));
		try {
			image = (MockImage) image.getSubimage(1, 1, -3, 3);
			fail("No Exception thrown");
		} catch (IllegalArgumentException ex) {
			// Expected
		}
	}
	
	public void test_getSubimage_OverEdge_Height() {
		MockImage image = new MockImage(createImage(4, 4));
		try {
			image = (MockImage) image.getSubimage(1, 1, 3, 4);
			fail("No Exception thrown");
		} catch (IllegalArgumentException ex) {
			// Expected
		}
	}
	
	public void test_getSubimage_OverEdge_NegativeHeight() {
		MockImage image = new MockImage(createImage(4, 4));
		try {
			image = (MockImage) image.getSubimage(1, 1, 3, -3);
			fail("No Exception thrown");
		} catch (IllegalArgumentException ex) {
			// Expected
		}
	}
	
	public void test_getSubimage_DoesNotModifyOldImage() {
		MockImage image = new MockImage(createImage(4, 4));
		image.getSubimage(0, 0, 2, 2);
		assertEquals(4, image.getImage().getWidth());
		assertEquals(4, image.getImage().getHeight());
		assertColor(BLACK, image.getImage().getRGB(0, 0));
		assertColor(BLACK, image.getImage().getRGB(1, 0));
		assertColor(WHITE, image.getImage().getRGB(2, 0));
		assertColor(WHITE, image.getImage().getRGB(3, 0));
		assertColor(BLACK, image.getImage().getRGB(0, 1));
		assertColor(BLACK, image.getImage().getRGB(1, 1));
		assertColor(WHITE, image.getImage().getRGB(2, 1));
		assertColor(WHITE, image.getImage().getRGB(3, 1));
		assertColor(WHITE, image.getImage().getRGB(0, 2));
		assertColor(WHITE, image.getImage().getRGB(1, 2));
		assertColor(WHITE, image.getImage().getRGB(2, 2));
		assertColor(WHITE, image.getImage().getRGB(3, 2));
		assertColor(WHITE, image.getImage().getRGB(0, 3));
		assertColor(WHITE, image.getImage().getRGB(1, 3));
		assertColor(WHITE, image.getImage().getRGB(2, 3));
		assertColor(WHITE, image.getImage().getRGB(3, 3));
	}
	
	public void test_changeHue_Black_White_NoChange() {
		MockImage image = new MockImage(createImage(2, 2));
		image = (MockImage) image.changeHue(RED, 1.0);
		assertEquals(2, image.getImage().getWidth());
		assertEquals(2, image.getImage().getHeight());
		assertColor(BLACK, image.getImage().getRGB(0, 0));
		assertColor(WHITE, image.getImage().getRGB(1, 0));
		assertColor(WHITE, image.getImage().getRGB(0, 1));
		assertColor(WHITE, image.getImage().getRGB(1, 1));		
	}
	
	public void test_changeHue_Red_To_Green() {
		MockImage image = new MockImage(createImage(2, 2, RED));
		image = (MockImage) image.changeHue(GREEN, 1.0);
		assertEquals(2, image.getImage().getWidth());
		assertEquals(2, image.getImage().getHeight());
		assertColor(GREEN, image.getImage().getRGB(0, 0));
		assertColor(GREEN, image.getImage().getRGB(1, 0));
		assertColor(GREEN, image.getImage().getRGB(0, 1));
		assertColor(GREEN, image.getImage().getRGB(1, 1));		
	}
	
	public void test_changeHue_Green_To_Red() {
		MockImage image = new MockImage(createImage(2, 2, GREEN));
		image = (MockImage) image.changeHue(RED, 1.0);
		assertEquals(2, image.getImage().getWidth());
		assertEquals(2, image.getImage().getHeight());
		assertColor(RED, image.getImage().getRGB(0, 0));
		assertColor(RED, image.getImage().getRGB(1, 0));
		assertColor(RED, image.getImage().getRGB(0, 1));
		assertColor(RED, image.getImage().getRGB(1, 1));		
	}
	
	public void test_changeHue_Red_To_Blue() {
		MockImage image = new MockImage(createImage(2, 2, RED));
		image = (MockImage) image.changeHue(BLUE, 1.0);
		assertEquals(2, image.getImage().getWidth());
		assertEquals(2, image.getImage().getHeight());
		assertColor(BLUE, image.getImage().getRGB(0, 0));
		assertColor(BLUE, image.getImage().getRGB(1, 0));
		assertColor(BLUE, image.getImage().getRGB(0, 1));
		assertColor(BLUE, image.getImage().getRGB(1, 1));		
	}
	
	public void test_changeHue_Blue_To_Red() {
		MockImage image = new MockImage(createImage(2, 2, BLUE));
		image = (MockImage) image.changeHue(RED, 1.0);
		assertEquals(2, image.getImage().getWidth());
		assertEquals(2, image.getImage().getHeight());
		assertColor(RED, image.getImage().getRGB(0, 0));
		assertColor(RED, image.getImage().getRGB(1, 0));
		assertColor(RED, image.getImage().getRGB(0, 1));
		assertColor(RED, image.getImage().getRGB(1, 1));		
	}
	
	public void test_changeHue_Green_To_Blue() {
		MockImage image = new MockImage(createImage(2, 2, GREEN));
		image = (MockImage) image.changeHue(BLUE, 1.0);
		assertEquals(2, image.getImage().getWidth());
		assertEquals(2, image.getImage().getHeight());
		assertColor(BLUE, image.getImage().getRGB(0, 0));
		assertColor(BLUE, image.getImage().getRGB(1, 0));
		assertColor(BLUE, image.getImage().getRGB(0, 1));
		assertColor(BLUE, image.getImage().getRGB(1, 1));		
	}
	
	public void test_changeHue_Blue_To_Blue() {
		MockImage image = new MockImage(createImage(2, 2, BLUE));
		image = (MockImage) image.changeHue(GREEN, 1.0);
		assertEquals(2, image.getImage().getWidth());
		assertEquals(2, image.getImage().getHeight());
		assertColor(GREEN, image.getImage().getRGB(0, 0));
		assertColor(GREEN, image.getImage().getRGB(1, 0));
		assertColor(GREEN, image.getImage().getRGB(0, 1));
		assertColor(GREEN, image.getImage().getRGB(1, 1));		
	}	
	
	public void test_changeHue_RedWithWhiteFilter() {
		MockImage image = new MockImage(createImage(2, 2, RED));
		image = (MockImage) image.changeHue(WHITE, 0.5);
		assertEquals(2, image.getImage().getWidth());
		assertEquals(2, image.getImage().getHeight());
		assertColor(RED, image.getImage().getRGB(0, 0));
		assertColor(RED, image.getImage().getRGB(1, 0));
		assertColor(RED, image.getImage().getRGB(0, 1));
		assertColor(RED, image.getImage().getRGB(1, 1));		
	}
	
	public void test_changeHue_RedWithBlackFilter() {
		MockImage image = new MockImage(createImage(2, 2, RED));
		image = (MockImage) image.changeHue(BLACK, 0.5);
		assertEquals(2, image.getImage().getWidth());
		assertEquals(2, image.getImage().getHeight());
		assertColor(RED, image.getImage().getRGB(0, 0));
		assertColor(RED, image.getImage().getRGB(1, 0));
		assertColor(RED, image.getImage().getRGB(0, 1));
		assertColor(RED, image.getImage().getRGB(1, 1));		
	}
	
	public void test_changeHue_LightRedWithGreenFilter() {
		MockImage image = new MockImage(createImage(2, 2, LIGHT_RED));
		image = (MockImage) image.changeHue(GREEN, 1.0);
		assertEquals(2, image.getImage().getWidth());
		assertEquals(2, image.getImage().getHeight());
		assertColor(LIGHT_GREEN, image.getImage().getRGB(0, 0));
		assertColor(LIGHT_GREEN, image.getImage().getRGB(1, 0));
		assertColor(LIGHT_GREEN, image.getImage().getRGB(0, 1));
		assertColor(LIGHT_GREEN, image.getImage().getRGB(1, 1));		
	}
	
	public void test_changeHue_DarkRedWithGreenFilter() {
		MockImage image = new MockImage(createImage(2, 2, DARK_RED));
		image = (MockImage) image.changeHue(GREEN, 1.0);
		assertEquals(2, image.getImage().getWidth());
		assertEquals(2, image.getImage().getHeight());
		assertColor(DARK_GREEN, image.getImage().getRGB(0, 0));
		assertColor(DARK_GREEN, image.getImage().getRGB(1, 0));
		assertColor(DARK_GREEN, image.getImage().getRGB(0, 1));
		assertColor(DARK_GREEN, image.getImage().getRGB(1, 1));		
	}
	
	public void test_changeHue_RedWithRedFilter() {
		MockImage image = new MockImage(createImage(2, 2, RED));
		image = (MockImage) image.changeHue(RED, 0.5);
		assertEquals(2, image.getImage().getWidth());
		assertEquals(2, image.getImage().getHeight());
		assertColor(RED, image.getImage().getRGB(0, 0));
		assertColor(RED, image.getImage().getRGB(1, 0));
		assertColor(RED, image.getImage().getRGB(0, 1));
		assertColor(RED, image.getImage().getRGB(1, 1));		
	}
	
	public void test_changeHue_RedWithGreenFilter() {
		MockImage image = new MockImage(createImage(2, 2, RED));
		image = (MockImage) image.changeHue(GREEN, 0.5);
		assertEquals(2, image.getImage().getWidth());
		assertEquals(2, image.getImage().getHeight());
		assertColor(YELLOW, image.getImage().getRGB(0, 0));
		assertColor(YELLOW, image.getImage().getRGB(1, 0));
		assertColor(YELLOW, image.getImage().getRGB(0, 1));
		assertColor(YELLOW, image.getImage().getRGB(1, 1));		
	}
	
	public void test_changeHue_GreenWithRedFilter() {
		MockImage image = new MockImage(createImage(2, 2, GREEN));
		image = (MockImage) image.changeHue(RED, 0.5);
		assertEquals(2, image.getImage().getWidth());
		assertEquals(2, image.getImage().getHeight());
		assertColor(YELLOW, image.getImage().getRGB(0, 0));
		assertColor(YELLOW, image.getImage().getRGB(1, 0));
		assertColor(YELLOW, image.getImage().getRGB(0, 1));
		assertColor(YELLOW, image.getImage().getRGB(1, 1));		
	}
	
	public void test_changeHue_RedWithBlueFilter() {
		MockImage image = new MockImage(createImage(2, 2, RED));
		image = (MockImage) image.changeHue(BLUE, 0.5);
		assertEquals(2, image.getImage().getWidth());
		assertEquals(2, image.getImage().getHeight());
		assertColor(PURPLE, image.getImage().getRGB(0, 0));
		assertColor(PURPLE, image.getImage().getRGB(1, 0));
		assertColor(PURPLE, image.getImage().getRGB(0, 1));
		assertColor(PURPLE, image.getImage().getRGB(1, 1));		
	}
	
	public void test_changeHue_BlueWithRedFilter() {
		MockImage image = new MockImage(createImage(2, 2, BLUE));
		image = (MockImage) image.changeHue(RED, 0.5);
		assertEquals(2, image.getImage().getWidth());
		assertEquals(2, image.getImage().getHeight());
		assertColor(PURPLE, image.getImage().getRGB(0, 0));
		assertColor(PURPLE, image.getImage().getRGB(1, 0));
		assertColor(PURPLE, image.getImage().getRGB(0, 1));
		assertColor(PURPLE, image.getImage().getRGB(1, 1));		
	}
	
	public void test_changeHue_GreenWithBlueFilter() {
		MockImage image = new MockImage(createImage(2, 2, GREEN));
		image = (MockImage) image.changeHue(BLUE, 0.5);
		assertEquals(2, image.getImage().getWidth());
		assertEquals(2, image.getImage().getHeight());
		assertColor(TEAL, image.getImage().getRGB(0, 0));
		assertColor(TEAL, image.getImage().getRGB(1, 0));
		assertColor(TEAL, image.getImage().getRGB(0, 1));
		assertColor(TEAL, image.getImage().getRGB(1, 1));		
	}
	
	public void test_changeHue_BlueWithGreenFilter() {
		MockImage image = new MockImage(createImage(2, 2, BLUE));
		image = (MockImage) image.changeHue(GREEN, 0.5);
		assertEquals(2, image.getImage().getWidth());
		assertEquals(2, image.getImage().getHeight());
		assertColor(TEAL, image.getImage().getRGB(0, 0));
		assertColor(TEAL, image.getImage().getRGB(1, 0));
		assertColor(TEAL, image.getImage().getRGB(0, 1));
		assertColor(TEAL, image.getImage().getRGB(1, 1));		
	}
	
	public void test_changeHue_TealWithYellowFilter() {
		MockImage image = new MockImage(createImage(2, 2, TEAL));
		image = (MockImage) image.changeHue(YELLOW, 0.5);
		assertEquals(2, image.getImage().getWidth());
		assertEquals(2, image.getImage().getHeight());
		assertColor(GREEN, image.getImage().getRGB(0, 0));
		assertColor(GREEN, image.getImage().getRGB(1, 0));
		assertColor(GREEN, image.getImage().getRGB(0, 1));
		assertColor(GREEN, image.getImage().getRGB(1, 1));		
	}
	
	public void test_changeHue_YellowWithTealFilter() {
		MockImage image = new MockImage(createImage(2, 2, YELLOW));
		image = (MockImage) image.changeHue(TEAL, 0.5);
		assertEquals(2, image.getImage().getWidth());
		assertEquals(2, image.getImage().getHeight());
		assertColor(GREEN, image.getImage().getRGB(0, 0));
		assertColor(GREEN, image.getImage().getRGB(1, 0));
		assertColor(GREEN, image.getImage().getRGB(0, 1));
		assertColor(GREEN, image.getImage().getRGB(1, 1));		
	}
	
	public void test_changeHue_TealWithPurpleFilter() {
		MockImage image = new MockImage(createImage(2, 2, TEAL));
		image = (MockImage) image.changeHue(PURPLE, 0.5);
		assertEquals(2, image.getImage().getWidth());
		assertEquals(2, image.getImage().getHeight());
		assertColor(BLUE, image.getImage().getRGB(0, 0));
		assertColor(BLUE, image.getImage().getRGB(1, 0));
		assertColor(BLUE, image.getImage().getRGB(0, 1));
		assertColor(BLUE, image.getImage().getRGB(1, 1));		
	}
	
	public void test_changeHue_PurpleWithTealFilter() {
		MockImage image = new MockImage(createImage(2, 2, PURPLE));
		image = (MockImage) image.changeHue(TEAL, 0.5);
		assertEquals(2, image.getImage().getWidth());
		assertEquals(2, image.getImage().getHeight());
		assertColor(BLUE, image.getImage().getRGB(0, 0));
		assertColor(BLUE, image.getImage().getRGB(1, 0));
		assertColor(BLUE, image.getImage().getRGB(0, 1));
		assertColor(BLUE, image.getImage().getRGB(1, 1));		
	}
	
	public void test_changeHue_YellowWithPurpleFilter() {
		MockImage image = new MockImage(createImage(2, 2, YELLOW));
		image = (MockImage) image.changeHue(PURPLE, 0.5);
		assertEquals(2, image.getImage().getWidth());
		assertEquals(2, image.getImage().getHeight());
		assertColor(RED, image.getImage().getRGB(0, 0));
		assertColor(RED, image.getImage().getRGB(1, 0));
		assertColor(RED, image.getImage().getRGB(0, 1));
		assertColor(RED, image.getImage().getRGB(1, 1));		
	}
	
	public void test_changeHue_PurpleWithYellowFilter() {
		MockImage image = new MockImage(createImage(2, 2, PURPLE));
		image = (MockImage) image.changeHue(YELLOW, 0.5);
		assertEquals(2, image.getImage().getWidth());
		assertEquals(2, image.getImage().getHeight());
		assertColor(RED, image.getImage().getRGB(0, 0));
		assertColor(RED, image.getImage().getRGB(1, 0));
		assertColor(RED, image.getImage().getRGB(0, 1));
		assertColor(RED, image.getImage().getRGB(1, 1));		
	}
	
	public void test_flipX_Even() {
		MockImage image = new MockImage(createImage(2, 4));
		image = (MockImage) image.flipX();
		assertEquals(2, image.getImage().getWidth());
		assertEquals(4, image.getImage().getHeight());
		assertColor(WHITE, image.getImage().getRGB(0, 0));
		assertColor(BLACK, image.getImage().getRGB(1, 0));
		assertColor(WHITE, image.getImage().getRGB(0, 1));
		assertColor(BLACK, image.getImage().getRGB(1, 1));
		assertColor(WHITE, image.getImage().getRGB(0, 2));
		assertColor(WHITE, image.getImage().getRGB(1, 2));
		assertColor(WHITE, image.getImage().getRGB(0, 3));
		assertColor(WHITE, image.getImage().getRGB(1, 3));
	}
	
	public void test_flipX_Odd() {
		MockImage image = new MockImage(createImage(3, 4));
		image = (MockImage) image.flipX();
		assertEquals(3, image.getImage().getWidth());
		assertEquals(4, image.getImage().getHeight());
		assertColor(WHITE, image.getImage().getRGB(0, 0));
		assertColor(WHITE, image.getImage().getRGB(1, 0));
		assertColor(BLACK, image.getImage().getRGB(2, 0));
		assertColor(WHITE, image.getImage().getRGB(0, 1));
		assertColor(WHITE, image.getImage().getRGB(1, 1));
		assertColor(BLACK, image.getImage().getRGB(2, 1));
		assertColor(WHITE, image.getImage().getRGB(0, 2));
		assertColor(WHITE, image.getImage().getRGB(1, 2));
		assertColor(WHITE, image.getImage().getRGB(2, 2));
		assertColor(WHITE, image.getImage().getRGB(0, 3));
		assertColor(WHITE, image.getImage().getRGB(1, 3));
		assertColor(WHITE, image.getImage().getRGB(2, 3));
	}
	
	public void test_flipX_DoesNotModifyOldImage() {
		MockImage image = new MockImage(createImage(2, 4));
		image.flipX();
		assertEquals(2, image.getImage().getWidth());
		assertEquals(4, image.getImage().getHeight());
		assertColor(BLACK, image.getImage().getRGB(0, 0));
		assertColor(WHITE, image.getImage().getRGB(1, 0));
		assertColor(BLACK, image.getImage().getRGB(0, 1));
		assertColor(WHITE, image.getImage().getRGB(1, 1));
		assertColor(WHITE, image.getImage().getRGB(0, 2));
		assertColor(WHITE, image.getImage().getRGB(1, 2));
		assertColor(WHITE, image.getImage().getRGB(0, 3));
		assertColor(WHITE, image.getImage().getRGB(1, 3));
	}
	
	public void test_flipY_Even() {
		MockImage image = new MockImage(createImage(2, 4));
		image = (MockImage) image.flipY();
		assertEquals(2, image.getImage().getWidth());
		assertEquals(4, image.getImage().getHeight());
		assertColor(WHITE, image.getImage().getRGB(0, 0));
		assertColor(WHITE, image.getImage().getRGB(1, 0));
		assertColor(WHITE, image.getImage().getRGB(0, 1));
		assertColor(WHITE, image.getImage().getRGB(1, 1));
		assertColor(BLACK, image.getImage().getRGB(0, 2));
		assertColor(WHITE, image.getImage().getRGB(1, 2));
		assertColor(BLACK, image.getImage().getRGB(0, 3));
		assertColor(WHITE, image.getImage().getRGB(1, 3));
	}
	
	public void test_flipY_Odd() {
		MockImage image = new MockImage(createImage(2, 3));
		image = (MockImage) image.flipY();
		assertEquals(2, image.getImage().getWidth());
		assertEquals(3, image.getImage().getHeight());
		assertColor(WHITE, image.getImage().getRGB(0, 0));
		assertColor(WHITE, image.getImage().getRGB(1, 0));
		assertColor(WHITE, image.getImage().getRGB(0, 1));
		assertColor(WHITE, image.getImage().getRGB(1, 1));
		assertColor(BLACK, image.getImage().getRGB(0, 2));
		assertColor(WHITE, image.getImage().getRGB(1, 2));
	}
	
	public void test_flipY_DoesNotModifyOldImage() {
		MockImage image = new MockImage(createImage(2, 4));
		image.flipY();
		assertEquals(2, image.getImage().getWidth());
		assertEquals(4, image.getImage().getHeight());
		assertColor(BLACK, image.getImage().getRGB(0, 0));
		assertColor(WHITE, image.getImage().getRGB(1, 0));
		assertColor(BLACK, image.getImage().getRGB(0, 1));
		assertColor(WHITE, image.getImage().getRGB(1, 1));
		assertColor(WHITE, image.getImage().getRGB(0, 2));
		assertColor(WHITE, image.getImage().getRGB(1, 2));
		assertColor(WHITE, image.getImage().getRGB(0, 3));
		assertColor(WHITE, image.getImage().getRGB(1, 3));
	}
	
	public void test_isAllColor_IsColor_WHITE() {
		MockImage image = new MockImage(createImage(2, 4, WHITE));
		assertEquals(true, image.isAllColor(255, 255, 255, 255));
	}
	
	public void test_isAllColor_NotColor_WHITE() {
		MockImage image = new MockImage(createImage(2, 4, WHITE));
		image.getImage().setRGB(0, 0, BLACK);
		assertEquals(false, image.isAllColor(255, 255, 255, 255));
	}
	
	public void test_isAllTransparent_IsTransparent_0x00000000() {
		MockImage image = new MockImage(createImage(2, 4, 0x00000000));
		assertEquals(true, image.isAllTransparent());
	}
	
	public void test_isAllTransparent_IsTransparent_0x00FFFFFF() {
		MockImage image = new MockImage(createImage(2, 4, 0x00FFFFFF));
		assertEquals(true, image.isAllTransparent());
	}
	
	public void test_isAllTransparent_NotTransparent_TopLeft() {
		MockImage image = new MockImage(createImage(2, 4, EMPTY));
		image.getImage().setRGB(0, 0, BLACK);
		assertEquals(false, image.isAllTransparent());
	}
	
	public void test_isAllTransparent_NotTransparent_BottomRight() {
		MockImage image = new MockImage(createImage(2, 4, EMPTY));
		image.getImage().setRGB(1, 3, BLACK);
		assertEquals(false, image.isAllTransparent());
	}
	
	public void test_isAllTransparent_NotTransparent_0x01000000() {
		MockImage image = new MockImage(createImage(2, 4, 0x01000000));
		assertEquals(false, image.isAllTransparent());
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
	
	private String getColorName(int color) {
		switch(color) {
			case EMPTY:
				return "EMPTY";
			case WHITE_BASE:
				return "WHITE_BASE";
			case GRAY_1_BASE:
				return "GRAY_1_BASE";
			case GRAY_2_BASE:
				return "GRAY_2_BASE";
			case RED_BASE:
				return "RED_BASE";
			case GREEN_BASE:
				return "GREEN_BASE";
			case BLACK:
				return "BLACK";
			case WHITE:
				return "WHITE";
			case GRAY:
				return "GRAY";
			case RED:
				return "RED";
			case GREEN:
				return "GREEN";
			case BLUE:
				return "BLUE";
			case LIGHT_RED:
				return "LIGHT_RED";
			case LIGHT_GREEN:
				return "LIGHT_GREEN";
			case LIGHT_BLUE:
				return "LIGHT_BLUE";
			case DARK_RED:
				return "DARK_RED";
			case DARK_GREEN:
				return "DARK_GREEN";
			case DARK_BLUE:
				return "DARK_BLUE";
			case YELLOW:
				return "YELLOW";
			case PURPLE:
				return "PURPLE";
			case TEAL:
				return "TEAL";
			default:
				return "0x" + Integer.toHexString(color).toUpperCase();
		}
	}
	
	private void assertColor(int expected, int actual) {
		assertEquals(getColorName(expected), getColorName(actual));
	}
}
