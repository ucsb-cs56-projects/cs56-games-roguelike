package edu.ucsb.cs56.projects.games.roguelike;


import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/** test class for my Item class
 *   @author Hans Marasigan & Richard Nguyen
 *   @version cs56 S13
 *   @see Item
 */

public class ItemTest {
    /**
     *  This tests the default constructor.
     *  The effect should be 10 where used is false. 
     *  This is for an Item with an icon 'I'.
     */
    @Test public void test_defaultItemConstructor_andGetters() {
        Item i = new Item();
        assertEquals(10, i.getEffect());
        assertEquals(false, i.getUse());
        assertEquals("item", i.getTypeOfPiece());
        assertEquals('I', i.getIcon());
    }
    /**
     *  This tests the 1 Arg constructor for an Item effect.
     *  The effect should be 15 where used is false.
     *  It is an item and has icon 'I'.
     */
    @Test public void test_1ArgEffectItemConstructor_andGetters() {
        Item i = new Item(15);
        assertEquals(15, i.getEffect());
        assertEquals(false, i.getUse());
        assertEquals("item", i.getTypeOfPiece());
        assertEquals('I', i.getIcon());
    }

    /**
     * This tests the 1 Arg constructor for an Item.
     * The effect should be 10 where used is true.
     * It is an Item with an icon 'I'.
     */
    @Test public void test_1ArgUseItemConstructor_andGetters() {
        Item i = new Item(true);
        assertEquals(10, i.getEffect());
        assertEquals(true, i.getUse());
        assertEquals("item", i.getTypeOfPiece());
        assertEquals('I', i.getIcon());
    }

    /**
     * This tests the default constructor.
     * The effect should be 10 where used is false and it is an Item.
     */
    @Test public void test_defaultItemConstructorSettersandGetters() {
        Item i = new Item();
        i.setUse(true);
        i.setTypeOfPiece("gameitem");
        i.setEffect(20);
        assertEquals(20, i.getEffect());
        assertEquals(true, i.getUse());
        assertEquals("gameitem", i.getTypeOfPiece());
    }
    /**
     * This tests the default constructor.
     * The effect should be 10 where used is false, it is an Item, and has icon 'H'.
     */
    @Test public void test_defaultHPPotConstructor_andGetters() {
        HealthPotion i = new HealthPotion();
        assertEquals(20, i.getEffect());
        assertEquals(false, i.getUse());
        assertEquals("item", i.getTypeOfPiece());
        assertEquals('H', i.getIcon());
    }
    /**
     * This tests the 1 Arg constructor for HealthPotion an Item effect.
     * The effect should be 15 where used is false, it is an Item, and has an icon 'H'.
     */
    @Test public void test_1ArgEffectHPPotConstructor_andGetters() {
        HealthPotion i = new HealthPotion(15);
        assertEquals(15, i.getEffect());
        assertEquals(false, i.getUse());
        assertEquals("item", i.getTypeOfPiece());
        assertEquals('H', i.getIcon());
    }

    /**
     * This tests the 1 Arg constructor for Health Potion for an Item.
     * The effect should be 10 where used is true, it is an Item,and it has an icon 'H'.
     */
    @Test public void test_1ArgUseHPPotConstructor_andGetters() {
        HealthPotion i = new HealthPotion(true);
        assertEquals(10, i.getEffect());
        assertEquals(true, i.getUse());
        assertEquals("item", i.getTypeOfPiece());
        assertEquals('H', i.getIcon());
    }

    /**
     * This tests the default constructor with setters and getters.
     * The effect should be 30 where used is true and it is a gameitem.
     */
    @Test public void test_defaultHPPotConstructorSettersandGetters() {
        HealthPotion i = new HealthPotion();
        i.setUse(true);
        i.setTypeOfPiece("gameitem");
        i.setEffect(30);
        assertEquals(30, i.getEffect());
        assertEquals(true, i.getUse());
        assertEquals("gameitem", i.getTypeOfPiece());
    }
    /**
     * This tests the default constructor.
     * The effect should be 20 where used is false, it is an Item, and it has an icon '!'.
     */
    @Test public void test_defaultPoisonConstructor_andGetters() {
        Poison i = new Poison();
        assertEquals(20, i.getEffect());
        assertEquals(false, i.getUse());
        assertEquals("item", i.getTypeOfPiece());
        assertEquals('!', i.getIcon());
    }
    /**
     * This tests the 1 Arg constructor for a Poison Item.
     * The effect should be 15 where used is false, it is an Item, and it has an icon '!'.
     */
    @Test public void test_1ArgEffectPoisonConstructor_andGetters() {
        Poison i = new Poison(15);
        assertEquals(15, i.getEffect());
        assertEquals(false, i.getUse());
        assertEquals("item", i.getTypeOfPiece());
        assertEquals('!', i.getIcon());
    }

    /**
     * This tests the 1 Arg constructor for a Poison Item.
     * The effect should be 10 where used is true, it is an Item, and it has an icon '!'.
     */
    @Test public void test_1ArgUsePoisonConstructor_andGetters() {
        Poison i = new Poison(true);
        assertEquals(10, i.getEffect());
        assertEquals(true, i.getUse());
        assertEquals("item", i.getTypeOfPiece());
        assertEquals('!', i.getIcon());
    }

    /**
     * This tests the default constructor with setters and getters.
     * The effect should be 30 where used is true and it is a gameitem.
     */
    @Test public void test_defaultPoisonConstructorSettersandGetters() {
        HealthPotion i = new HealthPotion();
        i.setUse(true);
        i.setTypeOfPiece("gameitem");
        i.setEffect(30);
        assertEquals(30, i.getEffect());
        assertEquals(true, i.getUse());
        assertEquals("gameitem", i.getTypeOfPiece());
    }
    /**
     * This tests the default constructor.
     * The effect should be 20 where used is false, it is an Item, and it has an icon '+'.
     */
    @Test public void test_defaultBeefConstructor_andGetters() {
        Beef i = new Beef();
        assertEquals(20, i.getEffect());
        assertEquals(false, i.getUse());
        assertEquals("item", i.getTypeOfPiece());
        assertEquals('+', i.getIcon());
    }
    /**
     * This tests the 1 Arg constructor for a Beef Item.
     * The effect should be 15 where used is false, it is an Item, and it has an icon '+'.
     */
    @Test public void test_1ArgEffectBeefConstructor_andGetters() {
        Beef i = new Beef(15);
        assertEquals(15, i.getEffect());
        assertEquals(false, i.getUse());
        assertEquals("item", i.getTypeOfPiece());
        assertEquals('+', i.getIcon());
    }

    /**
     * This tests the 1 Arg constructor for a Beef Item.
     * The effect should be 10 where used is true, it is an Item, and it has icon '+'.
     */
    @Test public void test_1ArgUseBeefConstructor_andGetters() {
        Beef i = new Beef(true);
        assertEquals(10, i.getEffect());
        assertEquals(true, i.getUse());
        assertEquals("item", i.getTypeOfPiece());
        assertEquals('+', i.getIcon());
    }

    /**
     * This tests the default constructor with setters and getters.
     * The effect should be 30 where used is true and it is a gameitem.
     */
    @Test public void test_defaultBeefConstructorSettersandGetters() {
        Beef i = new Beef();
        i.setUse(true);
        i.setTypeOfPiece("gameitem");
        i.setEffect(30);
        assertEquals(30, i.getEffect());
        assertEquals(true, i.getUse());
        assertEquals("gameitem", i.getTypeOfPiece());
    }
    /**
     * This tests how an Item affects a player.
     */
    @Test public void test_itemOnPlayer() {
        Item i = new Item();
        Player p = new Player();
        i.UseEffect(p);
        assertEquals(10, p.getScore());
    }

    /**
     * This tests how a HealthPotion affects a player.
     */
    @Test public void test_HealthPotionOnPlayer() {
        HealthPotion i = new HealthPotion();
        Player p = new Player();
        i.UseEffect(p);
        assertEquals(120, p.getHitPoints());
    }

    /**
     * This tests how a Poison affects a player.
     */
    @Test public void test_PoisonOnPlayer() {
        Poison i = new Poison();
        Player p = new Player();
        i.UseEffect(p);
        assertEquals(80, p.getHitPoints());
    }

    /**
     * This tests how a Beef affects a player.
     */
    @Test public void test_BeefOnPlayer() {
        Beef i = new Beef();
        Player p = new Player();
        i.UseEffect(p);
        assertEquals(40, p.getAttack());
    }


}
