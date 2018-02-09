#Readme Questions

**(a) (20 pts) A brief description of the project. Here, I’m looking for a short description: probably 1 sentence, 2-3 at most.**

The project is a roguelike video game in which a player attacks monsters to advance through levels in an ASCII based interface.

**(b) (20 pts) a set of user stories (as a X I can Y so that Z) that describe what the current software in its current state can do. First, review how User Stories are supposed to be written.**

As a player, I can start the game so that I can play the game.
As a player, I can move around so that I can interact with the environment.
As a player, I can advance levels so that I can progress through the game.
As a player, I can attack monsters in order to defeat them.
As a monster, I can move in order to attack the player.
As a monster, I can attack players in order to defeat them and end their game.

**(c) (20 pts) a brief assessment of whether the software runs or not. If it runs, briefly describe what it does.**

The software runs, and drops the user immediately into level 1, where they proceed to move around and kill monsters to advance levels. The background illuminates as the player moves around, and monsters try to attack the player in order to end the game. Does occasionally freeze and glitch out.

**(d) (20 pts) a set of user stories (at least 2, but you are encouraged to write up to 4 or more if you can, as many as you think is reasonable) about features that COULD be added to the software to make it more useful, fun, better, etc. Again, review the preferred way to write User Stories.**

As a player, I can face bosses when I reach a certain level.
As a player, I can pick up loot so that I can acquire items.
As a player, I can equip loot in order to increase my base stats.
As a player, I can use a wider variety of potions so that I can increase health/armor.
As a user, when on the main menu, I will be able to adjust options in order to change the game
As a user, I can interact with a GUI as opposed to an ASCII interface
As a monster, I can shoot flames or other weapons toward the player.

**(e) (20 pts) An assessment of the current quality of the README.md. What information could be added to make it easier for the next generation of folks maintaining this code to use the software, and/or maintain the software?**

A deeper explanation of the logic engine would make the game far easier to understand. Right now, it just explains where everything is initialized and basically just lists all the classes. It would be far better to know how everything is initialized and what classes are connected to each other. Something like a dynamic and static model of the dependency relationships, generalization, and associations would help greatly since there are a lot of classes.

**(f) (20 pts) An assessment of the current state of the build.xml file if applicable, or if the project has been converted to Maven or Gradle, note this.
If it’s based on Ant, Are there targets that need descriptions? Is there old legacy JWS stuff that needs to be removed? (More on this below).**

It is based on ant, as far as I can tell there is no JWS stuff that needs to be removed.
There are plenty of targets with clear enough descriptions, there is a compile, run, clean, javadoc, test, and jar target and they are all self explanatory.

**If it’s based on Maven or Gradle, is there sufficient documentation in the README.md that someone new to those tools has the information they need to get started?**

Not based on maven or gradle


**(g) (20 pts) An assessment of the current “issues”. Are there enough issues that you could earn 1000 points by working on this project? Are the issues clear in terms of what the expectations are?**

Yes, there are enough issues to make up 1000 points. There is a lot of room for improvement in terms of appearance and graphics, as well as making the game more challenging for the user. The issues given are very clear with expectations and fair in the amount of points offered for each solution for as far as we can understand and visualize the code.

**(h) (20 pts) A list of additional issues that you may have added, if any. For each, a link to the issue is good enough.**

-Cannot view the menu screen (it’s all white, no text visible)
-Unattractive music, and needs ability to toggle it to mute without physically muting user's computer
-Freezes in the middle of game play, very buggy

**(i) (100 pts) Most important: an assessment of the actual code. Write a bit about how the code is organized. Are the purposes of the classes, and their methods clear? Is it obvious how the classes relate to one another? Is the code easy to read and understand? If you had to give someone else that was going to work on the code just “one screenful of text” to help that programmer get up to speed quickly, what information would you convey?**

-“One screenful of text ” - there is a javadoc, could help the programmer get up to speed greatly.
-Also the main runner class that calls all the methods, if named more precisely, could be a great explanation of how the code runs
-Some of the method  and parameter names need work, but after looking into what they do they can be understood
-Very well commented and clean code overall, formatted methods and classes nicely.
-Could be refactored much better
-No real use for the GamePiece interface
-All code in one folder, should be separated into distinct directories like items, GamePieces, environments, controller, and tests
-GUI doesn’t really work
-The logic engine is the main thing that is pretty hard to understand and needs to be refactored


**(j) (40 pts) Related to code quality, but factored out into a separate issue because it is so important: how is the test coverage? Are there JUnit tests at all? If so, how much of the project is covered by testing? Are there opportunities to expand test coverage, and if so, how would you go about it?**

There are JUnit tests that cover the LogicEngine and all of the Items. There should be tests that cover the GamePieces, which the only two GamePieces seem to be the Player and Monster, and those could be implemented by testing their methods in the same format as the other tests. Those could be some of the main things we change so we would want to implement tests for those. Their could also be tests for the controller, panel, room, sound, and wall, and we could implement tests for them for future improvements to the code. Implementing tests for all of these could also help us pinpoint some of the bugs that cause the game to freeze.
