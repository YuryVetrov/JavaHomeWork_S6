public class binary_tree_traversal {
    int key; 
    binary_tree_traversal left, right; 
   
    public binary_tree_traversal(int data){ 
        key = data; 
        left = right = null; 
    } 
} 
class BST_class { 
    binary_tree_traversal root; 
    BST_class(){ 
        root = null; 
    } 

    void postOrder(binary_tree_traversal binary_tree_traversal)  { 
        if (binary_tree_traversal == null) 
            return; 

        postOrder(binary_tree_traversal.left); 
        postOrder(binary_tree_traversal.right); 
        System.out.print(binary_tree_traversal.key + " "); 
    } 
    void inOrder(binary_tree_traversal binary_tree_traversal)  { 
        if (binary_tree_traversal == null) 
            return; 

        inOrder(binary_tree_traversal.left); 
        System.out.print(binary_tree_traversal.key + " "); 
        inOrder(binary_tree_traversal.right); 
    } 
   
    void preOrder(binary_tree_traversal binary_tree_traversal)  { 
        if (binary_tree_traversal == null) 
            return; 

        System.out.print(binary_tree_traversal.key + " "); 
        preOrder(binary_tree_traversal.left); 
        preOrder(binary_tree_traversal.right); 
    } 
    void postOrder_traversal()  {    
        postOrder(root);  } 
    void inOrder_traversal() { 
        inOrder(root);   } 
    void preOrder_traversal() {
        preOrder(root);  } 
}
class Main{
    public static void main(String[] args) { 
        BST_class tree = new BST_class(); 
        /*        45
                //  \\
                10   90  
               // \\
               7   12      */
        tree.root = new binary_tree_traversal(45); 
        tree.root.left = new binary_tree_traversal(10); 
        tree.root.right = new binary_tree_traversal(90); 
        tree.root.left.left = new binary_tree_traversal(7); 
        tree.root.left.right = new binary_tree_traversal(12); 
        //PreOrder Traversal
        System.out.println("BST => Обход типа пред-заказа:"); 
        tree.preOrder_traversal(); 
        //InOrder Traversal
        System.out.println("\nBST => Порядковый обход:"); 
        tree.inOrder_traversal(); 
        //PostOrder Traversal
        System.out.println("\nBST => Обход типа пост-заказа:"); 
        tree.postOrder_traversal(); 
    } 
}

