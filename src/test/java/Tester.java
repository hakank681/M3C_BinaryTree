import com.m3c.hk.BinaryTreeStandard;
import com.m3c.hk.Node;
import com.m3c.hk.Problems;
import org.junit.*;
import org.junit.rules.ExpectedException;

import java.util.List;

/**
 * Created by alumniCurie07 on 12/10/2017.
 */
public class Tester {

    private BinaryTreeStandard binaryTreeStandard;

    @Before
    public void init(){
        binaryTreeStandard = new BinaryTreeStandard();
    }

    @Test
    public void testAddElement(){
        int elementToAdd = 4;
        binaryTreeStandard.addElement(elementToAdd);
        int rootValue = binaryTreeStandard.getRootElement();
        Assert.assertTrue(rootValue == 4);
    }

    @Test
    public void testAddManyElements(){
        int[] elementsToAdd = {4, 7, 9, 2, 5, 10};
        binaryTreeStandard.addElements(elementsToAdd);
        int nodeValue = binaryTreeStandard.findElement(5);
        Assert.assertTrue(nodeValue == 1);
   }

    @Test
    public void getLeftChild(){
        int[] elementsToAdd = {8, 10, 14, 13, 3, 1, 6, 4, 7};
        binaryTreeStandard.addElements(elementsToAdd);
        int leftChild = binaryTreeStandard.getLeftChild(14);
        Assert.assertTrue(leftChild == 13);
    }

    @Test
    public void getRightChild(){
        int[] elementsToAdd = {8, 10, 14, 13, 3, 1, 6, 4, 7};
        binaryTreeStandard.addElements(elementsToAdd);
        int rightChild = binaryTreeStandard.getRightChild(10);
        Assert.assertTrue(rightChild == 14);
    }

    @Test
    public void getRoot(){
        int[] elementsToAdd = {8, 10, 14, 13, 3, 1, 6, 4, 7};
        binaryTreeStandard.addElements(elementsToAdd);
        int root = binaryTreeStandard.getRootElement();
        Assert.assertTrue(root == 8);
    }

    @Test
    public void findElement(){
        int[] elementsToAdd = {8, 10, 14, 13, 3, 1, 6, 4, 7};
        binaryTreeStandard.addElements(elementsToAdd);
        int result = binaryTreeStandard.findElement(2);
        System.out.println(result);

        if(binaryTreeStandard.findElement(2) == -1){

        }
    }

    @Test
    public void numberOfElements(){
        int[] elementsToAdd = {8, 10, 14, 13, 3, 1, 6, 4, 7, 2, 15, 18};
        binaryTreeStandard.addElements(elementsToAdd);
        int result = binaryTreeStandard.getNumberOfElements();
        Assert.assertTrue(result == 12);
    }

    @Test
    public void ascListTest(){
        int[] elementsToAdd = {8, 10, 14, 13, 3, 1, 6, 4, 7, 2, 15, 18};
        binaryTreeStandard.addElements(elementsToAdd);
        List<Integer> resultList = binaryTreeStandard.getSortedTreeAsc();
        System.out.println(resultList);
    }

    @Test
    public void dscListTest(){
        int[] elementsToAdd = {8, 10, 14, 13, 3, 1, 6, 4, 7, 2, 15, 18};
        binaryTreeStandard.addElements(elementsToAdd);
        List<Integer> resultList = binaryTreeStandard.getSortedTreeDesc();
        System.out.println(resultList);

    }

    @After
    public void teardown(){

    }
}
