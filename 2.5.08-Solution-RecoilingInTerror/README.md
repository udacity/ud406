# Recoiling in Terror

In this exercise, we're fixing two unexpected behaviors resulting from adding knockback in the previous exercise.

First, while GigaGal is flying through the air after being launched by an enemy, she shouldn't be able to move left or right. Second, when GigaGal lands on a platform, her horizontal motion should be arrested.

Start out in the `Enums.java` file to add a new `RECOILING` jump state to indicate the condition where GigaGal has been hit by an enemy (and thus shouldn't be able to move). 
