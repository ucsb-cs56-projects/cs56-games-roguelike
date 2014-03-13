cs56-games-roguelike
====================

W14 ready! (Andrew Berls)

ASCII roguelike game

(OUTDATED PICTURE!!!)
![](http://i.imgur.com/E8qA2Pt.jpg)

High-level Description
======================


This project currently functions where the user is a player in the game and the player needs to survive waves of enemies. The player gains points and progresses the level by defeating monsters. Every level increases the difficulty of the monsters.



Program Internals
=================


The list of monsters is maintained in LogicEngine.java as a private variable:
```java
private Monster[][] listOfMonsters;
```
The LogicEngine.java constructor created the list:
```java
	listOfMonsters = new Monster[floorWidth][floorHeight];
```

Monsters are created in the createMonsters() method in LogicEngine.java
checkAllMonsterStatus() in RogueController.java calls this method



RogueController.java is the MAIN


How to run the project
======================

Navigate to the directory with the build.xml.

Type ```ant run```

