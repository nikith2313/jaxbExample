package jaxbImpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.GregorianCalendar;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class Marshalling {

	public static void main(String args[]) throws DatatypeConfigurationException, JAXBException, FileNotFoundException{
		
	/*	Customer obj=new Customer();
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
		marshalling(obj);*/
		umMarshalling();
	}
	
	
	public static void marshalling(Customer obj) throws JAXBException, FileNotFoundException{
		 JAXBContext contextObj = JAXBContext.newInstance(Customer.class);  
		  
		    Marshaller marshallerObj = contextObj.createMarshaller();  
		    marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true); 
		    marshallerObj.marshal(obj, new FileOutputStream("C:\\Users\\nikith kumar\\Desktop\\marshal.xml")); 
	}
	
	public static void umMarshalling() throws JAXBException{
		
		 File file = new File("C:\\Users\\nikith kumar\\Desktop\\marshal.xml");  
	        JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);  
	   
	        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();  
	        Customer cust= (Customer) jaxbUnmarshaller.unmarshal(file);  
	        System.out.println(cust);
		
	}
	 
}
