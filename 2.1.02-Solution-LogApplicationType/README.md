# The GDX Object

Remember that the central object of your game is an object that implements the [Application](https://libgdx.badlogicgames.com/nightlies/docs/api/com/badlogic/gdx/Application.html) protocol. That object is created by LibGDX, and the specific object used depends on what platform you game is running on.
 
Then the code you write lives in an [ApplicationListener](https://libgdx.badlogicgames.com/nightlies/docs/api/com/badlogic/gdx/ApplicationListener.html), that receives callbacks when it's time for your game logic to do something.

LibGDX also gives you access to many of the capabilities of the platform your game is running on, and it does so by supplying you with a set of static objects, which are all held by an object called [`Gdx`](https://libgdx.badlogicgames.com/nightlies/docs/api/com/badlogic/gdx/Gdx.html).

For instance, [`Gdx.net`](https://libgdx.badlogicgames.com/nightlies/docs/api/com/badlogic/gdx/Net.html) allows access to the platform's networking capabilities, and [`Gdx.input`](https://libgdx.badlogicgames.com/nightlies/docs/api/com/badlogic/gdx/Input.html) is where we went to get user input information in the last course.

In passing, we also used [`Gdx.app`](https://libgdx.badlogicgames.com/nightlies/docs/api/com/badlogic/gdx/Application.html), which actually holds a reference to the Application that is hosting your ApplicationListener.

The application has a ton of interesting capabilities, but the most obviously useful include finding out what platform your game is running on, accessing application or user preferences, and logging messages.

# Logging with Gdx.app

Your hosting Application has built-in logging that can be used with no setup and without the need for external libraries. Depending on the platform your game is running on, the log messages will always be directed to the appropriate place, such as to the console (Desktop) or logcat (Android). You can use the logging functionality as follows: 

```
public final static String TAG = "MyClass"; 

Gdx.app.log(TAG, "This is my message");

```

There are 3 types of logging in LibGDX: debug, info, and error. Each can optionally take a throwable for further logging. You can also adjust the logging level of your application as follows:

```
Gdx.app.setLogLevel(Application.LOG_NONE); // Don't log anything
Gdx.app.setLogLevel(Application.LOG_ERROR); // Never mind. Only log error messages.
Gdx.app.error(TAG, "Oh nooooo! We're about to crash or display an error message to the user", throwable);
Gdx.app.setLogLevel(Application.LOG_INFO); // Log informational messages as well as error messages
Gdx.app.log(TAG, "Player leveled up!"); 
Gdx.app.setLogLevel(Application.LOG_DEBUG); // Actually, you know what, log everything
Gdx.app.debug(TAG, "Experimental feature worked!");
```

You should in general use INFO (log function) for informational messages like notifying that textures or saved data have finished loading, DEBUG (debug function) for features that you are verifying or testing, and ERROR (error function) for blocks of code that will precede a crash or error message.

Remember, `System.out.println()` is not a cross-platform solution. Always use the methods in `Gdx.app` for logging. You can find more information on logging in the [LibGDX wiki](https://github.com/libgdx/libgdx/wiki/Logging).

# Logging Exercise

In this exercise, you'll use `Gdx.app` to find and log what type of device your game is running on! 

If you open up the TODOs pane at the bottom left of Android Studio, you'll see a list of steps you'll need to complete. If any of those steps gives you trouble, or if you just want to see our solution, you can find it (annotated with the same TODOs) in the 2.1.02-Solution-LogApplicationType folder.  

Check out the TODOs to get started.
