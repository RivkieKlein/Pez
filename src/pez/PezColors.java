package pez;


public enum PezColors {
	
a0("red"),
a1("yellow"),
a2("orange"),
a3("pink"),
a4("purple");

private String color;
private PezColors(String color){
	this.color=color;
}

public String getColor() {
	return color;
}
	
}

