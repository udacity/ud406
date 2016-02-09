# The Enemies

Let's specify the behavior of our enemies. Each enemy will have a particular platform that they're associated with, and they'll patrol from one end of the platform to the other, then turn around and come back. Since they seem to be floating using some sort of anti-gravity, let's also have them bob up and down a bit as they move.

Next we need to decide how to make our enemies dangerous. We could create some sort of health system, and subtract GigaGal's health when she touches an enemy. What I think would be fun though is for GigaGal to go flying back when she touches an enemy, possibly falling off all the platforms to her certain doom.


# Enemy Sprites Sighted!

First things first, setting up and drawing the enemy assets.

This process should be familiar at this point. We need to set up a inner class for the EnemyAssets in our Assets singleton, then we'll draw the Enemy sprite in the render method of gameplay screen.

Start off in `Constants.java`, and good luck! Check out the TODOs to find everything you'll need to do.
