package Beat_please;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener extends KeyAdapter { //keyListener클래스, KeyAdapter를 상속받는다.
	
	@Override
	public void keyPressed(KeyEvent e){ //키를 눌렀을 떄 전반적인것을 감지한다.
		if(Center_function.game == null){
			return;
		}
		if(e.getKeyCode() == KeyEvent.VK_1){ //1키 이벤트
			Center_function.game.press1();
		}
		else if(e.getKeyCode() == KeyEvent.VK_2){
			Center_function.game.press2();
		}
		else if(e.getKeyCode() == KeyEvent.VK_3){
			Center_function.game.press3();
		}
		else if(e.getKeyCode() == KeyEvent.VK_4){
			Center_function.game.press4();
		}
		else if(e.getKeyCode() == KeyEvent.VK_5){
			Center_function.game.press5();
		}
		else if(e.getKeyCode() == KeyEvent.VK_6){
			Center_function.game.press6();
		}
		else if(e.getKeyCode() == KeyEvent.VK_7){
			Center_function.game.press7();
		}
		else if(e.getKeyCode() == KeyEvent.VK_8){
			Center_function.game.press8();
		}
		else if(e.getKeyCode() == KeyEvent.VK_9){
			Center_function.game.press9();
		}
		else if(e.getKeyCode() == KeyEvent.VK_0){
			Center_function.game.press0();
		}
		else if(e.getKeyCode() == (int)'-'){
			Center_function.game.pressU();
		}
		else if(e.getKeyCode() == (int)'='){
			Center_function.game.pressI();
		}
		else if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE){
			Center_function.game.pressO();
		}
		else if(e.getKeyCode() == KeyEvent.VK_HOME){
			Center_function.game.pressP();
		}
		
	}
	
	@Override
	public void keyReleased(KeyEvent e){
		
		if(Center_function.game == null){
			return;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_1){
			Center_function.game.release1();
		}
		else if(e.getKeyCode() == KeyEvent.VK_2){
			Center_function.game.release2();
		}
		else if(e.getKeyCode() == KeyEvent.VK_3){
			Center_function.game.release3();
		}
		else if(e.getKeyCode() == KeyEvent.VK_4){
			Center_function.game.release4();
		}
		else if(e.getKeyCode() == KeyEvent.VK_5){
			Center_function.game.release5();
		}
		else if(e.getKeyCode() == KeyEvent.VK_6){
			Center_function.game.release6();
		}
		else if(e.getKeyCode() == KeyEvent.VK_7){
			Center_function.game.release7();
		}
		else if(e.getKeyCode() == KeyEvent.VK_8){
			Center_function.game.release8();
		}
		else if(e.getKeyCode() == KeyEvent.VK_9){
			Center_function.game.release9();
		}
		else if(e.getKeyCode() == KeyEvent.VK_0){
			Center_function.game.release0();
		}
		else if(e.getKeyCode() == (int)'-'){
			Center_function.game.releaseU();
		}
		else if(e.getKeyCode() == (int)'='){
			Center_function.game.releaseI();
		}
		else if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE){
			Center_function.game.releaseO();
		}
		else if(e.getKeyCode() == KeyEvent.VK_HOME){
			Center_function.game.releaseP();
		}
		
	}
}
