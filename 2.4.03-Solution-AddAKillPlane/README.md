# Add a Killplane


So now GigaGal can fall forever, which is a bit of a Game Over in itself, but it's a bit harsh to lock up the game forever after one missed jump. Let's check to see when GigaGal has fallen below the level, and reset her to her starting location. This sort of mechanic is also known as a kill-plane.

To accomplish this, we need to differentiate between constructing GigaGal, and initializing GigaGal. In GigaGal's constructor, we just want to set up vectors to hold her position, spawn position, and last frame position. We'll then add an `init()` method that sets GigaGal standing, facing right, at her spawn position.

Then when GigaGal falls off the level, we can just call `init()` to set her back up at the start of the level.

