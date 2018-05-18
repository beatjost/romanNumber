package ch.gemdat.romanNumber;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.TreeMap;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Scope("request")
public class HomeController {

	@RequestMapping(path = "/", method = { RequestMethod.GET, RequestMethod.POST })
	public String home(@RequestBody(required = false) final String number, Model model) {
		String roman = null;
		if (!StringUtils.isEmpty(number)) {
			String nbr = number.replace("number=", "");
			if (!StringUtils.isEmpty(nbr) && !nbr.startsWith("-")) {
				roman = convertToRoman(Integer.parseInt(nbr));
				model.addAttribute("nbr", format(nbr));
			}
		}
		model.addAttribute("roman", roman);
		return "home";
	}

	private String format(String nbr) {
		return ((DecimalFormat) NumberFormat.getNumberInstance(new Locale("de", "CH"))).format(Long.valueOf(nbr));
	}

	private final String convertToRoman(int number) {
		int l = map.floorKey(number);
		if (number == l) {
			return map.get(number);
		}
		return map.get(l) + convertToRoman(number - l);
	}

	private final static TreeMap<Integer, String> map = new TreeMap<>();

	static {
		map.put(1000, "M");
		map.put(900, "CM");
		map.put(500, "D");
		map.put(400, "CD");
		map.put(100, "C");
		map.put(90, "XC");
		map.put(50, "L");
		map.put(40, "XL");
		map.put(10, "X");
		map.put(9, "IX");
		map.put(5, "V");
		map.put(4, "IV");
		map.put(1, "I");
	}

}