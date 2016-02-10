# Police the Plasma

Right now we have the same issue we ran into back when we were making icicles fall down the screen: the bullets are just flying on forever, hitting characters in the next game over. Or, you know, more practically, eventually slowing the game down.

Let's add an active flag to the bullets, then check to see when the bullets are outside the viewport. If so, we'll set active to false. Then in the Level, we'll check which bullets are no longer active, and remove them from the bullets array.
 
Check out the TODOs to get started!

