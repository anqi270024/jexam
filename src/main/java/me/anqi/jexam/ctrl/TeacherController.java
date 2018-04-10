package me.anqi.jexam.ctrl;

import lombok.extern.slf4j.Slf4j;
import me.anqi.jexam.entity.Exercise;
import me.anqi.jexam.entity.User;
import me.anqi.jexam.entity.auxiliary.ExerciseForm;
import me.anqi.jexam.entity.auxiliary.UserAuxiliary;
import me.anqi.jexam.exception.CommonException;
import me.anqi.jexam.service.ExerciseService;
import me.anqi.jexam.service.PaperService;
import me.anqi.jexam.service.StudentService;
import me.anqi.jexam.service.SubjectService;
import me.anqi.jexam.utils.RequestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

/**
 * @author flyleft
 * @date 2018/4/8
 */
@Controller
@RequestMapping("/user/tea")
@Slf4j
public class TeacherController {

    @Autowired
    private SubjectService subjectService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private PaperService paperService;

    @Autowired
    private ExerciseService exerciseService;

    @GetMapping("/add_subject")
    public String addSubject(Model model) {
        StringBuilder builder = new StringBuilder();
        subjectService.getAllSubjects().forEach(t -> builder.append(t.getName()).append(" "));
        model.addAttribute("subjects", builder.toString());
        return "tea/add_subject";
    }

    @GetMapping("/add_student")
    public String addStudent(HttpServletRequest request, Model model) {
        UserAuxiliary userAuxiliary = RequestUtils.getUserAuxiliaryFromReq(request);
        List<User> existStudents = studentService.findAllStudentsByTeacherId(userAuxiliary.getId());
        List<User> allStudents = studentService.findAllStudents();
        StringBuilder builder = new StringBuilder();
        existStudents.forEach(t -> builder.append(t.getName()).append(" "));
        model.addAttribute("studentNames", builder.toString());
        model.addAttribute("students", allStudents);
        return "tea/add_student";
    }

    @GetMapping("/add_paper")
    public String addPaper(Model model) {
        model.addAttribute("subjects", subjectService.getAllSubjects());
        return "tea/add_paper";
    }

    @GetMapping("/manager_paper")
    public String managerPaper(Model model, HttpServletRequest request) {
        UserAuxiliary userAuxiliary = RequestUtils.getUserAuxiliaryFromReq(request);
        model.addAttribute("papers", paperService.findPapersByTeacherId(userAuxiliary.getId()));
        return "tea/manager_paper";
    }

    @GetMapping("/correct_paper")
    public String correctPaper() {
        return "tea/correct_paper";
    }


    @PostMapping("/subjects")
    public String addSubject(@RequestParam("name") String name) {
       if (StringUtils.isEmpty(name)) {
           throw new CommonException("error.subjects.add");
       }
       subjectService.addSubject(name);
       return "redirect:/user/tea/add_subject";
    }

    @PostMapping("/students")
    public String addStudent(@RequestParam("id") Long id, HttpServletRequest request) {
        if (id == null) {
            throw new CommonException("error.students.add.badRequest");
        }
        UserAuxiliary userAuxiliary = RequestUtils.getUserAuxiliaryFromReq(request);
        studentService.addStudent(userAuxiliary.getId(), id);
        return "redirect:/user/tea/add_student";
    }

    @PostMapping("/papers")
    public String addPaper(@RequestParam("title") String title,
                           @RequestParam("subject") Long subject,
                           HttpServletRequest request) {
        if (StringUtils.isEmpty(title) || subject == null) {
            throw new CommonException("error.papers.add.badRequest");
        }
        UserAuxiliary userAuxiliary = RequestUtils.getUserAuxiliaryFromReq(request);
        paperService.addPaper(title, subject, userAuxiliary.getId());
        return "redirect:/user/tea/manager_paper";
    }

    @GetMapping("/papers/{id}/delete")
    public String deletePaper(@PathVariable long id,
                              HttpServletRequest request) {
        UserAuxiliary userAuxiliary = RequestUtils.getUserAuxiliaryFromReq(request);
        paperService.deletePaper(id, userAuxiliary.getId());
        return "redirect:/user/tea/manager_paper";
    }

    @GetMapping("/papers/{id}/edit")
    public String editPage(@PathVariable long id, Model model) {
        model.addAttribute("paperId", id);
        model.addAttribute("subjectId", paperService.findPageById(id).getSubjectId());
        List<Exercise> exercises = exerciseService.getAllExercisesByPaperId(id);
        model.addAttribute("exercises", exercises);
        return "tea/edit_paper";
    }

    @PostMapping("/exercises")
    public String addExercise(@Valid ExerciseForm exerciseForm) {
      exerciseService.addExercise(exerciseForm);
      return "redirect:/user/tea/papers/" + exerciseForm.getPaperId() + "/edit";
    }

}
