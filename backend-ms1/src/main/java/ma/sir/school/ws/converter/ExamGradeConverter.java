package  ma.sir.school.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.sir.school.bean.core.Exam;
import ma.sir.school.bean.core.Student;

import ma.sir.school.zynerator.util.StringUtil;
import ma.sir.school.zynerator.converter.AbstractConverter;
import ma.sir.school.zynerator.util.DateUtil;
import ma.sir.school.bean.history.ExamGradeHistory;
import ma.sir.school.bean.core.ExamGrade;
import ma.sir.school.ws.dto.ExamGradeDto;

@Component
public class ExamGradeConverter extends AbstractConverter<ExamGrade, ExamGradeDto, ExamGradeHistory> {

    @Autowired
    private StudentConverter studentConverter ;
    @Autowired
    private ExamConverter examConverter ;
    private boolean exam;
    private boolean student;

    public  ExamGradeConverter(){
        super(ExamGrade.class, ExamGradeDto.class, ExamGradeHistory.class);
    }

    @Override
    public ExamGrade toItem(ExamGradeDto dto) {
        if (dto == null) {
            return null;
        } else {
        ExamGrade item = new ExamGrade();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getGrade()))
                item.setGrade(dto.getGrade());
            if(dto.getExam() != null && dto.getExam().getId() != null){
                item.setExam(new Exam());
                item.getExam().setId(dto.getExam().getId());
            }

            if(dto.getStudent() != null && dto.getStudent().getId() != null){
                item.setStudent(new Student());
                item.getStudent().setId(dto.getStudent().getId());
            }



        return item;
        }
    }

    @Override
    public ExamGradeDto toDto(ExamGrade item) {
        if (item == null) {
            return null;
        } else {
            ExamGradeDto dto = new ExamGradeDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getGrade()))
                dto.setGrade(item.getGrade());
        if(this.exam && item.getExam()!=null) {
            dto.setExam(examConverter.toDto(item.getExam())) ;
        }
        if(this.student && item.getStudent()!=null) {
            dto.setStudent(studentConverter.toDto(item.getStudent())) ;
        }


        return dto;
        }
    }


    public void initObject(boolean value) {
        this.exam = value;
        this.student = value;
    }


    public StudentConverter getStudentConverter(){
        return this.studentConverter;
    }
    public void setStudentConverter(StudentConverter studentConverter ){
        this.studentConverter = studentConverter;
    }
    public ExamConverter getExamConverter(){
        return this.examConverter;
    }
    public void setExamConverter(ExamConverter examConverter ){
        this.examConverter = examConverter;
    }
    public boolean  isExam(){
        return this.exam;
    }
    public void  setExam(boolean exam){
        this.exam = exam;
    }
    public boolean  isStudent(){
        return this.student;
    }
    public void  setStudent(boolean student){
        this.student = student;
    }
}
