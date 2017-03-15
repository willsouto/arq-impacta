package br.edu.impacta.arq4;

import static javax.swing.JOptionPane.*;

import java.io.*;
import java.net.*;
public class SaudacaoClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		String nome = showInputDialog("Qual é o seu nome?");
		Socket soc = new Socket("127.0.0.1", 58888);
		InputStream is = soc.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		OutputStream os = soc.getOutputStream();
		PrintWriter pw = new PrintWriter(os);
		pw.println(nome);
		pw.flush();
		String resposta = br.readLine();
		showMessageDialog(null, "Resposta do servidor: "+resposta);
		pw.close();
		br.close();
		soc.close();
	}

}
