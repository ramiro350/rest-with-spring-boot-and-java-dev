package com.dev.rest_with_spring_boot_and_java_dev;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dev.rest_with_spring_boot_and_java_dev.exceptions.UnsupportedMathOperationException;

import org.springframework.web.bind.annotation.RequestMethod;


@RestController
public class MathController {
  private static AtomicLong counter = new AtomicLong();
  
	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double sum(
		@PathVariable(value = "numberOne") String numberOne,
		@PathVariable(value = "numberTwo") String numberTwo)
		throws Exception {
			{
				if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
					throw new UnsupportedMathOperationException("Please set a numeric value");
				}
				return convertToDouble(numberOne) + convertToDouble(numberTwo);
			}

		}

	private Double convertToDouble(String strNumber){
		if(strNumber == null){
			return 0D;
		}
		String number = strNumber.replaceAll(",", ".");
		if(isNumeric(number)){
			return Double.parseDouble(number);
		}
		return null;
	}
		
	private boolean isNumeric(String strNumber){
		if(strNumber == null){
			return false;
		}
		String number = strNumber.replaceAll(",", ".");
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}
	
}
