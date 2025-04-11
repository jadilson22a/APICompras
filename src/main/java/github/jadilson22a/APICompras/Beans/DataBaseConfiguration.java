package github.jadilson22a.APICompras.Beans;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataBaseConfiguration {
    @Value("${spring.datasource.url}")
    String url;
    @Value("${spring.datasource.username}")
    String username;
    @Value("${spring.datasource.password}")
    String password;
    @Value("${spring.datasource.driverClassName}")
    String driver;

    @Bean
    public DataSource dataSource(){
        HikariConfig config = new HikariConfig();

        config.setJdbcUrl(this.url);
        config.setUsername(this.username);
        config.setPassword(this.password);
        config.setDriverClassName(this.driver);

        config.setMaximumPoolSize(5);
        config.setMinimumIdle(1);
        config.setPoolName("DataBase-Pool");
        config.setMaxLifetime(600000); //10 minutos
        config.setConnectionTimeout(300000); //5 minutos
        config.setConnectionTestQuery("select 1"); //teste de conecxão

        return new HikariDataSource(config);
    }
}
