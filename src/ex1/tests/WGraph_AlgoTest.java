//package ex1.tests;
//
//import ex1.src.WGraph_Algo;
//import ex1.src.WGraph_DS;
//import ex1.src.node_info;
//import org.junit.jupiter.api.Test;
//
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//class WGraph_AlgoTest {
//    /**
//     * Building connected graph, for Dikjstra algorithm (this graph displayed at lesson
//     * of Elizabeth)
//     * @param
//     * @return
//     */
//    static WGraph_DS Djx(){
//        WGraph_DS g = new WGraph_DS();
//        for (int i = 0; i < 6; i++) {
//            g.addNode(i);
//        }
//        g.connect(0,1,7);
//        g.connect(0,2,9);
//        g.connect(0,5,14);
//        g.connect(1,2,10);
//        g.connect(1,3,15);
//        g.connect(2,5,2);
//        g.connect(2,3,11);
//        g.connect(4,3,6);
//        g.connect(4,5,9);
//
//        return g;
//    }
//    /**
//     * Building graph which is not connected
//     * @param g
//     */
//    static WGraph_DS IsNotConnected(){
//        WGraph_DS g = new WGraph_DS();
//        for (int i = 0; i < 6; i++)
//            g.addNode(i);
//        g.connect(2,3,11);
//        g.connect(4,3,6);
//        g.connect(4,5,9);
//
//        return g;
//    }
//    /**
//     * dikjstra methode return false if the graph is connected, else true. Djx is connected.
//     * The test checks connectivity of IsNotConnected, from every node:
//     * dikjstra methode suppose return true, from any direction.
//     * After this check, we will check connectivity of Djx, from every node:
//     * dikjstra methode suppose return false, from any direction.
//     * Finally, we will the tag for each node, from source 0.
//     */
//    @Test
//    void dikjstra() {
//        WGraph_Algo operator = new WGraph_Algo();
//        operator.init(IsNotConnected());
//        assertTrue(operator.dikjstra(5));
//        assertTrue(operator.dikjstra(0));
//        assertTrue(operator.dikjstra(4));
//        assertTrue(operator.dikjstra(2));
//        assertTrue(operator.dikjstra(1));
//        assertTrue(operator.dikjstra(3));
//        operator.init(Djx());
//        assertFalse(operator.dikjstra(5));
//        assertFalse(operator.dikjstra(4));
//        assertFalse(operator.dikjstra(3));
//        assertFalse(operator.dikjstra(2));
//        assertFalse(operator.dikjstra(1));
//        assertFalse(operator.dikjstra(0));
//
//        assertEquals(0, operator.getGraph().getNode(0).getTag());
//        assertNotEquals(18, operator.getGraph().getNode(0).getTag());
//        assertEquals(7, operator.getGraph().getNode(1).getTag());
//        assertNotEquals(11.5, operator.getGraph().getNode(1).getTag());
//        assertEquals(9, operator.getGraph().getNode(2).getTag());
//        assertNotEquals(30, operator.getGraph().getNode(2).getTag());
//        assertEquals(20, operator.getGraph().getNode(3).getTag());
//        assertNotEquals(61, operator.getGraph().getNode(3).getTag());
//        assertEquals(20, operator.getGraph().getNode(4).getTag());
//        assertNotEquals(77, operator.getGraph().getNode(4).getTag());
//        assertEquals(11, operator.getGraph().getNode(5).getTag());
//        assertNotEquals(40, operator.getGraph().getNode(5).getTag());
//
//    }
//    /**
//     * Test for connectivity
//     */
//    @Test
//    void connectivity() {
//        WGraph_Algo operator = new WGraph_Algo();
//        operator.init(Djx());
//        assertTrue(operator.isConnected());
//        operator.init(IsNotConnected());
//        assertFalse(operator.isConnected());
//    }
//    /**
//     * Test of shortestPathDist: from every node to every node
//     */
//    @Test//6 tests, for every src of Dikjstra Algorithm
//    void shortestPathDist() {
//        WGraph_Algo operator = new WGraph_Algo();
//        operator.init(Djx());
//
//        assertEquals(0,operator.shortestPathDist(0,0));
//        assertNotEquals(9,operator.shortestPathDist(0,0));
//        assertEquals(7,operator.shortestPathDist(0,1));
//        assertNotEquals(7.2,operator.shortestPathDist(0,1));
//        assertEquals(9,operator.shortestPathDist(0,2));
//        assertEquals(20,operator.shortestPathDist(0,3));
//        assertEquals(20,operator.shortestPathDist(0,4));
//        assertEquals(11,operator.shortestPathDist(0,5));
//
//
//        assertEquals(7,operator.shortestPathDist(1,0));
//        assertEquals(0,operator.shortestPathDist(1,1));
//        assertEquals(10,operator.shortestPathDist(1,2));
//        assertEquals(15,operator.shortestPathDist(1,3));
//        assertEquals(21,operator.shortestPathDist(1,4));
//        assertEquals(12,operator.shortestPathDist(1,5));
//
//
//        assertEquals(9,operator.shortestPathDist(2,0));
//        assertEquals(10,operator.shortestPathDist(2,1));
//        assertEquals(0,operator.shortestPathDist(2,2));
//        assertEquals(11,operator.shortestPathDist(2,3));
//        assertEquals(11,operator.shortestPathDist(2,4));
//        assertEquals(2,operator.shortestPathDist(2,5));
//
//
//        assertEquals(20,operator.shortestPathDist(3,0));
//        assertEquals(15,operator.shortestPathDist(3,1));
//        assertEquals(11,operator.shortestPathDist(3,2));
//        assertEquals(0,operator.shortestPathDist(3,3));
//        assertEquals(6,operator.shortestPathDist(3,4));
//        assertEquals(13,operator.shortestPathDist(3,5));
//
//
//        assertEquals(20,operator.shortestPathDist(4,0));
//        assertEquals(21,operator.shortestPathDist(4,1));
//        assertEquals(11,operator.shortestPathDist(4,2));
//        assertEquals(6,operator.shortestPathDist(4,3));
//        assertEquals(0,operator.shortestPathDist(4,4));
//        assertEquals(9,operator.shortestPathDist(4,5));
//
//
//        assertEquals(11,operator.shortestPathDist(5,0));
//        assertEquals(12,operator.shortestPathDist(5,1));
//        assertEquals(2,operator.shortestPathDist(5,2));
//        assertEquals(13,operator.shortestPathDist(5,3));
//        assertEquals(9,operator.shortestPathDist(5,4));
//        assertEquals(0,operator.shortestPathDist(5,5));
//    }
//    /**
//     * Test of shortestPath: from every node to every node
//     * This test prints all the possible paths.
//     */
//    @Test
//    void shortestPath() {
//        WGraph_Algo operator = new WGraph_Algo();
//        operator.init(Djx());
//        List<node_info> check =operator.shortestPath(0,1);//0 --> 1
//        for (int i = 0; i<2; i++){
//            System.out.print(check.get(i) +" ");
//        }
//        System.out.println();
//        System.out.println();
//        check = operator.shortestPath(0,2);//0 --> 2
//        for (int i = 0; i<2; i++)
//            System.out.print(check.get(i) +" ");
//        System.out.println();
//        System.out.println();
//        check = operator.shortestPath(0,5);//0 --> 2 --> 5
//        for (int i = 0; i<3; i++)
//            System.out.print(check.get(i) +" ");
//        System.out.println();
//        System.out.println();
//        check = operator.shortestPath(0,3);//0 --> 2 --> 3
//        for (int i = 0; i<3; i++)
//            System.out.print(check.get(i) +" ");
//        System.out.println();
//        System.out.println();
//        check = operator.shortestPath(0,4);//0 --> 2 --> 5 --> 4
//        for (int i = 0; i<4; i++)
//            System.out.print(check.get(i) +" ");
//        System.out.println();
//        System.out.println();
//        check = operator.shortestPath(1,0);//1 --> 0
//        for (int i = 0; i<2; i++)
//            System.out.print(check.get(i) +" ");
//        System.out.println();
//        System.out.println();
//        check = operator.shortestPath(1,2);//1 --> 2
//        for (int i = 0; i<2; i++)
//            System.out.print(check.get(i) +" ");
//        System.out.println();
//        System.out.println();
//        check = operator.shortestPath(1,3);//1 --> 3
//        for (int i = 0; i<2; i++)
//            System.out.print(check.get(i) +" ");
//        System.out.println();
//        System.out.println();
//        check = operator.shortestPath(1,4);//1 --> 2 --> 5 --> 4
//        for (int i = 0; i<4; i++)
//            System.out.print(check.get(i) +" ");
//        System.out.println();
//        System.out.println();
//        check = operator.shortestPath(1,5);//1 --> 2 --> 5
//        for (int i = 0; i<3; i++)
//            System.out.print(check.get(i) +" ");
//        System.out.println();
//        System.out.println();
//        check = operator.shortestPath(2,0);//2 --> 0
//        for (int i = 0; i<2; i++)
//            System.out.print(check.get(i) +" ");
//        System.out.println();
//        System.out.println();
//        check = operator.shortestPath(2,1);//2 --> 1
//        for (int i = 0; i<2; i++)
//            System.out.print(check.get(i) +" ");
//        System.out.println();
//        System.out.println();
//        check = operator.shortestPath(2,3);//2 --> 3
//        for (int i = 0; i<2; i++)
//            System.out.print(check.get(i) +" ");
//        System.out.println();
//        System.out.println();
//        check = operator.shortestPath(2,4);//2 --> 5 --> 4
//        for (int i = 0; i<3; i++)
//            System.out.print(check.get(i) +" ");
//        System.out.println();
//        System.out.println();
//        check = operator.shortestPath(2,5);//2 --> 5
//        for (int i = 0; i<2; i++)
//            System.out.print(check.get(i) +" ");
//        System.out.println();
//        System.out.println();
//        check = operator.shortestPath(3,0);//3 --> 2 --> 0
//        for (int i = 0; i<3; i++)
//            System.out.print(check.get(i) +" ");
//        System.out.println();
//        System.out.println();
//        check = operator.shortestPath(3,1);//3 --> 1
//        for (int i = 0; i<2; i++)
//            System.out.print(check.get(i) +" ");
//        System.out.println();
//        System.out.println();
//        check = operator.shortestPath(3,2);//3 --> 2
//        for (int i = 0; i<2; i++)
//            System.out.print(check.get(i) +" ");
//        System.out.println();
//        System.out.println();
//        check = operator.shortestPath(3,4);//3 --> 4
//        for (int i = 0; i<2; i++)
//            System.out.print(check.get(i) +" ");
//        System.out.println();
//        System.out.println();
//        check = operator.shortestPath(3,5);//3 --> 2 --> 5
//        for (int i = 0; i<3; i++)
//            System.out.print(check.get(i) +" ");
//        System.out.println();
//        System.out.println();
//        check = operator.shortestPath(4,0);//4 --> 5 --> 2 --> 0
//        for (int i = 0; i<4; i++)
//            System.out.print(check.get(i) +" ");
//        System.out.println();
//        System.out.println();
//        check = operator.shortestPath(4,1);//4 --> 3 --> 1
//        for (int i = 0; i<3; i++)
//            System.out.print(check.get(i) +" ");
//        System.out.println();
//        System.out.println();
//        check = operator.shortestPath(4,2);//4 --> 5 --> 2
//        for (int i = 0; i<3; i++)
//            System.out.print(check.get(i) +" ");
//        System.out.println();
//        System.out.println();
//        check = operator.shortestPath(4,3);//4 --> 3
//        for (int i = 0; i<2; i++)
//            System.out.print(check.get(i) +" ");
//        System.out.println();
//        System.out.println();
//        check = operator.shortestPath(4,5);//4 --> 5
//        for (int i = 0; i<2; i++)
//            System.out.print(check.get(i) +" ");
//        System.out.println();
//        System.out.println();
//        check = operator.shortestPath(5,4);//5 --> 4
//        for (int i = 0; i<2; i++)
//            System.out.print(check.get(i) +" ");System.out.println();
//        System.out.println();
//        check = operator.shortestPath(5,3);//5 --> 2 --> 3
//        for (int i = 0; i<3; i++)
//            System.out.print(check.get(i) +" ");
//        System.out.println();
//        System.out.println();
//        check = operator.shortestPath(5,2);//5 --> 2
//        for (int i = 0; i<2; i++)
//            System.out.print(check.get(i) +" ");System.out.println();
//        System.out.println();
//        System.out.println();
//        check = operator.shortestPath(5,1);//5 --> 2 --> 1
//        for (int i = 0; i<3; i++)
//            System.out.print(check.get(i) +" ");
//        System.out.println();
//        System.out.println();
//        check = operator.shortestPath(5,0);//5 --> 2 --> 0
//        for (int i = 0; i<3; i++)
//            System.out.print(check.get(i) +" ");
//    }
//    /**
//     * Initialization  operator on Djx. Then, save Djx in file whose name is "myGraph".
//     * After this, replace the graph of operator to IsNotConnected.
//     * Load operator on "myGraph" file. Now, operator operates Djx again, instead of IsNotConnected.
//     */
//    @Test
//    void saveAndLoad() {
//        WGraph_Algo operator = new WGraph_Algo();
//        operator.init(Djx());
//        assertFalse(operator.save(""));
//        assertTrue(operator.save("myGraph"));
//        operator.init(IsNotConnected());
//        assertFalse(operator.load(""));
//        assertFalse(operator.load("fakeFile"));
//        assertTrue(operator.load("myGraph"));
//        assertFalse(operator.getGraph().equals(IsNotConnected()));
//        assertTrue(operator.getGraph().equals(Djx()));
//    }
//
//}
package ex1.tests;

import ex1.src.WGraph_Algo;
import ex1.src.node_info;
import ex1.src.weighted_graph;
import ex1.src.weighted_graph_algorithms;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WGraph_AlgoTest {

    @Test
    void isConnected() {
        weighted_graph g0 = WGraph_DSTest.graph_creator(0,0,1);
        weighted_graph_algorithms ag0 = new WGraph_Algo();
        ag0.init(g0);
        assertTrue(ag0.isConnected());

        g0 = WGraph_DSTest.graph_creator(1,0,1);
        ag0 = new WGraph_Algo();
        ag0.init(g0);
        assertTrue(ag0.isConnected());

        g0 = WGraph_DSTest.graph_creator(2,0,1);
        ag0 = new WGraph_Algo();
        ag0.init(g0);
        assertFalse(ag0.isConnected());

        g0 = WGraph_DSTest.graph_creator(2,1,1);
        ag0 = new WGraph_Algo();
        ag0.init(g0);
        assertTrue(ag0.isConnected());

        g0 = WGraph_DSTest.graph_creator(10,30,1);
        ag0.init(g0);
        boolean b = ag0.isConnected();
        assertTrue(b);
    }

    @Test
    void shortestPathDist() {
        weighted_graph g0 = small_graph();
        weighted_graph_algorithms ag0 = new WGraph_Algo();
        ag0.init(g0);
        assertTrue(ag0.isConnected());
        double d = ag0.shortestPathDist(0,10);
        assertEquals(d, 5.1);
    }

    @Test
    void shortestPath() {
        weighted_graph g0 = small_graph();
        weighted_graph_algorithms ag0 = new WGraph_Algo();
        ag0.init(g0);
        List<node_info> sp = ag0.shortestPath(0,10);
        //double[] checkTag = {0.0, 1.0, 2.0, 3.1, 5.1};
        int[] checkKey = {0, 1, 5, 7, 10};
        int i = 0;
        for(node_info n: sp) {
            //assertEquals(n.getTag(), checkTag[i]);
            assertEquals(n.getKey(), checkKey[i]);
            i++;
        }
    }

    @Test
    void save_load() {
        weighted_graph g0 = WGraph_DSTest.graph_creator(10,30,1);
        weighted_graph_algorithms ag0 = new WGraph_Algo();
        ag0.init(g0);
        String str = "g0.obj";
        ag0.save(str);
        weighted_graph g1 = WGraph_DSTest.graph_creator(10,30,1);
        ag0.load(str);
        assertEquals(g0,g1);
        g0.removeNode(0);
        assertNotEquals(g0,g1);
    }

    private weighted_graph small_graph() {
        weighted_graph g0 = WGraph_DSTest.graph_creator(11,0,1);
        g0.connect(0,1,1);
        g0.connect(0,2,2);
        g0.connect(0,3,3);

        g0.connect(1,4,17);
        g0.connect(1,5,1);
        g0.connect(2,4,1);
        g0.connect(3, 5,10);
        g0.connect(3,6,100);
        g0.connect(5,7,1.1);
        g0.connect(6,7,10);
        g0.connect(7,10,2);
        g0.connect(6,8,30);
        g0.connect(8,10,10);
        g0.connect(4,10,30);
        g0.connect(3,9,10);
        g0.connect(8,10,10);

        return g0;
    }
}