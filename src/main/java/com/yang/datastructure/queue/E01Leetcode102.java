package com.yang.datastructure.queue;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树层序遍历
 */
public class E01Leetcode102 {
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        LinkedListQueue<TreeNode> queue = new LinkedListQueue<>();

        queue.offer(root);
        int c1 = 1;  // 当前层节点数
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int c2 = 0;  // 下一层节点数
            for (int i = 0; i < c1; i++) {
                TreeNode n = queue.poll();
                level.add(n.val);

                if (n.left != null) {
                    queue.offer(n.left);
                    c2++;
                }

                if (n.right != null) {
                    queue.offer(n.right);
                    c2++;
                }
            }
            result.add(level);
            c1 = c2;

        }
        return result;
    }

    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) return result;

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        int c1 = 1;  // 当前层节点数
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int c2  = 0; // 下一层节点数
            for (int i = 0; i<c1;i++) {
                TreeNode n = queue.removeFirst();
                level.add(n.val);
                if(n.left != null) {
                    queue.addLast(n.left);
                    c2++;
                }
                if(n.right != null) {
                    queue.addLast(n.right);
                    c2++;
                }
            }

            result.add(level);
            c1 = c2;

        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(
                new TreeNode(
                        new TreeNode(4),
                        2,
                        new TreeNode(5)
                ),
                1,
                new TreeNode(
                        new TreeNode(6),
                        3,
                        new TreeNode(7)
                )
        );

        LinkedListQueue<TreeNode> queue = new LinkedListQueue<>();

        queue.offer(root);
        int c1 = 1;  // 当前层节点数
        while (!queue.isEmpty()) {
            int c2 = 0;  // 下一层节点数
            for (int i = 0; i < c1; i++) {
                TreeNode n = queue.poll();
                System.out.print(n + " ");

                if (n.left != null) {
                    queue.offer(n.left);
                    c2++;
                }

                if (n.right != null) {
                    queue.offer(n.right);
                    c2++;
                }
            }

            System.out.println();

            c1 = c2;

        }

        List<List<Integer>> lists = new E01Leetcode102().levelOrder1(root);
        System.out.println(lists);
    }
}
