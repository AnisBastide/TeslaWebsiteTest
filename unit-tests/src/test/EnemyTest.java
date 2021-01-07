package test;

import org.junit.Test;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import codingfactory.rpgconsole.hero.Hero;
import codingfactory.rpgconsole.enemy.Enemy;

public class EnemyTest {

    Enemy enemy;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        System.out.println("Avant le démarrage");
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        System.out.println("Après tous les tests");
    }

    @Before
    public void setUp() throws Exception {
        enemy = new Enemy("Michel",1);
        System.out.println("Avant un test");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Après un test");
    }

    @Test
    public void testEnemyTakeDamage() throws Exception {
        enemy.takeDamage(5);
        assertThat(enemy.getHp(), is(10));
    }
    @Test
    public void testEnemyGetHp() throws Exception {
        assertThat(enemy.getHp(), is(15));
    }

    @Test
    public void testEnemyProperties() throws Exception {
        assertThat(enemy, hasProperty("name"));
        assertThat(enemy, hasProperty("name", is("Michel")));
    }

    @Test
    public void testEnemyAttack() throws Exception {
        Hero hero = new Hero("michel");
        enemy.attack(hero);
        assertThat(hero.getHp(),lessThan(20));
    }

}
