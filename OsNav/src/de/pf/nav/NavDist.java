package de.pf.nav;

import java.io.File;
import java.util.List;

import org.w3c.dom.Node;

import de.pfeiffy.help.HelperGlobal;
import xml.classes.XmlKmlTool;

public class NavDist {

	static double lat = 0;
	static double lon = 0;
	static double latVor = 0;
	static double lonVor = 0;
	static boolean first = true;
	static double entfernung = 0;
	static int counter = 1;
	static double startLat = 0;
	static double startLon = 0;
	static double zielLat = 0;
	static double zielLon = 0;
	static double aktLat = 0;
	static double aktLon = 0;
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		XmlKmlTool xmlT = new XmlKmlTool(new File("YCSnachBibau251.gpx"));

		List<Node> koordinaten = xmlT.getNodes("rtept");


		for (Node node : koordinaten) {
			System.out.println(node.getAttributes().getNamedItem("lat").getNodeValue());
			System.out.println(node.getAttributes().getNamedItem("lon").getNodeValue());

			lat = Double.parseDouble(node.getAttributes().getNamedItem("lat").getNodeValue());
			lon = Double.parseDouble(node.getAttributes().getNamedItem("lon").getNodeValue());
			if (!first) {
				System.out.println("second");

				double distance = HelperGlobal.getDistance(latVor, lat, lonVor, lon);
				System.out.println(distance);
				entfernung = entfernung + distance;
			}

			latVor = lat;
			lonVor = lon;
			first = false;

			System.out.println("Poi " + counter++);

		}

		System.out.println("Entfernung = " + entfernung);

	}

}
