package it.objectmethod.esempio.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.objectmethod.esempio.dao.IDaoNazioni;
import it.objectmethod.esempio.dao.utils.MyDependencyInjectionExample;

@Controller
public class HomeController {

	@Autowired
	private IDaoNazioni daoNaz;

	@Autowired
	private MyDependencyInjectionExample example;

	@RequestMapping("/qualcosa")
	public void esempioDi(HttpServletResponse resp) throws IOException {
		String frase = example.qualcosa();
		PrintWriter writer = resp.getWriter();
		writer.write(frase);
	}

	@RequestMapping("/index")
	public String home(ModelMap map) {
		List<String> conts = daoNaz.getAllContinenti();
		map.addAttribute("continents", conts);

		return "home";
	}

//	@RequestMapping(value = "/index-con-get", method = RequestMethod.GET)
	@GetMapping("/index-con-get")
	public String homeGet(ModelMap map) {
		List<String> conts = daoNaz.getAllContinenti();
		map.addAttribute("continents", conts);

		return "home";
	}

	@GetMapping("/login")
	public String prepareLogin() {
		return "login";
	}

	@PostMapping("/login")
	public String login(@RequestParam("username") String username, @RequestParam("password") String password,
			ModelMap map) {
		String result = "ACCESSO NEGATO";
		if (username.equals("admin") && password.equals("admin")) {
			result = "ACCESSO ADMIN OK";
		}
		map.addAttribute("result", result);
		return "accesso";
	}

	@GetMapping("/pagina-param")
	public String getPagina(@RequestParam("num-pagina") Integer pagina, ModelMap map) {
		String result = "Sono la pagina numero " + pagina;
		map.addAttribute("result", result);
		return "pagina";
	}

	@GetMapping("/{num-pagina}/pagina")
	public String getPaginaPathVar(@PathVariable("num-pagina") Integer pagina, ModelMap map) {
		String result = "Sono la pagina numero " + pagina;
		map.addAttribute("result", result);
		return "pagina";
	}
}
