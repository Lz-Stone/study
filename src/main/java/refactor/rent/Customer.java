package refactor.rent;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {
    private String name;
    private Vector rentals = new Vector();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg){
        rentals.add(arg);
    }

    public String getName() {
        return name;
    }

    public String statement(){
        Enumeration rentales = rentals.elements();
        String result = "Rental Record for" + getName() +"\n";
        while (rentales.hasMoreElements()) {
            Rental each = (Rental) rentales.nextElement();
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + "\n";
        }
        result += "Amount owed is " + String.valueOf(getTotalCharge())+ "\n";
        result += "You earned " + String.valueOf(getTotalFrequentRenterPoints())+ " frequent renter points";
        return result;
    }

    private double getTotalCharge(){
        double result =0;
        Enumeration rentales = rentals.elements();
        while (rentales.hasMoreElements()){
            Rental each = (Rental) rentales.nextElement();
            result += each.getCharge();
        }
        return result;
    }

    private int getTotalFrequentRenterPoints(){
        int result = 0;
        Enumeration rentales = rentals.elements();
        while (rentales.hasMoreElements()){
            Rental each = (Rental) rentales.nextElement();
            result += each.getFrequentRenterPoints();
        }
        return result;
    }

    public String htmlStatement(){
        Enumeration rentales = rentals.elements();
        String result = "<H1>Rentals for <EM>" + getName()+ "</EM></H1><P>\n";
        while (rentales.hasMoreElements()){
            Rental each = (Rental) rentales.nextElement();
            result += each.getMovie().getTitle()+ ": "+ String.valueOf(each.getCharge())+ "<BR>\n";
        }
        result += "<P>You owe <EM>" + String.valueOf(getTotalCharge())+ "</EM><P>\n";
        result += "On this rental you earned <EM>"+ String.valueOf(getTotalFrequentRenterPoints()) + "</EM> frequent renter points<P>";
        return result;
    }
}
