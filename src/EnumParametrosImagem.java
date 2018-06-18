public enum EnumParametrosImagem {
	//@formatter:off
	CENTRALIZADO_1(0.5, 0.5, 1),
	CENTRALIZADO_10(0.5, 0.5, 10),
	CENTRALIZADO_30(0.5, 0.5, 30),
	INFERIOR_ESQUERDO_30(0.6,0.3,30);
	//@formatter:on

	private double widthMult;
	private double heigthMult;
	private int maxCount;

	public double getWidthMult() {
		return widthMult;
	}

	public double getHeigthMult() {
		return heigthMult;
	}

	public int getMaxCount() {
		return maxCount;
	}

	EnumParametrosImagem(double widthMult, double heigthMult, int maxCount) {
		this.widthMult = widthMult;
		this.heigthMult = heigthMult;
		this.maxCount = maxCount;
	}
}
