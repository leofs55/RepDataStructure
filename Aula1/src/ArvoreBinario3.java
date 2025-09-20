import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

public class ArvoreBinario3 {
    
    public static class Agenda {
        String name;
        String address;
        String tel;

        public Agenda(String name, String address, String tel) {
            this.name = name;
            this.address = address;
            this.tel = tel;
        }
    }

    public static class Node {
        private Agenda agenda;
        private Node left, right;

        public Node(Agenda obj) {
            this.agenda = obj;
            left = right = null;
        }
    }

    public Node root;

    public String add(Agenda agenda) {
        root = addRecursivo(root, agenda);
        return "Nome adicionado: " + agenda.name;
    }

    private Node addRecursivo(Node node, Agenda agenda) {
        if (node == null) {
            return new Node(agenda);
        }

        int cmp = agenda.name.compareToIgnoreCase(node.agenda.name);

        if (cmp < 0) {
            node.left = addRecursivo(node.left, agenda);
        } else if (cmp > 0) {
            node.right = addRecursivo(node.right, agenda);
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
            System.out.println(node.agenda.name);
            sorting(node.right);
        }
    }

    public boolean find(Agenda agenda) {
        return findRecursive(root, agenda);
    }

    private boolean findRecursive(Node node, Agenda agenda) {
        if (node == null) return false;

        if (agenda.name.equalsIgnoreCase(node.agenda.name)) return true;

        if (agenda.name.compareToIgnoreCase(node.agenda.name) < 0) {
            return findRecursive(node.left, agenda);
        } else {
            return findRecursive(node.right, agenda);
        }
    }

    void emNivel() {
        System.out.println("Nmes em nivel:");
        if (root == null) return;
        Queue<Node> filaQueue = new LinkedList<>();
        filaQueue.add(root);
        while (!filaQueue.isEmpty()) {
            Node actNode = filaQueue.poll();
            System.out.println(actNode.agenda.name + " ");
            if (actNode.left != null) {
                filaQueue.add(actNode.left);
            }if (actNode.right != null) {
                filaQueue.add(actNode.right);
            }
        }
    }

    public static void main(String[] args) {
        ArvoreBinario3 arvoreBinaria = new ArvoreBinario3();
        Set<Agenda> agendas = new TreeSet<>();
        Agenda[] contatos = {
            new Agenda("Lucas",    "Rua A, 123", "1111-1111"),
            new Agenda("Lucas",    "Rua A, 123", "1111-1111"),
            new Agenda("Amanda",   "Rua B, 456", "2222-2222"),
            new Agenda("Bruno",    "Rua C, 789", "3333-3333"),
            new Agenda("Carla",    "Rua D, 101", "4444-4444"),
            new Agenda("Eduardo",  "Rua E, 202", "5555-5555"),
            new Agenda("Fernanda", "Rua F, 303", "6666-6666"),
            new Agenda("Gustavo",  "Rua G, 404", "7777-7777"),
            new Agenda("Helena",   "Rua H, 505", "8888-8888"),
            new Agenda("Igor",     "Rua I, 606", "9999-9999"),
            new Agenda("Beatriz",  "Rua J, 707", "0000-0000")
        };

        for (Agenda coontato : contatos) {
            arvoreBinaria.add(coontato);
            agendas.add(coontato);
        }

        System.out.println("Raiz: " + arvoreBinaria.root.agenda.name);

        if (arvoreBinaria.find(new Agenda("Lucas",    "Rua A, 123", "1111-1111"))) {
            System.out.println("Achou");
        } else {
            System.out.println("Não achou!");
        }

        arvoreBinaria.sort();

        arvoreBinaria.emNivel();
        System.out.println(agendas.toString());
    }

}
