# Camera Controls

So far we've had a stationary point of view, while GigaGal moves around the screen. That puts some pretty severe limits on our level design, given that we only have one screen's worth of platforms to work with. Let's fix that by allowing the camera to follow GigaGal around the screen. While we're at it, we'll also remove the floor at the bottom of the screen, and detect when GigaGal has fallen to her doom.

Finally, while a chase camera is great, for debug purposes it'd sure be useful to be able to move the camera independently from GigaGal's position, so we'll add in debug cameras controls as well.

# Chase Camera

Let's get the heavy lifting out of the way first, by adding a chase cam that follows GigaGal around the level.

Check out the TODOs to get started!
