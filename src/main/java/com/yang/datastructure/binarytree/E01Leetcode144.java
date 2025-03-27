package com.yang.datastructure.binarytree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树前序遍历（值，左，右）
 */
public class E01Leetcode144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        return null;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(
                new TreeNode(new TreeNode(4), 2, null),
                1,
                new TreeNode(new TreeNode(5), 3, new TreeNode(6))
        );

        LinkedList<TreeNode> stack = new LinkedList<>();

        TreeNode curr = root;  // 当前节点
        while (curr != null || !stack.isEmpty()) {

            if (curr != null) {
                colorPrintln("去: " + curr.val, 31);
                stack.push(curr);  // 压入栈，为了记住回来的路
                curr = curr.left;
            } else {
                TreeNode pop = stack.pop();
                colorPrintln("回: " + pop.val, 34);
                curr = pop.right;
            }
        }
    }

    /*
        31 红
        32 黄
        33 橙
        34 蓝
        35 紫
        36 绿
     */
    public static void colorPrintln(String origin, int color) {
        System.out.printf("\033[%dm%s\033[0m%n", color, origin);
    }

}
