package main.java.list.OperacoesBasicas;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {
  //atributos
  private List<Item> itemList;

  public CarrinhoDeCompras() {
    this.itemList = new ArrayList<>();
  }

  public void adicionarItem(String nome, double preco, int quantidade) {
    Item item = new Item(nome, preco, quantidade);
    this.itemList.add(item);
  }

  public void removerItem(String nome) {
    List<Item> itensParaRemover = new ArrayList<>();
    if (!itemList.isEmpty()) {
      for (Item i : itemList) {
        if (i.getNome().equalsIgnoreCase(nome)) {
          itensParaRemover.add(i);
        }
      }
      itemList.removeAll(itensParaRemover);
    } else {
      System.out.println("Não há itens na lista.");
    }
  }

  public double calcularValorTotal() {
    double valorTotal = 0d;
    if (!itemList.isEmpty()) {
      for (Item item : itemList) {
        double valorItem = item.getPreco() * item.getQuantidade();
        valorTotal += valorItem;
      }
      return valorTotal;
    } else {
      throw new RuntimeException("Não há itens na lista.");
    }
  }

  public void exibirItens() {
    if (!itemList.isEmpty()) {
      System.out.println(this.itemList);
    } else {
      System.out.println("Não há itens na lista.");
    }
  }

  @Override
  public String toString() {
    return "CarrinhoDeCompras{" +
        "itens=" + itemList +
        '}';
  }

  public static void main(String[] args) {
    CarrinhoDeCompras carrinhoDeCompras = new CarrinhoDeCompras();

    carrinhoDeCompras.adicionarItem("coca-cola 2l", 11d, 6);
    carrinhoDeCompras.adicionarItem("macarrão", 7d, 2);
    carrinhoDeCompras.adicionarItem("arroz", 35d, 1);
    carrinhoDeCompras.adicionarItem("feijão", 17d, 1);
    carrinhoDeCompras.adicionarItem("alho", 13d, 2);
    carrinhoDeCompras.adicionarItem("farofa", 15d, 1);

    carrinhoDeCompras.exibirItens();

    carrinhoDeCompras.removerItem("Lápis");

    carrinhoDeCompras.exibirItens();

    System.out.println("O valor total da compra é = " + carrinhoDeCompras.calcularValorTotal());
  }
}