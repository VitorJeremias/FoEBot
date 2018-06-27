package main;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import modelo.EnumImagens;
import modelo.InputManager;
import utils.StringConstants;

public class ImageScanner {
	private static ArrayList<String> accs = new ArrayList<String>();
	private static String contasSemUsarPF = "";

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
			executarPassos(accs.get(i));
			wait(3);
		}
		System.err.println("Contas sem upar: " + contasSemUsarPF);
	}

	public static void executarPassos(String acc) throws AWTException, IOException, HeadlessException, InterruptedException {
		compararImagens(EnumImagens.CAMPO_LOGIN, acc);
		Thread.sleep(1000);
		InputManager.escrever(acc);
		compararImagens(EnumImagens.LOGIN, acc);
		compararImagens(EnumImagens.JOGAR, acc);
		compararImagens(EnumImagens.HOUNDSMOOR, acc);
		wait(10);
		compararImagens(EnumImagens.FECHAR_JANELA, acc);
		compararImagens(EnumImagens.AMIGOS, acc);
		compararImagens(EnumImagens.TOP_AMIGOS, acc);
		wait(1);
		aceitarAmizade(acc);
		auxiliar(acc);
		sentarNaTaberna(acc);
		moverCidade(acc);
		coletarPrata(acc);
		compararImagens(EnumImagens.ABRIR_MENU, acc);
		compararImagens(EnumImagens.NOTICIAS, acc);
		compararImagens(EnumImagens.GRANDES_EDIFICIOS, acc);
		compararImagens(EnumImagens.ABRIR, acc);
		todaABarra(acc);
		compararImagens(EnumImagens.FECHAR_JANELA, acc);
		compararImagens(EnumImagens.FECHAR_JANELA, acc);
		compararImagens(EnumImagens.LOGOUT, acc);
		compararImagens(EnumImagens.SAIR, acc);
		compararImagens(EnumImagens.SAIR2, acc);
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
			Thread.sleep(300);
			compararImagens(EnumImagens.OK, acc);
			Thread.sleep(200);
		} while (temAuxiliar);
	}

	public static void sentarNaTaberna(String acc) throws HeadlessException, AWTException, IOException, InterruptedException {
		boolean temTabernaPraSentar = true;
		do {
			compararImagens(EnumImagens.SENTAR_NA_TABERNA, acc);
			Thread.sleep(2000);
			compararImagens(EnumImagens.FECHAR_JANELA, acc);
			Thread.sleep(500);
			temTabernaPraSentar = esperarImagemComLimite(EnumImagens.SENTAR_NA_TABERNA, acc);
		} while (temTabernaPraSentar);
	}

	public static void todaABarra(String acc) throws HeadlessException, AWTException, IOException, InterruptedException {
		Boolean temPF = false;
		temPF = temPF || esperarImagemComLimite(EnumImagens.TODA_A_BARRA_10, acc);
		compararImagens(EnumImagens.TODA_A_BARRA_10, acc);
		temPF = temPF || esperarImagemComLimite(EnumImagens.TODA_A_BARRA_1_DIGITO, acc);
		compararImagens(EnumImagens.TODA_A_BARRA_1_DIGITO, acc);
		if (!temPF) {
			if (contasSemUsarPF.length() == 0) {
				contasSemUsarPF = acc;
			} else {
				contasSemUsarPF = contasSemUsarPF + ", " + acc;
			}
			System.err.println(acc + " Adicionado na lista");
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

	public static void aguardar(ArrayList<BufferedImage> bi, String acao, String acc) throws HeadlessException, AWTException {

		boolean achouUm = false;
		while (!achouUm) {
			achouUm = achouUm || esperarImagem(bi.get(1), acao, acc);
			achouUm = achouUm || esperarImagem(bi.get(0), acao, acc); // So procura a segunda imagem quando acha a primeira
		}
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
			System.out.println(acao + ": N�o achou! " + acc);
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
							// System.out.println(imagem.getAcao() + ": Achou! " + " " + acc);
							fail = false;
						}
					}
				}
			}
			count++;
		}
		if (fail) {
			// System.out.println(imagem.getAcao() + ": N�o achou! " + acc);
			achou = false;
		}
		return achou;
	}

	public static void acharImagem(BufferedImage bi, double widthMult, double heigthMult, int maxCount, String acao, String acc) throws HeadlessException, AWTException {
		Robot clicker = new Robot();
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
							clicker.mouseMove((int) k - (int) (bi.getWidth() * widthMult), (int) l - (int) (bi.getHeight() * heigthMult));
							// clickEvent(k - (bi.getWidth() * widthMult), l - (bi.getHeight() *
							// heigthMult)); // Clica no centro do objeto
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

	public static void compararPixels(BufferedImage bi, double widthMult, double heigthMult, int maxCount, String acao, String acc) throws HeadlessException, AWTException {
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
		compararPixels(bi, imagem.getParametrosDaImagem().getWidthMult(), imagem.getParametrosDaImagem().getHeigthMult(), imagem.getParametrosDaImagem().getMaxCount(), imagem.getAcao(), acc);
	}

}