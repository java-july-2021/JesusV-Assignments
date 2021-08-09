package com.Jesus.productsandcategories.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Jesus.productsandcategories.models.Category;
import com.Jesus.productsandcategories.models.Product;
import com.Jesus.productsandcategories.services.TheService;

@Controller
public class HomeController {
	@Autowired
	private TheService tService;
	
	@GetMapping("/products/new")
	public String newProduct() {
		return "newProduct.jsp";
	}
	
	@GetMapping("/categories/new")
	public String newCategory() {
		return "newCategory.jsp";
	}
	
	@PostMapping("/newCat")
	public String makeCat(@RequestParam("cat") String category) {
		Category newCat = new Category();
		newCat.setName(category);
		this.tService.createCategory(newCat);
		return "redirect:/categories/new";
	}
	
	@PostMapping("/newProd")
	public String makeProd(@RequestParam("name") String name, @RequestParam("desc") String desc, @RequestParam("price") Double price) {
		Product newProd = new Product(name, desc, price);
		this.tService.createProduct(newProd);
		return "redirect:/products/new";
		
	}
	
	@GetMapping("/{id}")
	public String showProd(Model viewModel, @PathVariable("id") Long id) {
		Product productToShow = this.tService.getSingleProd(id);
		viewModel.addAttribute("notInProd", this.tService.findCatNotProd(productToShow));
		viewModel.addAttribute("product", productToShow);
		return "showProduct.jsp";
	}
	
	@GetMapping("/cat/{id}")
	public String showCat(Model viewModel, @PathVariable("id") Long id) {
		Category catToShow = this.tService.getSingleCat(id);
		viewModel.addAttribute("notInCat", this.tService.findProdNotCat(catToShow));
		viewModel.addAttribute("category", catToShow);
		return "showCategory.jsp";
	}
	
	@PostMapping("/addCatToProd/{id}")
	public String addCatToProd(@RequestParam("cats") Long id, @PathVariable("id") Long productId) {
		Product productToAddCatTo = this.tService.getSingleProd(productId);
		Category categoryToAddProdTo = this.tService.getSingleCat(id);
		this.tService.addCategoryToProduct(productToAddCatTo, categoryToAddProdTo);
		return "redirect:/{id}";
	}
	
	@PostMapping("/addProdToCat/{id}")
	public String addProdToCat(@RequestParam("prod") Long id, @PathVariable("id") Long categoryId) {
		Product productToAddCatTo = this.tService.getSingleProd(id);
		Category categoryToAddProdTo = this.tService.getSingleCat(categoryId);
		this.tService.addProductToCategory(productToAddCatTo, categoryToAddProdTo);
		return "redirect:/cat/{id}";
	}
	
}
