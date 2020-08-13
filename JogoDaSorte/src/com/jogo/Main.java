package com.jogo;

import javax.swing.JOptionPane;

import com.jogo.model.Jogador;
import com.jogo.model.Jogo;

public class Main {

	public static void main(String[] args) {
		String nomeDoJogador;

		JOptionPane.showMessageDialog(null, "Bem vindo ao jogo da sorte!\nVamos definir os 3 jogadores da partida.", "Mensagem inicial", JOptionPane.PLAIN_MESSAGE);
		nomeDoJogador = JOptionPane.showInputDialog(null, "Digite o nome do primeiro jogador", "Cadastro", JOptionPane.QUESTION_MESSAGE);
		Jogador jogador1 = new Jogador(nomeDoJogador);
		jogador1.perguntarNumeroDaSorte();
		
		nomeDoJogador = JOptionPane.showInputDialog(null, "Digite o nome do segundo jogador", "Cadastro", JOptionPane.QUESTION_MESSAGE);
		Jogador jogador2 = new Jogador(nomeDoJogador);
		jogador2.perguntarNumeroDaSorte();
		
		while(jogador2.getNumeroDaSorte() == jogador1.getNumeroDaSorte()){
			JOptionPane.showMessageDialog(null, "Este número já existe", "Erro", JOptionPane.ERROR_MESSAGE);
			jogador2.setNumeroDaSorte(0);
			jogador2.perguntarNumeroDaSorte();
		}
		
		nomeDoJogador = JOptionPane.showInputDialog(null, "Digite o nome do terceiro jogador", "Cadastro", JOptionPane.QUESTION_MESSAGE);
		Jogador jogador3 = new Jogador(nomeDoJogador);
		jogador3.perguntarNumeroDaSorte();
		
		while(jogador3.getNumeroDaSorte() == jogador1.getNumeroDaSorte() || jogador3.getNumeroDaSorte() == jogador2.getNumeroDaSorte()) {
			JOptionPane.showMessageDialog(null, "Este número já existe", "Erro", JOptionPane.ERROR_MESSAGE);
			jogador3.setNumeroDaSorte(0);
			jogador3.perguntarNumeroDaSorte();
		}	
		
		Jogo jogo = new Jogo();
		jogo.adicionarJogador1(jogador1);
		jogo.adicionarJogador2(jogador2);
		jogo.adicionarJogador3(jogador3);
		
		JOptionPane.showMessageDialog(null, "Todos os jogadores começam com R$100,00 em caixa.", "Informação", JOptionPane.INFORMATION_MESSAGE);
		
		jogo.prepararJogo(100);
		while(!jogo.isJogoFinalizado()) {
			jogo.iniciarRodada();
			if(jogo.teveGanhador()) 
				JOptionPane.showMessageDialog(null, String.format("Tivemos um ganhador!%n Parabéns %s!",jogo.getGanhador().getNome()), "A banca paga!", JOptionPane.PLAIN_MESSAGE);
			else	
				JOptionPane.showMessageDialog(null, "Ninguém ganhou :)\n A banca agradece!", "A banca recebe!", JOptionPane.PLAIN_MESSAGE);
			jogo.finalizarRodada();
			
		}
		
		
	}

}