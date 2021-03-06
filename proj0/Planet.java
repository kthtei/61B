public class Planet {
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;
	public String fieldOfInterest = "mass";
	public String name;

	public Planet(double xP, double yP, double xV,
					double yV, double m, String img) {
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}

	public Planet(Planet p) {
		xxPos = p.xxPos;
		yyPos = p.yyPos;
		xxVel = p.xxVel;
		yyVel = p.yyVel;
		mass = p.mass;
		imgFileName = p.imgFileName;
	}

	public Planet(int mass, String name) {
		this.mass = mass;
		this.name = name;
	}

	public static void main(String[] args) {
		Planet earth = new Planet(6e24, "earth");
		double mass = earth[fieldOfInterest];
	}
}