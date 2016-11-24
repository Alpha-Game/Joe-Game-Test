package test.joe.game.platformer.physics;

import joe.classes.geometry2D.Rectangle2D;
import joe.game.layout.implementation.LayoutCalculator;
import joe.game.platformer.physics.PhysicsCalculator;
import junit.framework.TestCase;

public class PhysicsCalculatorTest extends TestCase {
	public void test_isCollision_TopLeftCorner_NoCollision() {
		Rectangle2D rect1 = LayoutCalculator.createRectangle(4, 4, 4, 4);
		Rectangle2D rect2 = LayoutCalculator.createRectangle(1, 1, 2, 2);
		assertEquals(false, PhysicsCalculator.isCollision(rect1, rect2));
	}
	
	public void test_isCollision_TopLeftCorner_isCollision() {
		Rectangle2D rect1 = LayoutCalculator.createRectangle(4, 4, 4, 4);
		Rectangle2D rect2 = LayoutCalculator.createRectangle(2, 2, 2, 2);
		assertEquals(true, PhysicsCalculator.isCollision(rect1, rect2));
	}
	
	public void test_isCollision_TopLeftCorner_isIntersection() {
		Rectangle2D rect1 = LayoutCalculator.createRectangle(4, 4, 4, 4);
		Rectangle2D rect2 = LayoutCalculator.createRectangle(3, 3, 2, 2);
		assertEquals(true, PhysicsCalculator.isCollision(rect1, rect2));
	}
	
	public void test_isCollision_TopLeftCorner_NoCollision_Reverse() {
		Rectangle2D rect1 = LayoutCalculator.createRectangle(4, 4, 4, 4);
		Rectangle2D rect2 = LayoutCalculator.createRectangle(1, 1, 2, 2);
		assertEquals(false, PhysicsCalculator.isCollision(rect2, rect1));
	}
	
	public void test_isCollision_TopLeftCorner_isCollision_Reverse() {
		Rectangle2D rect1 = LayoutCalculator.createRectangle(4, 4, 4, 4);
		Rectangle2D rect2 = LayoutCalculator.createRectangle(2, 2, 2, 2);
		assertEquals(true, PhysicsCalculator.isCollision(rect2, rect1));
	}
	
	public void test_isCollision_TopLeftCorner_isIntersection_Reverse() {
		Rectangle2D rect1 = LayoutCalculator.createRectangle(4, 4, 4, 4);
		Rectangle2D rect2 = LayoutCalculator.createRectangle(3, 3, 2, 2);
		assertEquals(true, PhysicsCalculator.isCollision(rect2, rect1));
	}
	
	public void test_isCollision_Top_NoCollision() {
		Rectangle2D rect1 = LayoutCalculator.createRectangle(4, 4, 4, 4);
		Rectangle2D rect2 = LayoutCalculator.createRectangle(5, 1, 2, 2);
		assertEquals(false, PhysicsCalculator.isCollision(rect1, rect2));
	}
	
	public void test_isCollision_Top_isCollision() {
		Rectangle2D rect1 = LayoutCalculator.createRectangle(4, 4, 4, 4);
		Rectangle2D rect2 = LayoutCalculator.createRectangle(5, 2, 2, 2);
		assertEquals(true, PhysicsCalculator.isCollision(rect1, rect2));
	}
	
	public void test_isCollision_Top_isIntersection() {
		Rectangle2D rect1 = LayoutCalculator.createRectangle(4, 4, 4, 4);
		Rectangle2D rect2 = LayoutCalculator.createRectangle(5, 3, 2, 2);
		assertEquals(true, PhysicsCalculator.isCollision(rect1, rect2));
	}
	
	public void test_isCollision_Top_NoCollision_Reverse() {
		Rectangle2D rect1 = LayoutCalculator.createRectangle(4, 4, 4, 4);
		Rectangle2D rect2 = LayoutCalculator.createRectangle(5, 1, 2, 2);
		assertEquals(false, PhysicsCalculator.isCollision(rect2, rect1));
	}
	
	public void test_isCollision_Top_isCollision_Reverse() {
		Rectangle2D rect1 = LayoutCalculator.createRectangle(4, 4, 4, 4);
		Rectangle2D rect2 = LayoutCalculator.createRectangle(5, 2, 2, 2);
		assertEquals(true, PhysicsCalculator.isCollision(rect2, rect1));
	}
	
	public void test_isCollision_Top_isIntersection_Reverse() {
		Rectangle2D rect1 = LayoutCalculator.createRectangle(4, 4, 4, 4);
		Rectangle2D rect2 = LayoutCalculator.createRectangle(5, 3, 2, 2);
		assertEquals(true, PhysicsCalculator.isCollision(rect2, rect1));
	}
	
	public void test_isCollision_TopRightCorner_NoCollision() {
		Rectangle2D rect1 = LayoutCalculator.createRectangle(4, 4, 4, 4);
		Rectangle2D rect2 = LayoutCalculator.createRectangle(9, 1, 2, 2);
		assertEquals(false, PhysicsCalculator.isCollision(rect1, rect2));
	}
	
	public void test_isCollision_TopRightCorner_isCollision() {
		Rectangle2D rect1 = LayoutCalculator.createRectangle(4, 4, 4, 4);
		Rectangle2D rect2 = LayoutCalculator.createRectangle(8, 2, 2, 2);
		assertEquals(true, PhysicsCalculator.isCollision(rect1, rect2));
	}
	
	public void test_isCollision_TopRightCorner_isIntersection() {
		Rectangle2D rect1 = LayoutCalculator.createRectangle(4, 4, 4, 4);
		Rectangle2D rect2 = LayoutCalculator.createRectangle(7, 3, 2, 2);
		assertEquals(true, PhysicsCalculator.isCollision(rect1, rect2));
	}
	
	public void test_isCollision_TopRightCorner_NoCollision_Reverse() {
		Rectangle2D rect1 = LayoutCalculator.createRectangle(4, 4, 4, 4);
		Rectangle2D rect2 = LayoutCalculator.createRectangle(9, 1, 2, 2);
		assertEquals(false, PhysicsCalculator.isCollision(rect2, rect1));
	}
	
	public void test_isCollision_TopRightCorner_isCollision_Reverse() {
		Rectangle2D rect1 = LayoutCalculator.createRectangle(4, 4, 4, 4);
		Rectangle2D rect2 = LayoutCalculator.createRectangle(8, 2, 2, 2);
		assertEquals(true, PhysicsCalculator.isCollision(rect2, rect1));
	}
	
	public void test_isCollision_TopRightCorner_isIntersection_Reverse() {
		Rectangle2D rect1 = LayoutCalculator.createRectangle(4, 4, 4, 4);
		Rectangle2D rect2 = LayoutCalculator.createRectangle(7, 3, 2, 2);
		assertEquals(true, PhysicsCalculator.isCollision(rect2, rect1));
	}
	
	public void test_isCollision_Left_NoCollision() {
		Rectangle2D rect1 = LayoutCalculator.createRectangle(4, 4, 4, 4);
		Rectangle2D rect2 = LayoutCalculator.createRectangle(1, 5, 2, 2);
		assertEquals(false, PhysicsCalculator.isCollision(rect1, rect2));
	}
	
	public void test_isCollision_Left_isCollision() {
		Rectangle2D rect1 = LayoutCalculator.createRectangle(4, 4, 4, 4);
		Rectangle2D rect2 = LayoutCalculator.createRectangle(2, 5, 2, 2);
		assertEquals(true, PhysicsCalculator.isCollision(rect1, rect2));
	}
	
	public void test_isCollision_Left_isIntersection() {
		Rectangle2D rect1 = LayoutCalculator.createRectangle(4, 4, 4, 4);
		Rectangle2D rect2 = LayoutCalculator.createRectangle(3, 5, 2, 2);
		assertEquals(true, PhysicsCalculator.isCollision(rect1, rect2));
	}
	
	public void test_isCollision_Left_NoCollision_Reverse() {
		Rectangle2D rect1 = LayoutCalculator.createRectangle(4, 4, 4, 4);
		Rectangle2D rect2 = LayoutCalculator.createRectangle(1, 5, 2, 2);
		assertEquals(false, PhysicsCalculator.isCollision(rect2, rect1));
	}
	
	public void test_isCollision_Left_isCollision_Reverse() {
		Rectangle2D rect1 = LayoutCalculator.createRectangle(4, 4, 4, 4);
		Rectangle2D rect2 = LayoutCalculator.createRectangle(2, 5, 2, 2);
		assertEquals(true, PhysicsCalculator.isCollision(rect2, rect1));
	}
	
	public void test_isCollision_Left_isIntersection_Reverse() {
		Rectangle2D rect1 = LayoutCalculator.createRectangle(4, 4, 4, 4);
		Rectangle2D rect2 = LayoutCalculator.createRectangle(3, 5, 2, 2);
		assertEquals(true, PhysicsCalculator.isCollision(rect2, rect1));
	}
	
	public void test_isCollision_Center_isIntersection() {
		Rectangle2D rect1 = LayoutCalculator.createRectangle(4, 4, 4, 4);
		Rectangle2D rect2 = LayoutCalculator.createRectangle(5, 5, 2, 2);
		assertEquals(true, PhysicsCalculator.isCollision(rect1, rect2));
	}
	
	public void test_isCollision_Center_isIntersection_Reverse() {
		Rectangle2D rect1 = LayoutCalculator.createRectangle(4, 4, 4, 4);
		Rectangle2D rect2 = LayoutCalculator.createRectangle(5, 5, 2, 2);
		assertEquals(true, PhysicsCalculator.isCollision(rect2, rect1));
	}
	
	public void test_isCollision_Right_NoCollision() {
		Rectangle2D rect1 = LayoutCalculator.createRectangle(4, 4, 4, 4);
		Rectangle2D rect2 = LayoutCalculator.createRectangle(9, 5, 2, 2);
		assertEquals(false, PhysicsCalculator.isCollision(rect1, rect2));
	}
	
	public void test_isCollision_Right_isCollision() {
		Rectangle2D rect1 = LayoutCalculator.createRectangle(4, 4, 4, 4);
		Rectangle2D rect2 = LayoutCalculator.createRectangle(8, 5, 2, 2);
		assertEquals(true, PhysicsCalculator.isCollision(rect1, rect2));
	}
	
	public void test_isCollision_Right_isIntersection() {
		Rectangle2D rect1 = LayoutCalculator.createRectangle(4, 4, 4, 4);
		Rectangle2D rect2 = LayoutCalculator.createRectangle(7, 5, 2, 2);
		assertEquals(true, PhysicsCalculator.isCollision(rect1, rect2));
	}
	
	public void test_isCollision_Right_NoCollision_Reverse() {
		Rectangle2D rect1 = LayoutCalculator.createRectangle(4, 4, 4, 4);
		Rectangle2D rect2 = LayoutCalculator.createRectangle(9, 5, 2, 2);
		assertEquals(false, PhysicsCalculator.isCollision(rect2, rect1));
	}
	
	public void test_isCollision_Right_isCollision_Reverse() {
		Rectangle2D rect1 = LayoutCalculator.createRectangle(4, 4, 4, 4);
		Rectangle2D rect2 = LayoutCalculator.createRectangle(8, 5, 2, 2);
		assertEquals(true, PhysicsCalculator.isCollision(rect2, rect1));
	}
	
	public void test_isCollision_Right_isIntersection_Reverse() {
		Rectangle2D rect1 = LayoutCalculator.createRectangle(4, 4, 4, 4);
		Rectangle2D rect2 = LayoutCalculator.createRectangle(7, 5, 2, 2);
		assertEquals(true, PhysicsCalculator.isCollision(rect2, rect1));
	}
	
	public void test_isCollision_BottomLeftCorner_NoCollision() {
		Rectangle2D rect1 = LayoutCalculator.createRectangle(4, 4, 4, 4);
		Rectangle2D rect2 = LayoutCalculator.createRectangle(1, 9, 2, 2);
		assertEquals(false, PhysicsCalculator.isCollision(rect1, rect2));
	}
	
	public void test_isCollision_BottomLeftCorner_isCollision() {
		Rectangle2D rect1 = LayoutCalculator.createRectangle(4, 4, 4, 4);
		Rectangle2D rect2 = LayoutCalculator.createRectangle(2, 8, 2, 2);
		assertEquals(true, PhysicsCalculator.isCollision(rect1, rect2));
	}
	
	public void test_isCollision_BottomLeftCorner_isIntersection() {
		Rectangle2D rect1 = LayoutCalculator.createRectangle(4, 4, 4, 4);
		Rectangle2D rect2 = LayoutCalculator.createRectangle(3, 7, 2, 2);
		assertEquals(true, PhysicsCalculator.isCollision(rect1, rect2));
	}
	
	public void test_isCollision_BottomLeftCorner_NoCollision_Reverse() {
		Rectangle2D rect1 = LayoutCalculator.createRectangle(4, 4, 4, 4);
		Rectangle2D rect2 = LayoutCalculator.createRectangle(1, 9, 2, 2);
		assertEquals(false, PhysicsCalculator.isCollision(rect2, rect1));
	}
	
	public void test_isCollision_BottomLeftCorner_isCollision_Reverse() {
		Rectangle2D rect1 = LayoutCalculator.createRectangle(4, 4, 4, 4);
		Rectangle2D rect2 = LayoutCalculator.createRectangle(2, 8, 2, 2);
		assertEquals(true, PhysicsCalculator.isCollision(rect2, rect1));
	}
	
	public void test_isCollision_BottomLeftCorner_isIntersection_Reverse() {
		Rectangle2D rect1 = LayoutCalculator.createRectangle(4, 4, 4, 4);
		Rectangle2D rect2 = LayoutCalculator.createRectangle(3, 7, 2, 2);
		assertEquals(true, PhysicsCalculator.isCollision(rect2, rect1));
	}
	
	public void test_isCollision_Bottom_NoCollision() {
		Rectangle2D rect1 = LayoutCalculator.createRectangle(4, 4, 4, 4);
		Rectangle2D rect2 = LayoutCalculator.createRectangle(5, 9, 2, 2);
		assertEquals(false, PhysicsCalculator.isCollision(rect1, rect2));
	}
	
	public void test_isCollision_Bottom_isCollision() {
		Rectangle2D rect1 = LayoutCalculator.createRectangle(4, 4, 4, 4);
		Rectangle2D rect2 = LayoutCalculator.createRectangle(5, 8, 2, 2);
		assertEquals(true, PhysicsCalculator.isCollision(rect1, rect2));
	}
	
	public void test_isCollision_Bottom_isIntersection() {
		Rectangle2D rect1 = LayoutCalculator.createRectangle(4, 4, 4, 4);
		Rectangle2D rect2 = LayoutCalculator.createRectangle(5, 7, 2, 2);
		assertEquals(true, PhysicsCalculator.isCollision(rect1, rect2));
	}
	
	public void test_isCollision_Bottom_NoCollision_Reverse() {
		Rectangle2D rect1 = LayoutCalculator.createRectangle(4, 4, 4, 4);
		Rectangle2D rect2 = LayoutCalculator.createRectangle(5, 9, 2, 2);
		assertEquals(false, PhysicsCalculator.isCollision(rect2, rect1));
	}
	
	public void test_isCollision_Bottom_isCollision_Reverse() {
		Rectangle2D rect1 = LayoutCalculator.createRectangle(4, 4, 4, 4);
		Rectangle2D rect2 = LayoutCalculator.createRectangle(5, 8, 2, 2);
		assertEquals(true, PhysicsCalculator.isCollision(rect2, rect1));
	}
	
	public void test_isCollision_Bottom_isIntersection_Reverse() {
		Rectangle2D rect1 = LayoutCalculator.createRectangle(4, 4, 4, 4);
		Rectangle2D rect2 = LayoutCalculator.createRectangle(5, 7, 2, 2);
		assertEquals(true, PhysicsCalculator.isCollision(rect2, rect1));
	}
	
	public void test_isCollision_BottomRightCorner_NoCollision() {
		Rectangle2D rect1 = LayoutCalculator.createRectangle(4, 4, 4, 4);
		Rectangle2D rect2 = LayoutCalculator.createRectangle(9, 9, 2, 2);
		assertEquals(false, PhysicsCalculator.isCollision(rect1, rect2));
	}
	
	public void test_isCollision_BottomRightCorner_isCollision() {
		Rectangle2D rect1 = LayoutCalculator.createRectangle(4, 4, 4, 4);
		Rectangle2D rect2 = LayoutCalculator.createRectangle(8, 8, 2, 2);
		assertEquals(true, PhysicsCalculator.isCollision(rect1, rect2));
	}
	
	public void test_isCollision_BottomRightCorner_isIntersection() {
		Rectangle2D rect1 = LayoutCalculator.createRectangle(4, 4, 4, 4);
		Rectangle2D rect2 = LayoutCalculator.createRectangle(7, 7, 2, 2);
		assertEquals(true, PhysicsCalculator.isCollision(rect1, rect2));
	}
	
	public void test_isCollision_BottomRightCorner_NoCollision_Reverse() {
		Rectangle2D rect1 = LayoutCalculator.createRectangle(4, 4, 4, 4);
		Rectangle2D rect2 = LayoutCalculator.createRectangle(9, 9, 2, 2);
		assertEquals(false, PhysicsCalculator.isCollision(rect2, rect1));
	}
	
	public void test_isCollision_BottomRightCorner_isCollision_Reverse() {
		Rectangle2D rect1 = LayoutCalculator.createRectangle(4, 4, 4, 4);
		Rectangle2D rect2 = LayoutCalculator.createRectangle(8, 8, 2, 2);
		assertEquals(true, PhysicsCalculator.isCollision(rect2, rect1));
	}
	
	public void test_isCollision_BottomRightCorner_isIntersection_Reverse() {
		Rectangle2D rect1 = LayoutCalculator.createRectangle(4, 4, 4, 4);
		Rectangle2D rect2 = LayoutCalculator.createRectangle(7, 7, 2, 2);
		assertEquals(true, PhysicsCalculator.isCollision(rect2, rect1));
	}
	
	public void test_isCollision_Self_isIntersection() {
		Rectangle2D rect1 = LayoutCalculator.createRectangle(4, 4, 4, 4);
		assertEquals(true, PhysicsCalculator.isCollision(rect1, rect1));
	}
	
	public void test_isCollision_VerticalEdge_isIntersection() {
		Rectangle2D rect1 = LayoutCalculator.createRectangle(4, 4, 4, 4);
		Rectangle2D rect2 = LayoutCalculator.createRectangle(5, 3, 2, 6);
		assertEquals(true, PhysicsCalculator.isCollision(rect1, rect2));
	}
	
	public void test_isCollision_VerticalEdge_isIntersection_Reverse() {
		Rectangle2D rect1 = LayoutCalculator.createRectangle(4, 4, 4, 4);
		Rectangle2D rect2 = LayoutCalculator.createRectangle(5, 3, 2, 6);
		assertEquals(true, PhysicsCalculator.isCollision(rect2, rect1));
	}
	
	public void test_isCollision_HorizontalEdge_isIntersection() {
		Rectangle2D rect1 = LayoutCalculator.createRectangle(4, 4, 4, 4);
		Rectangle2D rect2 = LayoutCalculator.createRectangle(3, 5, 6, 2);
		assertEquals(true, PhysicsCalculator.isCollision(rect1, rect2));
	}
	
	public void test_isCollision_HorizontalEdge_isIntersection_Reverse() {
		Rectangle2D rect1 = LayoutCalculator.createRectangle(4, 4, 4, 4);
		Rectangle2D rect2 = LayoutCalculator.createRectangle(3, 5, 6, 2);
		assertEquals(true, PhysicsCalculator.isCollision(rect2, rect1));
	}
}
