cs56-games-roguelike
====================

This is an ASCII roguelike game.  If you are not familiar with the "Roguelike" genre, the Wikipedia entry can give you some background:

http://en.wikipedia.org/wiki/Roguelike

Project History
===============
```
 W14 | andrewberls 4pm | rick-lee | ASCII roguelike game
 W15 | dcoffill 6pm | dcwang | ASCII roguelike game
```
![](http://s14.postimg.org/5iewlbpyp/oie_GJB9p_Oxedgs_Z.png)

![](https://image.ibb.co/m1k9Sw/12_6_07_gameplay.pnghttps://ibb.co/i3H0Zb)

(Updated Gameplay Screen as of 12/6/17)

High-level Description
======================

This project currently functions where the user is a player trying to survive waves of enemies. The player gains points and progresses the level by defeating monsters. Advancing level increases the difficulty of the monsters. At the start of each level, most of the area is be pitch black and needs to be "discovered" by the player.

Features and Gameplay Guide
===========================

This Roguelike game is a single player dungeon game. It incorporates many features outlined by the "Berlin Interpretation", a rubric for judging the similarity of a Roguelike game to the original Rogue game. Berlin Interpretation features in our game include a birds-eye-view of the map, player and monster representation by ASCII characters, random environment genration, permadeath, turn-based gameplay, grid-based map, hack'n'slash style, and exploration/discovery. Unlike the original Rogue game, this version does not have multiple rooms connected by corridors. The map of this game can be viewed as one rectangular room.

The player is represented on the screen by the @ character. There are currently 7 types of monsters in the game: Bat, Golem, Monster, Pirate, Snake, Troll, and Zombie. On the screen, the monsters are represented by their intial (i.e. Bats show up as B, Golems as G, etc.). There is a pre-set maximum number of monsters in each level, and there can be multiple instances of one type of monster.  

The player begins each level by starting in the middle of the map, with all but his surrounding tiles enshrouded in darkness. The player "discovers" the rest of the map by navigating using WASD. Monsters also move around in random patterns. Note that the game is turn-based in that monsters move once every time the player moves. The player attacks by moving directly adjacent to a monster, and then pressing the arrow key that would move the player onto the same tile as the monster if it were not there. The player can be attacked, and hp lowered, by a monster when the monster does the same thing to him.


When a monster dies, there is a 20% chance of it dropping a health potion (icon H, gives 20 hp), 20% chance of dropping beef (icon +, increases player's attack power), and 15% chance of dropping poison (icon !, gives -20 hp).To consume an item, simply move onto it.

As soon as all the monsters of a level are killed, the player is automatically teleported to the next level. Reaching higher levels increases the strength of the monsters. When the player reaches 0 hp, he dies permanently, and his score, along with the current highscores, will be displayed. The game can be replayed by closing the game window and performing the "ant run" command again.

A good strategy for killing monsters while avoiding taking damage is to take advantage of the way monsters move. Monsters move one turn at a time in the same manner as the player. The player should only spend time adjacent to the monster if he is attacking it; otherwise he risks taking unnecesary damage.


Program Internals
=================


RogueController.java has the MAIN class.

```RogueController``` deals with user input and calls methods accordingly. It creates two objects: ```RoguePanel``` and ```LogicEngine```

```RoguePanel``` draws all the characters and UI on the window.

```LogicEngine``` calculates all the movement and game logic of the player and monsters. It creates objects: ```Player``` and ```Monster``` with all Monster subclasses.

The current level of the game is managed by the int variable ```level``` in ```LogicEngine```

GUI.java is the class that creates the main menu interface.



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

Items have  been implemented into the game. There are some files already created : ```Beef.java``` , ```HealthPotion.java``` , ```Item.java``` , ```Poison.java```



Future Improvements
============

* Make "rooms" and "corridors" part of the map

* Add more items to the game 
* Add boss monsters
* Add chests
* REFACTOR Please :)



How to run the project
======================

Navigate to the directory with the build.xml.

Type ```ant run```

W16 Final Remarks
========================
Hello CS56 W17 students! You've been assigned a pretty cool project so smile. Some things you should know before starting to work on this project are:

* Most of the stuff you need to know is above this Remark.
* The code doesn't have many bugs anymore, but there are a lot of things that could be added to the game so that is more fun to play.
* The few bugs that you need to fix are on the issues section of this repo.
* The things that you could include in the game are:
      * More superpowers to the character and monsters
      * Some music per level (that would be sick!)
      * A boss to defeat
      * Rooms and Corridors
      * A story line at the beginning of each level (like some text box maybe)
* Make sure you understand how ```Roguepanel.java``` , ```LogicEngine.java```, and ```RogueController.java``` work. Your understanding of these three classes will be crucial to how well and fast you solve issues and add anything you want to the game ;)
* Have fun with this project and put all your creativity on it!
Good luck!

Sincerely,

Josue and Ish.

F16 Final Remarks
=======================
This project is quite far along in terms of having an entertaining game. At this point the types of changes that you will make will be adding new features and refactoring old code.

Things to add to the game
	* More maps. We implemented a single map that is reused for each level. It would be better if there was a different map for each new level. We left our simple implementation of this initialization in the code near the bottom of Logic Engine(it's ugly) so that you could see one way to do it. A potential improvement would be to serialize maps, so that they don't have to be reinitialized with a bunch of for loops each time we change levels.
	* More music that is tied to each  level.
	* A combat system, either jrpg (like a pokemon battle with just the menu) or within the overworld (like Zelda)
	* Other than that, just check the issues for bugs and other things.

We recommend first fixing the issue dealing with elixir being able to jump over walls and monsters, as it should show you the interaction between different classes to make the game run.

Have fun!

-Max and Artem

F17 Final Remarks
========================
This project is lit! I hope you enjoy all the changes that have been made so far and I hope you can take care of this little project. 

* One thing I'd advise right away is to refactor the code. I'm taking the time to write the sentence again because it's important, REFACTOR THE CODE :). Specifically, the LogicEngine, RogueController, and RoguePanel classes are huge. Also, the floor could be the source of truth instead of having 3 different arrays for monsters, player, and floor.
* Once you refactor, implementing all the cool features will be a lot easier. 
* The things that you could include in the game are:
      * Boss Monsters
      * Chests
      * Weapon System
      * Options Menu
      * Some story text as you go along to make the game have depth
* The ```Roguepanel.java``` , ```LogicEngine.java```, and ```RogueController.java``` are the main pieces of code that make this game work. Understand them and please please refactor.

*NOTE: Please Add JavaDoc Comments as you go, this will make it easier for the next classes to read
*Also, if you do add story text, please make it interesting. The instructions in this game before were pretty boring so try to keep it spicy :)
Enjoy my dudes :D



Fall 16 Mentor Asssessment
====
The code for this project is reasonably well designed. However, it falls into some of the usual traps made by developers using OOP for the first time in a real capacity. The biggest one is that each item and monster is its own class. For instance, the Bat (extends Monster) class is just a collection of constructor overrides. That is to say, all its functionality exists in the Monster superclass, and you can create a Bat by creating a Monster with the specific stats of the Bat. Some possible refactors are static factory methods (Monster.createBat()) or storing each Monster 'class' in a file.
Another is that the Player class is wholely separate from the Monster class, despite them being reasonably similar. Instead, they could be one class, and the player controls a single specific instance of this GameEntity class.
The last major problem is that drawing the game state to the screen is fairly coupled to the actual logic of the game. These should be split so that changes to existing game logic doesn't break rendering.

F17 Final Remarks
=======================
Hey new CS56 students, so most of the stuff you need to know about what the project is and does is listed above this remark, any new things that would be helpful are:
* In order to edit the Map Generation, look at the code in Room.java and LogicEngine. Specifically look at createWalls, createRoom, hCorridor, vCorridor.

What features could be added include:
* Add a level boss
* Better Combat system
* More items / improvements on current items such as effects

What bugs exists include:
* Game Doesn't work without CSIL connection
* Elixer item stacks

Opportunites for refactoring:
* Wall Creation, the code is a bit messy, and could use better organization.
* Monster Creation
* LogicEngine and RogueController are too big and makes it hard to understand and change perhaps divide the classes into smaller ones.


F17 Final Remarks(pt2)
=======================
Heres a few tips for the new CS56 Students working on this project:

Understanding the code:
* LogicEngine.java and RogueController.java are where the vast majority of the code is located. Unfortunately, these are also the files that need the most work done on them.
* The code for these two files is very tightly coupled. You might need to switch back and forth between the 2 files to understand what's going on

Things you could work on:
* The code is in desperate need of refactoring. LogicEngine and RogueController practically need to be rebuilt from the ground up in order to decouple them.
* Combat is currently lackluster. Anything to make the game more exciting to play would be a big improvement

There arent too many bugs left in this code, but there are numerous improvements that can be made to the code and new features that can be added. With this in mind, good luck on this project!
