package in.gov.uidai.auth.sampleapp;

public class Customer {
    public String getName() {
		return name;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public String getBuilding() {
		return building;
	}

	public String getStreet() {
		return street;
	}

	public String getLocality() {
		return locality;
	}

	public String getDistrict() {
		return district;
	}

	public String getGender() {
		return gender;
	}

	public String getEmail() {
		return email;
	}

	public String getPostOfficeName() {
		return postOfficeName;
	}

	public String getState() {
		return state;
	}

	public String getPinCode() {
		return pinCode;
	}
	
	public String getPanNumber() {
		return panNumber;
	}
	
	public String getAadharId() {
		return aadharId;
	}

	private final String name; // required
    private final String dateOfBirth;
    private final String phone; // optional
    private final String building; // optional
    private final String street;
    private final String locality;
    private final String district;
    private final String gender;
    private final String email;
    private final String postOfficeName;
    private final String state;
    private final String pinCode;
    private String panNumber;
    private String aadharId;
    
 
    private Customer(UserBuilder builder) {
        this.name = builder.name;
        this.dateOfBirth = builder.dateOfBirth;
        this.phone = builder.phone;
        this.building = builder.building;
        this.street = builder.street;
        this.locality = builder.locality;
        this.district = builder.district;
        this.gender = builder.gender;
        this.email = builder.email;
        this.postOfficeName = builder.postOfficeName;
        this.state = builder.state;
        this.pinCode = builder.pinCode;
        this.aadharId = builder.aadharID;
    }
 
    public static class UserBuilder {
    	private  String name; // required
        private  String dateOfBirth;
        private  String phone; // optional
        private  String building; // optional
        private  String street;
        private  String locality;
        private  String district;
        private  String gender;
        private  String email;
        private  String postOfficeName;
        private String state;
        private  String pinCode;
        private String panNumber;
        private String aadharID;
     
 
        public UserBuilder(String name) {
            this.name = name;
        }
 
        public UserBuilder dob(String dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }
        
        public UserBuilder aadharId(String aadharId) {
            this.aadharID = aadharId;
            return this;
        }
 
        public UserBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }
 
        public UserBuilder building(String building) {
            this.building = building;
            return this;
        }
        
        public UserBuilder street(String street) {
            this.street = street;
            return this;
        }
 
        public UserBuilder locality(String locality) {
            this.locality = locality;
            return this;
        }
 
        public UserBuilder district(String district) {
            this.district = building;
            return this;
        }
        
        public UserBuilder gender(String gender) {
            this.gender = gender;
            return this;
        }
        
        public UserBuilder email(String email) {
            this.email = email;
            return this;
        }
        
        public UserBuilder postOfficeName(String postOfficeName) {
            this.postOfficeName = postOfficeName;
            return this;
        }
        
        public UserBuilder state(String state) {
            this.state = state;
            return this;
        }
        
        public UserBuilder pincode(String pincode) {
            this.pinCode = pincode;
            return this;
        }
        
        public UserBuilder panNumber(String panNumber) {
            this.panNumber = panNumber;
            return this;
        }
 
        public Customer build() {
            return new Customer(this);
        }

		
 
    }
}