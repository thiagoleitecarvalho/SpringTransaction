package com.github.thiagoleitecarvalho.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionException;

import com.github.thiagoleitecarvalho.entity.Student;
import com.github.thiagoleitecarvalho.service.StudentService;
import com.github.thiagoleitecarvalho.util.EntityUtils;

/**
 * Business class for the Example2. Creating a transaction with Propagation.MANDATOTY.
 * @author Thiago Leite e Carvalho
 * @see My linkedIn profile: https://www.linkedin.com/in/thiago-leite-e-carvalho-1b337b127/
 */
@Component
public class Example02 {

    /**
     * Log.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(Example02.class);

    /** {@link StudentService}. */
    @Autowired
    private StudentService studentService;

    /**
     * Runs the Example02.
     */
    public void execute() {

        try {

            LOGGER.info("---------------------");
            LOGGER.info("Example 2 started -> Propagation.MANDATOTY");

            LOGGER.info("Trying save a student.");
            Student student = EntityUtils.createStudent();
            this.studentService.saveMandatory(student);
        } catch (TransactionException e) {

            e.printStackTrace();
            LOGGER.error("Example 2 ended.");
        }

    }

}
