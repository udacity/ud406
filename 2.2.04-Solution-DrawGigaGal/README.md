# Draw GigaGal

Let's pull our drawing logic out of `GameplayScreen` and into `GigaGal` herself. We'll also start to flesh out the `GigaGal` and `Level` classes.

The only tricky thing we need to deal with is the relationship between GigaGal's position and where we draw her sprite. We're going to be drawing GigaGal using a bunch of different sprites (for jumping, walking, standing, etc.), and we want to make sure that it doesn't look like she's moving around when we switch sprites. Therefore, GigaGal's `position` is a `Vector2` that defines not the location of her feet or her bottem left corner, but rather the center of her head. Actually, her eye is a convinient reference point.

We've designed all GigaGal's sprites such that her eye is in the exact same place in the image. That way, when we go to draw GigaGal, we can draw all the sprites in the same way. Check out the TODOs in the course code to see what we mean.

We recommend tacking the TODOs in the following order:

1. Constants
2. GigaGal
3. Level
4. GameplayScreen


