
public class StupidRobot implements FuelRobot{
	private int index = 0;
	private boolean isRight = true;
	@Override
	public int getCurrentIndex() {
		// TODO Auto-generated method stub
		return index;
	}
	@Override
	public boolean isFacingRight() {
		// TODO Auto-generated method stub
		return isRight;
	}
	@Override
	public void changeDirection() {
		// TODO Auto-generated method stub
		isRight = !isRight;
	}
	@Override
	public void moveForward(int moves) {
		// TODO Auto-generated method stub
		index = index + moves;
	}
	
}
