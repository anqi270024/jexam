package me.anqi.jexam.service;

import me.anqi.jexam.entity.Subject;
import me.anqi.jexam.repository.SubjectRepository;
import me.anqi.jexam.repository.UserRepository;
import me.anqi.jexam.service.inter.InitSer;
import me.anqi.jexam.entity.User;
import me.anqi.jexam.utils.EncryptUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class InitSerImpl implements InitSer {

    private static final Logger logger= LoggerFactory.getLogger(InitSer.class);

    private UserRepository userRepository;

    private SubjectRepository subjectRepository;

    @Autowired
    public InitSerImpl(UserRepository userRepository, SubjectRepository subjectRepository) {
        this.userRepository = userRepository;
        this.subjectRepository = subjectRepository;
    }

    @PostConstruct
    @Transactional
    @Override
    public void executeInit() {
       initUserData();
       initSubjectData();
    }


    private void initUserData(){
        User jcala = userRepository.findUserByName("jcala");
        if (jcala==null){
            String pass= EncryptUtils.EncoderByMd5("jcala");
            userRepository.save(new User("jcala",pass,1));
        }

        User tea=userRepository.findUserByName("tea");
        if (tea==null){
            String pass= EncryptUtils.EncoderByMd5("tea");
            userRepository.save(new User("tea",pass,2));
        }
    }

    private void initSubjectData(){
       long size = subjectRepository.count();
       if (size < 1) {
           List<Subject> subjects = Arrays.asList(new Subject("语文"),
                   new Subject("数学"), new Subject("英语"));
           subjectRepository.save(subjects);
       }
    }


}
