package ui;

import model.Cliente;
import model.ClienteVip;
import model.LojaException;

import java.util.ArrayList;
import java.util.Scanner;
public class appLoja extends Cliente{

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		ArrayList<Cliente> lista;
		lista = new ArrayList<Cliente>();
		int N, opcao, id;
		String nome, email;
		float credito, compra, creditoespecial;
		
		System.out.print("Quantos clientes cadastrar? ");
		N = Integer.parseInt(teclado.nextLine());
		
		try {
			for(int i = 0;i < N; i++) {
				System.out.print("1- Cadastrar Cliente /2- Cadastrar Cliente VIP ");
				opcao = Integer.parseInt(teclado.nextLine());
				switch(opcao) {
				case 1:
					System.out.print("Digite o codigo do cliente ");
					id = Integer.parseInt(teclado.nextLine());
					System.out.print("Digite o nome do cliente ");
					nome = teclado.nextLine();
					System.out.print("Digite o email do cliente ");
					email = teclado.nextLine();
					System.out.print("Digite o credito do cliente ");
					credito = Integer.parseInt(teclado.nextLine());
					Cliente client = new Cliente(id,nome,email,credito);
					lista.add(client);
					break;
				case 2:
					System.out.print("Digite o codigo do cliente VIP ");
					id = Integer.parseInt(teclado.nextLine());
					System.out.print("Digite o nome do cliente VIP ");
					nome = teclado.nextLine();
					System.out.print("Digite o email do cliente VIP ");
					email = teclado.nextLine();
					System.out.print("Digite o credito do cliente VIP ");
					credito = Integer.parseInt(teclado.nextLine());
					System.out.print("Digite o limite do client2 VIP ");
					creditoespecial = Integer.parseInt(teclado.nextLine());
					Cliente client1 = new ClienteVip(id,nome,email,credito,creditoespecial);
					lista.add(client1);
					break;
				default:
					System.out.println("Erro digitado invalido");
					break;
				}

			}
			System.out.println("\n*******Fazer Compra******\n");
			for(Cliente x: lista) {
				System.out.print("Digite 22o valor da compra ");
				compra = Integer.parseInt(teclado.nextLine());
				if(x.fazercompra(compra));{
					System.out.println(x);
				}
			}
		}catch(LojaException e) {
			System.out.println("Erro ao cadastrar Cliente");
			System.out.println("MOTIVO: "+e.getMessage());
		}catch(NumberFormatException e) {
			System.out.println("Erro ao cadastrar Cliente");
			System.out.println("MOTIVO: No digitou caracter errado");
		}
		
		
		
	}

}
