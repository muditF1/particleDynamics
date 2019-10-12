/**
 * This interface represents a set of operations on any newtonian particle. A newtonian particle is
 * a particle that obeys Newton's laws of motion.
 */
public interface Particle {
  /**
   * Return the state of Newtonian particle as a formatted string. The format of the string is as
   * follows: At time [t]: position is ([x],[y]) where [t] is the time passed to this method,
   * rounded to two decimal places [x] is the x-coordinate of the position of this particle at this
   * time, rounded to two decimal places [y] is the y-coordinate of the position of this particle at
   * this time, rounded to two decimal places
   *
   * @param time the time at which the state must be obtained
   * @return the state of the particle as a string formatted as above
   */
  String getState(float time);
}
