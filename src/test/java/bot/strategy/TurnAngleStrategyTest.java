package bot.strategy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TurnAngleStrategyTest {

  // subject under test
  private final TurnAngleStrategy strategy = new TurnAngleStrategy();

  @Test
  @DisplayName("Check if angle is computed correctly")
  public void correctAngleTest() {
    // Setup
    final double bearing = 10;

    // Compute angle
    final double result = strategy.computeFromBearing(bearing);

    // Strategy should turn left by 90 degrees based on bearing
    final double expectedAngle = 80;

    assertEquals(expectedAngle, result, "Turn angle was computed incorrectly.");
  }
}