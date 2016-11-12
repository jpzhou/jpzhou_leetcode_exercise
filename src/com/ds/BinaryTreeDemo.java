package com.ds;

import java.util.Scanner;

/**
 * Created by jiping_zhou on 2016/10/29.
 * http://blog.csdn.net/luckyxiaoqiang/article/details/7518888  轻松搞定面试中的二叉树题目
 * http://www.cnblogs.com/Jax/archive/2009/12/28/1633691.html  算法大全（3） 二叉树
 * 1. 求二叉树中的节点个数: getNodeNumRec（递归），getNodeNum（迭代）
 * 2. 求二叉树的深度: getDepthRec（递归），getDepth
 * 3. 前序遍历，中序遍历，后序遍历: preorderTraversalRec, preorderTraversal, inorderTraversalRec, postorderTraversalRec
 * (https://en.wikipedia.org/wiki/Tree_traversal#Pre-order_2)
 * 4.分层遍历二叉树（按层次从上往下，从左往右）: levelTraversal, levelTraversalRec（递归解法！）
 * 5. 将二叉查找树变为有序的双向链表: convertBST2DLLRec, convertBST2DLL
 * 6. 求二叉树第K层的节点个数：getNodeNumKthLevelRec, getNodeNumKthLevel
 * 7. 求二叉树中叶子节点的个数：getNodeNumLeafRec, getNodeNumLeaf
 * 8. 判断两棵二叉树是否相同的树：isSameRec, isSame
 * 9. 判断二叉树是不是平衡二叉树：isAVLRec
 * 10. 求二叉树的镜像（破坏和不破坏原来的树两种情况）：mirrorRec, mirrorCopyRec
 * 10.1 判断两个树是否互相镜像：isMirrorRec
 * 11. 求二叉树中两个节点的最低公共祖先节点：getLastCommonParent, getLastCommonParentRec, getLastCommonParentRec2
 * 12. 求二叉树中节点的最大距离：getMaxDistanceRec
 * 13. 由前序遍历序列和中序遍历序列重建二叉树：rebuildBinaryTreeRec
 * 14.判断二叉树是不是完全二叉树：isCompleteBinaryTree, isCompleteBinaryTreeRec
 *
 */




public class BinaryTreeDemo {
    /**
                     1
                 /      \
                2        3
              /  \      /  \
             4    5    #    6
            /\    /\        /\
           #  #  #  #      #  #

     */

    static class TreeNode{
        String val;
        TreeNode left;
        TreeNode right;

        public TreeNode(){}

        public TreeNode(String val){
            this.val = val;
        }

        public void setNode(String val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    void createBinaryTree(TreeNode T) {
        Scanner sc = new Scanner(System.in);
        String value = sc.next();
//        System.out.println(value);
        if(value.equals("#")){
            T = null;
        }else{
            T.setNode(value, new TreeNode(), new TreeNode());
            createBinaryTree(T.left);
            createBinaryTree(T.right);
        }
    }

    void preOrderTraversalRec(TreeNode T){
        if(T == null || T.val == null) return;
        System.out.println(T.val);
        preOrderTraversalRec(T.left);
        preOrderTraversalRec(T.right);
    }

    void inOrderTraversalRec(TreeNode T){
        if(T == null || T.val == null) return;
        inOrderTraversalRec(T.left);
        System.out.println(T.val);
        inOrderTraversalRec(T.right);
    }

    void postOrderTraversalRec(TreeNode T){
        if(T == null || T.val == null) return;
        inOrderTraversalRec(T.left);
        inOrderTraversalRec(T.right);
        System.out.println(T.val);
    }

    int getNodeNumRec(TreeNode T){
        int nodeNum = 0;
        if(T == null || T.val == null) return nodeNum;
        nodeNum += 1;
        nodeNum += getNodeNumRec(T.left);
        nodeNum += getNodeNumRec(T.right);
        return nodeNum;
    }

    int getDepthRec(TreeNode T){
        int depth = 0;
        if(T == null || T.val == null) return depth;
        int leftDepth, rightDepth;
        leftDepth = getNodeNumRec(T.left) + 1;
        rightDepth = getNodeNumRec(T.right) + 1;
        return (leftDepth >= rightDepth)?leftDepth:rightDepth;
    }

    public static void main(String args[]){
//        String[] s = new String[]{"1", "2", "4", "#", "#", "5", "#", "#", "3", "#", "6", "#", "#"};
//        String[] s = new String[]{"A", "B", "D", "G", "#", "#", "C", "#", "F", "#", "#"};
        BinaryTreeDemo b = new BinaryTreeDemo();
        TreeNode T = new TreeNode();
        b.createBinaryTree(T);
        System.out.println("---------------preOrderTraversalRec---------------");
        b.preOrderTraversalRec(T);
        System.out.println("---------------inOrderTraversalRec---------------");
        b.inOrderTraversalRec(T);
        System.out.println("---------------postOrderTraversalRec---------------");
        b.postOrderTraversalRec(T);
        System.out.println("---------------getNodeNumRec---------------");
        System.out.println(b.getNodeNumRec(T));
        System.out.println("---------------getDepthRec---------------");
        System.out.println(b.getDepthRec(T));
    }
}
