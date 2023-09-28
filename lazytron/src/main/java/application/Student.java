package application;

public class Student {
	
	
	//STUDENT VARIABLES DECLARATION
	private String rank;
	private String firstName;
	private String lastName;
	private String middleInitial;
	private String startDate;
	private String gradDate;
	
	private int impactLabScore;
	private int tpLabScore;
	private int apptLabScore;
	private int preMEPSLabScore;
	private int postMEPSLabScore;
	
	/**
	 * Basic Student constructor
	 * Takes in rank, first, last name, middle initial, start date, graduation date
	 */
	public Student(String rank, String firstName, String lastName
					,String middleInitial, String startDate, String gradDate) {
		
		this.rank = rank;
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleInitial = middleInitial;
		this.startDate = startDate;
		this.gradDate = gradDate;
		
		instantiateScores();
		this.gradDate = gradDateConversion(gradDate);
		
	}
	
	/**
	 * Instantiates score variables.
	 */
	private void instantiateScores() {
		
		impactLabScore = 0;
		tpLabScore = 0;
		apptLabScore = 0;
		preMEPSLabScore = 0;
		postMEPSLabScore = 0;
		
	}
	
	/**
	 * String representation of a student
	 */
	@Override
	public String toString() {
		
		return rank + " " + lastName + ", " + firstName;
		
	}
	
	/**
	 * returns a string representation of students for certificate printing
	 * @return
	 */
	public String certString() {
		
		return rank + " " + firstName + " " + middleInitial + " " + lastName;
		
	}
	
	/**
	 * Converts Date from yearmonthday to Day-Month-Year
	 * @param gradDate
	 * @return
	 */
	public String gradDateConversion(String gradDate) {
		String result = "";
		String year = gradDate.substring(0,4);
		String month = monthConversion(gradDate);
		String day = gradDate.substring(6,8);
		
		
		result = day + "-" + month + "-" + year;
		
		return result;
	}
	
	private String monthConversion(String gradDate) {
		String month = gradDate.substring(4,6);
		
		switch(month) {
		case "01":
			month = "Jan";
			break;
		case "02":
			month = "Feb";
			break;
		case "03":
			month = "Mar";
			break;
		case "04":
			month = "Apr";
			break;
		case "05":
			month = "May";
			break;
		case "06":
			month = "Jun";
			break;
		case "07":
			month = "Jul";
			break;
		case "08":
			month = "Aug";
			break;
		case "09":
			month = "Sep";
			break;
		case "10":
			month = "Oct";
			break;
		case "11":
			month = "Nov";
			break;
		case "12":
			month = "Dec";
			break;
		default: 
			month = "unknown";
			break;
		}
		
				
		return month;
		
	}
	

	//SETTERS AND GETTERS BELOW FOR ALL VARIABLES OF THE STUDENT CLASS.
	
	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleInitial() {
		return middleInitial;
	}

	public void setMiddleInitial(String middleInitial) {
		this.middleInitial = middleInitial;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getGradDate() {
		return gradDate;
	}

	public void setGradDate(String gradDate) {
		this.gradDate = gradDate;
	}

	public int getImpactLabScore() {
		return impactLabScore;
	}

	public void setImpactLabScore(int impactLabScore) {
		this.impactLabScore = impactLabScore;
	}

	public int getTpLabScore() {
		return tpLabScore;
	}

	public void setTpLabScore(int tpLabScore) {
		this.tpLabScore = tpLabScore;
	}

	public int getApptLabScore() {
		return apptLabScore;
	}

	public void setApptLabScore(int apptLabScore) {
		this.apptLabScore = apptLabScore;
	}

	public int getPreMEPSLabScore() {
		return preMEPSLabScore;
	}

	public void setPreMEPSLabScore(int preMEPSLabScore) {
		this.preMEPSLabScore = preMEPSLabScore;
	}

	public int getPostMEPSLabScore() {
		return postMEPSLabScore;
	}

	public void setPostMEPSLabScore(int postMEPSLabScore) {
		this.postMEPSLabScore = postMEPSLabScore;
	}
	
	
	
	
	

}
