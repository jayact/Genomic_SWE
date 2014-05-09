package model;

import java.util.*;

/**
 * 
 * @author Jeffrey Creighton
 */
public class Patient {
	private String first_name;
	private String last_name;
	private String initial;
	private String address;
	private String city;
	private String state;
        private String zip;
	private int month;
	private int day;
	private String year;
	private String gender;
        private String ethnicity;
        private String age;
        private String report_id;

	/**
	 * Constructs a Patient with no attributes
	 */
	public Patient() {
		this.first_name = "";
		this.last_name = "";
		this.initial = "";
		this.address = "";
		this.city = "";
		this.state = "";
		this.month = 1;
		this.day = 1;
		this.year = "";
		this.gender = "";
                this.age = "";               
                this.ethnicity = "";
	}
        
        public String get_zip() {
            return zip;
        }

        public void set_zip(String zip) {
            this.zip = zip;
        }

	/**
	 * Sets the first name of the patient
	 * 
	 * @param first_name
	 */
	public void set_first_name(String first_name) {
		this.first_name = first_name;
	}

	/**
	 * Sets the middle initial of the patient
	 * 
	 * @param middle_initial
	 */
	public void set_initial(String middle_initial) {
		this.initial = middle_initial;
	}

	/**
	 * Sets the last name of the patient
	 * 
	 * @param last_name
	 */
	public void set_last_name(String last_name) {
		this.last_name = last_name;
	}

	/**
	 * Sets the address of the patient
	 * 
	 * @param address
	 */
	public void set_address(String address) {
		this.address = address;
	}

	/**
	 * Sets the city of the patient
	 * 
	 * @param city
	 */
	public void set_city(String city) {
		this.city = city;
	}

	/**
	 * Sets the state (geographically) of the patient
	 * 
	 * @param state
	 */
	public void set_state(String state) {
		this.state = state;
	}

	/**
	 * Sets the month of the patients date of birth
	 * 
	 * @param month
	 */
	public void set_month(int month) {
		this.month = month;
	}

	/**
	 * Sets the day of the patients date of birth
	 * 
	 * @param day
	 */
	public void set_day(int day) {
		this.day = day;
	}

	/**
	 * Sets the year of the patients date of birth
	 * 
	 * @param year
	 */
	public void set_year(String year) {
		this.year = year;
	}

	/**
	 * Sets the gender of the patient
	 * 
	 * @param gender
	 */
	public void set_gender(String gender) {
		this.gender = gender;
	}

	/**
	 * Gets the first name of the patient
	 * 
	 * @return first_name
	 */
	public String get_first_name() {
		return first_name;
	}

	/**
	 * Gets the last name of the patient
	 * 
	 * @return last_name
	 */
	public String get_last_name() {
		return last_name;
	}

	/**
	 * Gets the middle initial of the patient
	 * 
	 * @return initial
	 */
	public String get_initial() {
		return initial;
	}

	/**
	 * Gets the address of the patient
	 * 
	 * @return address
	 */
	public String get_address() {
		return address;
	}

	/**
	 * Get the city of the patient
	 * 
	 * @return city
	 */
	public String get_city() {
		return city;
	}

	/**
	 * Get the state (geographically) of the patient
	 * 
	 * @return state
	 */
	public String get_state() {
		return state;
	}

	/**
	 * Gets the month of the patients date of birth
	 * 
	 * @return month
	 */
	public int get_month() {
		return month;
	}

	/**
	 * Gets the day of the patients date of birth
	 * 
	 * @return day
	 */
	public int get_day() {
		return day;
	}

	/**
	 * Gets the year of the patients date of birth
	 * 
	 * @return year
	 */
	public String get_year() {
		return year;
	}
        
        public String get_dob() {
            return month +"/" + day + "/" + year;
        }

	/**
	 * Get the gender of the patient
	 * 
	 * @return gender
	 */
	public String get_gender() {
		return gender;
	}
        
        /**
         * set ethnicity of patient
         * 
         * @return void
         */
        public void set_ethnicity(String s){
            this.ethnicity = s;
        }

        /**
         * get ethnicity of patient
         * 
         * @return ethnicity  
         */
        public String get_ethnicity(){
            return ethnicity;
        }
        
        /**
         * gets the age of the patient
         * 
         * @return age
         */
        public String get_age(){
            return age;
        }
        
        
        /**
         * calculates the age of the patient
         * 
         * @return void
         */
        public void set_age(String y, String m, String d) {
            if(!y.isEmpty() && !m.isEmpty() && !d.isEmpty()){
                Calendar birthCal = new GregorianCalendar(Integer.parseInt(y), Integer.parseInt(m), Integer.parseInt(d));        
                Calendar nowCal = new GregorianCalendar();        
                int age_to_be = nowCal.get(Calendar.YEAR) - birthCal.get(Calendar.YEAR);       
                boolean isMonthGreater = birthCal.get(Calendar.MONTH) >= nowCal.get(Calendar.MONTH);       
                boolean isMonthSameButDayGreater = birthCal.get(Calendar.MONTH) == nowCal.get(Calendar.MONTH)
                    && birthCal.get(Calendar.DAY_OF_MONTH) > nowCal.get(Calendar.DAY_OF_MONTH);        
                if (isMonthGreater || isMonthSameButDayGreater) {
                    age_to_be = age_to_be - 1;
                } 
                age = age_to_be + "";
            }
        }
        
        /**
         * sets the report id for the patient
         * 
         * @param i 
         */
        public void set_id(String i) {
            this.report_id = i;
        }
        
        
        /**
         * gets the report id of the patient
         * 
         * 
         * @return report_id
         */
        public String get_id() {
            return report_id;
        }
        
        /**
         * Checks to see if the user filled in enough
         * information to generate a report id and 
         * calculate the patients age
         * 
         * 
         * @return boolean
         */
        public boolean is_filled_out() {
            if(!get_first_name().isEmpty() && !get_last_name().isEmpty() &&
                    !get_state().isEmpty() && !get_year().isEmpty()) {
                return true;
            } else {
                return false;
            }
        }
        
        /**
         * sets the patients report id
         * 
         * @return 
         */
        
	public String toString() {
		String returnString = "";
		if (first_name.length() != 0) {
			returnString += "First Name: " + first_name + " \n";
		}
		if (initial.length() != 0) {
			returnString += "Middle Initial: " + initial + " \n";
		}
		if (last_name.length() != 0) {
			returnString += "Last Name: " + last_name + " \n";
		}
		if (gender.length() != 0) {
			returnString += "Gender: " + gender + " \n";
		}
		if (address.length() != 0) {
			returnString += "Street Address: " + address + " \n";
		}
		if (city.length() != 0) {
			returnString += "City: " + city + " \n";
		}
		if (state.length() != 0) {
			returnString += "State: " + state + " \n";
		}
		returnString += "Month: " + month + " \n";
		returnString += "Day: " + day + " \n";
		if (year.length() != 0) {
			returnString += "Year: " + year + "\n";
		}
		return returnString;
	}
}
