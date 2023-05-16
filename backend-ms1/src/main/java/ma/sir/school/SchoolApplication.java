package  ma.sir.school;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import java.util.*;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import org.springframework.cache.annotation.EnableCaching;


import ma.sir.school.bean.core.*;
import ma.sir.school.service.facade.admin.*;

import ma.sir.school.zynerator.security.common.AuthoritiesConstants;
import ma.sir.school.zynerator.security.bean.User;
import ma.sir.school.zynerator.security.bean.Permission;
import ma.sir.school.zynerator.security.bean.Role;
import ma.sir.school.zynerator.security.service.facade.UserService;
import ma.sir.school.zynerator.security.service.facade.RoleService;


import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableCaching
//@EnableFeignClients("ma.sir.school.required.facade")
public class SchoolApplication {
    public static ConfigurableApplicationContext ctx;

    public static void main(String[] args) {
        ctx=SpringApplication.run(SchoolApplication.class, args);
    }


    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }
    @Autowired
    private ObjectMapper objectMapper;

    @Bean
    ObjectMapper objectMapper(){
        return new ObjectMapper();
    }
    public static ConfigurableApplicationContext getCtx() {
        return ctx;
    }

    @Bean
    public CommandLineRunner demo(UserService userService, RoleService roleService) {
    return (args) -> {
        if(true){



    // Role admin

        User userForAdmin = new User("admin");

        Role roleForAdmin = new Role();
        roleForAdmin.setAuthority(AuthoritiesConstants.ADMIN);
        List<Permission> permissionsForAdmin = new ArrayList<>();
        addPermissionForAdmin(permissionsForAdmin);
        roleForAdmin.setPermissions(permissionsForAdmin);
        if(userForAdmin.getRoles()==null)
            userForAdmin.setRoles(new ArrayList<>());

        userForAdmin.getRoles().add(roleForAdmin);
        userService.save(userForAdmin);
            }
        };
    }




    private static String fakeString(String attributeName, int i) {
        return attributeName + i;
    }

    private static Long fakeLong(String attributeName, int i) {
        return  10L * i;
    }
    private static Integer fakeInteger(String attributeName, int i) {
        return  10 * i;
    }

    private static Double fakeDouble(String attributeName, int i) {
        return 10D * i;
    }

    private static BigDecimal fakeBigDecimal(String attributeName, int i) {
        return  BigDecimal.valueOf(i*1L*10);
    }

    private static Boolean fakeBoolean(String attributeName, int i) {
        return i % 2 == 0 ? true : false;
    }
    private static LocalDateTime fakeLocalDateTime(String attributeName, int i) {
        return LocalDateTime.now().plusDays(i);
    }
    private static void addPermissionForAdmin(List<Permission> permissions){
        permissions.add(new Permission("Student.edit"));
        permissions.add(new Permission("Student.list"));
        permissions.add(new Permission("Student.view"));
        permissions.add(new Permission("Student.add"));
        permissions.add(new Permission("Student.delete"));
        permissions.add(new Permission("Module.edit"));
        permissions.add(new Permission("Module.list"));
        permissions.add(new Permission("Module.view"));
        permissions.add(new Permission("Module.add"));
        permissions.add(new Permission("Module.delete"));
        permissions.add(new Permission("Payment.edit"));
        permissions.add(new Permission("Payment.list"));
        permissions.add(new Permission("Payment.view"));
        permissions.add(new Permission("Payment.add"));
        permissions.add(new Permission("Payment.delete"));
        permissions.add(new Permission("ExamGrade.edit"));
        permissions.add(new Permission("ExamGrade.list"));
        permissions.add(new Permission("ExamGrade.view"));
        permissions.add(new Permission("ExamGrade.add"));
        permissions.add(new Permission("ExamGrade.delete"));
        permissions.add(new Permission("Exam.edit"));
        permissions.add(new Permission("Exam.list"));
        permissions.add(new Permission("Exam.view"));
        permissions.add(new Permission("Exam.add"));
        permissions.add(new Permission("Exam.delete"));
        permissions.add(new Permission("SemesterAverage.edit"));
        permissions.add(new Permission("SemesterAverage.list"));
        permissions.add(new Permission("SemesterAverage.view"));
        permissions.add(new Permission("SemesterAverage.add"));
        permissions.add(new Permission("SemesterAverage.delete"));
        permissions.add(new Permission("Semester.edit"));
        permissions.add(new Permission("Semester.list"));
        permissions.add(new Permission("Semester.view"));
        permissions.add(new Permission("Semester.add"));
        permissions.add(new Permission("Semester.delete"));
        permissions.add(new Permission("Training.edit"));
        permissions.add(new Permission("Training.list"));
        permissions.add(new Permission("Training.view"));
        permissions.add(new Permission("Training.add"));
        permissions.add(new Permission("Training.delete"));
        permissions.add(new Permission("ModuleGrade.edit"));
        permissions.add(new Permission("ModuleGrade.list"));
        permissions.add(new Permission("ModuleGrade.view"));
        permissions.add(new Permission("ModuleGrade.add"));
        permissions.add(new Permission("ModuleGrade.delete"));
        permissions.add(new Permission("Diploma.edit"));
        permissions.add(new Permission("Diploma.list"));
        permissions.add(new Permission("Diploma.view"));
        permissions.add(new Permission("Diploma.add"));
        permissions.add(new Permission("Diploma.delete"));
    }

}


