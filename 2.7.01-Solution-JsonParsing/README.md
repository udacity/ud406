# Level Loading

In this exercise we'll talk about how to use the Overlap2D level editor to create levels for GigaGal, and then we'll start work on loading up those levels so you can play them!

## Level Editing

Games are a team effort. You, the developer, are often working with a designer, who decides how the game should work. It's then your job to bring their designs to life. Even when you're working alone, it's a good idea to keep these two jobs somewhat separate.

Take your level design, for instance. You don't want to have to write Java and recompile your game every time you move a platform or add a new enemy. Ideally you'd like to use some external, purpose-built level editing tool to create a level file, which can then be loaded by your game.


## Using Overlap2D

Overlap2D is a game level and content editor for all desktop platforms where Java runs. We're using it for GigaGal because Overlap2D makes it easy to create levels. Overlap2D also allows us to separate visuals from the code. So if you have an artist friend or partner who doesn't code, they will be able to create engaging levels with no code. Though we won't cover it here, there is also support for lighting, physics, particle effects, as well as a pluggable API.

We've included a copy of Overlap2D in the root of this repository, or you can download a copy from http://overlap2d.com/

Let's create a new project(File -> New Project) and call it, GigaGalLevels. The Original Size is the dimensions of your complete level all across all screens. It's fine to leave it at the default of 1920 x 1200. Pixels per WUnit stands for pixels per world unit. This is mainly useful when you have a very large world that would be hard to manage in pixels. For GigaGal, we measure the world in pixels so change this to 1. That way we don't have to convert the output of Overlap2D before we display a level.

This area is the scene. It holds all the components of your level. A project comes with a single scene called MainScene with nothing in it. You can create another level by selecting File -> Scenes -> Create New Scene. Name it Level1

Let's add some platforms. Navigate to File -> Import Resources. From here you can import the GigaGal assets. It's important to note that drag and drop doesn't work on all platforms. Include  `standing-right.png`, the powerup, the platform, the enemy, and the first frame of the exit portal.

Just one step left before we can build a level from our resources. We need to convert our platform graphic into a 9patch. You can do this by dragging a platform into the scene, right clicking, and selecting "convert to NinePatch". If the "Convert to NinePatch" option isn't available, you can use [this tool](http://developer.android.com/tools/help/draw9patch.html) to  make your platform into a ninepatch.

One final detail: we'll only use enemy graphic in our level as a marker. To actually specify that we a platform needs an enemy on it, we'll give it the identifier "Enemy".

## Level Loading

Let's get started loading up the level we defined in Overlap2D. The first thing we need to do is move the scene files from the Overlap2D project to our assets directory. We've done this with a gradle task, which you can find in the build.gradle file at the root of this project.

Next we need to load up and parse the JSON contained in the Level1.dt file. To do this parsing, we'll use Google's JSON simple library. To use this library to our project, we've added a dependency to our build.gradle file. 

The rest of the work will be in `LevelLoader.java`, where we have a static method that takes a level name, and returns a live `Level` object containing the entities specified in the named level file.
 
## JSON parsing

JSON or JavaScript Object Notation is a human readable data for transmitting data. When you interact with most web sites, behind the scenes they are likely sending you chunks of JSON like this one to update your display.

JSON has a handful of basic types: Number, String, Boolean, Array, Object, and null. Arrays can a lists of any of the other types. Objects are key/value pairs using strings for the keys and any other type as the value including other objects or arrays.

The limited number of types has helped JSON expand outside JavaScript to become a widely used format praised for its readability and size advantages over more verbose formats like XML.

So, if we inspect Level1.dt, we see that the root object contains three keys: `[composite, sceneName, physicsPropertiesVO]`. The `composite` key holds another object with a further three keys: `[sImages, layers, sImage9patchs]`. Inspecting `sImage9patchs`, we find an array of objects specifying the platforms we placed in our level. Inspecting `sImages` we find the rest of the objects we placed, including GigaGal, the exit portal, and the powerups.

# The Exercise

In this exercise, you'll use the SimpleJSON library to parse and investigate the contents of a level file, in preparation for loading the platforms and enemies in the next exercise.

First open up the GigaGalLevels Overlap2D project, and make any changes you'd like to. Then check out the the changes made to the build.gradle file. Next check out the constants added to `Constants.java`.

