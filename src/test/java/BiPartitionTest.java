import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BiPartitionTest {

    /**
     * 测试目的：验证基本功能，能分组的情况
     */
    @Test
    public void testCanPartition() {
        BiPartition s = new BiPartition();
        int[][] dislikes = {{1, 2}, {1, 3}, {2, 4}};
        assertTrue(s.possibleBiPartition(4, dislikes));
    }

    /**
     * 测试目的：验证基本功能，不能分组的情况
     */
    @Test
    public void testCannotPartition() {
        BiPartition s = new BiPartition();
        int[][] dislikes1 = {{1, 2}, {1, 3}, {2, 3}};
        int[][] dislikes2 = {{1, 2}, {2, 3}, {3, 4}, {4, 5}, {1, 5}};
        assertFalse(s.possibleBiPartition(3, dislikes1));
        assertFalse(s.possibleBiPartition(5, dislikes2));
    }

    /**
     * 测试目的：验证边界值 n = 1
     */
    @Test
    public void testSinglePerson() {
        BiPartition s = new BiPartition();
        assertTrue(s.possibleBiPartition(1, new int[0][0]));
    }

    /**
     * 测试目的：验证 dislikes 数组为空
     */
    @Test
    public void testEmptyDislikes() {
        BiPartition s = new BiPartition();
        assertTrue(s.possibleBiPartition(5, new int[0][0]));
    }

    /**
     * 测试目的：验证孤立节点
     */
    @Test
    public void testIsolatedNodes() {
        BiPartition s = new BiPartition();
        int[][] dislikes = {{1, 2}};
        assertTrue(s.possibleBiPartition(3, dislikes));
    }

    /**
     * 测试目的：验证不连通图
     */
    @Test
    public void testDisconnectedGraph() {
        BiPartition s = new BiPartition();
        int[][] dislikes = {{1, 2}, {3, 4}};
        assertTrue(s.possibleBiPartition(4, dislikes));
    }

    /**
     * 测试目的：验证 dislikes 长度接近 10⁴ 的情况
     */
    @Test
    public void testLargeDislikes() {
        BiPartition s = new BiPartition();
        int n = 10000;
        int[][] dislikes = new int[9999][2];
        for (int i = 0; i < 9999; i++) {
            dislikes[i][0] = i + 1;
            dislikes[i][1] = i + 2;
        }
        assertTrue(s.possibleBiPartition(n, dislikes));
    }
}