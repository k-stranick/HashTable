package dtcc.itn262;

public class LongitudeLatitude {
	private final double longitude;
	private final double latitude;

	public LongitudeLatitude(double longitude, double latitude) {
		this.longitude = longitude;
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	@Override
	public String toString() {
		return "(" + longitude + ", " + latitude + ")";
	}
}
