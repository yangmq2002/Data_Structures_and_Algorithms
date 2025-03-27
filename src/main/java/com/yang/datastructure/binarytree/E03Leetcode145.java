package com.yang.datastructure.binarytree;

import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树后序遍历（值，左，右）
 */
public class E03Leetcode145 {
    public List<Integer> preorderTraversal(TreeNode root) {
        return null;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(
                new TreeNode(new TreeNode(4), 2, new TreeNode(7)),
                1,
                new TreeNode(new TreeNode(5), 3, new TreeNode(6))
        );

        LinkedList<TreeNode> stack = new LinkedList<>();

        TreeNode curr = root;  // 当前节点
        TreeNode pop = null;  // 最近一次弹栈的元素
        while (curr != null || !stack.isEmpty()) {

            if (curr != null) {
                stack.push(curr);  // 压入栈，为了记住回来的路

                // 待处理左子树
                colorPrintln("前:" + curr.val, 31);
                curr = curr.left;
            } else {
                TreeNode peek = stack.peek();  // 栈顶元素
                // 没有右子树
                if (peek.right == null) {  // 右子树处理完成
                    colorPrintln("中:" + peek.val, 36);
                    pop = stack.pop();
                    colorPrintln("后:" + pop.val, 34);
                }
                // 右子树处理完成
                else if (peek.right == pop) {
                    pop = stack.pop();
                    colorPrintln("后:" + pop.val, 34);
                }
                // 待处理右子树
                else {
                    colorPrintln("中:" + peek.val, 36);
                    curr = peek.right;
                }
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
