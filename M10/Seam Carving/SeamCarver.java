
public class SeamCarver {
	int width = 0;
	Picture pic;
	// create a seam carver object based on the given picture
	public SeamCarver(Picture picture) {
		this.pic = picture;




	}
	// current picture
	public Picture picture() {
		return null;
	}
	// width of current picture
	public int width() {
		//System.out.println("entered");
		return pic.width();
	}

	// height of current picture
	public int height() {
		return pic.height();
	}

	// energy of pixel at column x and row y
	public double energy(int x, int y) {
		return 0;
	}

	// sequence of indices for horizontal seam
	public int[] findHorizontalSeam() {
		return new int[0];
	}

	// sequence of indices for vertical seam
	public int[] findVerticalSeam() {
		return new int[0];
	}

	// remove horizontal seam from current picture
	public void removeHorizontalSeam(int[] seam) {

	}

	// remove vertical seam from current picture
	public void removeVerticalSeam(int[] seam) {

	}
}