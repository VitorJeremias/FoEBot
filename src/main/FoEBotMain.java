package main;

import java.awt.AWTException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import modelo.Acoes;

public class FoEBotMain {
	private static ArrayList<String> accs = new ArrayList<String>();

	public static void main(String[] args) throws IOException, AWTException, InterruptedException {

		try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Vitor\\Downloads\\PrintsFOE\\accs.txt"))) {
			String line;
			while ((line = br.readLine()) != null) {
				if (line.length() > 0 && !line.startsWith("/")) {
					accs.add(line);
				}
			}
		}

		for (int i = 0; i < accs.size(); i++) {
			System.out.println(accs.get(i).toUpperCase());
			Acoes.executarPassos(accs.get(i));
			System.err.println("Contas sem upar: " + Acoes.listaContasSemUsarPF);
			Thread.sleep(50);
			Acoes.wait(3);
		}
	}

}