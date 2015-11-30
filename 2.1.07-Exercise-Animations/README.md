# Animations

When GigaGal runs, we want to be able to cycle through multiple frames to show her legs moving, just like a movie cycles through frames to create the illusion of smooth motion. This is such a common pattern that LibGDX provides an Animation class to help.

An Animation consists of an array of textures, a duration, and a playmode. Then, when you want to use an animation, you supply it with the current time, and the Animation returns the appropriate texture to draw.

In this exercise, you'll create GigaGal's run loop, and will explore how to create more complex effects, like a bunch of explosions going off!

Check out the TODOs to get started!
