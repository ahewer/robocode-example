package bot.strategy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TurnAngleStrategy {

  private static final Logger logger = LogManager.getLogger(TurnAngleStrategy.class);

  // Turn 90 degrees to the bullet direction based on the bearing
  public double computeFromBearing(double bearing) {
    var result = 90 - bearing;
    logger.debug("Computed turn angle for " + bearing + ": " + result);
    return result;
  }
}
