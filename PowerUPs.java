//if2.java
import java.util.*;
public class PowerUPs{
	private boolean star=false;
	private boolean small=false;
	private boolean large=false;
	private boolean clear=false;
	private boolean speed=false;
	private Random rand=new Random();
	int xpos,ypos;
	int starcounter=0;
  	public PowerUPs(){

  	}
  	public int[][] placepowerup(String type,int[][] grid){
  		xpos=rand.nextInt(799-60)+30;
  		ypos=rand.nextInt(599-60)+30;
  		if (type.equals("star")){
  			for (int i=0;i<30;i++){
  				for (int j=0;j<30;j++){
  					grid[xpos+i][ypos+j]+=2;
  				}
  			}
  			star=true;
  		}
  		if (type.equals("large")){
  			for (int i=0;i<30;i++){
  				for (int j=0;j<30;j++){
  					grid[xpos+i][ypos+j]+=4;
  				}
  			}
  			large=true;
  		}
  		if (type.equals("small")){
  			for (int i=0;i<30;i++){
  				for (int j=0;j<30;j++){
  					grid[xpos+i][ypos+j]+=6;
  				}
  			}
  			small=true;
  		}
  		if (type.equals("clear")){
  			for (int i=0;i<30;i++){
  				for (int j=0;j<30;j++){
  					grid[xpos+i][ypos+j]+=8;
  				}
  			}
  			clear=true;
  		}
  		if (type.equals("speed")){
  			for (int i=0;i<30;i++){
  				for (int j=0;j<30;j++){
  					grid[xpos+i][ypos+j]+=10;
  				}
  			}
  			speed=true;
  		}
  		return grid;

  	}
  	public int[][] removepowers(int[][] grid){
  		for (int i=0;i<30;i++){
  			for (int j=0;j<30;j++){
  				if (star){
  					grid[xpos+i][ypos+j]-=2;
  				}
  				if (large){
  					grid[xpos+i][ypos+j]-=4;
  				}
  				if (small){
  					grid[xpos+i][ypos+j]-=6;
  				}
  				if (clear){
  					grid[xpos+i][ypos+j]-=8;
  				}
  				if (speed){
  					grid[xpos+i][ypos+j]-=10;
  				}
  			}
  		}
  		return grid;
  	}
  	public void clearPowers(){
  		star=false;
  		large=false;
  		small=false;
  		clear=false;
  		speed=false;
  	}
  	public boolean placed(){
  		if (star||small||large||clear||speed){
  			return true;
  		}
  		return false;
  	}
  	public int getX(){
  		return xpos;
  	}
  	public int getY(){
  		return ypos;
  	}
  	public boolean starPlaced(){
  		return star;
  	}
  	public boolean largePlaced(){
  		return large;
  	}
  	public boolean smallPlaced(){
  		return small;
  	}
  	public boolean clearPlaced(){
  		return clear;
  	}
  	public boolean speedPlaced(){
  		return speed;
  	}
}