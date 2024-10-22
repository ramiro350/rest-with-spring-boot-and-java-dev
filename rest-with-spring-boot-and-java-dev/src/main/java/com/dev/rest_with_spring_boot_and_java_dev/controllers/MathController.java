package com.dev.rest_with_spring_boot_and_java_dev.controllers;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dev.rest_with_spring_boot_and_java_dev.MathUtils;
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
				if(!MathUtils.isNumeric(numberOne) || !MathUtils.isNumeric(numberTwo)) {
					throw new UnsupportedMathOperationException("Please set a numeric value");
				}
				return MathUtils.convertToDouble(numberOne) + MathUtils.convertToDouble(numberTwo);
			}

		}

		@RequestMapping(value = "/sub/{numberOne}/{numberTwo}", method=RequestMethod.GET)
		public Double sub(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo)
			throws Exception {
				{
					if(!MathUtils.isNumeric(numberOne) || !MathUtils.isNumeric(numberTwo)) {
						throw new UnsupportedMathOperationException("Please set a numeric value");
					}
					return MathUtils.convertToDouble(numberOne) - MathUtils.convertToDouble(numberTwo);
				}
	
			}

	
	
}
