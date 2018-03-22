package me.anqi.jexam.service;


import me.anqi.jexam.BaseTestService;
import me.anqi.jexam.entity.Course;
import me.anqi.jexam.repository.CourserRepository;
import me.anqi.jexam.utils.FileType;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class CrsSerImplTest extends BaseTestService {

     @Autowired
     CourserRepository courserRepository;

     @Test
     public void test(){
         Course course=courserRepository.findOne(1L);
         System.out.println(course);
     }

     @Test
     public void testFileType(){
         System.out.println(FileType.VIDEO.toString());
     }
}
