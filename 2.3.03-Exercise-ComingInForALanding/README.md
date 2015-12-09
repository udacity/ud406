# Landing on Platforms

Let's think about the logic that GigaGal will use for determining if she has landed on a particular platform. First, let's say that the area between the toes of her sprite is her "stance", and if any part of her stance is on top of a platform, she's standing on it. That means she can be standing on the tip of her toes, but still won't fall.

So first, how to we make GigaGal switch from Falling to Grounded when her stance lands on top of a platform? And how can we also make sure that she falls off again when she walks off the edge of a platform?

Here's the approach we're going to take. First, we'll need to start keeping track of GigaGal's position in the previous frame. Then, for each platform, we check if the y position of GigaGal's feet was at or above the platform's top in the previous frame, and below the platform's top this frame. If so, we know we may have landed on the platform. However, that'll be true even if the platform whose top we fell past is way off on the other side of the level.

Next we need to check if GigaGal's stance intersects with the horizontal reach of the platform she fell past. There are three cases where this is so. Either her left toe is on the platform, and/or her right toe in on the platform, or she's straddling the platform. We can check each of those cases with a couple inequalities. If one or more of those cases is true, we've landed on the platform!

Check out the TODOs to get GigaGal jumping on top of stuff! Remember to set your constants first!
