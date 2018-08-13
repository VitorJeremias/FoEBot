package modelo;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import utils.StringConstants;

public class Acoes {
	public static ArrayList<String> listaContasSemUsarPF = new ArrayList<String>();
	private static ArrayList<String> accs = new ArrayList<String>();

	public static void iniciarPrograma() throws IOException, HeadlessException, AWTException, InterruptedException {
		try (BufferedReader br = new BufferedReader(new FileReader(StringConstants.pathPrincipal + "accs.txt"))) {
			String line;
			while ((line = br.readLine()) != null) {
				if (line.length() > 0 && !line.startsWith("/")) {
					accs.add(line);
				}
			}
		}
		Acoes.limparArquivo();

		for (int i = 0; i < accs.size(); i++) {
			System.out.println(accs.get(i).toUpperCase());
			Acoes.executarPassos(accs.get(i));
			System.err.println("Contas sem upar: " + Acoes.listaContasSemUsarPF);
			Thread.sleep(50);
			Acoes.wait(3);
		}
	}

	public static void executarPassos(String acc) throws AWTException, IOException, HeadlessException, InterruptedException {
		campoLogin(acc);
		InputManager.escrever(acc);
		botaoLogin(acc);
		botaoJogar(acc);
		botaoHoundsmoor(acc);
		fecharJanela(acc);
		Amigos(acc);
		topAmigos(acc);
		aceitarAmizade(acc);
		auxiliar(acc);
		sentarNaTaberna(acc);
		coletar(acc);
		moverCidade(acc);
		coletarPrata(acc);
		abrirMenu(acc);
		noticias(acc);
		grandesEdificios(acc);
		abrir(acc);
		todaABarra(acc);
		fecharJanela(acc);
		fecharJanela(acc);
		logout(acc);
		sair(acc);
		sair2(acc);
		
		
	}

	public static void limparArquivo() throws IOException {
		@SuppressWarnings("resource")
		BufferedWriter writer = new BufferedWriter(new FileWriter(StringConstants.pathPrincipal + "accsSemGE.txt"));
		writer.write("");
	}

	public static void escreverNoArquivo(String acc) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(StringConstants.pathPrincipal + "accsSemGE.txt", true));
		writer.append(acc + "\n");
		writer.close();

	}

	public static boolean temPF(String acc) throws HeadlessException, AWTException, IOException {
		return esperarImagemComLimite(EnumImagens.TEM_1_PF, acc);
	}

	public static void sair2(String acc) throws HeadlessException, AWTException, IOException {
		compararImagens(EnumImagens.SAIR2, acc);
	}

	public static void sair(String acc) throws HeadlessException, AWTException, IOException {
		compararImagens(EnumImagens.SAIR, acc);
	}

	public static void logout(String acc) throws HeadlessException, AWTException, IOException {
		compararImagens(EnumImagens.LOGOUT, acc);
	}

	public static void abrir(String acc) throws HeadlessException, AWTException, IOException {
		compararImagens(EnumImagens.ABRIR, acc);
	}

	public static void grandesEdificios(String acc) throws HeadlessException, AWTException, IOException {
		compararImagens(EnumImagens.GRANDES_EDIFICIOS, acc);
	}

	public static void noticias(String acc) throws HeadlessException, AWTException, IOException {
		compararImagens(EnumImagens.NOTICIAS, acc);
	}

	public static void abrirMenu(String acc) throws HeadlessException, AWTException, IOException {
		compararImagens(EnumImagens.ABRIR_MENU, acc);
	}

	public static void campoLogin(String acc) throws InterruptedException, HeadlessException, AWTException, IOException {
		compararImagens(EnumImagens.CAMPO_LOGIN, acc);
		Thread.sleep(1000);
	}

	public static void botaoLogin(String acc) throws HeadlessException, AWTException, IOException {
		compararImagens(EnumImagens.LOGIN, acc);
	}

	public static void botaoJogar(String acc) throws HeadlessException, AWTException, IOException {
		compararImagens(EnumImagens.JOGAR, acc);
	}

	public static void botaoHoundsmoor(String acc) throws HeadlessException, AWTException, IOException {
		compararImagens(EnumImagens.HOUNDSMOOR, acc);
		wait(10);
	}

	public static void fecharJanela(String acc) throws HeadlessException, AWTException, IOException {
		compararImagens(EnumImagens.FECHAR_JANELA, acc);
	}

	public static void Amigos(String acc) throws HeadlessException, AWTException, IOException {
		compararImagens(EnumImagens.AMIGOS, acc);
	}

	public static void topAmigos(String acc) throws InterruptedException, HeadlessException, AWTException, IOException {
		compararImagens(EnumImagens.TOP_AMIGOS, acc);
		Thread.sleep(1000);
	}

	public static void coletarCupulaNivel1(String acc) throws HeadlessException, AWTException, IOException {
		compararImagens(EnumImagens.CUPULA_NIVEL_1, acc);
		compararImagens(EnumImagens.FECHAR_JANELA_RAPIDO, acc);
	}

	public static void coletarPilarDosHeroisNivel2(String acc) throws HeadlessException, AWTException, IOException {
		compararImagens(EnumImagens.PILAR_DOS_HEROIS_NIVEL_2, acc);
		compararImagens(EnumImagens.FECHAR_JANELA_RAPIDO, acc);
	}

	public static void coletarPilarDosHeroisNivel4(String acc) throws HeadlessException, AWTException, IOException {
		compararImagens(EnumImagens.PILAR_DOS_HEROIS_NIVEL_4, acc);
		compararImagens(EnumImagens.FECHAR_JANELA_RAPIDO, acc);
	}

	public static void coletarPrefeituraIdadeDoFerro(String acc) throws HeadlessException, AWTException, IOException {
		compararImagens(EnumImagens.PREFEITURA_IDADE_DO_FERRO, acc);
		compararImagens(EnumImagens.FECHAR_JANELA_RAPIDO, acc);
	}

	public static void coletarPrefeituraIdadeMedia(String acc) throws HeadlessException, AWTException, IOException {
		compararImagens(EnumImagens.PREFEITURA_IDADE_MEDIA, acc);
		compararImagens(EnumImagens.FECHAR_JANELA_RAPIDO, acc);
	}

	public static void coletarSantuarioDoConhecimento(String acc) throws HeadlessException, AWTException, IOException {
		compararImagens(EnumImagens.SANTUARIO_DO_CONHECIMENTO, acc);
	}

	public static void coletarPocoDosDesejos(String acc) throws HeadlessException, AWTException, IOException {
		compararImagens(EnumImagens.POCO_DOS_DESEJOS, acc);
	}

	public static void coletarPonteGrandeNivel1(String acc) throws HeadlessException, AWTException, IOException {
		compararImagens(EnumImagens.PONTE_GRANDE_NIVEL_1, acc);
		compararImagens(EnumImagens.FECHAR_JANELA_RAPIDO, acc);
	}

	public static void coletarPonteGrandeNivel3(String acc) throws HeadlessException, AWTException, IOException {
		compararImagens(EnumImagens.PONTE_GRANDE_NIVEL_3, acc);
		compararImagens(EnumImagens.FECHAR_JANELA_RAPIDO, acc);
	}

	public static void coletarPonteGrandeNivel4(String acc) throws HeadlessException, AWTException, IOException {
		compararImagens(EnumImagens.PONTE_GRANDE_NIVEL_4, acc);
		compararImagens(EnumImagens.FECHAR_JANELA_RAPIDO, acc);
	}

	public static void coletar(String acc) throws HeadlessException, AWTException, IOException {
		coletarPrefeituraIdadeDoFerro(acc);
		coletarPrefeituraIdadeMedia(acc);
		coletarCupulaNivel1(acc);
		coletarPilarDosHeroisNivel2(acc);
		coletarPilarDosHeroisNivel4(acc);
		coletarPonteGrandeNivel1(acc);
		coletarPonteGrandeNivel3(acc);
		coletarPonteGrandeNivel4(acc);
		coletarSantuarioDoConhecimento(acc);
		coletarPocoDosDesejos(acc);
	}

	public static void aceitarAmizade(String acc) throws HeadlessException, AWTException, IOException, InterruptedException {
		boolean temPedidoDeAmizade = true;
		do {
			compararImagens(EnumImagens.ACEITAR_AMIZADE, acc);
			Thread.sleep(500);
			compararImagens(EnumImagens.FECHAR_JANELA, acc);
			Thread.sleep(500);
			temPedidoDeAmizade = esperarImagemComLimite(EnumImagens.ACEITAR_AMIZADE, acc);
		} while (temPedidoDeAmizade);
	}

	public static void auxiliar(String acc) throws HeadlessException, AWTException, IOException, InterruptedException {
		boolean temAuxiliar = true;
		do {
			compararImagens(EnumImagens.AUXILIAR, acc);
			Thread.sleep(1500);
			temAuxiliar = esperarImagemComLimite(EnumImagens.AUXILIAR, acc);
			Thread.sleep(100);
			compararImagens(EnumImagens.OK_RECOMPENSA, acc);
			Thread.sleep(100);
		} while (temAuxiliar);
	}

	public static void sentarNaTaberna(String acc) throws HeadlessException, AWTException, IOException, InterruptedException {
		boolean temTabernaPraSentar = true;
		do {
			compararImagens(EnumImagens.SENTAR_NA_TABERNA, acc);
			Thread.sleep(1500);
			compararImagens(EnumImagens.FECHAR_JANELA, acc);
			Thread.sleep(500);
			temTabernaPraSentar = esperarImagemComLimite(EnumImagens.SENTAR_NA_TABERNA, acc);
		} while (temTabernaPraSentar);
		compararImagens(EnumImagens.OK_RECOMPENSA, acc);
	}

	public static void todaABarra(String acc) throws HeadlessException, AWTException, IOException, InterruptedException {
		Boolean temPF = false;
		Thread.sleep(1500);
		temPF = temPF || esperarImagemComLimite(EnumImagens.TODA_A_BARRA_10, acc);
		Thread.sleep(200);
		compararImagens(EnumImagens.TODA_A_BARRA_10, acc);
		Thread.sleep(200);
		temPF = temPF || esperarImagemComLimite(EnumImagens.TODA_A_BARRA_1_DIGITO, acc);
		compararImagens(EnumImagens.TODA_A_BARRA_1_DIGITO, acc);
		Thread.sleep(200);
		if (!temPF) {
			listaContasSemUsarPF.add(acc);
			System.err.println(acc + " Adicionado na lista");
			escreverNoArquivo(acc);
		}
	}

	public static void coletarPrata(String acc) throws HeadlessException, AWTException, IOException, InterruptedException {
		Robot keyboard = new Robot();
		keyboard.keyPress(KeyEvent.VK_W);
		Thread.sleep(1000);
		keyboard.keyRelease(KeyEvent.VK_W);
		compararImagens(EnumImagens.ABRIR_TABERNA, acc);
		compararImagens(EnumImagens.ABRIR_TABERNA2, acc);
		compararImagens(EnumImagens.COLETAR_PRATA, acc);
		compararImagens(EnumImagens.OK, acc);
	}

	public static void moverCidade(String acc) throws AWTException, IOException, InterruptedException {
		Robot keyboard = new Robot();
		keyboard.keyPress(KeyEvent.VK_A);
		Thread.sleep(500);
		keyboard.keyRelease(KeyEvent.VK_A);
		keyboard.keyPress(KeyEvent.VK_S);
		Thread.sleep(100);
		keyboard.keyRelease(KeyEvent.VK_S);
	}

	public static void wait(int segundos) throws AWTException {
		InputManager.clicker = new Robot();
		System.out.print("Wait " + segundos + "s: ");
		for (int i = 0; i < segundos - 1; i++) {
			InputManager.clicker.delay(1000);
			System.out.print(i + 1 + ", ");
		}
		InputManager.clicker.delay(1000);
		System.out.println(segundos);
	}

	public static boolean esperarImagem(BufferedImage bi, String acao, String acc) throws HeadlessException, AWTException {
		System.out.println("Procurando imagem " + acao);
		boolean achou = false;
		boolean fail = true;
		while (achou == false) {
			BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
			for (int x = 0; x < image.getWidth(); x++) {
				for (int y = 0; y < image.getHeight(); y++) {
					if (!achou) {
						boolean invalid = false;
						int k = x, l = y;
						for (int a = 0; a < bi.getWidth(); a++) {
							l = y;
							for (int b = 0; b < bi.getHeight(); b++) {
								if (bi.getRGB(a, b) != image.getRGB(k, l)) {
									invalid = true;
									break;
								} else {
									l++;
								}
							}
							if (invalid) {
								break;
							} else {
								k++;
							}
						}
						if (!invalid) {
							achou = true;
							System.out.println(acao + ": Achou! " + " " + acc);
							fail = false;
						}
					}
				}
			}
		}
		if (fail) {
			System.out.println(acao + ": Nao achou! " + acc);
			achou = false;
		}
		return achou;
	}

	public static boolean esperarImagemComLimite(EnumImagens imagem, String acc) throws HeadlessException, AWTException, IOException {
		BufferedImage bi = ImageIO.read(new File(imagem.getPath()));
		boolean achou = false;
		boolean fail = true;
		int count = 0;
		while (achou == false && count < imagem.getParametrosDaImagem().getMaxCount()) {
			BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
			for (int x = 0; x < image.getWidth(); x++) {
				for (int y = 0; y < image.getHeight(); y++) {
					if (!achou) {
						boolean invalid = false;
						int k = x, l = y;
						for (int a = 0; a < bi.getWidth(); a++) {
							l = y;
							for (int b = 0; b < bi.getHeight(); b++) {
								if (bi.getRGB(a, b) != image.getRGB(k, l)) {
									invalid = true;
									break;
								} else {
									l++;
								}
							}
							if (invalid) {
								break;
							} else {
								k++;
							}
						}
						if (!invalid) {
							achou = true;
							System.out.println(imagem.getAcao() + ": Achou! " + " " + acc);
							fail = false;
						}
					}
				}
			}
			count++;
		}
		if (fail) {
			System.out.println(imagem.getAcao() + ": Nao achou! " + acc);
			achou = false;
		}
		return achou;
	}

	public static void acharImagem(BufferedImage bi, double widthMult, double heigthMult, int maxCount, String acao, String acc) throws HeadlessException, AWTException {
		boolean achou = false;
		boolean fail = true;
		int count = 0;
		while (achou == false && count < maxCount) {
			BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
			for (int x = 0; x < image.getWidth(); x++) {
				for (int y = 0; y < image.getHeight(); y++) {
					if (!achou) {
						boolean invalid = false;
						int k = x, l = y;
						for (int a = 0; a < bi.getWidth(); a++) {
							l = y;
							for (int b = 0; b < bi.getHeight(); b++) {
								if (bi.getRGB(a, b) != image.getRGB(k, l)) {
									invalid = true;
									break;
								} else {
									l++;
								}
							}
							if (invalid) {
								break;
							} else {
								k++;
							}
						}
						if (!invalid) {
							InputManager.clickEvent(k - (bi.getWidth() * widthMult), l - (bi.getHeight() * heigthMult)); // Clica no centro do objeto
							achou = true;
							System.out.println(acao + ": OK! " + " " + acc);
							fail = false;
						}
					}
				}
			}
			count++;
		}
		if (fail) {
			System.out.println(acao + ": FAIL! " + acc);
		}
	}

	public static void compararImagens(EnumImagens imagem, String acc) throws HeadlessException, AWTException, IOException {
		BufferedImage bi = ImageIO.read(new File(imagem.getPath()));
		acharImagem(bi, imagem.getParametrosDaImagem().getWidthMult(), imagem.getParametrosDaImagem().getHeigthMult(), imagem.getParametrosDaImagem().getMaxCount(), imagem.getAcao(), acc);
	}

}
