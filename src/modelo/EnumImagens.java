package modelo;

import utils.StringConstants;

public enum EnumImagens {

	//@formatter:off
	
	//CENTRALIZADO_1
	ABRIR_TABERNA(StringConstants.pathPrincipal + "abrirTaberna.png", EnumParametrosImagem.CENTRALIZADO_10, "AbrirTaberna"),
	ABRIR_TABERNA2(StringConstants.pathPrincipal + "abrirTaberna2.png", EnumParametrosImagem.CENTRALIZADO_10, "AbrirTaberna2"),
	ACEITAR_AMIZADE(StringConstants.pathPrincipal + "aceitarAmizade.png", EnumParametrosImagem.CENTRALIZADO_1, "AceitarAmizade"),
	AUXILIAR(StringConstants.pathPrincipal + "auxiliar.png", EnumParametrosImagem.CENTRALIZADO_1, "Auxiliar"),
	TOP_AMIGOS(StringConstants.pathPrincipal + "topAmigos.png", EnumParametrosImagem.CENTRALIZADO_1, "TopAmigos"),
	
	//CENTRALIZADO_10
	AMIGOS(StringConstants.pathPrincipal + "amigos.png", EnumParametrosImagem.CENTRALIZADO_10, "Amigos"),
	COLETAR_PRATA(StringConstants.pathPrincipal + "coletarPrata.png", EnumParametrosImagem.CENTRALIZADO_10, "ColetarPrata"),
	FECHAR_JANELA(StringConstants.pathPrincipal + "fecharJanela.png", EnumParametrosImagem.CENTRALIZADO_10, "FecharJanela"),	
	OK(StringConstants.pathPrincipal + "ok.png", EnumParametrosImagem.CENTRALIZADO_10, "OK"),	
	SENTAR_NA_TABERNA(StringConstants.pathPrincipal + "sentarNaTaberna.png", EnumParametrosImagem.CENTRALIZADO_10, "SentarNaTaberna"),
	TODA_A_BARRA_10(StringConstants.pathPrincipal + "todaABarra10.png", EnumParametrosImagem.CENTRALIZADO_10, "TodaABarra10"),
	TODA_A_BARRA_1_DIGITO(StringConstants.pathPrincipal + "todaABarra1Digito.png",EnumParametrosImagem.CENTRALIZADO_10, "TodaABarra1Digito"),
	
	//CENTRALIZADO_30	
	ABRIR(StringConstants.pathPrincipal + "abrir.png", EnumParametrosImagem.CENTRALIZADO_30, "Abrir"),	
	ABRIR_MENU(StringConstants.pathPrincipal + "abrirMenu.png", EnumParametrosImagem.CENTRALIZADO_30, "AbrirMenu"),	
	GRANDES_EDIFICIOS(StringConstants.pathPrincipal + "grandesEdificios.png", EnumParametrosImagem.CENTRALIZADO_30, "GrandesEdificios"),	
	HOUNDSMOOR(StringConstants.pathPrincipal + "houndsmoor.png", EnumParametrosImagem.CENTRALIZADO_30, "Houndsmoor"),	
	JOGAR(StringConstants.pathPrincipal + "jogar.png",EnumParametrosImagem.CENTRALIZADO_30, "Jogar"),	
	LOGIN(StringConstants.pathPrincipal + "login.png",EnumParametrosImagem.CENTRALIZADO_30, "Login"),	
	LOGOUT(StringConstants.pathPrincipal + "logout.png",EnumParametrosImagem.CENTRALIZADO_30, "Logout"),	
	NOTICIAS(StringConstants.pathPrincipal + "noticias.png",EnumParametrosImagem.CENTRALIZADO_30, "Noticias"),	
	SAIR(StringConstants.pathPrincipal + "sair.png",EnumParametrosImagem.CENTRALIZADO_30, "Sair"),	
	SAIR2(StringConstants.pathPrincipal + "sair2.png",EnumParametrosImagem.CENTRALIZADO_30, "Sair2"),
	
	//INFERIOR_ESQUERDO_30
	CAMPO_LOGIN(StringConstants.pathPrincipal + "campoLogin.png", EnumParametrosImagem.INFERIOR_ESQUERDO_30, "CampoLogin");
	//@formatter:on

	private String path;
	private EnumParametrosImagem parametrosDaImagem;
	private String acao;

	public String getPath() {
		return path;
	}

	public EnumParametrosImagem getParametrosDaImagem() {
		return parametrosDaImagem;
	}

	public String getAcao() {
		return acao;
	}

	EnumImagens(String path, EnumParametrosImagem parametrosImagem, String acao) {
		this.path = path;
		this.parametrosDaImagem = parametrosImagem;
		this.acao = acao;
	}
}
