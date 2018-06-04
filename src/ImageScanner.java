import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

class ClasseThread implements Runnable {

	BufferedImage bi = null;
	int id = 0;
	String acc;
	int count;

	public ClasseThread(BufferedImage bi, int id, String acc) {
		this.bi = bi;
		this.id = id;
		this.acc = acc;
	}

	public void run() {

		try {
			System.out.println(id + " foi");
			ImageScanner.esperarImagem(bi, id + " aguardando imagem ", acc);
		} catch (HeadlessException | AWTException e) {
			e.printStackTrace();
		}
	}

}

public class ImageScanner {
	private static Robot clicker = null;
	private static Robot keyboard = null;
	private static int casas = 16;
	private static ArrayList<String> accs = new ArrayList<String>();
	private static int count = 0;
	private static boolean achouUma = false;

	public static void main(String[] args) throws IOException, AWTException, InterruptedException {

		try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Vitor\\Downloads\\PrintsFOE\\accs.txt"))) {
			String line;
			while ((line = br.readLine()) != null) {
				if (line.length() > 0) {
					accs.add(line);
				}
			}
		}

		// accs.add("ze pequeno3");
		// accs.add("andre matias4");
		// accs.add("capitao fabio5");
		// accs.add("zero meia");
		// accs.add("laranjinha7");
		// accs.add("dadinho8");
		// accs.add("neto gouveia9");
		// accs.add("cabo tiao10");
		// accs.add("carl11");
		// accs.add("michonne12");
		// accs.add("daryl13");
		// accs.add("glenn14");

		// Thread t3 = new Thread(new Runnable() {
		// public void run() {
		// int id = 0;
		// BufferedImage bi = null;
		// while (!Thread.interrupted()) {
		// try {
		// bi = ImageIO.read(new File("C:\\Users\\Vitor\\Downloads\\PrintsFOE\\cidadeDe.png"));
		// } catch (IOException e1) {
		// e1.printStackTrace();
		// }
		//
		// try {
		// System.out.println("t3 começou");
		// ImageScanner.esperarImagem(bi, id + " aguardando imagem ", "");
		// achouUma = true;
		// } catch (HeadlessException | AWTException e) {
		// e.printStackTrace();
		// }
		// // Thread.yield();
		// }
		// System.out.println("t3 parou");
		// }
		// });
		// Thread t4 = new Thread(new Runnable() {
		// public void run() {
		// int id = 1;
		// BufferedImage bi = null;
		// while (!Thread.interrupted()) {
		// try {
		// bi = ImageIO.read(new File("C:\\Users\\Vitor\\Downloads\\PrintsFOE\\cidadeDeEscura.png"));
		// } catch (IOException e1) {
		// e1.printStackTrace();
		// }
		//
		// try {
		// System.out.println("t4 começou");
		// ImageScanner.esperarImagem(bi, id + " aguardando imagem ", "");
		// achouUma = true;
		//
		// } catch (HeadlessException | AWTException e) {
		// e.printStackTrace();
		// }
		// // Thread.yield();
		// }
		// System.out.println("t4 parou");
		// }
		// });
		// Thread coordenador = new Thread(new Runnable() {
		// public void run() {
		// try {
		// while (!achouUma) {
		// System.out.println("Ainda não achou nenhuma");
		// Thread.sleep(500);
		// }
		// t3.interrupt();
		// t4.interrupt();
		// } catch (InterruptedException e) {
		// System.out.println("Coordenador parando!");
		// t3.interrupt();
		// t4.interrupt();
		// }
		// }
		// });
		//
		// t3.start();
		// t4.start();
		// coordenador.start();
		//
		// t3.join();
		// t4.join();
		// coordenador.join();

		for (int i = 0; i < accs.size(); i++) {
			System.out.println(accs.get(i).toUpperCase());
			executarPassos(accs.get(i));
			wait(2);
		}
	}

	// public static synchronized void incCount() {
	// count++;
	// }

	public static void executarPassos(String acc) throws AWTException, IOException, HeadlessException, InterruptedException {
		// carregandoCidade(acc);
		campoLogin(acc);
		escrever(acc);
		login(acc);
		jogar(acc);
		houndsmoor(acc);
		// carregandoCidade(acc);
		wait(10);
		fecharJanela(acc);
		abrirMenu(acc);
		noticias(acc);
		grandesEdificios(acc);
		abrir(acc);
		todaABarra(acc);
		todaABarra10(acc);
		fecharJanela(acc);
		fecharJanela(acc);
		logout(acc);
		sair(acc);
		sair2(acc);
	}

	public static void campoLogin(String acc) throws HeadlessException, AWTException, IOException {
		clicarLogin(ImageIO.read(new File("C:\\Users\\Vitor\\Downloads\\PrintsFOE\\campoLogin.png")), "Campo Login", acc);
	}

	public static void login(String acc) throws HeadlessException, AWTException, IOException {
		clicar(ImageIO.read(new File("C:\\Users\\Vitor\\Downloads\\PrintsFOE\\login.png")), "Login", acc);
	}

	public static void jogar(String acc) throws HeadlessException, AWTException, IOException {
		clicar(ImageIO.read(new File("C:\\Users\\Vitor\\Downloads\\PrintsFOE\\jogar.png")), "Jogar", acc);
	}

	public static void houndsmoor(String acc) throws HeadlessException, AWTException, IOException {
		clicar(ImageIO.read(new File("C:\\Users\\Vitor\\Downloads\\PrintsFOE\\houndsmoor.png")), "Houndsmoor", acc);
	}

	public static void fecharJanela(String acc) throws HeadlessException, AWTException, IOException {
		clicarRapido(ImageIO.read(new File("C:\\Users\\Vitor\\Downloads\\PrintsFOE\\fecharJanela.png")), "Fechar janela", acc);
	}

	public static void abrirMenu(String acc) throws HeadlessException, AWTException, IOException {
		clicar(ImageIO.read(new File("C:\\Users\\Vitor\\Downloads\\PrintsFOE\\cidadeDe.png")), "Cidade de", acc);
	}

	public static void noticias(String acc) throws HeadlessException, AWTException, IOException {
		clicar(ImageIO.read(new File("C:\\Users\\Vitor\\Downloads\\PrintsFOE\\noticias.png")), "Noticias", acc);
	}

	public static void grandesEdificios(String acc) throws HeadlessException, AWTException, IOException {
		clicar(ImageIO.read(new File("C:\\Users\\Vitor\\Downloads\\PrintsFOE\\grandesEdificios.png")), "Grandes Edificios", acc);
	}

	public static void abrir(String acc) throws HeadlessException, AWTException, IOException {
		clicar(ImageIO.read(new File("C:\\Users\\Vitor\\Downloads\\PrintsFOE\\abrir.png")), "Abrir", acc);
	}

	public static void todaABarra(String acc) throws HeadlessException, AWTException, IOException {
		clicar(ImageIO.read(new File("C:\\Users\\Vitor\\Downloads\\PrintsFOE\\todaABarra.png")), "Toda a barra", acc);
	}

	public static void todaABarra10(String acc) throws HeadlessException, AWTException, IOException {
		clicarRapido(ImageIO.read(new File("C:\\Users\\Vitor\\Downloads\\PrintsFOE\\todaABarra10.png")), "Toda a barra10", acc);
	}

	public static void logout(String acc) throws HeadlessException, AWTException, IOException {
		clicarRapido(ImageIO.read(new File("C:\\Users\\Vitor\\Downloads\\PrintsFOE\\logout.png")), "Logout", acc);
	}

	public static void sair(String acc) throws HeadlessException, AWTException, IOException {
		clicar(ImageIO.read(new File("C:\\Users\\Vitor\\Downloads\\PrintsFOE\\sair.png")), "Sair", acc);
	}

	public static void sair2(String acc) throws HeadlessException, AWTException, IOException {
		clicar(ImageIO.read(new File("C:\\Users\\Vitor\\Downloads\\PrintsFOE\\sair2.png")), "Sair2", acc);
	}

	public static void carregandoCidade(String acc) throws HeadlessException, AWTException, IOException, InterruptedException {
		Thread t3 = new Thread(new Runnable() {
			public void run() {
				int id = 0;
				BufferedImage bi = null;
				while (!Thread.interrupted()) {
					try {
						bi = ImageIO.read(new File("C:\\Users\\Vitor\\Downloads\\PrintsFOE\\cidadeDe.png"));
					} catch (IOException e1) {
						e1.printStackTrace();
					}

					try {
						System.out.println("t3 começou");
						ImageScanner.esperarImagem(bi, id + " aguardando imagem ", "");
						achouUma = true;
					} catch (HeadlessException | AWTException e) {
						e.printStackTrace();
					}
					// Thread.yield();
				}
				System.out.println("t3 parou");
			}
		});
		Thread t4 = new Thread(new Runnable() {
			public void run() {
				int id = 1;
				while (!Thread.interrupted()) {
					BufferedImage bi = null;
					try {
						bi = ImageIO.read(new File("C:\\Users\\Vitor\\Downloads\\PrintsFOE\\cidadeDeEscura.png"));
					} catch (IOException e1) {
						e1.printStackTrace();
					}

					try {
						System.out.println("t4 começou");
						ImageScanner.esperarImagem(bi, id + " aguardando imagem ", "");
						achouUma = true;

					} catch (HeadlessException | AWTException e) {
						e.printStackTrace();
					}
					// Thread.yield();
				}
				System.out.println("t4 parou");
			}
		});
		Thread coordenador = new Thread(new Runnable() {
			public void run() {
				try {
					while (!achouUma) {
						System.out.println("Ainda não achou nenhuma");
						Thread.sleep(500);
					}
					t3.interrupt();
					t4.interrupt();
				} catch (InterruptedException e) {
					System.out.println("Coordenador parando!");
					t3.interrupt();
					t4.interrupt();
				}
			}
		});

		t3.start();
		t4.start();
		coordenador.start();

		t3.join();
		t4.join();
		coordenador.join();
	}

	public static void escrever(String string) throws AWTException {
		apagar();
		digitar(string);
	}

	public static void digitar(String nome) throws AWTException {
		keyboard = new Robot();
		for (int i = 0; i < nome.length(); i++) {
			char[] chars = nome.toUpperCase().toCharArray();
			switch (chars[i]) {
			case 'Ã':
				keyboard.keyPress(KeyEvent.VK_DEAD_TILDE);
				keyboard.keyRelease(KeyEvent.VK_DEAD_TILDE);
				keyboard.keyPress(KeyEvent.VK_A);
				keyboard.keyRelease(KeyEvent.VK_A);
				keyboard.delay(20);
				break;
			case 'Ê':
				keyboard.keyPress(KeyEvent.VK_SHIFT);
				keyboard.keyPress(KeyEvent.VK_DEAD_TILDE);
				keyboard.keyRelease(KeyEvent.VK_SHIFT);
				keyboard.keyRelease(KeyEvent.VK_DEAD_TILDE);
				keyboard.keyPress(KeyEvent.VK_E);
				keyboard.keyRelease(KeyEvent.VK_E);
				keyboard.delay(20);
				break;
			default:
				keyboard.keyPress(chars[i]);
				keyboard.keyRelease(chars[i]);
			}
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
		clicker.mousePress(MouseEvent.BUTTON1_DOWN_MASK);
		clicker.delay(20);
		clicker.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
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

	public static void aguardar(ArrayList<BufferedImage> bi, String acao, String acc) throws HeadlessException, AWTException {

		boolean achouUm = false;
		while (!achouUm) {
			achouUm = achouUm || esperarImagem(bi.get(1), acao, acc);
			achouUm = achouUm || esperarImagem(bi.get(0), acao, acc); // Só procura a segunda imagem quando acha a
																		// primeira
		}
	}

	public static void clicar(BufferedImage bi, String acao, String acc) throws AWTException, HeadlessException, IOException {
		compararImagens(bi, 0.5, 0.5, 0, 30, acao, acc);
	}

	public static void clicarRapido(BufferedImage bi, String acao, String acc) throws AWTException, HeadlessException, IOException {
		compararImagens(bi, 0.5, 0.5, 0, 10, acao, acc);
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

	public static boolean esperarImagem(BufferedImage bi, String acao, String acc) throws HeadlessException, AWTException {
		boolean achou = false;
		boolean fail = true;
		while (achou == false) {
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
						achou = true;
						System.out.println(acao + ": OK! " + acc);
						fail = false;
					}
				}
			}
		}
		if (fail) {
			System.out.println(acao + ": FAIL! " + acc);
			achou = false;
		}
		return achou;
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
						clickEvent(k - (bi.getWidth() * widthMult), l - (bi.getHeight() * heigthMult)); // Clica no
																										// centro do
																										// objeto
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