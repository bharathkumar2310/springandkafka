package com.ecomerce.project.category;

import java.util.ArrayList;
import java.util.List;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.ecomerce.project.kafka.kafkaJsonProducer;
import com.ecomerce.project.kafka.kafkaProducer;

@RestController
@RequestMapping("/api")
public class categoryController {
	
	@Autowired
	private categoryService catService;
	
	@Autowired
	private kafkaProducer kafkaproducer;
	
	
	@Autowired
	private kafkaJsonProducer kafkajsonproducer;
	
	@GetMapping("/public/categories")
	public ResponseEntity<List<categoryModel>> getAllCatagories(){
		return new ResponseEntity<>(catService.getAllCategories(),HttpStatus.OK);
	}
	
	@PostMapping("/public/categories")
	public ResponseEntity<String> createCategoty(@RequestBody categoryModel catModel) {	
		catService.createCategories(catModel);
		return new ResponseEntity<>("Updated Succesfuuly", HttpStatus.CREATED); 		
	}

	@DeleteMapping("/public/categories/{categoryId}")
	public ResponseEntity<String> deleteCategory(@PathVariable Long categoryId) {
		try {
		String status = catService.deleteCatagory(categoryId);
		return  new ResponseEntity<>(status, HttpStatus.OK);
//      different ways of using response entity
//		return ResponseEntity.ok(status);
//		return ResponseEntity.status(HttpStatus.OK).body(status);
		}
		catch(ResponseStatusException e) {
			//ResponseStatusException-> way to handle HTTP exceptions
			return  new ResponseEntity<>(e.getReason(), HttpStatus.NOT_FOUND);

		}
	}
	
	@PutMapping("/public/categories/{categoryId}")
	public ResponseEntity<String> updateCategories(@RequestBody categoryModel categoryModel , @PathVariable Long categoryId){
		try {
			categoryModel categoryModel1 = catService.updateCategory(categoryModel, categoryId);
			return  new ResponseEntity<>("Updated Successfully", HttpStatus.OK);
			}
			catch(ResponseStatusException e) {
				return  new ResponseEntity<>(e.getReason(), HttpStatus.NOT_FOUND);

			}
	}
	
	@GetMapping("/publish")
	public ResponseEntity<String> kafkaPublish(@RequestParam("message") String message) {
		
		kafkaproducer.sendMessage(message);
		return ResponseEntity.ok("message sent");

		
	}
	
	@GetMapping("/publishJson")
	public ResponseEntity<String> kafkaPublish(@RequestBody categoryModel message) {
		
		kafkajsonproducer.sendMessage(message);
		return ResponseEntity.ok("message sent");

		
	}
}
