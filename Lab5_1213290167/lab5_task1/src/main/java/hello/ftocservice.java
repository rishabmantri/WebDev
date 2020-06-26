package hello;

import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.math.BigDecimal;

@RestController
@RequestMapping("/ftocservice")
public class ftocservice {



@RequestMapping(method = RequestMethod.GET, produces = "application/json")
public @ResponseBody ResponseEntity convertFtoC(@RequestParam(name ="precision" ,required = false) String precision) {

//   JSONObject jsonObject = new JSONObject();
  Double fahrenheit = 98.24;
  Double celsius1;
  celsius1 = (fahrenheit - 32) * 5 / 9;

  if (precision==null)
  {precision="2";}

	int result = Integer.parseInt(precision);
  if(result<0)
  {
	  return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
  }

//	JSONObject jsonObject = new JSONObject();
	BigDecimal celsius = new BigDecimal(celsius1).setScale(result,BigDecimal.ROUND_DOWN);

	JSONObject jsonObject = new JSONObject();
	jsonObject.put("F Value", fahrenheit);
	jsonObject.put("C Value", celsius);

	String result1 = "Output: \n\nF to C Converter Output: \n\n" + jsonObject.toString();


	return ResponseEntity.ok(result1);

}

@RequestMapping(value ="{f}",  produces = "application/json")
public @ResponseBody ResponseEntity convertFtoCfromInput(@PathVariable("f") float f,@RequestParam(name ="precision" ,required = false) String precision) {

  float celsius1;
  celsius1 = (f - 32) * 5 / 9;


	if (precision==null)
	{precision="2";}

	int result = Integer.parseInt(precision);

	if(result<0)
	{
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	BigDecimal celsius = new BigDecimal(celsius1).setScale(result,BigDecimal.ROUND_DOWN);

	JSONObject jsonObject = new JSONObject();
	jsonObject.put("F Value", f);
	jsonObject.put("C Value", celsius);

	String result1 = "Output: \n\nF to C Converter Output: \n\n" + jsonObject.toString();


	return ResponseEntity.ok(result1);


}





}
