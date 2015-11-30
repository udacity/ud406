# GigaGal!

Let's lay out the classes that we'll need to bring GigaGal to life.

`GigaGalGame extends Game` will be our application listener. As we're only using a single screen in this game for now, all `GigaGalGame` is responsible for is delegating it's callbacks to a new `GameplayScreen`.

`GameplayScreen extends ScreenAdapter` sets up the drawing environment and viewport, and initializes the `Assets` class. 

`Level` holds on to the entities that make up the level, such as GigaGal herself, the platforms, the enemies, the bullets, etc. The important methods on `Level` are `update` and `render`.

## Entitites

`GigaGal` controls and draws GigaGal, keeping track of her position, velocity, her facing direction, and so on. Also handles user input controlling GigaGal's movement.

`Platform` holds on to the position and dimensions of a particular platform that GigaGal can jump on. Doesn't need to do anything to update, but knows how to draw itself.

## Utilities

`Assets implements Disposable, AssetErrorListener` is a singleton that loads and holds onto the texture atlas containing all GigaGal's assets.
 
`Constants` is a static class that contains all the constants for stuff like sprite names, dimensions, speeds, accelerations, etc.

# Render

Let's explore the chain of events that is kicked off every frame.
 
When `render()` is called on `GigaGalGame`, that call is redirected to `GamePlayScreen`. `GamePlayScreen` then calls `update` on the current `Level`, which in turn calls `update` on all the entities in the level. In response to the `update` call, the entities move themselves, interact, and handle user input as necessary.

Once all the entities contained in the `Level` have updated themselves, `GamePlayScreen` begins a `SpriteBatch`, and calls `render` on the `Level`. The `Level` then calls `render` on all the entities it contains, in background to foreground order. When `Level` returns from `render`, `GamePlayScreen` ends the `SpriteBatch`, and the `render` call returns.


# Create the Project skeleton

Create the following classes as specified above. Don't worry about adding any functionality yet.

TODO: Create GigaGalGame
TODO: Create GameplayScreen
TODO: Create Level

## util package

TODO: Create GigaGal
TODO: Create Platform

## entities package

TODO: Create Assets
TODO: Create Constants
