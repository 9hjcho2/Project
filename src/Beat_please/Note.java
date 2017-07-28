package Beat_please;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Note extends Thread{
	
	private Image noteBasicImage = new ImageIcon(Main.class.getResource("../images/noteBasic.jpg")).getImage(); //변수에 noteBasic 이미지 초기화
	private int x;
	private int y = 650 - 1000 / Main.SLEEP_TIME * Main.NOTE_SPEED;//580은 노트 판정라인이다. 노트가 생성되고 1초뒤에 판정라인에 다다른다.
	private String noteType;
	
	public Note(String noteType){ //생성자
		if(noteType.equals("1")){
			x = 190;
		}
		else if(noteType.equals("2")){
			x = 253;
		}
		else if(noteType.equals("3")){
			x = 318;
		}
		else if(noteType.equals("4")){
			x = 381;
		}
		else if(noteType.equals("5")){
			x = 446;
		}
		else if(noteType.equals("6")){
			x = 510;
		}
		else if(noteType.equals("7")){
			x = 574;
		}
		else if(noteType.equals("8")){
			x = 638;
		}
		else if(noteType.equals("9")){
			x = 702;
		}
		else if(noteType.equals("0")){
			x = 765;
		}
		else if(noteType.equals("U")){
			x = 831;
		}
		else if(noteType.equals("I")){
			x = 894;
		}
		else if(noteType.equals("O")){
			x = 958;
		}
		else if(noteType.equals("P")){
			x = 1020;
		}
		this.noteType = noteType;
	}
	
	public void screenDraw(Graphics g){//하나의 노트에 대한 이미지를 그릴 수 있도록
			g.drawImage(noteBasicImage,  x,  y,  null);
		
	}
	
	public void drop(){ // 노트가 떨어지는 함수
		y += Main.NOTE_SPEED;
	}
	
	@Override
	public void run(){ //쓰레드가 실행되는 함수
		try{ //오류가 발생했을 때는 오류 출력하게
			while (true) { 
				drop();
				Thread.sleep(Main.SLEEP_TIME); //SLEEP_TIME을 10이라고 했는데 sleep은 0.001이므로, 0.01초 동안 쉬게 해줬다가 다시 떨어뜨리고 무한정 반복되서 실행될 수 있도록. 
			}
		} catch(Exception e){
			System.err.println(e.getMessage());
		}
		
	}

		
}
