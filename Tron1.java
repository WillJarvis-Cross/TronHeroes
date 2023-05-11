import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/*public class Tron extends JFrame implements ActionListener,KeyListener{
	Timer myTimer;
	GamePanel game;

    public Tron() {
		super("TRON LEGACY OF THE FALLEN HEROES OF THE NORDIC TRIBE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800,600);

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
		new Tron();
    }
}

class GamePanel extends JPanel{

	private boolean []keys;
	private Image tronBack;

	public GamePanel(){
		keys = new boolean[KeyEvent.KEY_LAST+1];
		setFocusable(true);
		addMouseListener(this);
		requestFocus();

		tronBack = new ImageIcon("tronBack.png").getImage();

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
    	g.drawImage(tronBack,0,0,this);
		g.setColor(player1.getTronColor());
		g.fillRect(player1.getTronX,player1.getTronY,40,40);
    }
}*/