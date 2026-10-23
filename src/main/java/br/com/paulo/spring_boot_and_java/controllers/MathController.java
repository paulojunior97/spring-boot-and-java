package br.com.paulo.spring_boot_and_java.controllers;

import br.com.paulo.spring_boot_and_java.exception.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math") // Define o path base para o controlador
public class MathController {
    
    @RequestMapping(value="/soma/{numberOne}/{numberTwo}", method= RequestMethod.GET)
    public Double soma(@PathVariable("numberOne") String numberOne,
                      @PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return covertToDouble(numberOne) + covertToDouble(numberTwo);
    }

	@RequestMapping(value = "/subtracao/{numberOne}/{numberTwo}", method =  RequestMethod.GET)
	public Double subtracao(@PathVariable("numberOne") String numberOne
							 , @PathVariable("numberTwo") String numberTwo) {
		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		return covertToDouble(numberOne) - covertToDouble(numberTwo);
	}

	@RequestMapping(value = "/multiplicacao/{numberOne}/{numberTwo}", method =  RequestMethod.GET)
	public Double multiplicacao(@PathVariable("numberOne") String numberOne
			, @PathVariable("numberTwo") String numberTwo) {
		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		return covertToDouble(numberOne) * covertToDouble(numberTwo);
	}

	@RequestMapping(value = "/divisao/{numberOne}/{numberTwo}", method =  RequestMethod.GET)
	public Double divisao(@PathVariable("numberOne") String numberOne
			, @PathVariable("numberTwo") String numberTwo) {
		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		return covertToDouble(numberOne) * covertToDouble(numberTwo);
	}

	@RequestMapping(value = "/media/{numberOne}/{numberTwo}", method =  RequestMethod.GET)
	public Double media(@PathVariable("numberOne") String numberOne
			, @PathVariable("numberTwo") String numberTwo) {
		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		return (covertToDouble(numberOne) + covertToDouble(numberTwo)) / 2;
	}

	@RequestMapping(value = "/raiz-quadrada/{numero}", method =  RequestMethod.GET)
	public Double raizQuadrada(@PathVariable("numero") String numero) {
		if (!isNumeric(numero)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		return Math.sqrt(covertToDouble(numero));
	}
    
    public static Double covertToDouble(String strNumber) {
		if (strNumber == null) return 0d; 
		String number = strNumber.replaceAll(",", ".");// Moeda Americana x Brasileira
		return Double.parseDouble(number);
	}

	public static boolean isNumeric(String strNumber) {
		if (strNumber == null) return false; 
		String number = strNumber.replaceAll(",", ".");
			return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}
}
