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
