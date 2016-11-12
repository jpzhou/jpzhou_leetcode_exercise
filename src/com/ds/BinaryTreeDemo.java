package com.ds;

import java.util.Scanner;

/**
 * Created by jiping_zhou on 2016/10/29.
 * http://blog.csdn.net/luckyxiaoqiang/article/details/7518888  ���ɸ㶨�����еĶ�������Ŀ
 * http://www.cnblogs.com/Jax/archive/2009/12/28/1633691.html  �㷨��ȫ��3�� ������
 * 1. ��������еĽڵ����: getNodeNumRec���ݹ飩��getNodeNum��������
 * 2. ������������: getDepthRec���ݹ飩��getDepth
 * 3. ǰ�����������������������: preorderTraversalRec, preorderTraversal, inorderTraversalRec, postorderTraversalRec
 * (https://en.wikipedia.org/wiki/Tree_traversal#Pre-order_2)
 * 4.�ֲ����������������δ������£��������ң�: levelTraversal, levelTraversalRec���ݹ�ⷨ����
 * 5. �������������Ϊ�����˫������: convertBST2DLLRec, convertBST2DLL
 * 6. ���������K��Ľڵ������getNodeNumKthLevelRec, getNodeNumKthLevel
 * 7. ���������Ҷ�ӽڵ�ĸ�����getNodeNumLeafRec, getNodeNumLeaf
 * 8. �ж����ö������Ƿ���ͬ������isSameRec, isSame
 * 9. �ж϶������ǲ���ƽ���������isAVLRec
 * 10. ��������ľ����ƻ��Ͳ��ƻ�ԭ�����������������mirrorRec, mirrorCopyRec
 * 10.1 �ж��������Ƿ��ྵ��isMirrorRec
 * 11. ��������������ڵ����͹������Ƚڵ㣺getLastCommonParent, getLastCommonParentRec, getLastCommonParentRec2
 * 12. ��������нڵ�������룺getMaxDistanceRec
 * 13. ��ǰ��������к�������������ؽ���������rebuildBinaryTreeRec
 * 14.�ж϶������ǲ�����ȫ��������isCompleteBinaryTree, isCompleteBinaryTreeRec
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
