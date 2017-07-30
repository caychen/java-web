package service;

import entity.Person;

public class PersonService {
	public String BMICalculate(Person person) throws Exception{
		String result = "";
		String gender = person.getGender();
		double height = person.getHeight();
		double weight = person.getWeight();
		double bmi = weight / height / height;
		
		switch(gender)
		{
		case "male":
			if(bmi < 20)
				result = "过轻";
			else if(bmi >= 20 && bmi < 25)
				result = "适中";
			else if(bmi >= 25 && bmi < 30)
				result = "过重";
			else if(bmi >= 30 && bmi < 35)
				result = "肥胖";
			else 
				result = "非常肥胖";
			break;
			
		case "female":
			if(bmi < 19)
				result = "过轻";
			else if(bmi >= 19 && bmi < 24)
				result = "适中";
			else if(bmi >= 24 && bmi < 29)
				result = "过重";
			else if(bmi >= 29 && bmi < 34)
				result = "肥胖";
			else 
				result = "非常肥胖";
			break;
		}
		return result;
	}
}
