package org.example;

import com.arangodb.ArangoDB;
import com.arangodb.Protocol;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class MnConfig {

    @Bean
    public JdbcTemplate jdbcTemplate(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setUrl("jdbc:postgresql://localhost:5432/allcard");
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUsername("postgres");
        System.out.println("111");
        dataSource.setPassword("Hf3W@rt88");
        return new JdbcTemplate(dataSource);}
/*@Bean
    public ArangoDB arangoDB(){
        return new ArangoDB.Builder()
                .timeout(100)
                .host("127.0.0.1",8529)
                .user("root")
                .password("1234")
                .useProtocol(Protocol.VST)
                .build();
}*/
}
