package com.jsp.Studentpage.controller;


import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.jsp.Studentpage.Excel.ExcelExporter;
import com.jsp.Studentpage.dto.Student;
import com.jsp.Studentpage.repository.StudentRepository;
import com.jsp.Studentpage.service.AWSS3Service;
import com.jsp.Studentpage.service.StudentService;
import com.jsp.Studentpage.util.ResponseStructure;

@RestController
@RequestMapping("/api")
public class StudentController {
	
	
		
		@Autowired
		private AWSS3Service awsS3Service;
		
		@CrossOrigin(origins = "http://localhost:4200/")
		@PostMapping("/upload")
		public ResponseEntity<Map<String, String>> uploadFile(@RequestParam("file") MultipartFile file) {
			String publicURL = awsS3Service.uploadFile(file);
			Map<String, String> response = new HashMap<>();
			response.put("publicURL", publicURL);
			return new ResponseEntity<Map<String, String>>(response, HttpStatus.CREATED);
		}
	
	@Autowired
	private StudentRepository dataRepository;
	
		@Autowired
		private StudentService service;

		@CrossOrigin(origins = "http://localhost:4200/")
		@PostMapping("/student")
		public ResponseEntity<ResponseStructure<Student>> saveStudent(@RequestBody Student student){
			return service.saveStudent(student);
		}
		
		@CrossOrigin(origins = "http://localhost:4200/")
	    @GetMapping("/export-to-excel")
	    public ResponseEntity<InputStreamResource> exportToExcel() throws IOException {
	        List<Student> data = dataRepository.findAll();

	        ByteArrayInputStream excelFile = ExcelExporter.exportToExcel(data);
	        
	        HttpHeaders headers = new HttpHeaders();
	        headers.add("Content-Disposition", "attachment; filename=data.xlsx");
	        
	        return ResponseEntity.ok()
	        		.headers(headers)
	        		.contentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
	        		.body(new InputStreamResource(excelFile));
	        
		}
}
//		
		
//		 @PostMapping("/upload")
//		    public ResponseEntity<String> uploadFile(@RequestParam(value = "file") MultipartFile file) {
//		        return new ResponseEntity<>(service.uploadFile(file), HttpStatus.OK);
//		    }
//
//		    @GetMapping("/download/{fileName}")
//		    public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable String fileName) {
//		        byte[] data = service.downloadFile(fileName);
//		        ByteArrayResource resource = new ByteArrayResource(data);
//		        return ResponseEntity
//		                .ok()
//		                .contentLength(data.length)
//		                .header("Content-type", "application/octet-stream")
//		                .header("Content-disposition", "attachment; filename=\"" + fileName + "\"")
//		                .body(resource);
//		    }
//
//		    @DeleteMapping("/delete/{fileName}")
//		    public ResponseEntity<String> deleteFile(@PathVariable String fileName) {
//		        return new ResponseEntity<>(service.deleteFile(fileName), HttpStatus.OK);
//		    }
//		
//		
//}
		
		
		
//		@CrossOrigin(origins = "http://localhost:4200/")
//		@GetMapping("/findall")
//		public ResponseEntity<ResponseStructure<List<Student>>> findAll() {
////		    List<Student> students = service.findAll(); 
////		    ResponseStructure<List<Student>> response = new ResponseStructure<>();
////		    response.setData(students);
////		    response.setMessage("All student data retrieved successfully");
////		    response.setStatus(HttpStatus.OK.value());
//
//		    return (ResponseEntity<ResponseStructure<List<Student>>>) service.findAll();
//		}
		
		
		
		
		
		
		

//		@GetMapping("/export/excel")
//		public ResponseEntity<Student> exportToExcel(@RequestBody Student student){
//			try {
//				Student excelData =student;
//				student.setHeader("Content-Disposition", "attachment; filename=exported_data.xlsx");
//				student.setContentType("application/vnd.openxmlformats-officedocument.spredsheetml.sheet");
//				return ResponseEntity.ok(excelData);
//				
//			}catch (IoException e) {
//				return ResponseEntity.status(500).body(null);
//			}
//		}
//}
//		@GetMapping("/export/excel")
//	    public ResponseEntity<byte[]> exportToExcel(HttpServletResponse response) {
//	        try {
////	            // Create a new workbook
////	            Workbook workbook = new XSSFWorkbook();
////	            
////	            // Create a new sheet
////	            Sheet sheet = workbook.createSheet("Sheet 1");
////	            
////	            // Create a new row and set cell values
////	            Row row = sheet.createRow(0);
////	            Cell cell1 = row.createCell(0);
////	            cell1.setCellValue("Hello");
////	            
////	            // ... Add more rows and cells as needed ...
////	            
////	            // Write the workbook to a byte array
//	            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//	            workbook.write(outputStream);
//	            
//	            // Get the byte array
//	            byte[] excelData = outputStream.toByteArray();
// 
//	            // Set headers for the Excel file
//	            response.setHeader("Content-Disposition", "attachment; filename=exported_data.xlsx");
//	            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
//
//	            return ResponseEntity.ok(excelData);
//	        } catch (IOException e) {
//	           // Handle exceptions
//	           return ResponseEntity.status(500).body(null);
//	        }
//	    }
//	}
 