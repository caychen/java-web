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
				result = "����";
			else if(bmi >= 20 && bmi < 25)
				result = "����";
			else if(bmi >= 25 && bmi < 30)
				result = "����";
			else if(bmi >= 30 && bmi < 35)
				result = "����";
			else 
				result = "�ǳ�����";
			break;
			
		case "female":
			if(bmi < 19)
				result = "����";
			else if(bmi >= 19 && bmi < 24)
				result = "����";
			else if(bmi >= 24 && bmi < 29)
				result = "����";
			else if(bmi >= 29 && bmi < 34)
				result = "����";
			else 
				result = "�ǳ�����";
			break;
		}
		return result;
	}
}
