public class Plot {
	private int x;
	private int y;
	private int width;
	private int depth;
	//No-arg Constructor
	public Plot() {
		this.x=0;
		this.y=0;
		this.width=1;
		this.depth=1;
	}
	//Copy Constructor
	public Plot(Plot p) {
		this.x=p.x;
		this.y=p.y;
		this.width=p.width;
		this.depth=p.depth;
		
	}
	//Parameterized Constructor
	public Plot(int x, int y, int width, int depth) {
		this.x=x;
		this.y=y;
		this.width=width;
		this.depth=depth;
	}
	//check to see if plot overlaps and returns true, else returns false
	public boolean overlaps(Plot plot) {
		if(getX()<(plot.getX()+plot.getWidth())&&(getX()+getWidth()>plot.getX())&&(y<(plot.getY()+plot.getDepth())&&(getY()+getDepth())>plot.getY())) {
			return true;
		}
		return false;
	}
	//checks to see if plot is encompassed and returns true, else returns false
	public boolean encompasses(Plot plot) {
		int wid=plot.getWidth();
		int dep=plot.getDepth();
		//if x and y are within the bounds of the plot, returns true, else return false
		if((x<=plot.getX()&&(plot.getX()<=(x+width)))) {
			if((y<=plot.getY()&&(plot.getY()<=(y+depth)))) {
				if((x<=(plot.getX()+wid)&&((plot.getX()+wid)<=(x+width)))){
					if((y<=(plot.getY()+plot.getDepth()))&&((plot.getY()+dep)<=(y+depth))) {
						return true;
					}
				}
			}
		}
		return false;
	}
	//Getter methods
	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}
	public int getWidth() {
		return this.width;
	}
	public int getDepth() {
		return this.depth;
	}
	//Setter methods
	public void setX(int x) {
		this.x=x;
	}
	public void setY(int y) {
		this.y=y;
	}
	public void setWidth(int width) {
		this.width=width;
	}
	public void setDepth(int depth) {
		this.depth=depth;
	}
	//returns a string format of the upper left x & y coordinates, the depth and the width
	public String toString() {
		String str="Upper left: ("+x+","+y+"); Width: "+width+" "+"Depth: "+depth;
		return str;
	}
	
	
}

