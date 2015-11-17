# The GDX Object

Remember that the central object of your game is an Application object, created by LibGDX. Then the code you write lives in an ApplicationListener, that receives callbacks when it's time for your game logic to do something.

LibGDX also gives you access to many of the capabilities of the platform your game is running on, and it does so by supplying you with a set of static objects, which are all held by an object called `Gdx`. 

For instance, Gdx.net allows access to the platform's networking capabilities, and Gdx.input is where we went to get user input information in the last course.

In passing, we also used Gdx.app, which actually holds a reference to the Application that is hosting your ApplicationListener.

The application has a ton of interesting capabilities, but the most obviously useful include finding out what platform your game is running on, accessing application or user preferences, and logging useful messages.

# Logging with Gdx.app

LibGdx has built-in logging that can be used with no setup and without the need for external libraries. The following code snippet will log text to the console(Desktop) or logcat(Android). 

```
public final static String TAG = "MyClass"; 

Gdx.app.log(TAG, "This is my message");

```

There are 3 logging levels in LibGDX: info, debug, and error. Each can optionally take a throwable for further logging.

```
Gdx.app.log(TAG, "Informational message!");
Gdx.app.debug(TAG, "Did this work?!");
Gdx.app.error(TAG, "Oh nooooo!", throwable);
```


You should in general use INFO (log function) for informational messages like notifying that textures or saved data have finished loading, DEBUG(debug function) for features that you are verifying or testing, and ERROR(error function) for blocks of code that will precede a crash or error message.

Remember, `System.out.println()` is not a cross-platform solution. Always use `Gdx.app` for logging.

# Logging Exercise

In this exercise, you'll use `Gdx.app` to find and log what type of device your game is running on! 

If you open up the TODO pane at the bottom left of Android Studio, you'll see a list of steps you'll need to complete. If any of those steps gives you trouble, or if you just want to see our solution, you can find it (annotated with the same TODOs) in the 2.1.02-Solution-LogApplicationType folder.  

Check out the TODOs to get started.
