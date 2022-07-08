package bot;

import bot.strategy.TurnAngleStrategy;
import dev.robocode.tankroyale.botapi.*;
import dev.robocode.tankroyale.botapi.events.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// ------------------------------------------------------------------
// MyFirstBot
// ------------------------------------------------------------------
// A sample bot original made for Robocode by Mathew Nelson.
// Ported to Robocode Tank Royale by Flemming N. Larsen.
//
// Probably the first bot you will learn about.
// Moves in a seesaw motion, and spins the gun around at each end.
// ------------------------------------------------------------------
public class MyFirstBot extends Bot {

    private static final Logger logger = LogManager.getLogger(MyFirstBot.class);
    private final TurnAngleStrategy turnAngleStrategy = new TurnAngleStrategy();

    // The main method starts our bot
    public static void main(String[] args) {
        logger.info("Starting my bot.");
        new MyFirstBot().start();
    }

    // Constructor, which loads the bot config file
    MyFirstBot() {
        super(BotInfo.fromFile("MyFirstBot.json"));
    }

    // Called when a new round is started -> initialize and do some movement
    @Override
    public void run() {
        // Repeat while the bot is running
        while (isRunning()) {
            forward(100);
            turnGunRight(360);
            back(100);
            turnGunRight(360);
        }
    }

    // We saw another bot -> fire!
    @Override
    public void onScannedBot(ScannedBotEvent e) {
        logger.debug("Firing at detected bot!");
        fire(1);
    }

    // We were hit by a bullet -> turn perpendicular to the bullet
    @Override
    public void onHitByBullet(HitByBulletEvent e) {
        // Calculate the bearing to the direction of the bullet
        var bearing = calcBearing(e.getBullet().getDirection());
        // Compute turn angle based on bearing
        var turnAngle = turnAngleStrategy.computeFromBearing(bearing);
        turnLeft(turnAngle);
    }

}
