package jaxbImpl;

import java.io.File;
import java.io.IOException;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonSerialise {

	public static void main(String args[]) throws JsonGenerationException, JsonMappingException, IOException, DatatypeConfigurationException{
		
		
		Customer obj=new Customer();
		Address address=new Address();
		PaymentMethod pm=new PaymentMethod();
		GregorianCalendar gc = new GregorianCalendar();
		gc.set(1992, 06, 13);
		GregorianCalendar gc1 = new GregorianCalendar();
		gc1.set(2017, 06, 13);
		GregorianCalendar gc2 = new GregorianCalendar();
		gc2.set(2001, 06, 13);
		XMLGregorianCalendar date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);
		XMLGregorianCalendar date = DatatypeFactory.newInstance().newXMLGregorianCalendar(gc1);
		XMLGregorianCalendar date3 = DatatypeFactory.newInstance().newXMLGregorianCalendar(gc2);
		obj.setCustomerId(1);
		obj.setName("nikith");
		obj.setDataOfBirth(date2);
		obj.setAnualSalary(15000f);
		obj.setAddress(address);
		
		address.setAddress("hyderabad");
		address.setCity("hyderabad");
		address.setCountry("INDIA");
		address.setPaymentMethod(pm);
		
		pm.setCardName("amex");
		pm.setCardType("Creditcard");
		pm.setCardNumber("1239-1253-1358-1235");
		pm.setDateFrom(date);
		pm.setDateType(date3);
		//jsoonSerialisation(obj);
		jsonDeserialisation();
	}
	
	public static void jsoonSerialisation(Customer c) throws JsonGenerationException, JsonMappingException, IOException{
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.writeValue(new File("C:\\Users\\nikith kumar\\Desktop\\cust.json"), c);
		
	}
	
	public static void jsonDeserialisation() throws JsonParseException, JsonMappingException, IOException{
		ObjectMapper objectMapper = new ObjectMapper();
		Customer c = objectMapper.readValue(new File("C:\\Users\\nikith kumar\\Desktop\\cust.json"), Customer.class);
	//	Customer c = objectMapper.readValue("C:\\Users\\nikith kumar\\Desktop\\cust.json", Customer.class); 
	System.out.println(c);
	}
	
}
