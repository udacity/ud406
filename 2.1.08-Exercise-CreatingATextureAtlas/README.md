# Texture Atlas

Loading individual files is fine if you have one or two images to load but it becomes more and more inefficient and possibly even more error-prone as you need to load more images in your game.

[`TextureAtlas`](https://libgdx.badlogicgames.com/nightlies/docs/api/com/badlogic/gdx/graphics/g2d/TextureAtlas.html) to the rescue! Instead of inefficiently loading a bunch of smaller files and have your game act weirdly or crash because you tried to use an image before it was loaded, you can package all of your images into a single file and only pay the penalty for loading once.

In this exercise, we've set up a task in the Gradle build process that will use a tool called [TexturePacker](https://github.com/libgdx/libgdx/wiki/Texture-packer) to package all images in `core/rawAssets/sprites` into a texture atlas at `android/assets/images`. You can check out the TODOs in the build.gradle file to see how that works. TexturePacker creates 2 files, an atlas with all the images and a pack file describing where the images are in the atlas, along with their rotation and scaling.

Then follow the TODOs to use an [`AssetManager`](https://libgdx.badlogicgames.com/nightlies/docs/api/com/badlogic/gdx/assets/AssetManager.html) to load the atlas, and extract an [`AtlasRegion`](https://libgdx.badlogicgames.com/nightlies/docs/api/com/badlogic/gdx/graphics/g2d/TextureAtlas.AtlasRegion.html) object that contains a reference to the `Texture` that contains all the sprites, and the region within that larger texture that contains the image we want.

Finally we can use a `SpriteBatch` to draw our `AtlasRegion`. Note that if you just draw the `Texture` from an `AtlasRegion`, you actually draw the entire atlas. You'll need to use the version of `SpriteBatch.draw()` that allows you to specify what region of a `Texture` you want to draw.
