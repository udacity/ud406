# Gdx.graphics

So if we remember that most mobile platforms use OpenGL (ES 2+) for their rendering, there seems to be 4 static fields that deal with graphics. Let's disambiguate it a bit.

You can think of them as two very related parts of the graphics pipeline.

Gdx.graphics abstracts communication with the graphics processor.

and gl/gl20/gl30 wrap OpenGL ES specific calls.

So why are there three of them? It all comes down to the features you need for your app and specification support on mobile devices. GL20 and GL30 correspond to the OpenGL ES 2.0 and 3.0 specifications. GL20 is supported for Android 2.2 and above(API 8). OpenGL 3.0 is theoretically available on devices with Android 4.3 and above(API 18) but some manufacturers didn't choose to support it. So unless you need OpenGL ES 3.0 features, don't use gl30 and when you do check for its availability with

Gdx.graphics.isGL30Available()

To make your games even more future proof, use Gdx.gl. At the time of writing it aliases to gl20 which is guaranteed to be supported.


# Sprites and Textures

Most of the time, instead of basic shapes, we'll use images in our games. Depending on your source material, you might see the words image, texture, and sprite used interchangeably. Let's clear things up a bit.

Image is an umbrella term, but is usually meant to refer to a file on your computer (like a JPEG, PNG, or TIF).

A Texture is an in-memory representation of an image. It's called a texture because in the world of 3D graphics, a texture can be wrapped around a mesh to form a 3D object. The mesh provides the shape, while the image provides the texture. In our case, it's more like we're pasting stickers on a flat surface, but the idea is the same. 

Note that for an image to be drawn to the screen, we first have to get it into memory, which means turning it into a texture. 

Finally, a sprite is an object that holds on to a texture, as well as information about where the texture should be drawn in the world.


# Drawing Textures

