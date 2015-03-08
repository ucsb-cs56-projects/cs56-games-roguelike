cs56-games-roguelike
====================

This is an ASCII roguelike game.  If you are not familiar with the "Roguelike" genre, the Wikipedia entry can give you some background:

http://en.wikipedia.org/wiki/Roguelike

project history
===============
```
 W14 | andrewberls 4pm | rick-lee | ASCII roguelike game
 W15 | dcwang 6pm | ASCII roguelike game
```

![](https://lh5.googleusercontent.com/-KnFV8pd3O04/VPkVDthIfdI/AAAAAAAAAFU/izxmYe3mRZM/w720-h425-no/photo_name)

High-level Description
======================

This project currently functions where the user is a player trying to survive waves of enemies. The player gains points and progresses the level by defeating monsters. Advancing level increases the difficulty of the monsters. At the start of each level, most of the area is be pitch black and needs to be "discovered" by the player.

Features and Gameplay Guide
===========================
This Roguelike game is a single player dungeon game. It incorporates many features outlined by the "Berlin Interpretation", a rubric for judging the similarity of a Roguelike game to the original Rogue game. Berlin Interpretation features in our game include a birds-eye-view of the map, player and monster representation by ASCII characters, random environment genration, permadeath, turn-based gameplay, grid-based map, hack'n'slash style, and exploration/discovery. Unlike the original Rogue game, this version does not have multiple rooms connected by corridors. The map of this game can be viewed as one rectangular room. 
  
	The player is represented on the screen by the @ character. There are currently 7 types of monsters in the game: Bat, Golem, Monster, Pirate, Snake, Troll, and Zombie. On the screen, the monsters are represented by their intial (i.e. Bats show up as B, Golems as G, etc.). There is a pre-set maximum number of monsters in each level, and there can be multiple instances of one type of monster.  
	The player begins each level by starting in the middle of the map, with all but his surrounding tiles enshrouded in darkness. The player "discovers" the rest of the map by navigating using WASD. Monsters also move around in random patterns. Note that the game is turn-based in that monsters move once every time the player moves. The player attacks by moving directly adjacent to a monster, and then pressing the arrow key that would move the player onto the same tile as the monster if it were not there. The player can be attacked, and hp lowered, by a monster when the monster does the same thing to him.
  
	As soon as all the monsters of a level are killed, the player is automatically teleported to the next level. Reaching higher levels increases the strength of the monsters. When the player reaches 0 hp, he dies permanently, and his score, along with the current highscores, will be displayed. The game can be replayed by closing the game window and performing the "ant run" command again.
  
	A good strategy for killing monsters while avoiding taking damage is to take advantage of the way monsters move. Monsters move one turn at a time in the same manner as the player. The player should only spend time adjacent to the monster if he is attacking it; otherwise he risks taking unnecesary damage.


Program Internals
=================


RogueController.java is the MAIN class.

```RogueController``` deals with user input and calls methods accordingly. It creates two objects: ```RoguePanel``` and ```LogicEngine```

```RoguePanel``` draws all the characters and UI on the window.

```LogicEngine``` calculates all the movement and game logic of the player and monsters. It creates objects: ```Player``` and ```Monster``` with all Monster subclasses.

The current level of the game is managed by the int variable ```level``` in ```LogicEngine```



-Player
-------

Player is created and dealt with in the ```LogicEngine``` class

Player specifications can be modified in ```Player.java``` (i.e. HP, attack)

The Player is created and its location is set in the method ```createAllObjects()``` in ```LogicEngine``` class. The method ```createAllObjects()``` is called in the ```LogicEngine``` constructor.



-Monsters
---------

All monsters are created and dealt with in the ```LogicEngine``` class

Current monsters in the game:
```[ Bat , Golem , Monster , Pirate , Snake , Troll , Zombie ]```


The list of monsters is maintained in ```LogicEngine.java``` as a private variable:
```java
	private Monster[][] listOfMonsters;
```
The ```LogicEngine.java``` constructor created the list:
```java
	listOfMonsters = new Monster[floorWidth][floorHeight];
```

Monsters are created in the ```createMonsters()``` method in ```LogicEngine.java```. The method ```checkAllMonsterStatus()``` in ```RogueController.java``` calls this method

The maximum number of monsters per level is maintained by ```maxNumOfMonsters``` int variable in ```LogicEngine```

Monsters' increase in difficulty per level is set by ```setLevelBonus(int level)``` method in ```Monster.java```. This is called in ```LogicEngine.java``` when monsters are created by ```createMonsters()```



-Items
------

Items have NOT been implemented into the game yet. There are some files already created : ```Beef.java``` , ```HealthPotion.java``` , ```Item.java``` , ```Poison.java```



Improvements
============
Add items to the game
Add a GUI interface
Create a replay button for convenience
Make "rooms" and "corridors" part of the map


How to run the project
======================

Navigate to the directory with the build.xml.

Type ```ant run```

