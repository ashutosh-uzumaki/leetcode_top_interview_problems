package binary_trees;

import java.util.ArrayList;

class BinaryTreeNode<T> {
    T data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;
            
    public BinaryTreeNode(T data) {
        this.data = data;
    }
}

public class RootToChildrenSum {
    public static ArrayList<Integer> sumTree(BinaryTreeNode<Integer> root) {
        generateSumTree(root);
        ArrayList<Integer> preorder = new ArrayList<>();
        generatePreorder(root, preorder);
        return preorder;
    }

    public static void generatePreorder(BinaryTreeNode<Integer> root, ArrayList<Integer> preorder) {
        if (root == null) {
            return;
        }

        preorder.add(root.data);
        generatePreorder(root.left, preorder);
        generatePreorder(root.right, preorder);
    }

    public static int generateSumTree(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            int originalValue = root.data;
            root.data = 0;
            return originalValue;
        }

        int left = generateSumTree(root.left);
        int right = generateSumTree(root.right);

        int originalValue = root.data;
        root.data = left + right;
        return originalValue;
    }
}
