# Jumping!

Now that we can move, let's let GigaGal jump, and let's design her jumping system so she can vary how high she goes.

Here's how jumping will work. GigaGal can be in one of three possible JumpStates. She can be on the ground (which we'll call GROUNDED), she can be FALLING, or she can be in the process of JUMPING.

If she's GROUNDED, and the player hits the jump button, three things happen. First, we set GigaGals's JumpState to JUMPING. Second, we set GigaGal's vertical speed to some pre-definied value. Third, we save the time at which the jump starts.

When GigaGal is in the JUMPING JumpState, every frame we check to see if the jump button is still pressed. If not, we set JumpState to FALLING. If the jump button is still pressed, we then check how long it's been since the jump started. If it's been longer than some predetermined time, the jump is over, and it's also time to set GigaGal's state to FALLING. Otherwise, we again set her vertical velocity to the same predetermined jump speed.

Finally, when GigaGal is falling, we simply apply gravitational acceleration, and ignore the jump button.

Check out the TODOs to make GigaGal bouncy! Note that you'll probably want to set up the constants and JumpState enum first.
