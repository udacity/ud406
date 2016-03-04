# Load the Rest

We're almost done loading up the level! Now that we have an exit portal to load, we'll load it, along with GigaGal's spawn location, and the location of any powerups that have been placed about the level.

To do this, first we need to get the array of images that we placed in the level. Then, for each image, we'll save off its location. Note that the location stored in the level file is actually the bottom left corner of the image. Then we'll figure out if it's GigaGal, the exit portal, or a powerup. Finally, we'll all a new object of the appropriate type to the level, making sure we use the proper offset, so the bottom left corner of the in-game object matches where we placed the bottom left corner of the image in the level editor.

All the TODOs you'll need to handle are in `LevelLoader.java`. Best of luck! Note that we've already completed the code to load up GigaGal, as an example.
