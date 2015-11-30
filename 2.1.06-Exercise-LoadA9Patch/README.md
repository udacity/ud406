# NinePatch

We talked earlier about texture filtering, and how that lets you draw textures at whatever size you want. However, check out the buttons in your operating system. No matter how big they are, they always have nice rounded corners, and the same smooth gradient on the sides. If we created those buttons of different sizes by drawing the same texture at different scales, they would look stretched out, and the corners wouldn't maintain their nice curve.

The way buttons are drawn (and the way we'll draw GigaGal's platforms) is using what's called a 9 patch.

If you look at a button, there are four corners that don't stretch at all. The there are the four edges that do stretch, but only in one direction. Finally, there's the middle of the button, which stretches in both directions.

For more info on ninepatches, check out the LibGDX documentation, and [this article](https://github.com/libgdx/libgdx/wiki/Ninepatches) in the LibGDX wiki.

In this exercise, we'll load up the [`Texture`](https://libgdx.badlogicgames.com/nightlies/docs/api/com/badlogic/gdx/graphics/Texture.html) for GigaGal's platforms, then turn it into a [`NinePatch`](https://libgdx.badlogicgames.com/nightlies/docs/api/com/badlogic/gdx/graphics/g2d/NinePatch.html) by specifying what parts of the texture are stretchy. Check out the TODOs to get started. 
