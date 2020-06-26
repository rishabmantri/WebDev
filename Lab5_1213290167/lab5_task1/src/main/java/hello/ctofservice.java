package hello;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/ctofservice")
public class ctofservice {


  @RequestMapping(method = RequestMethod.GET, produces = "application/xml")
	public @ResponseBody ResponseEntity convertCtoF(@RequestParam(name ="precision" ,required = false) String precision) {
		Double fahrenheit1;
		Double celsius = 36.8;
		fahrenheit1 = ((celsius * 9) / 5) + 32;

	  if (precision==null)
	  {precision="2";}

	  int pre = Integer.parseInt(precision);

	  if(pre<0)
	  {
		  return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	  }

	  BigDecimal fahrenheit = new BigDecimal(fahrenheit1).setScale(pre,BigDecimal.ROUND_DOWN);

	  String result = "@Produces(\"application/xml\") Output: \n\nC to F Converter Output: \n\n" + fahrenheit;
	  String result1= "<ctofservice>" + "<celsius>" + celsius + "</celsius>" + "<ctofoutput>" + result + "</ctofoutput>" + "</ctofservice>";


	  return ResponseEntity.ok(result1);
  }

//precision query parameter
  @RequestMapping(value= "{id}", method = RequestMethod.GET, produces = "application/xml")
	public @ResponseBody ResponseEntity convertCtoFfromInput(@PathVariable("id") Double id,@RequestParam(name ="precision" ,required = false) String precision) {
	  Double fahrenheit1;
	  Double celsius = id;
	  fahrenheit1 = ((celsius * 9) / 5) + 32;

	  if (precision==null)
	  {precision="2";}


	  int pre = Integer.parseInt(precision);
	  if(pre<0)
	  {
		  return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	  }

	  BigDecimal fahrenheit = new BigDecimal(fahrenheit1).setScale(pre,BigDecimal.ROUND_DOWN);

	  String result = "@Produces(\"application/xml\") Output: \n\nC to F Converter Output: \n\n" + fahrenheit;
	  String result1= "<ctofservice>" + "<celsius>" + celsius + "</celsius>" + "<ctofoutput>" + result + "</ctofoutput>" + "</ctofservice>";


	  return ResponseEntity.ok(result1);
  }


}






