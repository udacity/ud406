# Loading the Platforms and Enemies

Now that we can read in the level file and parse the JSON, let's load up the platforms and their associated enemies!

We'll need to grab the 9-patches from the level file, extract their position and dimensions, and add them to the level. We'll need to be careful though, that we don't order the platforms in such a way that platforms that are higher up hide platforms that are lower down in the level. Also, we'll check the identifier attached to each platform to see if that platform needs an enemy!

Also, note that we added a random phase to the bobbing of the enemies, so they're not all synced up.

Check out the TODOs to get started, and check out the solution project if you run into trouble.
