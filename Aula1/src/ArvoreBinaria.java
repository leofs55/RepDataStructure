public class ArvoreBinaria {
    
    public static class Node{
        private String name;
        private Node left, rigth;

        public Node(String value) {
            this.name = value;
            left = rigth = null;
        }
    }

    public Node root;

    public void set(String name) {
        Node newNode = new Node(name);

        if (root == null) {
            root = newNode;
            return;
        }

        Node actNode = root;
        Node fatherNode = null;
        
        while (actNode != null) {
            fatherNode = actNode;

            if (name.compareToIgnoreCase(actNode.name) < 0) {
                actNode = actNode.left;
            } else if (name.compareToIgnoreCase(actNode.name) > 0) {
                actNode = actNode.rigth;
            }
        }

        if (name.compareToIgnoreCase(fatherNode.name) < 0) {
            fatherNode.left = newNode;
        } else {
            fatherNode.rigth = newNode;
        }

    }
    
    public Node search(String name) {
        Node currentNode = root;

        while (currentNode != null) {
            if (name.compareToIgnoreCase(currentNode.name) == 0) {
                return currentNode;
            }
            else if (name.compareToIgnoreCase(currentNode.name) < 0) {
                currentNode = currentNode.left;
            }
            else {
                currentNode = currentNode.rigth;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ArvoreBinaria arvoreBinaria = new ArvoreBinaria();
        String[] names = {
            "Ana", "Carlos", "Pedro", "Mariana", "Lucas", 
            "João", "Beatriz", "Fernanda", "Rafael", "Gabriela"
        };

        for (String name : names) {
            arvoreBinaria.set(name);
        }
        
        System.out.println(arvoreBinaria.search("Nomeee"));
    }
}
