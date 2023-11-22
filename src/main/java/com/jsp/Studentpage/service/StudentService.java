package com.jsp.Studentpage.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.jsp.Studentpage.dao.StudentDao;
import com.jsp.Studentpage.dto.Student;
import com.jsp.Studentpage.util.ResponseStructure;


@Service
public class StudentService {
	
		@Autowired
		private StudentDao dao;
		
//		@Value("${application.bucket.name}")
//		private String bucketName;
		
//		@Autowired
//		private AmazonS3 s3Client;

		
		public ResponseEntity<ResponseStructure<Student>> saveStudent(Student student){
			ResponseStructure<Student> structure = new ResponseStructure<Student>();
			structure.setData(dao.saveStudent(student));
			structure.setMessage("Student Data Saved SuccessFully");
			structure.setStatus(HttpStatus.CREATED.value());
			
			return new ResponseEntity<ResponseStructure<Student>>(structure,HttpStatus.CREATED);
		}
		
}	
		
//	public String uploadFile(MultipartFile file) {
//		 File fileObj=convertMultiPartFileToFile(file);
//		 String fileName=System.currentTimeMillis()+"_"+file.getOriginalFilename();
//		 s3Client.putObject(new PutObjectRequest(bucketName, fileName,fileObj ));
//		 fileObj.delete();
//		 return "File uploades :"+ fileName;
//			
//		}
//	
//	public byte[] downloadFile(String fileName) {
//        S3Object s3Object = s3Client.getObject(bucketName, fileName);
//        S3ObjectInputStream inputStream = s3Object.getObjectContent();
//        try {
//            byte[] content = IOUtils.toByteArray(inputStream);
//            return content;
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//
//    public String deleteFile(String fileName) {
//        s3Client.deleteObject(bucketName, fileName);
//        return fileName + " removed ...";
//    }
//	
//	
//	
//		
//    private File convertMultiPartFileToFile(MultipartFile file) {
//        File convertedFile = new File(file.getOriginalFilename());
//        try (FileOutputStream fos = new FileOutputStream(convertedFile)) {
//            fos.write(file.getBytes());
//        } catch (IOException e) {
//            Log.error("Error converting multipartFile to file", e);
//        }
//        return convertedFile;
//    }
//		
//		
//}	
//		
//		
//		
//		
		
		
		
		
//		public List<Student> findAll() {
//		    return dao.findAll();
//		}
//		public ResponseEntity<ResponseStructure<List<Student>>> findAll() {
//		    List<Student> students = dao.findAll();
//		    ResponseStructure<List<Student>> response = new ResponseStructure<>();
//		    response.setData(students);
//		    response.setMessage("All student data retrieved successfully");
//		    response.setStatus(HttpStatus.OK.value());
//
//		    return new ResponseEntity<>(response, HttpStatus.OK);
//		}
		
		
		
//		public ResponseEntity<ResponseStructure<List<Student>>> findAll(Student student) {
//		    ResponseStructure<List<Student>> structure = new ResponseStructure<>();
//		    structure.setData(dao.findAll());
//		    structure.setMessage("All The Data Is Showed");
//		    structure.setStatus(HttpStatus.FOUND.value());
//
//		    return new  ResponseEntity<ResponseStructure<List<Student>>>(structure, HttpStatus.FOUND);
//		}

		
//		public ResponseEntity<ResponseStructure<Student>> findAll(Student student){
//			ResponseStructure<Student> structure = new ResponseStructure<Student>();
//			structure.setData((Student) dao.findAll());
//			structure.setMessage("All The Data Is Showed");
//			structure.setStatus(HttpStatus.FOUND.value());
//			
//			return new ResponseEntity<ResponseStructure<Student>>(structure,HttpStatus.FOUND);
//		}	

