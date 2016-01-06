# File Loading

Games often rely heavily on file assets like images, sounds, level specifications, and so on. LibGDX provides a [Gdx.files](https://libgdx.badlogicgames.com/nightlies/docs/api/com/badlogic/gdx/Files.html) object to wrap access to your assets. There are few ways to use the files object, but for this class we'll just be using `Gdx.files.internal()` to access private files packaged with our game.

Where should we put those files? You might think they would belong in the `core` module, since that's where our shared code goes, but it turns out that the more elegant solution (from the point of the LibGDX build process) is to put all your assets in the `android/assets` directory. The reason has to do with the rather convoluted process of building an Android app, and the fact that the Android build system needs to know about all assets before it starts compiling any source code.

For more information on file handling in LibGDX, check out [this page](https://github.com/libgdx/libgdx/wiki/File-handling) of the LibGDX wiki. 

# File Loading Exercise

If you look in the "android/assets" directory you'll find the punchline to a hilarious joke. Unfortunately, it's encrypted, so I guess you'll have to use Gdx.files to read it in to a String, decrypt it, and use Gdx.app to log it. Note that this exercise only works on the Desktop backend.

Check out the TODOs to get started!
