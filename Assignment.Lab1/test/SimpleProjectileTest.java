import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * unit test suite for SimpleParticle class implementation.
 *
 * @author Mudit.
 */
public class SimpleProjectileTest {
  @Test
  public void testStateWhenAllValuesPositive() {
    Particle particleObj = new SimpleProjectile(10, 10, 5, 5);
    String result = particleObj.getState(0.80f);
    assertEquals("At time 0.80: position is (14.00,10.86)", result);
  }

  @Test
  public void testStateWhenPositionValuesNegative() {
    Particle particleObj = new SimpleProjectile(-10, -10, 5, 5);
    String result = particleObj.getState(0.80f);
    assertEquals("At time 0.80: position is (-6.00,-9.14)", result);
  }

  @Test
  public void testStateWhenValuesInDecimal() {
    Particle particleObj = new SimpleProjectile(11.80f, 7.91f, 5.44f, 8.25f);
    String result = particleObj.getState(0.80f);
    assertEquals("At time 0.80: position is (16.15,11.37)", result);
  }

  @Test
  public void testStateWhenThrownInVerticalDirection() {
    Particle particleObj = new SimpleProjectile(11.80f, 7.91f, 0.00f, 8.25f);
    String result = particleObj.getState(1.80f);
    assertEquals("At time 1.80: position is (11.80,7.91)", result);
  }

  @Test
  public void testStateWhenThrownInHorizontalDirection() {
    Particle particleObj = new SimpleProjectile(11.80f, 7.91f, 5.44f, 0.00f);
    String result = particleObj.getState(5.00f);
    assertEquals(
        "Particle location cannot be determined as it is moving infinitely along X axis.", result);
  }

  @Test
  public void testStateWhenTimeIsNegative() {
    Particle particleObj = new SimpleProjectile(10, 10, 5, 5);
    String result = particleObj.getState(-1.0f);
    assertEquals("At time -1.00: position is (10.00,10.00)", result);
  }

  @Test
  public void testStateWhenTimeExceedsOverallTimeofFlight() {
    Particle particleObj = new SimpleProjectile(10, 10, 10, 5);
    String result = particleObj.getState(10.0f);
    assertEquals("At time 10.00: position is (20.19,10.00)", result);
  }

  @Test
  public void testStateWhenInputExtremeValues() {
    Particle particleObj = new SimpleProjectile(330, 230, 10000, 1000);
    String result = particleObj.getState(100.0f);
    assertEquals("At time 100.00: position is (1000330.00,51180.00)", result);
  }
}
