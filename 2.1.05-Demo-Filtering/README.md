# Texture Filtering

An important part of drawing using textures is figuring out what colors to draw when the texture is drawn at a size that's smaller or larger than the actual size of the textures. This process is called filtering, or interpolation. LibGDX provides three texture filtering algorithms to assist you: Linear, Nearest, and Mipmap.

Nearest(neighbor) interpolation uses the closest texel (or texture pixel) to determine the final color in the destination sprite. It's very fast, but when you use it for drawing a texture at larger than usual size, it'll look blocky. Since we've gone with a pixel-art visual style for GigaGal, this is actually what we want in this case. When using nearest neighbor filtering for downsizing, the result can be "aliased" ([aliasing](https://en.wikipedia.org/wiki/Aliasing) is a bit beyond the scope of this course, but it's one of my favorite topics. It spans pure math, signal process, graphics, audio...), so only use it if you're certain that a sprite will be very very very far from the camera.

Linear filtering comes in several levels of granularity but the basic premise is that instead of taking the single nearest texel to determine the color, you use a number of nearby texels to calculate the final color. Linear filtering looks smoother when upscaling and preserves more details when downscaling, however it also takes more processing power.

Mipmaps are a set of precalculated textures at various scales, each is a power of two smaller than the one that preceded it. When the texture is drawn, it chooses the appropriate mipmap to use for rendering. If the destination sprite falls between two mipmaps, the GPU will blend two adjacent mipmaps. Mipmaps have an initial performance hit for the precalculation but fare better than having to generate textures on the fly. This is generally used in 3D graphics, when the size of a texture is likely the change dramatically over the course of a game.

In this demo, we show the difference between drawing a texture using nearest neighbor filtering, and linear filtering. Check out the TODOs to see how it works.

