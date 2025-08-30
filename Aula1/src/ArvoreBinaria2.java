package com.aula3;

public class ArvoreBinaria2 {

    public static class Node{
        private String name;
        private Node left, rigth;

        public Node(String value) {
            this.name = value;
            left = rigth = null;
        }
    }

    public Node root;

    public String add(String name) {
        Node actNde = addRecursivo(root, name);
        if (actNde.name == null) {
            return "Nome adcionado: " + name;
        }
        return "Nome nao conseguiu ser adicionado: " + name;
    }

    private Node addRecursivo(Node node ,String name) {
        if (node == null) {
            return new Node(name);
        }
        if (name.compareToIgnoreCase(node.name) < 0) {
            node.left = addRecursivo(node.left, name);

        } else if (name.compareToIgnoreCase(node.name) > 0) {
            node.rigth = addRecursivo(node.rigth, name);  
        }
        return node;
    }

    public void sort() {
        System.out.println();
        sorting(root);
    }

    private void sorting(Node node) {
        if (node != null) {
            sorting(node.left);
            System.out.println(node.name);
            sorting(node.rigth);
        }
    }

    public boolean find(String nome) {
        return findRecursive(root, nome);
    }

    private boolean findRecursive(Node node, String name) {
        if (node == null) return false;

        if (name.equalsIgnoreCase(node.name)) return true;

        if (name.compareToIgnoreCase(root.name) < 0) {
            return findRecursive(node.left, name);
        } else {
            return findRecursive(node.rigth, name);
        }
    }

    public static void main(String[] args) {
        ArvoreBinaria2 arvoreBinaria = new ArvoreBinaria2();
        String[] names = {
            "Ana", "Carlos", "Pedro", "Mariana", "Lucas", 
            "João", "Beatriz", "Fernanda", "Rafael", "Gabriela"
        };

        for (String name : names) {
            arvoreBinaria.add(name);
        }
        
        if (arvoreBinaria.find("Carlos")) {
            System.out.println("Carlos foi encontrado");
        } else {
            System.out.println("Carlos não foi encontrado");
        }

        arvoreBinaria.sort();
    }
}
