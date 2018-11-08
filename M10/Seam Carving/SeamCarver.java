
public class SeamCarver {

	Picture pic;
	// create a seam carver object based on the given picture
	public SeamCarver(Picture picture) {
		this.pic = picture;
		if (picture == null) {
			System.out.println("picture is null");
		}

	}
	// current picture
	public Picture picture() {
		return null;
	}
	// width of current picture
	public int width() {

		return pic.width();
	}

	// height of current picture
	public int height() {
		return pic.height();
	}

	// energy of pixel at column x and row y
	public double energy(int x, int y) {
		//System.out.print(pic.getRGB(x, y));
		if (x == 0 || y == 0 || x == width() - 1 || y == height() - 1) {
			return 1000;
		}
		// pic.get(x, y).getRed();
		// System.out.println();
		int rx = pic.get(x, y - 1).getRed() - pic.get(x, y + 1).getRed();
		int gx = pic.get(x, y - 1).getGreen() - pic.get(x, y + 1).getGreen();
		int bx = pic.get(x, y - 1).getBlue() - pic.get(x, y + 1).getBlue();
		double xsum = (rx * rx) + (gx * gx) + (bx * bx);
		int ry = pic.get(x - 1, y).getRed() - pic.get(x + 1, y).getRed();
		int gy = pic.get(x - 1, y).getGreen() - pic.get(x + 1, y).getGreen();
		int by = pic.get(x - 1, y).getBlue() - pic.get(x + 1, y).getBlue();
		double ysum = (ry * ry) + (gy * gy) + (by * by);
		double res = Math.sqrt(xsum + ysum);
		return res;
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