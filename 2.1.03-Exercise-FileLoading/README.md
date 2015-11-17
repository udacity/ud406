# File Loading


Games often rely heavily on file assets like textures, sounds, level specifications, and so on. LibGDX provides a Gdx.files object to wrap access to your assets. There are few ways to use the files object, but for this class we'll just be using Gdx.files.internal() to access private files packaged with our game.

Where should we put those files? Well 

Since there are four backends and we would rather not have to 



You can use this if you know the absolute path to a file, but, don't.

You'd use this to access a file on the app's classpath. Files accessed this way have some restrictions based on the platform so in general, also, don't.

Use this to access and create files that you want other apps to access. On mobile, these files are saved on the SD card and on desktop, they are relative to your home directory.

99.9% of the time, the files you access will be assets for your game that no other apps should access. On mobile, these are relative to the assets directory and on desktop, it's relative to your apps root directory

Local files are private to your app. Use these for user-specific settings, local cache for achievements, etc

There's one key thing to remember during development. LibGDX treats your android/assets directory as the source of truth for what should be bundled with your app. Always make sure that is where you are saving internal files.

# File Loading Exercise

If you look in the "android/assets" directory you'll find the punchline to a hilarious joke. Unfortunately, it's encrypted, so I guess you'll have to use Gdx.files to read it in to a String, decrypt it, and use Gdx.app to log it.

Check out the TODOs to get started!
