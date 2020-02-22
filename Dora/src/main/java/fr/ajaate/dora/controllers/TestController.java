package fr.ajaate.dora.controllers;

import fr.ajaate.dora.entities.Staff;
import fr.ajaate.dora.services.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/profil")
public class TestController {
	@Autowired
	private StaffService staffService;

	@GetMapping("/all")
	public String allAccess() {
		return "Public Content.";
	}
	
	@GetMapping("/doctor")
	@PreAuthorize("hasAuthority('DOCTOR')")
	public String DoctorAccess() {
		return "DOCTOR Content.";
	}

	@GetMapping("/nurse")
	@PreAuthorize("hasAuthority('NURSE')")
	public String NurseAccess() {
		return "NURSE Board.";
	}

	@GetMapping("/admin")
	@PreAuthorize("hasAuthority('ADMINISTRATOR')")
	public String adminAccess() {
		return "ADMINISTRATOR Board.";
	}

	@GetMapping("/laboratory")
	@PreAuthorize("hasAuthority('LABORATORY')")
	public String LaboraintainAccess() {
		return "LABORATORY Board.";
	}

	@GetMapping("/secretary")
	@PreAuthorize("hasAuthority('SECRETARY')")
	public String SeacretaryAccess() {
		return "SECRETARY Board.";
	}


	@GetMapping("/{id}")
	public ResponseEntity<Staff> findById(@PathVariable("id") Long id){
		return new ResponseEntity<Staff>(staffService.findByID(id), HttpStatus.OK);
	}

	@PostMapping ("/update/{id}")
	public ResponseEntity<Staff> updateStaff(@PathVariable("id") Long id, @RequestBody Staff staff){
		return new ResponseEntity<Staff>(staffService.updateStaff(id,staff), HttpStatus.OK);
	}
}

