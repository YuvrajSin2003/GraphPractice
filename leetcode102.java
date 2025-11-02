class leetcode102{
    public List<List<Integer>> levelorder(TreeNode node){
        List<List<Integer>> result = new ArrayList<>();
        if(node == null) return result;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);

        while(!queue.isEmpty){
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for(int i = 0 ; i < size ; i++){
                TreeNode current = queue.poll();
                level.add(current);
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            result.add(level);
        }
        return result;
    }
}