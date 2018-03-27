import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class Code {
	public static void main(String arg[]){
		launchCode("C://ForJava/Code/f.jpg");
	}
	public static int launchCode(String path){
		int result = 0 ;
		Random r = new Random();
		BufferedImage bi = new BufferedImage(140,60,BufferedImage.TYPE_INT_BGR);
		Graphics2D g = (Graphics2D)bi.getGraphics();
		g.setColor(new Color(230,230,250));
		g.fillRect(0,0,140,60);
		int a = r.nextInt(20)+1;
		int b = r.nextInt(10)+1;
		String symbol = "+-X";
		char[] sym = symbol.toCharArray();
		char c = sym[r.nextInt(3)];
			if(c == 'X'){
				result = a*b;
			}else if(c == '+'){
				result = a+b;
			}else if(c == '-'){
				result = a-b;
			}
		String sym1 = String.valueOf(c);
		//画出干扰线
		for(int i = 0 ;i<20;i++){
			g.setColor(new Color(r.nextInt(256),r.nextInt(256),r.nextInt(256)));
			final int x = r.nextInt(100)+1;
			final int y = r.nextInt(40)+1;
			final int w = r.nextInt(120)+1;
			final int h = r.nextInt(40)+1;
			int un1 = r.nextBoolean()?1:-1;
			int un2 = r.nextBoolean()?1:-1;
			g.fillRect(x,y,w,h);
		}
		 float yawpRate = 0.05f;// 噪声率
	        int area = (int) (yawpRate * 140 * 60);
	        for (int i = 0; i < area; i++) {
	            int x = r.nextInt(140);
	            int y = r.nextInt(60);
	            bi.setRGB(x, y,r.nextInt(256));
	        }
		g.setFont(new Font("Comic Sans MS",Font.BOLD,36));
		g.setColor(new Color(r.nextInt(256),r.nextInt(256),r.nextInt(256)));
		g.drawString(""+a,10,45);
		g.setColor(new Color(r.nextInt(256),r.nextInt(256),r.nextInt(256)));
		g.drawString(sym1, 60, 42);
		g.setColor(new Color(r.nextInt(256),r.nextInt(256),r.nextInt(256)));
		g.drawString(""+b,100,42);
		try {
			ImageIO.write(bi,"JPEG",new FileOutputStream(path));
		} catch (IOException e) {
			e.printStackTrace();
			return (Integer) null ;
		}
		return result;
	}
}
