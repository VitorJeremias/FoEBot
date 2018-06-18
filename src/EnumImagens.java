public enum EnumImagens {
	//@formatter:off
	
	//CENTRALIZADO_1
	ABRIR_TABERNA("C:\\Users\\Vitor\\Downloads\\PrintsFOE\\abrirTaberna.png", EnumParametrosImagem.CENTRALIZADO_10, "AbrirTaberna"),
	ABRIR_TABERNA2("C:\\Users\\Vitor\\Downloads\\PrintsFOE\\abrirTaberna2.png", EnumParametrosImagem.CENTRALIZADO_10, "AbrirTaberna2"),
	ACEITAR_AMIZADE("C:\\Users\\Vitor\\Downloads\\PrintsFOE\\aceitarAmizade.png", EnumParametrosImagem.CENTRALIZADO_1, "AceitarAmizade"),
	AUXILIAR("C:\\Users\\Vitor\\Downloads\\PrintsFOE\\auxiliar.png", EnumParametrosImagem.CENTRALIZADO_1, "Auxiliar"),
	TOP_AMIGOS("C:\\Users\\Vitor\\Downloads\\PrintsFOE\\topAmigos.png", EnumParametrosImagem.CENTRALIZADO_1, "TopAmigos"),
	
	//CENTRALIZADO_10
	AMIGOS("C:\\Users\\Vitor\\Downloads\\PrintsFOE\\amigos.png", EnumParametrosImagem.CENTRALIZADO_10, "Amigos"),
	FECHAR_JANELA("C:\\Users\\Vitor\\Downloads\\PrintsFOE\\fecharJanela.png", EnumParametrosImagem.CENTRALIZADO_10, "FecharJanela"),	
	OK("C:\\Users\\Vitor\\Downloads\\PrintsFOE\\ok.png", EnumParametrosImagem.CENTRALIZADO_10, "OK"),	
	SENTAR_NA_TABERNA("C:\\Users\\Vitor\\Downloads\\PrintsFOE\\sentarNaTaberna.png", EnumParametrosImagem.CENTRALIZADO_10, "SentarNaTaberna"),
	TODA_A_BARRA_10("C:\\Users\\Vitor\\Downloads\\PrintsFOE\\todaABarra10.png", EnumParametrosImagem.CENTRALIZADO_10, "TodaABarra10"),
	TODA_A_BARRA_1_DIGITO("C:\\Users\\Vitor\\Downloads\\PrintsFOE\\todaABarra1Digito.png",EnumParametrosImagem.CENTRALIZADO_10, "TodaABarra1Digito"),
	
	//CENTRALIZADO_30	
	ABRIR("C:\\Users\\Vitor\\Downloads\\PrintsFOE\\abrir.png", EnumParametrosImagem.CENTRALIZADO_30, "Abrir"),	
	ABRIR_MENU("C:\\Users\\Vitor\\Downloads\\PrintsFOE\\abrirMenu.png", EnumParametrosImagem.CENTRALIZADO_30, "AbrirMenu"),	
	COLETAR_PRATA("C:\\Users\\Vitor\\Downloads\\PrintsFOE\\coletarPrata.png", EnumParametrosImagem.CENTRALIZADO_30, "ColetarPrata"),
	GRANDES_EDIFICIOS("C:\\Users\\Vitor\\Downloads\\PrintsFOE\\grandesEdificios.png", EnumParametrosImagem.CENTRALIZADO_30, "GrandesEdificios"),	
	HOUNDSMOOR("C:\\Users\\Vitor\\Downloads\\PrintsFOE\\houndsmoor.png", EnumParametrosImagem.CENTRALIZADO_30, "Houndsmoor"),	
	JOGAR("C:\\Users\\Vitor\\Downloads\\PrintsFOE\\jogar.png",EnumParametrosImagem.CENTRALIZADO_30, "Jogar"),	
	LOGIN("C:\\Users\\Vitor\\Downloads\\PrintsFOE\\login.png",EnumParametrosImagem.CENTRALIZADO_30, "Login"),	
	LOGOUT("C:\\Users\\Vitor\\Downloads\\PrintsFOE\\logout.png",EnumParametrosImagem.CENTRALIZADO_30, "Logout"),	
	NOTICIAS("C:\\Users\\Vitor\\Downloads\\PrintsFOE\\noticias.png",EnumParametrosImagem.CENTRALIZADO_30, "Noticias"),	
	SAIR("C:\\Users\\Vitor\\Downloads\\PrintsFOE\\sair.png",EnumParametrosImagem.CENTRALIZADO_30, "Sair"),	
	SAIR2("C:\\Users\\Vitor\\Downloads\\PrintsFOE\\sair2.png",EnumParametrosImagem.CENTRALIZADO_30, "Sair2"),
	
	//INFERIOR_ESQUERDO_30
	CAMPO_LOGIN("C:\\Users\\Vitor\\Downloads\\PrintsFOE\\campoLogin.png", EnumParametrosImagem.INFERIOR_ESQUERDO_30, "CampoLogin");
	//formatter:on
	
	
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
