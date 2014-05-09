package tester;

import model.Patient;

public class Patient_Tester {
	public static void main(String[] args) {
		Patient p = new Patient();

		p.set_first_name("Derick");
		p.set_initial("P");
		p.set_last_name("Palos");
		p.set_address("411 Hamilton Road");
		p.set_city("Glassboro");
		p.set_state("NJ");
		p.set_month(4);
		p.set_day(1);
		p.set_year("1993");
		p.set_gender("Male");

		System.out.println(p.toString());

		System.out.println(p.get_first_name());
		System.out.println(p.get_initial());
		System.out.println(p.get_last_name());
		System.out.println(p.get_gender());
		System.out.println(p.get_address());
		System.out.println(p.get_city());
		System.out.println(p.get_state());
		System.out.println(p.get_month());
		System.out.println(p.get_day());
		System.out.println(p.get_year());
	}
}