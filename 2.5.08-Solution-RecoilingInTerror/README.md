# Knockback

In this game, enemies will be dangerous because when GigaGal touches them, she'll be flung away from the enemy, and will probably fall to her doom. This mechanic is commonly referred to as knockback.

First we need to set up a constant for GigaGal's new velocity when she gets knocked back. Then, after we establish that GigaGal is touching an enemy, we need to figure our wether to knock her back to the left, or to the right.

Since we already know how to detect when GigaGal has hit an enemy, we just need to set up 



# Directional Influence

If you were so lucky as to have been knocked back by an enemy in such a way as to land on a platform, you may have noticed that you were still pretty much doomed, given that landing didn't arrest your sideways velocity. Also, while being flung through the air, you could still kinda control your movement left to right, either speeding up or slowing down your flight. Nither of those behaviors make much sense, so let's fix 'em!
  
First, we need to set GigaGal's horizontal speed to zero when she lands on a platform. Second, we need to add a new JumpState for when GigaGal is recoiling from an enemy, and disable controls when she's in that state. Check out the TODOs to get it done!
