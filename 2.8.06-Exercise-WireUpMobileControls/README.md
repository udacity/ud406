# Wiring up Mobile Controls

Now that we have our mobile controls on screen let's make them work! This will require a bit of refactoring in `GigaGal`, but it's not too tough. First we need to set our `OnscreenControls` class as an `InputAdapter`. Then we can listen for `touchDown()`, `touchUp()`, and `touchDragged()` events to figure out what buttons are being pressed.

The shoot control is the easiest. We can factor the shooting logic in `GigaGal` into its own method, then watch for a touchDown event within the shoot button, and call the shoot method.
 
The jump control is harder, as we need to allow for the jump button being held down. The touch events are identified with a certain pointer, so when a touch comes down within the jump button, we hold onto that pointer ID, and tell `GigaGal` that the button is down. Then, in `render()`, we check to see if that pointer is still down. If not, we tell `GigaGal` that the jump button is no longer pressed.

The movement controls are definitely the hardest. They're handled similarly to the jump button, but we discovered in testing that players really want to be able to slide their finger from the move left button to the move right button, and vice versa. That means we need to watch `touchDragged()`, and detect when a touch that came down in the left button has been dragged into the right button, inform `GigaGal` that this has happened, and tag that pointer ID as now a touch that came down in the right button (or the other way around).

Finally, for debug purposes we have been displaying the mobile controls on the desktop backend. Let's add some checks to ensure that the mobile controls are only displayed on mobile devices.

Check out the TODOs in the course code!
