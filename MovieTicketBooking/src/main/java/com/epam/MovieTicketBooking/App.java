package com.epam.MovieTicketBooking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class App {
	public static void main(String[] args) {

		DBoperations object = new CollectionDB();

		ArrayList<String> locations = new ArrayList<String>();
		locations.add("Hyderabad");
		locations.add("Kolkata");
		locations.add("Banglore");
		locations.add("Chennai");

		HashMap<String, ArrayList<String>> movies = new HashMap<String, ArrayList<String>>();
		movies.put("Hyderabad", new ArrayList<String>(Arrays.asList("Dream Girl", "Joker", "War")));
		movies.put("Kolkata", new ArrayList<String>(Arrays.asList("Chhichore", "Joker", "War")));
		movies.put("Banglore", new ArrayList<String>(Arrays.asList("Jai Ho", "Joker", "War")));
		movies.put("Chennai", new ArrayList<String>(Arrays.asList("Bahubali", "Joker", "Chhichore")));

		HashMap<String, ArrayList<String>> theatres = new HashMap<String, ArrayList<String>>();
		theatres.put("Dream Girl", new ArrayList<String>(Arrays.asList("PVR", "Cinepolis", "INOX")));
		theatres.put("Joker", new ArrayList<String>(Arrays.asList("INOX", "Carnival", "PVR")));
		theatres.put("War", new ArrayList<String>(Arrays.asList("PVR", "INOX", "Carnival")));
		theatres.put("Chhichore", new ArrayList<String>(Arrays.asList("INOX", "Cinepolis", "PVR")));
		theatres.put("Jai Ho", new ArrayList<String>(Arrays.asList("PVR", "INOX", "Cinepolis")));
		theatres.put("Bahubali", new ArrayList<String>(Arrays.asList("INOX", "Cinepolis", "Carnival")));

		HashMap<String, ArrayList<String>> thearteTiming = new HashMap<String, ArrayList<String>>();
		thearteTiming.put("PVR", new ArrayList<String>(Arrays.asList("8:00 am", "12:00 pm", "4:00 pm")));
		thearteTiming.put("Cinepolis", new ArrayList<String>(Arrays.asList("9:00 am", "1:00 pm", "5:00 pm")));
		thearteTiming.put("INOX", new ArrayList<String>(Arrays.asList("8:10 am", "12:15 pm", "5:20 pm")));
		thearteTiming.put("Carnival", new ArrayList<String>(Arrays.asList("11:00 am", "4:00 pm", "8:00 pm")));

		ArrayList<Double> price = new ArrayList<Double>();
		price.add(100.00);
		price.add(200.00);

		Scanner input = new Scanner(System.in);

		System.out.println("Enter Location :\n");
		object.display(locations);
		String locationChoice = input.nextLine();
		System.out.println("Enter Movie Name :\n");
		object.display(movies, locationChoice);
		String movieChoice = input.nextLine();
		System.out.println("Enter Theatre Name :\n");
		object.display(theatres, movieChoice);
		String theatreChoice = input.nextLine();
		System.out.println("Enter Theatre Time :\n");
		object.display(thearteTiming, theatreChoice);
		String timingChoice = input.nextLine();
		System.out.println("Select price category:\n");
		object.display(price);
		Double priceChoice = input.nextDouble();
		input.close();
	}
}
