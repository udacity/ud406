# Facing Direction

Let's begin working on the logic that displays the correct sprite for GigaGal at the correct time. Right now we display the standing right sprite, even when GigaGal is walking left. Let's fix that by loading up the standing-left sprite in our `Assets` singleton, keeping track of what direction GigaGal is facing, and making sure we draw the right texture in GigaGal's `render()` method.

Check out the TODOs to get started! We reccomend completing them in the following order:

1. Constants.java
2. Assets.java
3. GigaGal.java
