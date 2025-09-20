import java.util.ArrayList;
import java.util.Iterator;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class ArrayTeste {
    public static void main(String[] args) {
        ArrayList<String> listaNome = new ArrayList<>();
        listaNome.add("Nome 1");
        listaNome.add("Nome 2");
        listaNome.add("Nome 3");
        listaNome.add("Nome 4");
        listaNome.add("Nome 5");
        System.out.println("Tamanho: "+listaNome.size());
        System.out.println("Index 1: "+listaNome.get(0));
        for (String nome: listaNome) {
            System.out.println("Numero: " + " ; Nome: "+ nome);
        }
        System.out.println(listaNome.toString());
//        Iterator<String> iterator = listaNome.iterator();
//
//        while (iterator.hasNext()) {
//            System.out.println("Item da lista: " + iterator.next());
//            iterator.remove();
//        }

        listaNome.stream().forEach(name -> System.out.println("Item da lista: " + name));
    }
}
