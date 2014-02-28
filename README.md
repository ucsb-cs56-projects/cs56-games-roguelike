cs56-games-roguelike
====================

W14 ready! (Andrew Berls)

ASCII roguelike game

![](http://i.imgur.com/E8qA2Pt.jpg)



program internals
=================


The list of monsters is maintained in LogicEngine.java as a private variable:
```java
private Monster[][] listOfMonsters;
```
The LogicEngine.java constructor created the list:
```java
	listOfMonsters = new Monster[floorWidth][floorHeight];
```
Monsters are created in the createMonsters() method in LogicEngine.java:




