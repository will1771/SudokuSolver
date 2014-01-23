/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.scottalanwilliams.sudokusolver;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author swilliams
 */
@RunWith(Suite.class)
//put in all the classes that have tests
@Suite.SuiteClasses({com.scottalanwilliams.sudokusolver.SolverBrainTest.class, com.scottalanwilliams.sudokusolver.TileTest.class, com.scottalanwilliams.sudokusolver.TacticsEngineTest.class, com.scottalanwilliams.sudokusolver.BoardTest.class, com.scottalanwilliams.sudokusolver.ThreeByThreeGridTest.class})
public class MainTestSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}