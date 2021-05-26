package pl.coderslab.controller;
import org.springframework.validation.BindingResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.entity.User;
import javax.validation.ConstraintViolation;
import java.awt.print.Book;
import java.util.Set;

@Controller
public class ValidationController {

    private final Logger logger = LoggerFactory.getLogger(ValidationController.class);
    private final Validator validator;

    public ValidationController(Validator validator) {
        this.validator = validator;
    }

    @RequestMapping(value = "/validate", method = RequestMethod.GET)
    @ResponseBody
    public String validateBook() {
        User user = new User();
        String output="";
        Set<ConstraintViolation<Book>> violations = validator.validate(user);
        if (!violations.isEmpty()) {
            for (ConstraintViolation<Book> constraintViolation : violations) {
                System.out.println(constraintViolation.getPropertyPath() + " "
                        + constraintViolation.getMessage());
                output = output + constraintViolation.getPropertyPath() + " "
                        + constraintViolation.getMessage() + "\n";

            }
        }
        return output;
    }
}

