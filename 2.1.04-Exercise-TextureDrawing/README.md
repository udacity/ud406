# Graphics Access

Let's explore how the static [`Gdx`](https://libgdx.badlogicgames.com/nightlies/docs/api/com/badlogic/gdx/Gdx.html) object gives us access to the drawing capabilities of our current platform. 

`Gdx` has four static fields that deal with graphics, and  
 [`Gdx.graphics`](https://libgdx.badlogicgames.com/nightlies/docs/api/com/badlogic/gdx/Graphics.html) is where all the real action lives. `Gdx.graphics` abstracts communication with the graphics processor, and also provides us with ways to directly call OpenGL methods.
 
Remember that OpenGL is the language by which the CPU passes instructions to the GPU, and OpenGL ES is the restricted version that's used by most mobile devices. The [`GL20`](https://libgdx.badlogicgames.com/nightlies/docs/api/com/badlogic/gdx/graphics/GL20.html) and [`GL30`](https://libgdx.badlogicgames.com/nightlies/docs/api/com/badlogic/gdx/graphics/GL30.html) fields of `Gdx` wrap calls using the OpenGL ES 2.0 and 3.0 specifications. GL20 is supported for Android 2.2 and above(API 8). OpenGL 3.0 is theoretically available on devices with Android 4.3 and above(API 18) but some manufacturers didn't choose to support it. So unless you need OpenGL ES 3.0 features, don't use gl30 and when you do check for its availability with `Gdx.graphics.isGL30Available()`.

Generally, you should use `Gdx.gl`, which will always point to the minimum required version of OpenGL. At the time of writing it aliases to `gl20`. In this class, all we actually need to do with `Gdx.gl` is clear the screen at the start of each frame.


# Sprites and Textures

Most of the time, instead of basic shapes, we'll use images in our games. Depending on your source material, you might see the words image, texture, and sprite used interchangeably. Let's clear things up a bit.

Image is an umbrella term, but is usually meant to refer to a file on your computer (like a JPEG, PNG, or TIF) that contains instructions on how to fill in the colors in a rectangle of a particular size. These instructions can be a list of colors (like a BMP), a set of shapes (like a SVG), or a chunk of compressed data that can be expanded into the actual colors (most other file types). 

A Texture is an in-memory representation of the actual rectangle of colors that make up an image. It's called a texture because, in the world of 3D graphics, a texture can be wrapped around a mesh to form a 3D object. The mesh provides the shape, while the image provides the texture. In our case, it's more like we're pasting stickers on a flat surface, but the idea is the same. 

Note that for an image to be drawn to the screen, we first have to get it into memory, which means turning it into a texture. 

Finally, a sprite is an object that holds on to a texture, as well as information about where the texture should be drawn in the world.

# Drawing Textures

Textures are drawn using a [`SpriteBatch`](https://libgdx.badlogicgames.com/nightlies/docs/api/com/badlogic/gdx/graphics/g2d/SpriteBatch.html), in much the same way that shapes are drawn using [`ShapeRenderer`](https://libgdx.badlogicgames.com/nightlies/docs/api/com/badlogic/gdx/graphics/glutils/ShapeRenderer.html). Actually, the `draw()` method on `SpriteBatch` is overloaded in a very similar way to the `rect()` method on `ShapeRenderer`. Both are drawing a rectangle, but instead of drawing a rectangle of a solid color or gradient, `SpriteBatch` is drawing a rectangle containing a texture.

For more information on drawing images, refer to the [Spritebatch, Textureregions, and Sprites](https://github.com/libgdx/libgdx/wiki/Spritebatch,-Textureregions,-and-Sprites) page in the LibGDX wiki.

# Texture Drawing Exercise

In this exercise you'll load an image file into a `Texture`, set up a `SpriteBatch`, and draw the texture to the screen. Check out the TODOs to get started!



