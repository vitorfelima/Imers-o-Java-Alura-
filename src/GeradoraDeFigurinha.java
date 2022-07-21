import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class GeradoraDeFigurinha {
	
	public void cria(InputStream inputStream, String nomeArquivo) throws Exception {
		
		//InputStream inputStream = new FileInputStream(new File("entrada/filme.jpg"));
		//InputStream inputStream = new URL("https://imersao-java-apis.s3.amazonaws.com/TopTVs_1.jpg").openStream();
		BufferedImage imagemOriginal = ImageIO.read(inputStream);
		
		int largura = imagemOriginal.getWidth();
		int altura = imagemOriginal.getHeight();
		int novaAltura = altura + 200;
		BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);
		
		Graphics2D grafico = (Graphics2D) novaImagem.getGraphics();
		grafico.drawImage(imagemOriginal, 0, 0, null);
		
		var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 48);
		grafico.setFont(fonte);
		grafico.setColor(Color.black);
		
		grafico.drawString("TOPZERA", largura / 2, novaAltura - 100);
		
		ImageIO.write(novaImagem, "png", new File(nomeArquivo));
		
		
	}
	
}
