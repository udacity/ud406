# Hit Detection

In this exercise we'll make GigaGal's bullets deadly to the dastardly enemy robots. We'll define an enemy hit detection radius, and then check each frame to see if the center of any bullets are within that radius. If so, we remove the bullet from the level and decrement the enemy health. If the enemy has no health left, we remove the enemy from the level as well.
 
Check out the TODOs to get started! You'll probably want to start off in `Constants.java`.
