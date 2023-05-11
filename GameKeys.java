import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/*public class Tron extends JFrame implements ActionListener,KeyListener{
	Timer myTimer;
	GamePanel game;

    public void GameKeys() {
		super("TRON LEGACY OF THE FALLEN HEROES OF THE NORDIC TRIBE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800,650);

		myTimer = new Timer(10, this);	 // trigger every 10 ms


		game = new GamePanel();
		add(game);
		addKeyListener(this);
		setResizable(false);
		setVisible(true);
    }

	public void actionPerformed(ActionEvent evt){
		if(game != null){
			game.refresh();
			game.repaint();
		}
	}

    public void keyTyped(KeyEvent e) {}

    public void keyPressed(KeyEvent e) {
    	game.setKey(e.getKeyCode(),true);
    }

    public void keyReleased(KeyEvent e) {
    	game.setKey(e.getKeyCode(),false);
    }

    public static void main(String[] arguments) {
		GameKeys frame = new GameKeys();
    }
}

class GamePanel extends JPanel{
	private int boxx,boxy;
	private boolean []keys;
	private Image back;

	public GamePanel(){
		keys = new boolean[KeyEvent.KEY_LAST+1];
		back = new ImageIcon("OuterSpace.jpg").getImage();
	    boxx = 170;
        boxy = 170;
		setSize(800,600);
	}

    public void setKey(int k, boolean v) {
    	keys[k] = v;
    }

	public void refresh(){
		if(keys[KeyEvent.VK_RIGHT] ){
			boxx += 5;
		}
		if(keys[KeyEvent.VK_LEFT] ){
			boxx -= 5;
		}
		if(keys[KeyEvent.VK_UP] ){
			boxy -= 5;
		}
		if(keys[KeyEvent.VK_DOWN] ){
			boxy += 5;
		}
	}

    public void paintComponent(Graphics g){
    	g.drawImage(back,0,0,this);
		g.setColor(Color.blue);
		g.fillRect(boxx,boxy,40,40);
    }
}*/