# Walk Loop

Let's Give GigaGal an awesome walk animation! First we need to load up the rest of the walking sprites and package them into an Animation.

Then we need to modify GigaGal to keep track of how long she's been walking, and finally we can fetch and render the correct frame as GigaGal walks.

The only trick is figuring out how we want to structure our Animation. When GigaGal is facing right, we have a frame with GigaGal's left foot forward, a frame with both her feet together, and a frame with her right foot forward. We want to display a sequence with her feet going like: together, right, together, left, together, and so on. We could use a PINGPONG animation (right, together, left) for this, but it looks most natural for the first frame of the walk animation to be the one with GigaGal's feet together. Therefore it's actually easier to make a normal looping animation (together, right, together, left).
 
Check out the TODOs to make it happen!
 
As usual, the suggested order is:

1. `Constants.java`
2. `Assets.java`
3. `GigaGal.java`


