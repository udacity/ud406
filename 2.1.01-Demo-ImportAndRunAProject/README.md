# Importing and Running Your First LibGDX Project

Let's review how to import and run a LibGDX project. Open up Android Studio, and close any open projects until you get to the splash screen. On the Quick Start pane, select Import project. You can then click the second button from the left to jump to the desktop. If you don't see the ud406 folder, you can click the blue circle arrows to refresh the file picker. Once you can see the ud406 folder, navigate to 2.1.01-ImportAndRunAProject, and click OK.

Now that the project is imported, let's get it fired up!

## Running the Desktop Backend

The simplest way to run the desktop backend is to ask Gradle to execute the `run` task on the
`desktop` subproject:

```
    $ ./gradlew desktop:run
```

It's nice to be able to run the project using Ctrl-r, and to do that we can set up a run configuration.  Navigate to Run > Edit Configurations...

Then click the plus button at the upper right, and select Gradle in the dropdown. We'll call this run configuration "Desktop". In the Gradle Project field you can just start typing "desktop" and it'll figure out you want the desktop module of the LibGDX project. Finally, the Task we want to run is ":desktop:run". Hit OK, and we're good to go. Unfortunately you'll have to do this with every project you import, as these run configurations are stored in the same place as user-specific stuff like the theme you're using, which it doesn't make sense to check into Git.

Anyway, now that check the drop down in the toolbar says Desktop, and hit the green arrow, or just press Ctrl-r. Beautiful Udacity Orange, and, as a bonus, if you click and drag around, you get some awesome particle effects!

## Running the Android Backend

Running the Android backend is actually easier than running the Desktop backend, assuming you've already [set up your Android device](https://www.udacity.com/course/viewer#!/c-ud808/l-4216368924/m-4291353613). Click on the run configuration
dropdown in the toolbar, and switch back to "Android", then hit the green button, or press Ctrl-r.

For completeness's sake, if you want to launch the Android backend from the command line, the tasks you need are:

```
    $ ./gradlew android:installDebug android:run
```

# Bonus questions

In future programming quizzes, there will be TODOs scattered through the code, showing what you'll need to change or add to achieve the desired functionality. In this demo, we've just included some questions for you. You can find them by opening up the TODOs pane at the bottom left of Android Studio.


