import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class ImageScanner {
	private static Robot clicker = null;
	private static Robot keyboard = null;
	private static int casas = 16;
	private static ArrayList<String> accs = new ArrayList<>();

	public static void main(String[] args) throws IOException, AWTException {

//		accs.add("ze pequeno3");
//		accs.add("andre matias4");
//		accs.add("capitao fabio5");
//		accs.add("zero meia");
//		accs.add("laranjinha7");
//		accs.add("dadinho8");
		accs.add("neto gouveia9");
		accs.add("cabo tiao10");
		accs.add("carl11");
		accs.add("michonne12");
		accs.add("daryl13");
		accs.add("glenn14");

		 for (int i = 0; i < accs.size(); i++) {
		 System.out.println(accs.get(i).toUpperCase());
		 executarPassos(accs.get(i));
		 wait(3);
		 }

//		auxiliar("ze pequeno3");

	}

	public static void auxiliar(String acc) throws AWTException, IOException {
		clicar(ImageIO.read(new File("C:\\Users\\Vitor\\Downloads\\PrintsFOE\\auxiliar.png")), "Auxiliar", acc);
	}

	public static void executarPassos(String acc) throws AWTException, IOException {
		clicarLogin(ImageIO.read(new File("C:\\Users\\Vitor\\Downloads\\PrintsFOE\\campoLogin.png")), "Campo Login", acc);
		escrever(acc);
		clicar(ImageIO.read(new File("C:\\Users\\Vitor\\Downloads\\PrintsFOE\\login.png")), "Login", acc);
		clicar(ImageIO.read(new File("C:\\Users\\Vitor\\Downloads\\PrintsFOE\\jogar.png")), "Jogar", acc);
		clicar(ImageIO.read(new File("C:\\Users\\Vitor\\Downloads\\PrintsFOE\\houndsmoor.png")), "Houndsmoor", acc);
		wait(10);
		clicar(ImageIO.read(new File("C:\\Users\\Vitor\\Downloads\\PrintsFOE\\fecharJanela.png")), "Fechar janela", acc);
//		clicarColeta(ImageIO.read(new File("C:\\Users\\Vitor\\Downloads\\PrintsFOE\\casa.png")), "casa", acc);
//		clicarColeta(ImageIO.read(new File("C:\\Users\\Vitor\\Downloads\\PrintsFOE\\casaEstrela.png")), "casaEstrela", acc);
		clicar(ImageIO.read(new File("C:\\Users\\Vitor\\Downloads\\PrintsFOE\\cidadeDe.png")), "Cidade de", acc);
		clicar(ImageIO.read(new File("C:\\Users\\Vitor\\Downloads\\PrintsFOE\\noticias.png")), "Noticias", acc);
		clicar(ImageIO.read(new File("C:\\Users\\Vitor\\Downloads\\PrintsFOE\\grandesEdificios.png")), "Grandes Edificios", acc);
		clicar(ImageIO.read(new File("C:\\Users\\Vitor\\Downloads\\PrintsFOE\\abrir.png")), "Abrir", acc);
		clicar(ImageIO.read(new File("C:\\Users\\Vitor\\Downloads\\PrintsFOE\\todaABarra.png")), "Toda a barra", acc);
		clicar(ImageIO.read(new File("C:\\Users\\Vitor\\Downloads\\PrintsFOE\\todaABarra10.png")), "Toda a barra10", acc);
		clicar(ImageIO.read(new File("C:\\Users\\Vitor\\Downloads\\PrintsFOE\\fecharJanela.png")), "Fechar janela", acc);
		clicar(ImageIO.read(new File("C:\\Users\\Vitor\\Downloads\\PrintsFOE\\fecharJanela.png")), "Fechar janela", acc);
		clicar(ImageIO.read(new File("C:\\Users\\Vitor\\Downloads\\PrintsFOE\\logout.png")), "Logout", acc);
		clicar(ImageIO.read(new File("C:\\Users\\Vitor\\Downloads\\PrintsFOE\\sair.png")), "Sair", acc);
		clicar(ImageIO.read(new File("C:\\Users\\Vitor\\Downloads\\PrintsFOE\\sair2.png")), "Sair2", acc);
	}

	public static void escrever(String string) throws AWTException {
		apagar();
		digitar(string);
	}

	public static void digitar(String nome) throws AWTException {
		keyboard = new Robot();
		for (int i = 0; i < nome.length(); i++) {
			char[] chars = nome.toUpperCase().toCharArray();
			keyboard.keyPress(chars[i]);
			keyboard.keyRelease(chars[i]);
			keyboard.delay(20);
		}
	}

	public static void apagar() throws AWTException {
		keyboard = new Robot();
		for (int i = 0; i < 20; i++) {
			keyboard.keyPress(KeyEvent.VK_BACK_SPACE);
			keyboard.delay(20);
		}
	}

	public static void wait(int segundos) throws AWTException {
		clicker = new Robot();
		System.out.print("Wait " + segundos + "s: ");
		for (int i = 0; i < segundos - 1; i++) {
			clicker.delay(1000);
			System.out.print(i + 1 + ", ");
		}
		clicker.delay(1000);
		System.out.println(segundos);
	}

	public static void clickEvent(double x, double y) throws AWTException {
		clicker = new Robot();
		clicker.mouseMove((int) x, (int) y);
		clicker.delay(500);
		clicker.mousePress(MouseEvent.BUTTON1_MASK);
		clicker.delay(20);
		clicker.mouseRelease(MouseEvent.BUTTON1_MASK);
	}

	public static void zoomIn() throws AWTException {
		clicker = new Robot();
		clicker.delay(500);
		clicker.mouseWheel(-50);
		clicker.delay(200);
	}

	public static void zoomOut() throws AWTException {
		clicker = new Robot();
		clicker.mouseWheel(50);
		clicker.delay(200);
	}

	public static void clicar(BufferedImage bi, String acao, String acc) throws AWTException, HeadlessException, IOException {
		compararImagens(bi, 0.5, 0.5, 0, 30, acao, acc);
	}

	public static void clicarRapido(BufferedImage bi, String acao, String acc) throws AWTException, HeadlessException, IOException {
		compararImagens(bi, 0.5, 0.5, 0, 2, acao, acc);
	}

	public static void clicarLogin(BufferedImage bi, String acao, String acc) throws AWTException, HeadlessException, IOException {
		compararImagens(bi, 0.6, 0.3, 0, 30, acao, acc);
	}

	public static void clicarColeta(BufferedImage bi, String acao, String acc) throws AWTException, HeadlessException, IOException {
		zoomIn();
		for (int i = 0; i < casas; i++) {
			compararImagens(bi, 0.6, 0.1, 0, 2, acao + (i + 1), acc);
		}
		wait(3);
		zoomOut();
	}

	public static void compararPixels(BufferedImage bi, double widthMult, double heigthMult, int count, int maxCount, String acao, String acc) throws HeadlessException, AWTException {
		boolean achou = false;
		boolean fail = true;
		while (achou == false && count < maxCount) {
			BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
			for (int x = 0; x < image.getWidth(); x++) {
				for (int y = 0; y < image.getHeight(); y++) {
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
						clickEvent(k - (bi.getWidth() * widthMult), l - (bi.getHeight() * heigthMult)); // Clica no centro do objeto
						achou = true;
						System.out.println(acao + ": OK! " + acc);
						fail = false;
					}
				}
			}
			count++;
		}
		if (fail) {
			System.out.println(acao + ": FAIL! " + acc);
		}
	}

	public static void compararImagens(BufferedImage bi, double widthMult, double heigthMult, int count, int maxCount, String acao, String acc) throws HeadlessException, AWTException, IOException {
		if (acao == "Auxiliar") {
			for (int i = 0; i < 5; i++) {
				compararPixels(bi, widthMult, heigthMult, count, maxCount, acao, acc);
				clicarRapido(ImageIO.read(new File("C:\\Users\\Vitor\\Downloads\\PrintsFOE\\fechar.png")), "Fechar", acc);
			}
		} else {
			compararPixels(bi, widthMult, heigthMult, count, maxCount, acao, acc);
		}
	}
}