package com.yang.datastructure.binarysearchtree;

/**
 * 二叉搜索树，泛型 key 版本
 */
public class BSTTree2<K extends Comparable<K>, V> {

    static class BSTNode<K, V> {
        K key;
        V value;
        BSTNode<K, V> left;
        BSTNode<K, V> right;

        public BSTNode(K key) {
            this.key = key;
        }

        public BSTNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public BSTNode(K key, V value, BSTNode<K, V> left, BSTNode<K, V> right) {
            this.key = key;
            this.left = left;
            this.right = right;
            this.value = value;
        }
    }

    BSTNode<K, V> root;  // 根节点

    /**
     * <h3>查找关键字对应的值</h3>
     *
     * @param key 关键字
     * @return 关键字对应的值
     */
    public Object get(K key) {
        // key 改成了泛型，有可能是 null，可以优化一下判断是否为 null
        BSTNode<K, V> p = root;

        while (p != null) {
            /*
                -1 key < p.key
                0  key == p.key
                1  key > p.key
             */
            int result = key.compareTo(p.key);
            if (result < 0) {
                p = p.left;
            } else if (result > 0) {
                p = p.right;
            } else {
                return p.value;
            }
        }
        return null;
    }

}
