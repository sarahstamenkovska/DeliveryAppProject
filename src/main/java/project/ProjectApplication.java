package project;

import lombok.NoArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@NoArgsConstructor
@SpringBootApplication
@ServletComponentScan
public class ProjectApplication {

    public static void main(String[] args)

    {
        SpringApplication.run(ProjectApplication.class, args);
    }

}

