package binary_trees;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree {
    /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null){
            return "";
        }
        StringBuilder serializedString = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){

            TreeNode curr = q.poll();
            if(curr == null){
                serializedString.append("#,");
            }else{
                serializedString.append(curr.val).append(",");
                q.offer(curr.left);
                q.offer(curr.right);
            }
        }

        return serializedString.toString();

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == ""){
            return null;
        }

        StringBuilder deserializedString = new StringBuilder(data);

        int delimeterIdx = deserializedString.indexOf(",");
        String rootStr = deserializedString.substring(0, delimeterIdx);
        deserializedString.delete(0, delimeterIdx + 1);
        TreeNode root = new TreeNode(Integer.parseInt(rootStr));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode curr = q.poll();

            delimeterIdx = deserializedString.indexOf(",");
            rootStr = deserializedString.substring(0, delimeterIdx);
            deserializedString.delete(0, delimeterIdx + 1);
            if(!rootStr.equals("#")){
                TreeNode leftNode = new TreeNode(Integer.parseInt(rootStr));
                curr.left = leftNode;
                q.offer(leftNode);
            }

            delimeterIdx = deserializedString.indexOf(",");
            rootStr = deserializedString.substring(0, delimeterIdx);
            deserializedString.delete(0, delimeterIdx + 1);

            if(!rootStr.equals("#")){
                TreeNode rightNode = new TreeNode(Integer.parseInt(rootStr));
                curr.right = rightNode;
                q.offer(rightNode);
            }

        }

        return root;

    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
}
