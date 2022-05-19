package co.com.sergiofranko.config;

import co.com.sergiofranko.jpa.dao.TaskDAO;
import co.com.sergiofranko.jpa.dao.UserDAO;
import co.com.sergiofranko.jpa.entity.TaskEntity;
import co.com.sergiofranko.jpa.service.TaskService;
import co.com.sergiofranko.jpa.service.UserService;
import co.com.sergiofranko.model.task.gateways.TaskGateway;
import co.com.sergiofranko.model.user.gateways.UserGateway;
import co.com.sergiofranko.usecase.tasks.TaskUseCase;
import co.com.sergiofranko.usecase.user.UserUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.security.config.web.server.ServerHttpSecurity;

@Configuration
@ComponentScan(basePackages = "co.com.sergiofranko.usecase",
        includeFilters = {
                @ComponentScan.Filter(type = FilterType.REGEX, pattern = "^.+UseCase$")
        },
        useDefaultFilters = false)
public class UseCasesConfig {

        @Bean
        public TaskUseCase getTaskUseCase(TaskGateway taskGateway) {
                return new TaskUseCase(taskGateway);
        }

        @Bean
        public TaskService getTaskService(TaskDAO taskDAO) {
                return new TaskService(taskDAO);
        }

        @Bean
        public UserService getUserService(UserDAO userDAO) {
                return new UserService(userDAO);
        }

}
