import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
/**
 *  Test class for Doubly Linked List
 *
 *  @version 3.1 09/11/15 11:32:15
 *
 *  @author  TODO
 */

@RunWith(JUnit4.class)
public class BSTTest
{
  
  //TODO write more tests here.

  
  /** <p>Test {@link BST#prettyPrintKeys()}.</p> */
      
 @Test
 public void testPrettyPrint() {
     BST<Integer, Integer> bst = new BST<Integer, Integer>();
     assertEquals("Checking pretty printing of empty tree",
             "-null\n", bst.prettyPrintKeys());
      
                          //  -7
                          //   |-3
                          //   | |-1
                          //   | | |-null
     bst.put(7, 7);       //   | |  -2
     bst.put(8, 8);       //   | |   |-null
     bst.put(3, 3);       //   | |    -null
     bst.put(1, 1);       //   |  -6
     bst.put(2, 2);       //   |   |-4
     bst.put(6, 6);       //   |   | |-null
     bst.put(4, 4);       //   |   |  -5
     bst.put(5, 5);       //   |   |   |-null
                          //   |   |    -null
                          //   |    -null
                          //    -8
                          //     |-null
                          //      -null
     
     String result = 
      "-7\n" +
      " |-3\n" + 
      " | |-1\n" +
      " | | |-null\n" + 
      " | |  -2\n" +
      " | |   |-null\n" +
      " | |    -null\n" +
      " |  -6\n" +
      " |   |-4\n" +
      " |   | |-null\n" +
      " |   |  -5\n" +
      " |   |   |-null\n" +
      " |   |    -null\n" +
      " |    -null\n" +
      "  -8\n" +
      "   |-null\n" +
      "    -null\n";
     assertEquals("Checking pretty printing of non-empty tree", result, bst.prettyPrintKeys());
     }

  
     /** <p>Test {@link BST#delete(Comparable)}.</p> */
     @Test
     public void testDelete() {
         BST<Integer, Integer> bst = new BST<Integer, Integer>();
         bst.delete(1);
         assertEquals("Deleting from empty tree", "()", bst.printKeysInOrder());
         
         bst.put(7, 7);   //        _7_
         bst.put(8, 8);   //      /     \
         bst.put(3, 3);   //    _3_      8
         bst.put(1, 1);   //  /     \
         bst.put(2, 2);   // 1       6
         bst.put(6, 6);   //  \     /
         bst.put(4, 4);   //   2   4
         bst.put(5, 5);   //        \
                          //         5
         
         assertEquals("Checking order of constructed tree",
                 "(((()1(()2()))3((()4(()5()))6()))7(()8()))", bst.printKeysInOrder());
         
         bst.delete(9);
         assertEquals("Deleting non-existent key",
                 "(((()1(()2()))3((()4(()5()))6()))7(()8()))", bst.printKeysInOrder());
 
         bst.delete(8);
         assertEquals("Deleting leaf", "(((()1(()2()))3((()4(()5()))6()))7())", bst.printKeysInOrder());
 
         bst.delete(6);
         assertEquals("Deleting node with single child",
                 "(((()1(()2()))3(()4(()5())))7())", bst.printKeysInOrder());
 
         bst.delete(3);
         assertEquals("Deleting node with two children",
                 "(((()1())2(()4(()5())))7())", bst.printKeysInOrder());
     }
     @Test
     public void testHeight()
     {
    	 BST<Integer, Integer> bst = new BST<Integer, Integer>();
    	 bst.put(7, 7);   //        _7_
         bst.put(8, 8);   //      /     \
         bst.put(3, 3);   //    _3_      8
         bst.put(1, 1);   //  /     \
         bst.put(2, 2);   // 1       6
         bst.put(6, 6);   //  \     /
         bst.put(4, 4);   //   2   4
         bst.put(5, 5);   //        \
                          //         5
         assertEquals(bst.height(), 4);
         bst.put(10, 10);
         bst.put(11, 10);
         bst.put(12, 10);
         bst.put(13, 10);
         bst.put(14, 10);
         bst.put(15, 10);
         assertEquals(7, bst.height());
         
         bst = new BST<Integer, Integer>();
         assertEquals(-1, bst.height());
     }
     
     @Test
     public void testMedian()
     {
    	 BST<Integer, Integer> bst = new BST<Integer, Integer>();
    	 bst.put(50, 50);
    	 bst.put(25, 25);
    	 bst.put(15, 15);
    	 bst.put(30, 30);
    	 bst.put(60, 60);
    	 bst.put(55, 55);
    	 bst.put(62, 62);
    	 bst.put(100, 100);
    	 bst.put(90, 90);
         
         assertEquals(55,(int) bst.median());
         bst = new BST<Integer, Integer>();
    	 bst.put(50, 50);
    	 bst.put(25, 25);
    	 bst.put(15, 15);
    	 bst.put(30, 30);
    	 bst.put(60, 60);
    	 bst.put(55, 55);
    	 bst.put(62, 62);
    	 bst.put(10, 10);
    	 assertEquals(30,(int) bst.median());
   
         bst = new BST<Integer, Integer>();
    	 bst.put(50, 50);
    	 bst.put(25, 25);
    	 bst.put(15, 15);
    	 bst.put(30, 30);
    	 bst.put(60, 60);
    	 bst.put(55, 55);
    	 bst.put(62, 62);
    	 assertEquals(50, (int) bst.median());
    	 
    	 bst = new BST<Integer, Integer>();
    	 assertEquals(null, bst.median());
         
     }
     @Test
     public void testPrintKeysInOrder()
     {
    	 BST<Integer, Integer> bst = new BST<Integer, Integer>();
    	 bst.put(50, 50);
 		bst.put(25, 25);
 		bst.put(15, 15);
 		bst.put(30, 30);
 		bst.put(60, 60);
 		bst.put(55, 55);
 		bst.put(62, 62);
 		bst.put(100, 100);
 		bst.put(90, 90);
 		assertEquals("(((()15())25(()30()))50((()55())60(()62((()90())100()))))", bst.printKeysInOrder());
 		bst = new BST<Integer, Integer>();
 		assertEquals("()", bst.printKeysInOrder());
 		bst.put(50, 50);
 		bst.put(25, 25);
 		bst.put(15, 15);
 		assertEquals("(((()15())25())50())", bst.printKeysInOrder());
     }
     
     @Test
     public void testPut()
     {
    	 BST<Integer, Integer> bst = new BST<Integer, Integer>();
    	 bst.put(10, 10);
    	 int test = (int) bst.get(10);
    	 assertEquals(test, 10);
    	 bst.put(5, 5);
    	 test = (int) bst.get(5);
    	 assertEquals(test, 5);
    	 bst.put(15, 15);
    	 test = bst.get(15);
    	 assertEquals(test, 15);
    	 bst.put(1, null);
    	 bst.put(100, 100);
    	 assertEquals((int) bst.get(100), 100);
    	
     }
     
     @Test
     public void testRank()
     {
    	 BST<Integer, Integer> bst = new BST<Integer, Integer>();
    	 assertEquals(bst.rank(1), 0);
     }
     @Test 
     public void testGet()
     {
    	 BST<Integer, Integer> bst = new BST<Integer, Integer>();
    	 assertEquals(bst.get(10), null);
    	 bst.put(50, 50);
 		bst.put(25, 25);
 		bst.put(15, 15);
 		bst.put(30, 30);
 		bst.put(60, 60);
 		bst.put(55, 55);
 		bst.put(62, 62);
 		bst.put(100, 100);
 		bst.put(90, 90);
 		
 		assertEquals((int) bst.get(50), 50);
 		assertEquals((int) bst.get(100), 100);
 		assertEquals((int) bst.get(30), 30);
     }
    @Test
    public void testContains()
    {
    	BST<Integer, Integer> bst = new BST<Integer, Integer>();
    	bst.put(10, 10);
    	assertTrue(bst.contains(10));
    	assertFalse(bst.contains(5));
    }
    
}

