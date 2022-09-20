class BST1_class { 
        class Node { 
            int key; 
            Node left, right; 
       
            public Node(int data){ 
                key = data; 
                left = right = null; 
            } 
        } 
        Node root; 
        BST1_class(){ 
            root = null; 
        } 

        void deleteKey(int key) { 
            root = delete_Recursive(root, key); 
        } 

        Node delete_Recursive(Node root, int key)  { 

            if (root == null)  return root; 

            if (key < root.key)     
                root.left = delete_Recursive(root.left, key); 
            else if (key > root.key)  
                root.right = delete_Recursive(root.right, key); 
            else  { 
                if (root.left == null) 
                    return root.right; 
                else if (root.right == null) 
                    return root.left; 
                root.key = minValue(root.right); 
                root.right = delete_Recursive(root.right, root.key); 
            } 
            return root; 
        } 
       
        int minValue(Node root)  { 
            int minval = root.key; 
            while (root.left != null)  { 
                minval = root.left.key; 
                root = root.left; 
            } 
            return minval; 
        } 
       
        void insert(int key)  { 
            root = insert_Recursive(root, key); 
        } 
       
        Node insert_Recursive(Node root, int key) { 

            if (root == null) { 
                root = new Node(key); 
                return root; 
            } 

            if (key < root.key)     
                root.left = insert_Recursive(root.left, key); 
            else if (key > root.key)   
                root.right = insert_Recursive(root.right, key); 
            return root; 
        } 
     
        void inorder() { 
            inorder_Recursive(root); 
        } 

        void inorder_Recursive(Node root) { 
            if (root != null) { 
                inorder_Recursive(root.left); 
                System.out.print(root.key + " "); 
                inorder_Recursive(root.right); 
            } 
        } 
         
        boolean search(int key)  { 
            root = search_Recursive(root, key); 
            if (root!= null)
                return true;
            else
                return false;
        } 
       
        Node search_Recursive(Node root, int key)  { 

            if (root==null || root.key==key) 
                return root; 

            if (root.key > key) 
                return search_Recursive(root.left, key); 

            return search_Recursive(root.right, key); 
        } 
    }
    class Main{
        public static void main(String[] args)  { 
            BST1_class bst = new BST1_class(); 
            /* BST tree example
                  45 
               /     \ 
              10      90 
             /  \    /   
            7   12  50   */
            //ввод данных 
            bst.insert(37); 
            bst.insert(8); 
            bst.insert(1); 
            bst.insert(15); 
            bst.insert(94); 
            bst.insert(52); 
            //вывод BST
            System.out.println("Создано дерево со следующими входными данными (слева-корень-справа):"); 
            bst.inorder(); 
            
            System.out.println("\nпосле удалим 15 (конечный узел):"); 
            bst.deleteKey(15); 
            bst.inorder(); 

            System.out.println("\nпосле удаления 94 (узел с 1 дочерним элементом):"); 
            bst.deleteKey(94); 
            bst.inorder(); 
                     
            System.out.println("\nпосле удаления 37 (узел с двумя дочерними элементами):"); 
            bst.deleteKey(37); 
            bst.inorder(); 

            boolean ret_val = bst.search (52);
            System.out.println("\nКлюч 52 найден в BST:" + ret_val );
            ret_val = bst.search (15);
            System.out.println("\nКлюч 15 найден в BST:" + ret_val );
} 
}

