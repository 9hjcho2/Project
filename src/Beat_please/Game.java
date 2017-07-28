package Beat_please;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Game extends Thread{ //쓰레드는 하나의 프로그램 안에서 실행되는 작은 프로그램. Game 클래스
	
	private Image noteRouteLineImage = new ImageIcon(Main.class.getResource("../images/noteRouteLine.png")).getImage();//noteRouteLine 이미지를 담을 수 있는 객체를 초기화
	private Image judgementLineImage = new ImageIcon(Main.class.getResource("../images/judgementLine.jpg")).getImage();//judgementLine 이미지를 담을 수 있는 객체를 초기화
	private Image gameInfoImage = new ImageIcon(Main.class.getResource("../images/gameInfo.png")).getImage();//gameInfo 이미지를 담을 수 있는 객체를 초기화
	private Image noteRoute1Image = null;// = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();//noteRoute 이미지를 담을 수 있는 객체를 초기화
	private Image noteRoute2Image = null;// new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();//noteRoute 이미지를 담을 수 있는 객체를 초기화
	private Image noteRoute3Image = null; //new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();//noteRoute 이미지를 담을 수 있는 객체를 초기화
	private Image noteRoute4Image = null; //new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();//noteRoute 이미지를 담을 수 있는 객체를 초기화
	private Image noteRoute5Image = null; //new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();//noteRoute 이미지를 담을 수 있는 객체를 초기화
	private Image noteRoute6Image = null; //new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();//noteRoute 이미지를 담을 수 있는 객체를 초기화
	private Image noteRoute7Image = null; //new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();//noteRoute 이미지를 담을 수 있는 객체를 초기화
	private Image noteRoute8Image = null; //new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();//noteRoute 이미지를 담을 수 있는 객체를 초기화
	private Image noteRoute9Image = null; //new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();//noteRoute 이미지를 담을 수 있는 객체를 초기화
	private Image noteRoute0Image = null; //new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();//noteRoute 이미지를 담을 수 있는 객체를 초기화
	private Image noteRouteUImage = null; //new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();//noteRoute 이미지를 담을 수 있는 객체를 초기화
	private Image noteRouteIImage = null; //new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();//noteRoute 이미지를 담을 수 있는 객체를 초기화
	private Image noteRouteOImage = null; //new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();//noteRoute 이미지를 담을 수 있는 객체를 초기화
	private Image noteRoutePImage = null; //new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();//noteRoute 이미지를 담을 수 있는 객체를 초기화

	private String gameMusic;
	private Music startMusic;
	
	ArrayList<Note> noteList = new ArrayList<Note>();
	
	public Game(String gameMusic){
		this.gameMusic = gameMusic;
		startMusic = new Music(this.gameMusic, false);
		startMusic.start();
		
	}

	public void screenDraw(Graphics g){
		g.drawImage(noteRoute1Image, 190, 50, null);
		g.drawImage(noteRoute2Image, 253, 50, null);
		g.drawImage(noteRoute3Image, 318, 50, null);
		g.drawImage(noteRoute4Image, 381, 50, null);
		g.drawImage(noteRoute5Image, 446, 50, null);
		g.drawImage(noteRoute6Image, 510, 50, null);
		g.drawImage(noteRoute7Image, 574, 50, null);
		g.drawImage(noteRoute8Image, 638, 50, null);
		g.drawImage(noteRoute9Image, 702, 50, null);
		g.drawImage(noteRoute0Image, 765, 50, null);
		g.drawImage(noteRouteUImage, 831, 50, null);
		g.drawImage(noteRouteIImage, 894, 50, null);
		g.drawImage(noteRouteOImage, 958, 50, null);
		g.drawImage(noteRoutePImage, 1020, 50, null);
		g.drawImage(noteRouteLineImage, 190, 50, null);
		g.drawImage(noteRouteLineImage, 380, 50, null);
		g.drawImage(noteRouteLineImage, 638, 50, null);
		g.drawImage(noteRouteLineImage, 829, 50, null);
		g.drawImage(noteRouteLineImage, 1085, 50, null);
		g.drawImage(gameInfoImage,  0,  30,  null);
		for(int i = 0; i < noteList.size(); i++)
		{
			Note note = noteList.get(i);
			note.screenDraw(g);
		}
		g.drawImage(judgementLineImage,  190,  650,  null);
		
		
		g.setColor(Color.white); //글자색깔
		//g.setColor(Color.WHITE);
		g.setFont(new Font(gameMusic, Font.BOLD, 30)); //글자 폰트와 크기 정함
		//g.drawString("정은지", 20, 702);
		//g.drawString("Easy",  1190,  702);
		g.setFont(new Font("Arial", Font.PLAIN, 26));
		g.setColor(Color.BLACK);
		g.drawString("1",  190+27, 714);
		g.drawString("2",  253+27, 714);
		g.drawString("3",  318+27, 714);
		g.drawString("4",  381+27, 714);
		g.drawString("5",  446+27, 714);
		g.drawString("6",  510+27, 714);
		g.drawString("7",  574+27, 714);
		g.drawString("8",  638+27, 714);
		g.drawString("9",  702+27, 714);
		g.drawString("0",  765+27, 714);
		g.drawString("-",  831+27, 714);
		g.drawString("=",  894+27, 714);
		g.drawString("<",  958+27, 714);
		g.drawString("H",  1020+27, 714);
		g.setColor(Color.white);
		g.setFont(new Font("Elephant", Font.BOLD, 30));
		g.drawString("000000", 565, 70); //점수판



	}
	
	public void press1(){
		noteRoute1Image = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.jpg")).getImage(); //noteRoutePressed로 이미지로 바꿈.
		new Music("도.mp3", false).start(); //버튼을 눌럿을 때 소리나오게 한다.
	}
	public void release1(){
		noteRoute1Image =null; // new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage(); //noteRoute로 이미지로 바꿈.
	}
	public void press2(){
		noteRoute2Image = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.jpg")).getImage(); //noteRoutePressed로 이미지로 바꿈.
		new Music("레.mp3", false).start();//버튼을 눌럿을 때 소리나오게 한다
	}
	public void release2(){
		noteRoute2Image = null; //new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage(); //noteRoute로 이미지로 바꿈.
	}
	
	public void press3(){
		noteRoute3Image = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.jpg")).getImage(); //noteRoutePressed로 이미지로 바꿈.
		new Music("미.mp3", false).start();//버튼을 눌럿을 때 소리나오게 한다
	}
	public void release3(){
		noteRoute3Image =null; // new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage(); //noteRoute로 이미지로 바꿈.
	}
	
	public void press4(){
		noteRoute4Image = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.jpg")).getImage(); //noteRoutePressed로 이미지로 바꿈.
		new Music("파.mp3", false).start();//버튼을 눌럿을 때 소리나오게 한다
	}
	public void release4(){
		noteRoute4Image =null; // new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage(); //noteRoute로 이미지로 바꿈.
	}
	
	public void press5(){
		noteRoute5Image = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.jpg")).getImage(); //noteRoutePressed로 이미지로 바꿈.
		new Music("솔.mp3", false).start();//버튼을 눌럿을 때 소리나오게 한다
	}
	public void release5(){
		noteRoute5Image = null; // new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage(); //noteRoute로 이미지로 바꿈.
	}
	public void press6(){
		noteRoute6Image = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.jpg")).getImage(); //noteRoutePressed로 이미지로 바꿈.
		new Music("라.mp3", false).start();//버튼을 눌럿을 때 소리나오게 한다
	}
	public void release6(){
		noteRoute6Image =null; // new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage(); //noteRoute로 이미지로 바꿈.
	}
	public void press7(){
		noteRoute7Image = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.jpg")).getImage(); //noteRoutePressed로 이미지로 바꿈.
		new Music("시.mp3", false).start();//버튼을 눌럿을 때 소리나오게 한다
	}
	public void release7(){
		noteRoute7Image = null; //new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage(); //noteRoute로 이미지로 바꿈.
	}
	public void press8(){
		noteRoute8Image = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.jpg")).getImage(); //noteRoutePressed로 이미지로 바꿈.
		new Music("높은 도.mp3", false).start();//버튼을 눌럿을 때 소리나오게 한다
	}
	public void release8(){
		noteRoute8Image = null; //new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage(); //noteRoute로 이미지로 바꿈.
	}
	public void press9(){
		noteRoute9Image = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.jpg")).getImage(); //noteRoutePressed로 이미지로 바꿈.
		new Music("높은 레.mp3", false).start();//버튼을 눌럿을 때 소리나오게 한다
	}
	public void release9(){
		noteRoute9Image = null; //new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage(); //noteRoute로 이미지로 바꿈.
	}
	public void press0(){
		noteRoute0Image = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.jpg")).getImage(); //noteRoutePressed로 이미지로 바꿈.
		new Music("높은 미.mp3", false).start();//버튼을 눌럿을 때 소리나오게 한다
	}
	public void release0(){
		noteRoute0Image = null; //new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage(); //noteRoute로 이미지로 바꿈.
	}
	public void pressU(){
		noteRouteUImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.jpg")).getImage(); //noteRoutePressed로 이미지로 바꿈.
		new Music("높은 파.mp3", false).start();//버튼을 눌럿을 때 소리나오게 한다
	}
	public void releaseU(){
		noteRouteUImage = null; //new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage(); //noteRoute로 이미지로 바꿈.
	}
	public void pressI(){
		noteRouteIImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.jpg")).getImage(); //noteRoutePressed로 이미지로 바꿈.
		new Music("높은 솔.mp3", false).start();//버튼을 눌럿을 때 소리나오게 한다
	}
	public void releaseI(){
		noteRouteIImage = null; //new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage(); //noteRoute로 이미지로 바꿈.
	}
	public void pressO(){
		noteRouteOImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.jpg")).getImage(); //noteRoutePressed로 이미지로 바꿈.
		new Music("높은 라.mp3", false).start();//버튼을 눌럿을 때 소리나오게 한다
	}
	public void releaseO(){
		noteRouteOImage = null; //new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage(); //noteRoute로 이미지로 바꿈.
	}
	public void pressP(){
		noteRoutePImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.jpg")).getImage(); //noteRoutePressed로 이미지로 바꿈.
		new Music("높은 시.mp3", false).start();//버튼을 눌럿을 때 소리나오게 한다
	}
	public void releaseP(){
		noteRoutePImage = null; //new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage(); //noteRoute로 이미지로 바꿈.
	}

	@Override
	public void run(){ //Game 클래스는 안에 있는 Run 메소드를 실행한다.
		dropNotes();
	}
	
	public void close(){
		startMusic.close();
		this.interrupt(); //쓰레드 종료
	}
	
	public void dropNotes()
	{
		if(gameMusic == "CANON.mp3")
		{
			Beat[] beats = {
					new Beat(900, "3"),
					new Beat(4255, "1"),
					new Beat(9217, "1"),
					new Beat(14247, "1"),
					new Beat(14247, "3"),
					new Beat(14247, "8"),
					new Beat(14247, "0"),
					new Beat(15987, "2"),
					new Beat(15987, "7"),
					new Beat(15987, "9"),
					new Beat(17622, "1"),
					new Beat(17622, "6"),  
					new Beat(17622, "8"),
					new Beat(19200, "5"),
					new Beat(19200, "7"),
					new Beat(20887, "4"),
					new Beat(20887, "6"),
					new Beat(22717, "1"),
					new Beat(22717, "5"),
					new Beat(24317, "4"),
					new Beat(24317, "6"),
					new Beat(24317, "6"),
					new Beat(26005, "5"),
					new Beat(26005, "7"),
					new Beat(27667, "1"),
					new Beat(27667, "3"),
					new Beat(27667, "8"),
					new Beat(27667, "0"),
					new Beat(29307, "5"),
					new Beat(29307, "7"),
					new Beat(29307, "9"),
					new Beat(30121, "4"),
					new Beat(30941, "3"),
					new Beat(30941, "6"),
					new Beat(30941, "8"),
					new Beat(32716, "3"),
					new Beat(32716, "5"),
					new Beat(32716, "7"),
					new Beat(34264, "1"),
					new Beat(34264, "6"),
					new Beat(35904, "1"),
					new Beat(35904, "5"),
					new Beat(36817, "3"),
					new Beat(37637, "2"),
					new Beat(37637, "6"),
					new Beat(39317, "5"),
					new Beat(39317, "7"),
					new Beat(40157, "4"),
					new Beat(40900, "3"),
					new Beat(40900, "8"),
					new Beat(42639, "5"),
					new Beat(42639, "7"),
					new Beat(43517, "4"),
					new Beat(44297, "3"),
					new Beat(44297, "8"),
					new Beat(45150, "6"),
					new Beat(45150, "0"),
					new Beat(46087, "0"),
					new Beat(46087, "I"),
					new Beat(46767, "9"),
					new Beat(46767, "O"),
					new Beat(47659, "6"),
					new Beat(47659, "U"),
					new Beat(48515, "8"),
					new Beat(48515, "U"),
					
					

					
			};
		int i = 0;
		while(true)
		{
			if(beats[i].getTime() <= startMusic.getTime())
			{
				Note note = new Note(beats[i].getNoteName());
				note.start();
				noteList.add(note);
				i++;
			}

		}
	}
		
	}
	
}
