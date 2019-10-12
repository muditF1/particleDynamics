/**
 * This class represents a simple Newtonian particle. It has an initial position (x,y) and an
 * initial velocity (vx,vy).
 */
public class SimpleProjectile implements Particle {
  private static final float gravity = 9.81f;
  private float x;
  private float y;
  private float vx;
  private float vy;

  /**
   * Constructs Simple Projectile.
   *
   * @param x starting X position.
   * @param y starting Y position.
   * @param vx starting X vector velocity.
   * @param vy starting Y vector velocity.
   */
  public SimpleProjectile(float x, float y, float vx, float vy) {
    this.x = x;
    this.y = y;
    this.vx = vx;
    this.vy = vy;
  }

  /**
   * gets the current state of the Newtonian particle.
   *
   * @param time Time at which particle's state needs to be determined.
   */
  public String getState(float time) {
    float xDisplacement = 0.00f;
    float yDisplacement = 0.00f;
    String result;
    /* Check if vy is zero */
    if (vy == 0) {
      result = "Particle location cannot be determined as it is moving infinitely along X axis.";
    } else {
      /* make sure that the time is non-negative */
      if (time > 0.00f) {
        // Calculate max. flight time
        float maxTime = (2.00f * vy) / gravity;

        /* calculate X coordinate by default for max flight time */
        xDisplacement = vx * maxTime;

        /* calculate X & Y coordinates according to flight time*/
        if (time < maxTime) {
          xDisplacement = vx * time;
          yDisplacement = vy * time - (gravity * time * time) / 2.00f;
        }
      }

      result =
          "At time "
              + String.format("%.2f", time)
              + ": position is ("
              + String.format("%.2f", x + xDisplacement)
              + ","
              + String.format("%.2f", y + yDisplacement)
              + ")";
    }

    return result;
  }
}
