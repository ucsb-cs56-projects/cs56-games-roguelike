cs56-games-roguelike
====================

W14 ready! (Andrew Berls)

ASCII roguelike game

(OUTDATED PICTURE!!!)
![](http://i.imgur.com/E8qA2Pt.jpg)

High-level Description
======================


This project currently functions where the user is a player in the game and the player needs to survive waves of enemies. The player gains points and progresses the level by defeating monsters. Every level increases the difficulty of the monsters. At the start of each level, most of the area is be pitch black and needs to be "discovered" by the user.






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






How to run the project
======================

Navigate to the directory with the build.xml.

Type ```ant run```

