package productcrud.controller;

import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.swing.text.html.FormSubmitEvent.MethodType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import productcrud.dao.ProductDao;
import productcrud.model.Product;

@Controller
public class MainController {
	
	@Autowired
	private ProductDao dao;

	@RequestMapping("/")
	public String home(Model m) {
		List<Product> products = dao.getProducts();
		m.addAttribute("products", products);
		return "index";
	}
	
	@RequestMapping("/add-product")
	public String addProduct(Model m) {
		m.addAttribute("title","Add Product");
		return "add_product_form";
	}
	
	@RequestMapping(path="/handle-product", method=RequestMethod.POST)
	public RedirectView handel(@ModelAttribute Product product,HttpServletRequest request) {
		System.out.println(product);
		this.dao.createProduct(product);
		RedirectView redirectView  =  new RedirectView();
		redirectView.setUrl(request.getContextPath()+"/");
		return redirectView;
	}
	
	@RequestMapping("/delete/{productId}")
	public RedirectView deletePro(@PathVariable("productId") int pid,HttpServletRequest request) {
		
		this.dao.deleteProduct(pid);
		
		RedirectView redirectView  =  new RedirectView();
		redirectView.setUrl(request.getContextPath()+"/");
		return redirectView;
	}
	
	@RequestMapping("/update/{productId}")
	public String update(@PathVariable("productId") int id,Model m) {
	Product product =this.dao.getProduct(id);
	m.addAttribute("product",product);	
	return "update_form";
	}
}
